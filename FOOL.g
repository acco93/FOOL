grammar FOOL;

@header {
  // import utilizzati nelle classi generate del parser
  import java.util.ArrayList;
  import java.util.HashMap;
}


@members {
// queste dichiarazioni diventano campi delle classi generate del parser

// all'ingresso di ogni scope il nesting level viene incrementato
// quando entro nel primo scope passa a 0 il che è il livello dell'ambiente globale
// qui sono dichiarate anche le classi (i loro nomi)
// le virtual table (symbol table per i componenti delle classi) sono a nesting level 1
private int nestingLevel = -1; 

private  ArrayList<HashMap<String,STEntry>> symbolTable = new ArrayList<HashMap<String,STEntry>>(); 

// la class table mappa il nome della classe alla CTEntry
// che contiene varie cose tra cui la virtual table
private HashMap<String,CTEntry> classTable = new HashMap<String,CTEntry>();

// mappa ID di classi in ID di classi super
private HashMap<String,String> superType = new HashMap<String,String>();

}

@lexer::members {
int lexicalErrors=0;
}
  
// PARSER RULES

// rappresenta l'AST corrispondente al programma
prog returns [Node ast] :

    // se c'è solo una espressione quindi nessuna dichiarazione
    e = exp SEMIC {$ast = new ProgNode($e.ast);}
    | 
    // altrimenti ho anche delle dichiarazioni tra le quali anche classi
    // (sono sempre dichiarate per prime)
    LET 
	      {
         // all'inizio del parsing passo il riferimento della map supertype a FOOLLib per poterlo
         // utilizzare nel typechecking
			   FOOLLib.setSuperTypeMap(superType);
         FOOLLib.setClassTable(classTable);
	       // entro in un nuovo scope quindi incremento il nesting level
	       nestingLevel++; 
	       // creo la hashmap dove memorizzo le cose che incontro
	       HashMap<String,STEntry> hm = new HashMap<String,STEntry>();
	       // la aggiungo alla mia lista di hashmap (la ricaverò successivamente tramite .get(nestingLevel))
	       symbolTable.add(hm);
	       }
	  // posso quindi incontrare una lista di classi     
	  c=cllist      
    // seguita da una lista di dichiarazoni (variabili/funzioni)
    d=declist 
    
    IN 
    // infine una espressione
    e=exp SEMIC 
    
    {
      // ora esco dallo scope in cui sono quindi rimuovo la symbol table corrispondente al nesting level in esame
      // l'albero rimane comunque decorato con le entry
      symbolTable.remove(nestingLevel--);
      // creo il nodo da ritornare
      $ast = new LetInNode($c.astList,$d.astList, $e.ast);}  
    ;

// gestione della dichiarazione delle classi
// per semplicità le classi sono contenute solamente nell'ambiente globale (nesting level 0)
cllist returns [ArrayList<Node> astList] : 
  
    { 
    // inizializzo la lista di classi
    $astList = new ArrayList<Node>();
    }
  
  (CLASS i=ID 
    
    {    
    
    
        
    // la symbol table di livello 0 include STEntry per i nomi delle classi
    // questo per controllare che nello stesso scope non vengano dichiarate altre cose
    // con lo stesso nome
    
    // essendo le dichiarazione nell'ambiente globale è necessario che nestingLevel == 0
    assert nestingLevel == 0;
    
    // l'offset della entry della dichiarazoine della classe non verrà mai utilizzato 
    // la dichiarazione non viene messa in memoria (stack o heap)
    
    HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
    if(hm.put($i.text,new STEntry(nestingLevel,null, 999))!=null){ 
          System.out.println("Error: id "+$i.text +" at line "+ $i.line +" already declared!");
          System.exit(0);
         };
    
    // creo la CTEntry la quale conterra le info della classe
    CTEntry entry = new CTEntry();
    CTEntry superClassEntry = null;
    
    }
     
   (
    EXTENDS ei=ID
    {
      // se finisco qua dentro significa che estendo da qualcuno, allora devo recuperare la CTEntry
      // dalla class table (controllando che esista) e utilizzare il II costruttore di CTEntry (quello
      // che fa la copia)
      superClassEntry = classTable.get($ei.text);
      if(superClassEntry == null){
          System.out.println("Error: class "+$ei.text +" at line "+ $ei.line +" not declared!");
          System.exit(0);
      }
      // se tutto va bene ridefinisco entry, questo costruttore fa la copia della superClassEntry
      entry = new CTEntry(superClassEntry);
      
      //devo inoltre aggiornare la superType map
      superType.put($i.text,$ei.text);
      
    }
   )? 
  
    
    {
    
    // creo una lista di metodi e una lista di campi vuote
    ArrayList<Node> fieldsList = new ArrayList<Node>();
    ArrayList<Node> methodsList = new ArrayList<Node>();
    // creo un nodo di tipo classe contenente il nome della classe
    ClassTypeNode classType = new ClassTypeNode($i.text);
    // creo un nodo classe 
    ClassNode c = new ClassNode(classType, fieldsList, methodsList, entry, superClassEntry);
    // lo aggiungo alla lista delle classi (lista che viene poi restituita)
    $astList.add(c);
    
    // Inserisco l'entry anche nella class table (il controllo che non sia un nome già usato è stato fatto
    // prima tramite la symbol table).
    classTable.put($i.text, entry);
    
    // viene creato un nuovo livello e la relativa Symbol Table (anzichè creata vuota) viene 
    // settata alla Virtual Table contenuta dentro la nuova CTentry
    // incremento perchè la virtual table è sempre ad offset 1
    // in questo modo alla fine riesco a rimuoverla correttamente
    // i campi e metodi vengono settati a nesting level 1 di default (senza che glielo passi)
     nestingLevel++; 
     symbolTable.add(entry.getVirtualTable());
    }
    
    // ora scorro gli elementi della classe e aggiorno la CTEntry ad ogni campo/metodo incontrato:
   
    // questo è il costruttore, esso contiene i campi della classe che devono essere inizializzati
    // alla creazione degli oggetti in quanto immutabili
    LPAR
      // primo campo
      (pfid=ID COLON pft=basic
      // lo aggiungo alla CTEntry e alla classe
      {
        // addField ritorna il nodo field
        fieldsList.add(entry.addField($pfid.text,$pft.ast));
        
      }
      
      // mi occupo degli altri eventuali campi     
      (     
      COMMA pnid=ID COLON pnt=basic
      {
        fieldsList.add(entry.addField($pnid.text,$pnt.ast));
      }
      )* )? 
    RPAR    
    
    // inizia la dichiarazione e definizione dei metodi
    CLPAR
    
    (
      FUN mid=ID COLON mt=basic 
      {

       // creo il nodo dell'AST
       MethodNode method = new MethodNode($mid.text, $mt.ast);
       
       // aggiungo il metodo alla lista dei metodi
       methodsList.add(method);
       
       // mi memorizzo il tipo dei parametri il quale andrà insieme al tipo di ritorno
       // a comporre il tipo complessivo del metodo
       ArrayList<Node> parTypes = new ArrayList<Node>();
        
       // creo la symbol table che rappresenta il contesto del metodo
       nestingLevel++; 
       HashMap<String,STEntry> hmn = new HashMap<String,STEntry>();
       symbolTable.add(hmn);
       // qua mi salvo le dichiarazioni (per come è def la grammatica non possono essere fuzionali)
       ArrayList<Node> varList = new ArrayList<Node>();
       // per quanto riguarda il layout dei metodi devo rifarmi a quello delle funzioni:
       // i parametri iniziano dall'offset 1 e incremento
       int parOffset = 1;
       // le dichiarazioni da -2 e decremento
       int varOffset = -2;
       // ps. a 0 ho l'AL e a -1 il RA
       }
      
      // lavoro sui parametri aggiungengoli al metodo e alla symbol table man mano che li incontro
      LPAR 
        (
          // primo parametro
          mpfid=ID COLON mpft=type
          {
            ParNode firstPar = new ParNode($mpfid.text,$mpft.ast);
            method.addParameter(firstPar);
            parTypes.add($mpft.ast);
                        
            // verifico eventuali duplicati e aggiungo alla symbol table (primo par) 
            // [Remember: i parametri sono allo stesso livello del corpo della fun]
            if(hmn.put($mpfid.text,new STEntry(nestingLevel,$mpft.ast, parOffset++))!=null){ 
	            System.out.println("Error: id "+$mpfid.text +" at line "+ $mpfid.line +" already declared!");
	            System.exit(0);
            };     
          }
          // parametri successivi
          (
            COMMA mpnid=ID COLON mtnt=type
            {
	            ParNode nextPat = new ParNode($mpnid.text,$mtnt.ast);
	            method.addParameter(nextPat);
              parTypes.add($mtnt.ast);
              
              if(hmn.put($mpnid.text,new STEntry(nestingLevel,$mtnt.ast, parOffset++))!=null){ 
	              System.out.println("Error: id "+$mpnid.text +" at line "+ $mpnid.line +" already declared!");
	              System.exit(0);
	            };
              
            }
          )* )?
        
      RPAR
      // ora ci sono le dichiarazioni (che non possono essere ulteriormente annidate) e potrebbero anche non esserci
      (
        LET
        // scorro tutte le variabili
        (
          VAR vid=ID COLON vty=basic ASS vexp=exp SEMIC
          {
             VarNode v = new VarNode($vid.text, $vty.ast, $vexp.ast);
             varList.add(v);
             // verifico eventuali duplicati
             if(hmn.put($vid.text,new STEntry(nestingLevel,$vty.ast, varOffset--))!=null){ 
             System.out.println("Error: id "+$vty.text +" at line "+ $vid.line +" already declared!");
             System.exit(0);
             };
          }
        )*
        // devo aggiungere le dichiarazioni al metodo
        {method.addDec(varList);}
        IN 
        
      )? 
      
      mexp=exp
      // aggiungo il body al metodo
      {method.addBody($mexp.ast);}
      SEMIC
      
      {
        // è finito lo scope del metodo quindo posso rimuovere la symbol table corrispondente
        // e decrementare il NL
        symbolTable.remove(nestingLevel--);
        // istanzio il nodo che rappresenta il tipo del metodo
        ArrowTypeNode methodType = new ArrowTypeNode(parTypes,$mt.ast);
        // aggiungo il tipo complessivo al MethodNode
        method.addSymType(methodType);  
        // aggiungo il metodo alla virtual table e ad allMethods)
        entry.addMethod($mid.text, method);
      }
      )*                
       
      CRPAR
     
      {
        // devo ricordarmi di chiudere il livello della classe!
        symbolTable.remove(nestingLevel--);
      }
      // potrebbero esserci altre classi quindi * 
      )*
       ; 

// gestione di dichiarazioni di variabili e funzioni
declist returns [ArrayList<Node> astList] :

    {
      // creo l'arraylist vuoto, esso conterrà le dichiarazioni
      $astList = new ArrayList<Node>();
      
      // l'offset mi serve per recuperare le cose in fase di esecuzione
      // inizializzo l'offset a -2 perchè nel caso di 
      // AR dell'ambiente globale a -1 abbiamo il return address fittizio
      // mentre nel caso di layout AR funzione a 0 c'è l'AL e a -1 il RA
      int offset = -2;
    }
    
    ( 
      // le dichiarazioni possono essere di variabili o funzioni
    ( 
       // DICHIARAZIONE DI VARIABILE
       VAR i=ID COLON t=type ASS e=exp
        {
          VarNode v = new VarNode($i.text, $t.ast, $e.ast);
          $astList.add(v);
          // ora che ho dichiarato la var la aggiungo alla symbol table
          // recupero l'hash table dell'ambiente dove sto parsando
          HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
          // controllo che niente sia dichiarato con lo stesso nome
          if(hm.put($i.text,new STEntry(nestingLevel,$t.ast, offset--))!=null){ 
		        System.out.println("Error: id "+$i.text +" at line "+ $i.line +" already declared!");
		        System.exit(0);
		        };
		      // se la variabile è di tipo funzione occupa due offset
		      // TODO: è da verificare se può esistere (non credo)
		      if($t.ast instanceof ArrowTypeNode){offset--;}
		     }
       |
       // DICHIARAZIONE DI FUNZIONE                          
       FUN i=ID COLON t=type 
        {
          FunNode f = new FunNode($i.text, $t.ast); 
          $astList.add(f);  
          HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
         // creo una entry con solo il nesting level e l'offset
         // ci metterò il tipo quando lo saprò (lo capisco dopo aver letto il tipo di tutti i parametri)
         STEntry entry = new STEntry(nestingLevel,offset);
         // la funzione occupa due offset (vedi layout high order)
         offset-=2;
         // inserisco l'ID della funzione nella symbol table	                                             
         if(hm.put($i.text,entry)!=null){
          System.out.println("Error: id "+$i.text +" at line "+ $i.line +" already declared!");
	        System.exit(0);
	       };
	       // i parametri assumiamo facciano parte del corpo della funzione
	       // creo una hashmap che rappresenta il contesto interno alla funzione
         nestingLevel++; 
         HashMap<String,STEntry> hmn = new HashMap<String,STEntry>();
         symbolTable.add(hmn);
         
         // creo un array list per mantenere il tipo dei parametri             
         ArrayList<Node> parTypes = new ArrayList<Node>();
         int parOffset = 1; //i parametri iniziano da 1 nel layout e l'offset si incrementa
        
         } 
                               
         LPAR 
         
         // dichiarazione dei parametri
          (fid=ID COLON fty=type 
            { 
              parTypes.add($fty.ast);
              ParNode fpar = new ParNode($fid.text, $fty.ast);
              f.addParameter(fpar);
              // nel caso in cui sia presente qualche parametro di tipo funzionale devo riservare due
              // spazi. Incremento prima in modo da memorizzare nell'entry l'offset corretto
              if($fty.ast instanceof ArrowTypeNode){parOffset++;}
              if(hmn.put($fid.text,new STEntry(nestingLevel,$fty.ast,parOffset++))!=null){
                System.out.println("Error: id "+$fid.text +" at line "+ $fid.line +" already declared!");
                System.exit(0);
              };
              
             }                                
          
             (COMMA id=ID COLON ty=type 
              { 
                parTypes.add($ty.ast);
                ParNode par = new ParNode($id.text, $ty.ast);
                f.addParameter(par);
                if($ty.ast instanceof ArrowTypeNode){parOffset++;}
                if(hmn.put($id.text,new STEntry(nestingLevel,$ty.ast, parOffset++))!=null){
                  System.out.println("Error: id "+$id.text +" at line "+ $id.line +" already declared!");
                  System.exit(0);
                };
               
               }
              )*  //potrebbero esserci più parametri
              )?  //potrebbero non esserci affatto parametri
         RPAR 
          {// ora posso istanziare il nodo che rappresenta il tipo della funzione
            ArrowTypeNode functionType = new ArrowTypeNode(parTypes,$t.ast);
            entry.addType(functionType);
            // aggiungo il tipo anche al FunNode
            f.addSymType(functionType);
          }
         (LET d=declist IN{f.addDec($d.astList);})? e=exp 
          {//chiudo lo scope
            symbolTable.remove(nestingLevel--);
	          f.addBody($e.ast);
          }
         )SEMIC
        )+
        ;     
                                                                                                                                   
exp returns [Node ast] :
  v=term {$ast = $v.ast;}
        (
            PLUS l=term {$ast = new PlusNode($ast,$l.ast);}
          | MINUS l=term {$ast = new MinusNode($ast,$l.ast);}
          | OR l=term {$ast = new OrNode($ast,$l.ast);}
        )*;


term returns [Node ast] :
  f=factor {$ast = $f.ast;} 
      (
          TIMES l=factor {$ast = new TimesNode($ast,$l.ast);}
        | DIV  l=factor {$ast = new DivNode($ast,$l.ast);}
        | AND  l=factor {$ast = new AndNode($ast,$l.ast);}
        )* ;
        	                                              
factor returns [Node ast]: 
  v=value {$ast = $v.ast;} 
      (
        EQ v=value {$ast = new EqualNode($ast,$v.ast);}
      | GR v=value {$ast = new GreaterEqualNode($ast,$v.ast);}
      | LE v=value {$ast = new LowerEqualNode($ast,$v.ast);}
    )*
  ;     
     
value returns [Node ast] :
        n=NAT { $ast = new NatNode(Integer.parseInt($n.text)); } |
				TRUE {$ast = new BoolNode(true);}   |
				FALSE {$ast = new BoolNode(false);} |                              
				NULL {$ast = new EmptyNode();}|
				NEW nid=ID LPAR
				{
				  // creo la lista dei parametri che contengono le espressioni passate alla new
				  ArrayList<Node> parList = new ArrayList<Node>();
				  // recupero la CTEntry che descrive la classe
				  CTEntry classEntry = classTable.get($nid.text);
				  // verifico che sia effettivamente definita
				  if(classEntry == null){
				    System.out.println("Error: class "+$nid.text+" at line " +$nid.line+ " not declared!");
            System.exit(0);
				  }
				  // creo il new node
				  NewNode nn = new NewNode($nid.text,classEntry, parList);
				}
				  // aggiungo i parametri man mano che li incotro
				 (nfe=exp {parList.add($nfe.ast);} (COMMA nne=exp {parList.add($nne.ast);})* )? RPAR 
				 // restituisco il new Node
				 {$ast = nn;} |      
				LPAR e=exp RPAR {$ast = $e.ast;}  |                      
        IF c=exp THEN CLPAR t=exp CRPAR
                 ELSE CLPAR e=exp CRPAR {$ast = new IfElseNode($c.ast, $t.ast, $e.ast);}         |
        NOT LPAR e=exp {$ast = new NotNode($e.ast);} RPAR |
        PRINT LPAR e=exp {$ast = new PrintNode($e.ast);} RPAR |
        i=ID {        
              //cerco l'id nella symbol table
              int j = nestingLevel;
              STEntry entry = null;
              
              while(j>=0 && entry==null){
                entry = symbolTable.get(j).get($i.text);  
                j--;
              }
              
              if(entry == null){
                System.out.println("Error: "+$i.text+" at line " +$i.line+ " not declared!");
                System.exit(0);
              }
              
              // associo l'utilizzo con la dichiarazione 
              $ast = new IdNode($i.text,entry,nestingLevel);
          
            } 
            // se vado oltre => posso avere: chiamata di funzione x() o invocazione metodo x.m()
            (
              // CHIAMATA DI FUNZIONE
              LPAR {ArrayList<Node> argList = new ArrayList<Node>();}
              (fa=exp {argList.add($fa.ast);}
              (COMMA a=exp {argList.add($a.ast);})*
              )?
            RPAR {$ast = new CallNode($i.text, entry, argList, nestingLevel);} 
            //se eseguo quello qui dentro sostituisco l'IdNode generato sopra  
                          |
            // INVOCAZIONE METODO
            DOT mid=ID 
            {
              // la variabile che punta all'oggetto è dichiarata nello stack
              // l'id dell'oggetto della classe è catturato da $i settato li su
              
              // innanzitutto verifico se classe e metodo esistono
              
              // ricavo il tipo dell'oggetto
              ClassTypeNode classType = (ClassTypeNode)entry.getType();
              // cerco nella class table la classe
              CTEntry classEntry = classTable.get(classType.getType());
              if(classEntry == null){
	              System.out.println("Error: class "+classType.getType()+" at line " +$i.line+ " not declared!");
	              System.exit(0);
              } 
              // cerco il metodo nella virtual table
              STEntry methodEntry = classEntry.getVirtualTable().get($mid.text);
              if(methodEntry == null){
                System.out.println("Error: method "+$mid.text+" at line " +$mid.line+ " not defined!");
                System.exit(0);
              }
            }
            // parametri del metodo
            {
              // creo una lista di parametri
              ArrayList<Node> parList = new ArrayList<Node>();
            }
            LPAR
             (fe = exp {parList.add($fe.ast);} (COMMA ne=exp {parList.add($ne.ast);})* )? 
            RPAR 
            
            {
              // creo il nodo che verrà restituito
              $ast = new ClassCallNode($i.text, entry, $mid.text, methodEntry, parList,nestingLevel);
            }
            
            )?  
        ;
                              
type  returns [Node ast]  : 
         b=basic  {$ast = $b.ast;} 
      |  a=arrow {$ast = $a.ast;} 
        ;

// IntNode è un valore
// IntTypeNode rappresenta la dichiarazione di una variabile di tipo int => non ha nessun parametro

basic  returns [Node ast] : 
    INT {$ast = new IntTypeNode();}   
  | BOOL {$ast = new BoolTypeNode();}              
  | i=ID   {$ast = new ClassTypeNode($i.text);}                     
  ;  
   
arrow  returns [Node ast] : 
  {
    //lista dei parametri
    ArrayList<Node> parList = new ArrayList<Node>();
  }
  LPAR (t=type {parList.add($t.ast);} (COMMA t=type {parList.add($t.ast);})* )? RPAR ARROW b=basic
  // il tipo della funzione da ritornare
 {$ast = new ArrowTypeNode(parList,$b.ast);}
  ;          


// LEXER RULES

PLUS	: '+' ;
TIMES	: '*' ;
MINUS   : '-' ;
DIV   : '/' ;

SEMIC : ';' ;

OR  : '||';
AND : '&&';
NOT : 'not' ;
GR  : '>=' ;
LE  : '<=' ;
EQ  : '==' ;  

NAT	: (('1'..'9')('0'..'9')*) | '0' ;   
TRUE  : 'true' ;
FALSE : 'false' ;
LPAR  : '(' ;
RPAR  : ')' ;
CLPAR   : '{' ;
CRPAR : '}' ;
IF  : 'if' ;
THEN  : 'then' ;
ELSE  : 'else' ;
PRINT : 'print' ;
FUN : 'fun' ;
CLASS : 'class' ; 
EXTENDS : 'extends' ; 
NEW   : 'new' ; 
NULL    : 'null' ;   
LET     : 'let' ; 
IN      : 'in' ;
VAR     : 'var' ;
COLON   : ':' ; 
COMMA : ',' ;
DOT : '.' ;
ASS : '=' ;
INT : 'int' ;

ARROW   : '->' ;  

BOOL  : 'bool' ;
/* L'id deve avere priorità inferiore rispetto a tt le keyword*/
ID    : ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;
/*
  $channel = HIDDEN cioè non deve passare quel token al parser
*/
WHITESP : (' '|'\t'|'\n'|'\r')+ { $channel=HIDDEN;};

// non passo al parser i commenti
COMMENT : '/*' .* '*/' { $channel=HIDDEN; } ;

ERR	: . {System.err.println("Invalid char: "+$text); lexicalErrors++;
             $channel=HIDDEN;} ;
/*tutto quello che non matcha con le regole precedenti => viene preso dal . come errore*/
          	      
	/*
	
	  La grammatica è questa ed è la disambiguazione di quella sotto:
	  
	  exp -> term + exp | term
	  term -> value * term | value
	  value -> NUM | (exp)
	
	  E -> E+E | E*E | NUM | ( E )
	  La disambiguo facendo dei livelli diversi.
	  
	  Qua l'associatività è a destra.
	  1 +              1+1
	  1 *              1*1
	  
	  perchè term non può più avere un +
	  
	  ANTLR è un generatore di compilatori.
	
	*/
	