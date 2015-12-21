grammar FOOL;

@header {
  import java.util.ArrayList;
  import java.util.HashMap;
}


@members {
// Queste diventano variabili globali

// è il livello dell'ambiente globale
private int nestingLevel = -1; 

private  ArrayList<HashMap<String,STEntry>> symbolTable = new ArrayList<HashMap<String,STEntry>>(); 

}

@lexer::members {
int lexicalErrors=0;
/* Queste cose diventano un campo della classe SimpleExpLexer.java */
}
  

// PARSER RULES
 
// prog ritorna l'albero sintattico
prog returns [Node ast] :
    // se c'è solo una espressione
    e = exp SEMIC {$ast = new ProgNode($e.ast);}                     //nessuna dichiarazione: nessun ambiente globale
    // altrimenti ho anche delle dichiarazioni
    | LET 
	      {
	       nestingLevel++; 
	       HashMap<String,STEntry> hm = new HashMap<String,STEntry>();
	       symbolTable.add(hm);} 
    d=declist IN e=exp SEMIC 
         {//ora esco dall'ambiente => rimuovo la tabella nel fronte
          symbolTable.remove(nestingLevel--);
          $ast = new LetInNode($d.astList, $e.ast);}  
    ; //chiude prog
     
// ritorna un array list di nodi
declist returns [ArrayList<Node> astList] :
//creo l'arraylist vuoto, esso conterrà le dichiarazioni
    {$astList = new ArrayList<Node>();
    //inizializzo l'offset
    int offset = -2;//perchè abbiamo aggiunto l'access link
    }
    ( ( 
       VAR i=ID COLON t=type ASS e=exp      
        {VarNode v = new VarNode($i.text, $t.ast, $e.ast);
         $astList.add(v);
         //ora che ho dichiarato la var la aggiungo alla symbol table
         //recupero l'hash table dell'ambiente locale
         HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
         //ora controllo che non ci sia già
	       if(hm.put($i.text,new STEntry(nestingLevel,$t.ast, offset--))!=null){ //l'offset lo calcolo in base all'ordine in cui incontro le variabili
	        System.out.println("Error: id "+$i.text +" at line "+ $i.line +" already declared!");
	        System.exit(0);
	       };
         }  //chiude l'azione che inizia dopo la lettura della var, tipo e due punti 
       |  //oppure                          
       FUN i=ID COLON t=type 
        {FunNode f = new FunNode($i.text, $t.ast); 
         $astList.add(f);  
         HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
         //creo una entry con solo il nesting level, ci metterò il tipo quando lo saprò (lo leggo dopo aver letto tutti i parametri)
         STEntry entry = new STEntry(nestingLevel,offset--);
         // inserisco l'ID della funzione nella symbol table	                                             
         if(hm.put($i.text,entry)!=null){
          System.out.println("Error: id "+$i.text +" at line "+ $i.line +" already declared!");
	        System.exit(0);
	       };
	       //i parametri assumiamo facciano parte del corpo della funzione
	       //quindi creo una hashmap che rappresenta il contesto interno alla funzione
         nestingLevel++; 
         HashMap<String,STEntry> hmn = new HashMap<String,STEntry>();
         symbolTable.add(hmn);
         } 
         // le funzioni hanno dei parametri tra parentesi tonde
         // creo un array list per mantenere il tipo dei parametri                                   
         LPAR {
          ArrayList<Node> parTypes = new ArrayList<Node>();
          int parOffset = 1; //i parametri iniziano da 1 nel layout e l'offset si incrementa
         }
         //dichiarazione dei parametri, è scritta così perchè
         //voglio almeno un parametro, e se ce n'è più di uno
         //voglio la virgola in mezzo
          (fid=ID COLON fty=type 
            { parTypes.add($fty.ast);
              ParNode fpar = new ParNode($fid.text, $fty.ast);
              f.addParameter(fpar);
              if(hmn.put($fid.text,new STEntry(nestingLevel,$fty.ast,parOffset++))!=null){
                System.out.println("Error: id "+$fid.text +" at line "+ $fid.line +" already declared!");
                System.exit(0);
              };
             }                                
             //è molto simile alle variabili, mi creo un parnode mettendoci l'id 
             // e il tipo e lo aggiungo all'oggetto funnode .addParameter Poi 
             // aggiungo la dichiarazione del parametro STEntry alla symbol table hmn
             (COMMA id=ID COLON ty=type 
              { parTypes.add($ty.ast);
                ParNode par = new ParNode($id.text, $ty.ast);
                f.addParameter(par);
                if(hmn.put($id.text,new STEntry(nestingLevel,$ty.ast, parOffset++))!=null){
                  System.out.println("Error: id "+$id.text +" at line "+ $id.line +" already declared!");
                  System.exit(0);
                };
               }
              )*  //potrebbero esserci più parametri
              )?  //potrebbero non esserci parametri affatto
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
                                                                                                                                   
//il nodo + ha due sottoalberi
// exp è o un singolo nodo, tutto quello che può essere term
// oppure è un +, - o OR
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
              
              $ast = new IdNode($i.text,entry,nestingLevel);
              //quando trovo un id ricerco nella symbol table
              //perchè vogliamo associare all'idNode corrispondente a questo id la sua dichiarazione nella symbol table (cioè la STEntry).
          
            } /*dentro ad una espressione possiamo usare un identificatore*/
            (LPAR {ArrayList<Node> argList = new ArrayList<Node>();}
              //devo distinguere il primo dai successivi a causa della virgola
              (fa=exp {argList.add($fa.ast);}
              (COMMA a=exp {argList.add($a.ast);})*
              )?
            RPAR {$ast = new CallNode($i.text, entry, argList, nestingLevel);} //se eseguo quello qui dentro sostituisco l'IdNode generato sopra
            )?
            
        ;
                              // le parentesi non influiscono nell'albero di sintassi astratta




type  returns [Node ast]  : 
         b=basic  {$ast = $b.ast;} 
      |  a=arrow {$ast = $a.ast;} 
        ;

// IntNode è un valore
// IntTypeNode rappresenta la dichiarazione di una variabile di tipo int => non ha nessun parametro

basic  returns [Node ast] : 
    INT {$ast = new IntTypeNode();}   
  | BOOL {$ast = new BoolTypeNode();}              
  | ID                        
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
LET     : 'let' ; 
IN      : 'in' ;
VAR     : 'var' ;
COLON   : ':' ; 
COMMA : ',' ;
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
	