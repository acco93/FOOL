// $ANTLR 3.5.2 /home/acco/workspace/FOOL/FOOL.g 2016-03-06 12:58:45

  // import utilizzati nelle classi generate del parser
  import java.util.ArrayList;
  import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARROW", "ASS", "BOOL", 
		"CLASS", "CLPAR", "COLON", "COMMA", "COMMENT", "CRPAR", "DEBUG", "DIV", 
		"DOT", "ELSE", "EQ", "ERR", "EXTENDS", "FALSE", "FUN", "GR", "ID", "IF", 
		"IN", "INT", "LE", "LET", "LPAR", "MINUS", "NAT", "NEW", "NOT", "NULL", 
		"OR", "PLUS", "PRINT", "RPAR", "SEMIC", "THEN", "TIMES", "TRUE", "VAR", 
		"WHITESP"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARROW=5;
	public static final int ASS=6;
	public static final int BOOL=7;
	public static final int CLASS=8;
	public static final int CLPAR=9;
	public static final int COLON=10;
	public static final int COMMA=11;
	public static final int COMMENT=12;
	public static final int CRPAR=13;
	public static final int DEBUG=14;
	public static final int DIV=15;
	public static final int DOT=16;
	public static final int ELSE=17;
	public static final int EQ=18;
	public static final int ERR=19;
	public static final int EXTENDS=20;
	public static final int FALSE=21;
	public static final int FUN=22;
	public static final int GR=23;
	public static final int ID=24;
	public static final int IF=25;
	public static final int IN=26;
	public static final int INT=27;
	public static final int LE=28;
	public static final int LET=29;
	public static final int LPAR=30;
	public static final int MINUS=31;
	public static final int NAT=32;
	public static final int NEW=33;
	public static final int NOT=34;
	public static final int NULL=35;
	public static final int OR=36;
	public static final int PLUS=37;
	public static final int PRINT=38;
	public static final int RPAR=39;
	public static final int SEMIC=40;
	public static final int THEN=41;
	public static final int TIMES=42;
	public static final int TRUE=43;
	public static final int VAR=44;
	public static final int WHITESP=45;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public FOOLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FOOLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/acco/workspace/FOOL/FOOL.g"; }


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




	// $ANTLR start "prog"
	// /home/acco/workspace/FOOL/FOOL.g:36:1: prog returns [Node ast] : (e= exp SEMIC | LET c= cllist d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> c =null;
		ArrayList<Node> d =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:36:25: (e= exp SEMIC | LET c= cllist d= declist IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==DEBUG||LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||LA1_0==LPAR||(LA1_0 >= NAT && LA1_0 <= NULL)||LA1_0==PRINT||LA1_0==TRUE) ) {
				alt1=1;
			}
			else if ( (LA1_0==LET) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:38:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog53);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog55); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:42:5: LET c= cllist d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog80); 

					         // all'inizio del parsing passo il riferimento della map supertype a FOOLLib per poterlo
					         // utilizzare nel typechecking
								   FOOLLib.setSuperTypeMap(superType);
						       // entro in un nuovo scope quindi incremento il nesting level
						       nestingLevel++; 
						       // creo la hashmap dove memorizzo le cose che incontro
						       HashMap<String,STEntry> hm = new HashMap<String,STEntry>();
						       // la aggiungo alla mia lista di hashmap (la ricaverò successivamente tramite .get(nestingLevel))
						       symbolTable.add(hm);
						       
					pushFollow(FOLLOW_cllist_in_prog101);
					c=cllist();
					state._fsp--;

					pushFollow(FOLLOW_declist_in_prog114);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog126); 
					pushFollow(FOLLOW_exp_in_prog140);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog142); 

					      // ora esco dallo scope in cui sono quindi rimuovo la symbol table corrispondente al nesting level in esame
					      // l'albero rimane comunque decorato con le entry
					      symbolTable.remove(nestingLevel--);
					      // creo il nodo da ritornare
					      ast = new LetInNode(c,d, e);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "prog"



	// $ANTLR start "cllist"
	// /home/acco/workspace/FOOL/FOOL.g:73:1: cllist returns [ArrayList<Node> astList] : ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )* ;
	public final ArrayList<Node> cllist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token ei=null;
		Token pfid=null;
		Token pnid=null;
		Token mid=null;
		Token mpfid=null;
		Token mpnid=null;
		Token vid=null;
		ParserRuleReturnScope pft =null;
		ParserRuleReturnScope pnt =null;
		ParserRuleReturnScope mt =null;
		Node mpft =null;
		Node mtnt =null;
		ParserRuleReturnScope vty =null;
		Node vexp =null;
		Node mexp =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:73:42: ( ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )* )
			// /home/acco/workspace/FOOL/FOOL.g:75:5: ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )*
			{
			 
			    // inizializzo la lista di classi che verrà restituita a prog
			    astList = new ArrayList<Node>();
			    
			// /home/acco/workspace/FOOL/FOOL.g:80:3: ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:80:4: CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist191); 
					i=(Token)match(input,ID,FOLLOW_ID_in_cllist195); 
					    
					  
					    // la symbol table di livello 0 include STEntry per i nomi delle classi
					    // questo per controllare che nello stesso scope non vengano dichiarate altre cose
					    // con lo stesso nome
					    
					    // l'offset della entry della dichiarazoine della classe non verrà mai utilizzato in quanto
					    // la dichiarazione non viene messa in memoria (stack o heap)
					    
					    HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
					    if(hm.put((i!=null?i.getText():null),new STEntry(nestingLevel,null, 2666))!=null){ 
					          System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
					          System.exit(0);
					         };
					    
					    // creo la CTEntry che conterrà le info della classe
					    CTEntry entry = new CTEntry();
					    CTEntry superClassEntry = null;
					    
					    
					// /home/acco/workspace/FOOL/FOOL.g:103:4: ( EXTENDS ei= ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:104:5: EXTENDS ei= ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist224); 
							ei=(Token)match(input,ID,FOLLOW_ID_in_cllist228); 

							      // se finisco qua dentro significa che estendo da qualcuno, allora devo recuperare la CTEntry
							      // dalla class table della super classe (controllando che esista) e utilizzare il II costruttore di CTEntry (quello
							      // che fa la copia)
							      superClassEntry = classTable.get((ei!=null?ei.getText():null));
							      if(superClassEntry == null){
							          System.out.println("Error: class "+(ei!=null?ei.getText():null) +" at line "+ (ei!=null?ei.getLine():0) +" not declared!");
							          System.exit(0);
							      }
							      // se tutto va bene ridefinisco entry, questo costruttore fa la copia della superClassEntry
							      entry = new CTEntry(superClassEntry);
							      
							      //devo inoltre aggiornare la superType map
							      superType.put((i!=null?i.getText():null),(ei!=null?ei.getText():null));
							      
							    
							}
							break;

					}


					    
					    // creo una lista di metodi e una lista di campi vuoti
					    ArrayList<Node> fieldsList = new ArrayList<Node>();
					    ArrayList<Node> methodsList = new ArrayList<Node>();
					    // creo un nodo di tipo classe contenente il nome della classe
					    ClassTypeNode classType = new ClassTypeNode((i!=null?i.getText():null));
					    // creo un nodo classe 
					    ClassNode c = new ClassNode(classType, fieldsList, methodsList, entry, superClassEntry);
					    // lo aggiungo alla lista delle classi (lista che verrà infine restituita)
					    astList.add(c);
					    
					    // Inserisco l'entry anche nella class table (il controllo che non sia un nome già usato è stato fatto
					    // prima tramite la symbol table).
					    classTable.put((i!=null?i.getText():null), entry);
					    
					    // viene creato un nuovo livello e la relativa Symbol Table (anzichè creata vuota) viene 
					    // settata alla Virtual Table contenuta dentro la nuova CTentry
					    // incremento perchè la virtual table è sempre ad offset 1
					    // in questo modo alla fine riesco a rimuoverla correttamente
					    // i campi e metodi vengono settati a nesting level 1 di default (senza doverglielo passare, vedi addMethod e addField in CTEntry)
					     nestingLevel++; 
					     symbolTable.add(entry.getVirtualTable());
					    
					match(input,LPAR,FOLLOW_LPAR_in_cllist285); 
					// /home/acco/workspace/FOOL/FOOL.g:155:7: (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:155:8: pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )*
							{
							pfid=(Token)match(input,ID,FOLLOW_ID_in_cllist303); 
							match(input,COLON,FOLLOW_COLON_in_cllist305); 
							pushFollow(FOLLOW_basic_in_cllist309);
							pft=basic();
							state._fsp--;


							        // addField ritorna il nodo field che vado ad aggiungere alla lista dei campi definiti in questa classe
							        fieldsList.add(entry.addField((pfid!=null?pfid.getText():null),(pft!=null?((FOOLParser.basic_return)pft).ast:null)));
							        
							      
							// /home/acco/workspace/FOOL/FOOL.g:164:7: ( COMMA pnid= ID COLON pnt= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:165:7: COMMA pnid= ID COLON pnt= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist359); 
									pnid=(Token)match(input,ID,FOLLOW_ID_in_cllist363); 
									match(input,COLON,FOLLOW_COLON_in_cllist365); 
									pushFollow(FOLLOW_basic_in_cllist369);
									pnt=basic();
									state._fsp--;


									        fieldsList.add(entry.addField((pnid!=null?pnid.getText():null),(pnt!=null?((FOOLParser.basic_return)pnt).ast:null)));
									      
									}
									break;

								default :
									break loop3;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_cllist396); 
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist416); 
					// /home/acco/workspace/FOOL/FOOL.g:175:5: ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:176:7: FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist435); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_cllist439); 
							match(input,COLON,FOLLOW_COLON_in_cllist441); 
							pushFollow(FOLLOW_basic_in_cllist445);
							mt=basic();
							state._fsp--;



							       // creo il nodo dell'AST
							       MethodNode method = new MethodNode((mid!=null?mid.getText():null), (mt!=null?((FOOLParser.basic_return)mt).ast:null));
							       
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
							       
							match(input,LPAR,FOLLOW_LPAR_in_cllist476); 
							// /home/acco/workspace/FOOL/FOOL.g:205:9: (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:207:11: mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )*
									{
									mpfid=(Token)match(input,ID,FOLLOW_ID_in_cllist512); 
									match(input,COLON,FOLLOW_COLON_in_cllist514); 
									pushFollow(FOLLOW_type_in_cllist518);
									mpft=type();
									state._fsp--;


									            ParNode firstPar = new ParNode((mpfid!=null?mpfid.getText():null),mpft);
									            method.addParameter(firstPar);
									            parTypes.add(mpft);
									                        
									            // verifico eventuali duplicati e aggiungo alla symbol table (primo par) 
									            // [Remember: i parametri sono allo stesso livello del corpo della fun]
									            if(hmn.put((mpfid!=null?mpfid.getText():null),new STEntry(nestingLevel,mpft, parOffset++))!=null){ 
										            System.out.println("Error: id "+(mpfid!=null?mpfid.getText():null) +" at line "+ (mpfid!=null?mpfid.getLine():0) +" already declared!");
										            System.exit(0);
									            };     
									          
									// /home/acco/workspace/FOOL/FOOL.g:221:11: ( COMMA mpnid= ID COLON mtnt= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:222:13: COMMA mpnid= ID COLON mtnt= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist567); 
											mpnid=(Token)match(input,ID,FOLLOW_ID_in_cllist571); 
											match(input,COLON,FOLLOW_COLON_in_cllist573); 
											pushFollow(FOLLOW_type_in_cllist577);
											mtnt=type();
											state._fsp--;


												            ParNode nextPat = new ParNode((mpnid!=null?mpnid.getText():null),mtnt);
												            method.addParameter(nextPat);
											              parTypes.add(mtnt);
											              
											              if(hmn.put((mpnid!=null?mpnid.getText():null),new STEntry(nestingLevel,mtnt, parOffset++))!=null){ 
												              System.out.println("Error: id "+(mpnid!=null?mpnid.getText():null) +" at line "+ (mpnid!=null?mpnid.getLine():0) +" already declared!");
												              System.exit(0);
												            };
											              
											            
											}
											break;

										default :
											break loop5;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_cllist624); 
							// /home/acco/workspace/FOOL/FOOL.g:238:7: ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:239:9: LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist649); 
									// /home/acco/workspace/FOOL/FOOL.g:241:9: ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:242:11: VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist680); 
											vid=(Token)match(input,ID,FOLLOW_ID_in_cllist684); 
											match(input,COLON,FOLLOW_COLON_in_cllist686); 
											pushFollow(FOLLOW_basic_in_cllist690);
											vty=basic();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist692); 
											pushFollow(FOLLOW_exp_in_cllist696);
											vexp=exp();
											state._fsp--;

											match(input,SEMIC,FOLLOW_SEMIC_in_cllist698); 

											             VarNode v = new VarNode((vid!=null?vid.getText():null), (vty!=null?((FOOLParser.basic_return)vty).ast:null), vexp);
											             varList.add(v);
											             // verifico eventuali duplicati
											             if(hmn.put((vid!=null?vid.getText():null),new STEntry(nestingLevel,(vty!=null?((FOOLParser.basic_return)vty).ast:null), varOffset--))!=null){ 
											             System.out.println("Error: id "+(vty!=null?input.toString(vty.start,vty.stop):null) +" at line "+ (vid!=null?vid.getLine():0) +" already declared!");
											             System.exit(0);
											             };
											          
											}
											break;

										default :
											break loop7;
										}
									}

									method.addDec(varList);
									match(input,IN,FOLLOW_IN_in_cllist750); 
									}
									break;

							}


							       // istanzio il nodo che rappresenta il tipo del metodo
							        ArrowTypeNode methodType = new ArrowTypeNode(parTypes,(mt!=null?((FOOLParser.basic_return)mt).ast:null));
							        // aggiungo il tipo complessivo al MethodNode
							        method.addSymType(methodType);  
							        // aggiungo il metodo alla virtual table e ad allMethods
							        // NB. è necessario farlo prima di processare l'exp nel caso in cui
							        // il metodo richiami se stesso
							        entry.addMethod((mid!=null?mid.getText():null), method);
							      
							pushFollow(FOLLOW_exp_in_cllist802);
							mexp=exp();
							state._fsp--;

							method.addBody(mexp);
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist825); 

							        // è finito lo scope del metodo quindo posso rimuovere la symbol table corrispondente
							        // e decrementare il NL
							        symbolTable.remove(nestingLevel--);
							      
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist881); 

					        // devo ricordarmi di chiudere il livello interno della classe! (livello virtual table)
					        symbolTable.remove(nestingLevel--);
					      
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return astList;
	}
	// $ANTLR end "cllist"



	// $ANTLR start "declist"
	// /home/acco/workspace/FOOL/FOOL.g:293:1: declist returns [ArrayList<Node> astList] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astList = null;


		Token i=null;
		Token fid=null;
		Token id=null;
		Node t =null;
		Node e =null;
		Node fty =null;
		Node ty =null;
		ArrayList<Node> d =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:293:43: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// /home/acco/workspace/FOOL/FOOL.g:295:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{

			      // creo l'arraylist vuoto, esso conterrà le dichiarazioni
			      astList = new ArrayList<Node>();
			      
			      // l'offset mi serve per recuperare le cose in fase di esecuzione
			      // inizializzo l'offset a -2 perchè nel caso di 
			      // AR dell'ambiente globale a -1 abbiamo il return address fittizio
			      // mentre nel caso di layout AR funzione a 0 c'è l'AL e a -1 il RA
			      int offset = -2;
			    
			// /home/acco/workspace/FOOL/FOOL.g:306:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==FUN||LA15_0==VAR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:308:5: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// /home/acco/workspace/FOOL/FOOL.g:308:5: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==VAR) ) {
						alt14=1;
					}
					else if ( (LA14_0==FUN) ) {
						alt14=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:310:8: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist981); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist985); 
							match(input,COLON,FOLLOW_COLON_in_declist987); 
							pushFollow(FOLLOW_type_in_declist991);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist993); 
							pushFollow(FOLLOW_exp_in_declist997);
							e=exp();
							state._fsp--;


							          VarNode v = new VarNode((i!=null?i.getText():null), t, e);
							          astList.add(v);
							          // ora che ho dichiarato la var la aggiungo alla symbol table
							          // recupero l'hash table dell'ambiente dove sto parsando
							          HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
							          // controllo che niente sia dichiarato con lo stesso nome
							          if(hm.put((i!=null?i.getText():null),new STEntry(nestingLevel,t, offset--))!=null){ 
									        System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
									        System.exit(0);
									        };
									      // se la variabile è di tipo funzione occupa due offset
									      // TODO: è da verificare se può esistere (non credo)
									      // if(t instanceof ArrowTypeNode){offset--;}
									     
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:328:8: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist1033); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist1037); 
							match(input,COLON,FOLLOW_COLON_in_declist1039); 
							pushFollow(FOLLOW_type_in_declist1043);
							t=type();
							state._fsp--;


							          FunNode f = new FunNode((i!=null?i.getText():null), t); 
							          astList.add(f);  
							          HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
							         // creo una entry con solo il nesting level e l'offset
							         // ci metterò il tipo quando lo saprò (lo capisco dopo aver letto il tipo di tutti i parametri)
							         STEntry entry = new STEntry(nestingLevel,offset);
							         // la funzione occupa due offset (vedi layout high order)
							         offset-=2;
							         // inserisco l'ID della funzione nella symbol table	                                             
							         if(hm.put((i!=null?i.getText():null),entry)!=null){
							          System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
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
							        
							         
							match(input,LPAR,FOLLOW_LPAR_in_declist1098); 
							// /home/acco/workspace/FOOL/FOOL.g:358:11: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:358:12: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist1134); 
									match(input,COLON,FOLLOW_COLON_in_declist1136); 
									pushFollow(FOLLOW_type_in_declist1140);
									fty=type();
									state._fsp--;

									 
									              parTypes.add(fty);
									              ParNode fpar = new ParNode((fid!=null?fid.getText():null), fty);
									              f.addParameter(fpar);
									              // nel caso in cui sia presente qualche parametro di tipo funzionale devo riservare due
									              // spazi. Incremento prima in modo da memorizzare nell'entry l'offset corretto
									              if(fty instanceof ArrowTypeNode){parOffset++;}
									              if(hmn.put((fid!=null?fid.getText():null),new STEntry(nestingLevel,fty,parOffset++))!=null){
									                System.out.println("Error: id "+(fid!=null?fid.getText():null) +" at line "+ (fid!=null?fid.getLine():0) +" already declared!");
									                System.exit(0);
									              };
									              
									             
									// /home/acco/workspace/FOOL/FOOL.g:373:14: ( COMMA id= ID COLON ty= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:373:15: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist1214); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist1218); 
											match(input,COLON,FOLLOW_COLON_in_declist1220); 
											pushFollow(FOLLOW_type_in_declist1224);
											ty=type();
											state._fsp--;

											 
											                parTypes.add(ty);
											                ParNode par = new ParNode((id!=null?id.getText():null), ty);
											                f.addParameter(par);
											                if(ty instanceof ArrowTypeNode){parOffset++;}
											                if(hmn.put((id!=null?id.getText():null),new STEntry(nestingLevel,ty, parOffset++))!=null){
											                  System.out.println("Error: id "+(id!=null?id.getText():null) +" at line "+ (id!=null?id.getLine():0) +" already declared!");
											                  System.exit(0);
											                };
											               
											               
											}
											break;

										default :
											break loop11;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_declist1290); 
							// ora posso istanziare il nodo che rappresenta il tipo della funzione
							            ArrowTypeNode functionType = new ArrowTypeNode(parTypes,t);
							            entry.addType(functionType);
							            // aggiungo il tipo anche al FunNode
							            f.addSymType(functionType);
							          
							// /home/acco/workspace/FOOL/FOOL.g:394:10: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:394:11: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist1315); 
									pushFollow(FOLLOW_declist_in_declist1319);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist1321); 
									f.addDec(d);
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist1328);
							e=exp();
							state._fsp--;

							//chiudo lo scope
							            symbolTable.remove(nestingLevel--);
								          f.addBody(e);
							          
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist1353); 
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return astList;
	}
	// $ANTLR end "declist"



	// $ANTLR start "exp"
	// /home/acco/workspace/FOOL/FOOL.g:403:1: exp returns [Node ast] : (v= term ( PLUS l= term | MINUS l= term | OR l= term )* | DEBUG LPAR e= exp RPAR );
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node v =null;
		Node l =null;
		Node e =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:403:24: (v= term ( PLUS l= term | MINUS l= term | OR l= term )* | DEBUG LPAR e= exp RPAR )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==FALSE||(LA17_0 >= ID && LA17_0 <= IF)||LA17_0==LPAR||(LA17_0 >= NAT && LA17_0 <= NULL)||LA17_0==PRINT||LA17_0==TRUE) ) {
				alt17=1;
			}
			else if ( (LA17_0==DEBUG) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:404:3: v= term ( PLUS l= term | MINUS l= term | OR l= term )*
					{
					pushFollow(FOLLOW_term_in_exp1525);
					v=term();
					state._fsp--;

					ast = v;
					// /home/acco/workspace/FOOL/FOOL.g:405:9: ( PLUS l= term | MINUS l= term | OR l= term )*
					loop16:
					while (true) {
						int alt16=4;
						switch ( input.LA(1) ) {
						case PLUS:
							{
							alt16=1;
							}
							break;
						case MINUS:
							{
							alt16=2;
							}
							break;
						case OR:
							{
							alt16=3;
							}
							break;
						}
						switch (alt16) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:406:13: PLUS l= term
							{
							match(input,PLUS,FOLLOW_PLUS_in_exp1551); 
							pushFollow(FOLLOW_term_in_exp1555);
							l=term();
							state._fsp--;

							ast = new PlusNode(ast,l);
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:407:13: MINUS l= term
							{
							match(input,MINUS,FOLLOW_MINUS_in_exp1571); 
							pushFollow(FOLLOW_term_in_exp1575);
							l=term();
							state._fsp--;

							ast = new MinusNode(ast,l);
							}
							break;
						case 3 :
							// /home/acco/workspace/FOOL/FOOL.g:408:13: OR l= term
							{
							match(input,OR,FOLLOW_OR_in_exp1591); 
							pushFollow(FOLLOW_term_in_exp1595);
							l=term();
							state._fsp--;

							ast = new OrNode(ast,l);
							}
							break;

						default :
							break loop16;
						}
					}

					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:410:6: DEBUG LPAR e= exp RPAR
					{
					match(input,DEBUG,FOLLOW_DEBUG_in_exp1617); 
					match(input,LPAR,FOLLOW_LPAR_in_exp1619); 
					pushFollow(FOLLOW_exp_in_exp1623);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_exp1625); 
					ast = new DebugNode(e);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// /home/acco/workspace/FOOL/FOOL.g:413:1: term returns [Node ast] : f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:413:25: (f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* )
			// /home/acco/workspace/FOOL/FOOL.g:414:3: f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1654);
			f=factor();
			state._fsp--;

			ast = f;
			// /home/acco/workspace/FOOL/FOOL.g:415:7: ( TIMES l= factor | DIV l= factor | AND l= factor )*
			loop18:
			while (true) {
				int alt18=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt18=1;
					}
					break;
				case DIV:
					{
					alt18=2;
					}
					break;
				case AND:
					{
					alt18=3;
					}
					break;
				}
				switch (alt18) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:416:11: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term1677); 
					pushFollow(FOLLOW_factor_in_term1681);
					l=factor();
					state._fsp--;

					ast = new TimesNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:417:11: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1695); 
					pushFollow(FOLLOW_factor_in_term1700);
					l=factor();
					state._fsp--;

					ast = new DivNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:418:11: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1714); 
					pushFollow(FOLLOW_factor_in_term1719);
					l=factor();
					state._fsp--;

					ast = new AndNode(ast,l);
					}
					break;

				default :
					break loop18;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "factor"
	// /home/acco/workspace/FOOL/FOOL.g:421:1: factor returns [Node ast] : v= value ( EQ v= value | GR v= value | LE v= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node v =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:421:26: (v= value ( EQ v= value | GR v= value | LE v= value )* )
			// /home/acco/workspace/FOOL/FOOL.g:422:3: v= value ( EQ v= value | GR v= value | LE v= value )*
			{
			pushFollow(FOLLOW_value_in_factor1804);
			v=value();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:423:7: ( EQ v= value | GR v= value | LE v= value )*
			loop19:
			while (true) {
				int alt19=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt19=1;
					}
					break;
				case GR:
					{
					alt19=2;
					}
					break;
				case LE:
					{
					alt19=3;
					}
					break;
				}
				switch (alt19) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:424:9: EQ v= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1825); 
					pushFollow(FOLLOW_value_in_factor1829);
					v=value();
					state._fsp--;

					ast = new EqualNode(ast,v);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:425:9: GR v= value
					{
					match(input,GR,FOLLOW_GR_in_factor1841); 
					pushFollow(FOLLOW_value_in_factor1845);
					v=value();
					state._fsp--;

					ast = new GreaterEqualNode(ast,v);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:426:9: LE v= value
					{
					match(input,LE,FOLLOW_LE_in_factor1857); 
					pushFollow(FOLLOW_value_in_factor1861);
					v=value();
					state._fsp--;

					ast = new LowerEqualNode(ast,v);
					}
					break;

				default :
					break loop19;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "factor"



	// $ANTLR start "value"
	// /home/acco/workspace/FOOL/FOOL.g:430:1: value returns [Node ast] : (n= NAT | TRUE | FALSE | NULL | NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token nid=null;
		Token i=null;
		Token mid=null;
		Node nfe =null;
		Node nne =null;
		Node e =null;
		Node c =null;
		Node t =null;
		Node fa =null;
		Node a =null;
		Node fe =null;
		Node ne =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:430:26: (n= NAT | TRUE | FALSE | NULL | NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )? )
			int alt27=10;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt27=1;
				}
				break;
			case TRUE:
				{
				alt27=2;
				}
				break;
			case FALSE:
				{
				alt27=3;
				}
				break;
			case NULL:
				{
				alt27=4;
				}
				break;
			case NEW:
				{
				alt27=5;
				}
				break;
			case LPAR:
				{
				alt27=6;
				}
				break;
			case IF:
				{
				alt27=7;
				}
				break;
			case NOT:
				{
				alt27=8;
				}
				break;
			case PRINT:
				{
				alt27=9;
				}
				break;
			case ID:
				{
				alt27=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:431:9: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_value1905); 
					 ast = new NatNode(Integer.parseInt((n!=null?n.getText():null))); 
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:432:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1915); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:433:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1927); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// /home/acco/workspace/FOOL/FOOL.g:434:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1967); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// /home/acco/workspace/FOOL/FOOL.g:435:5: NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1976); 
					nid=(Token)match(input,ID,FOLLOW_ID_in_value1980); 
					match(input,LPAR,FOLLOW_LPAR_in_value1982); 

									  // creo la lista dei parametri che contengono le espressioni passate alla new
									  ArrayList<Node> parList = new ArrayList<Node>();
									  // recupero la CTEntry che descrive la classe
									  CTEntry classEntry = classTable.get((nid!=null?nid.getText():null));
									  // verifico che sia effettivamente definita
									  if(classEntry == null){
									    System.out.println("Error: class "+(nid!=null?nid.getText():null)+" at line " +(nid!=null?nid.getLine():0)+ " not declared!");
					            System.exit(0);
									  }
									  // creo il new node
									  NewNode nn = new NewNode((nid!=null?nid.getText():null),classEntry, parList);
									
					// /home/acco/workspace/FOOL/FOOL.g:450:6: (nfe= exp ( COMMA nne= exp )* )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==DEBUG||LA21_0==FALSE||(LA21_0 >= ID && LA21_0 <= IF)||LA21_0==LPAR||(LA21_0 >= NAT && LA21_0 <= NULL)||LA21_0==PRINT||LA21_0==TRUE) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:450:7: nfe= exp ( COMMA nne= exp )*
							{
							pushFollow(FOLLOW_exp_in_value2005);
							nfe=exp();
							state._fsp--;

							parList.add(nfe);
							// /home/acco/workspace/FOOL/FOOL.g:450:40: ( COMMA nne= exp )*
							loop20:
							while (true) {
								int alt20=2;
								int LA20_0 = input.LA(1);
								if ( (LA20_0==COMMA) ) {
									alt20=1;
								}

								switch (alt20) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:450:41: COMMA nne= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value2010); 
									pushFollow(FOLLOW_exp_in_value2014);
									nne=exp();
									state._fsp--;

									parList.add(nne);
									}
									break;

								default :
									break loop20;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_value2023); 
					ast = nn;
					}
					break;
				case 6 :
					// /home/acco/workspace/FOOL/FOOL.g:453:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value2051); 
					pushFollow(FOLLOW_exp_in_value2055);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value2057); 
					ast = e;
					}
					break;
				case 7 :
					// /home/acco/workspace/FOOL/FOOL.g:454:9: IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value2094); 
					pushFollow(FOLLOW_exp_in_value2098);
					c=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value2100); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value2102); 
					pushFollow(FOLLOW_exp_in_value2106);
					t=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value2108); 
					match(input,ELSE,FOLLOW_ELSE_in_value2127); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value2129); 
					pushFollow(FOLLOW_exp_in_value2133);
					e=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value2135); 
					ast = new IfElseNode(c, t, e);
					}
					break;
				case 8 :
					// /home/acco/workspace/FOOL/FOOL.g:456:9: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value2157); 
					match(input,LPAR,FOLLOW_LPAR_in_value2159); 
					pushFollow(FOLLOW_exp_in_value2163);
					e=exp();
					state._fsp--;

					ast = new NotNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value2167); 
					}
					break;
				case 9 :
					// /home/acco/workspace/FOOL/FOOL.g:457:9: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value2179); 
					match(input,LPAR,FOLLOW_LPAR_in_value2181); 
					pushFollow(FOLLOW_exp_in_value2185);
					e=exp();
					state._fsp--;

					ast = new PrintNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value2189); 
					}
					break;
				case 10 :
					// /home/acco/workspace/FOOL/FOOL.g:458:9: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value2203); 
					        
					              //cerco l'id nella symbol table
					              int j = nestingLevel;
					              STEntry entry = null;
					              
					              while(j>=0 && entry==null){
					                entry = symbolTable.get(j).get((i!=null?i.getText():null));  
					                j--;
					              }
					              
					              if(entry == null){
					                System.out.println("Error: "+(i!=null?i.getText():null)+" at line " +(i!=null?i.getLine():0)+ " not declared!");
					                System.exit(0);
					              }
					              
					              // associo l'utilizzo con la dichiarazione 
					              ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
					          
					            
					// /home/acco/workspace/FOOL/FOOL.g:478:13: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )?
					int alt26=3;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==LPAR) ) {
						alt26=1;
					}
					else if ( (LA26_0==DOT) ) {
						alt26=2;
					}
					switch (alt26) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:480:15: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value2264); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// /home/acco/workspace/FOOL/FOOL.g:481:15: (fa= exp ( COMMA a= exp )* )?
							int alt23=2;
							int LA23_0 = input.LA(1);
							if ( (LA23_0==DEBUG||LA23_0==FALSE||(LA23_0 >= ID && LA23_0 <= IF)||LA23_0==LPAR||(LA23_0 >= NAT && LA23_0 <= NULL)||LA23_0==PRINT||LA23_0==TRUE) ) {
								alt23=1;
							}
							switch (alt23) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:481:16: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value2285);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// /home/acco/workspace/FOOL/FOOL.g:482:15: ( COMMA a= exp )*
									loop22:
									while (true) {
										int alt22=2;
										int LA22_0 = input.LA(1);
										if ( (LA22_0==COMMA) ) {
											alt22=1;
										}

										switch (alt22) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:482:16: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value2304); 
											pushFollow(FOLLOW_exp_in_value2308);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop22;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value2343); 
							ast = new CallNode((i!=null?i.getText():null), entry, argList, nestingLevel);
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:488:13: DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value2414); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_value2418); 

							              // la variabile che punta all'oggetto è dichiarata nello stack
							              // l'id dell'oggetto della classe è catturato da i settato li su
							              
							              // innanzitutto verifico se classe e metodo esistono
							              
							              // ricavo il tipo dell'oggetto
							              ClassTypeNode classType = (ClassTypeNode)entry.getType();
							              // cerco nella class table la classe
							              CTEntry classEntry = classTable.get(classType.getType());
							              if(classEntry == null){
								              System.out.println("Error: class "+classType.getType()+" at line " +(i!=null?i.getLine():0)+ " not declared!");
								              System.exit(0);
							              } 
							              // cerco il metodo nella virtual table
							              STEntry methodEntry = classEntry.getVirtualTable().get((mid!=null?mid.getText():null));
							              if(methodEntry == null){
							                System.out.println("Error: method "+(mid!=null?mid.getText():null)+" at line " +(mid!=null?mid.getLine():0)+ " not defined!");
							                System.exit(0);
							              }
							            

							              // creo una lista di parametri
							              ArrayList<Node> parList = new ArrayList<Node>();
							            
							match(input,LPAR,FOLLOW_LPAR_in_value2474); 
							// /home/acco/workspace/FOOL/FOOL.g:516:14: (fe= exp ( COMMA ne= exp )* )?
							int alt25=2;
							int LA25_0 = input.LA(1);
							if ( (LA25_0==DEBUG||LA25_0==FALSE||(LA25_0 >= ID && LA25_0 <= IF)||LA25_0==LPAR||(LA25_0 >= NAT && LA25_0 <= NULL)||LA25_0==PRINT||LA25_0==TRUE) ) {
								alt25=1;
							}
							switch (alt25) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:516:15: fe= exp ( COMMA ne= exp )*
									{
									pushFollow(FOLLOW_exp_in_value2494);
									fe=exp();
									state._fsp--;

									parList.add(fe);
									// /home/acco/workspace/FOOL/FOOL.g:516:48: ( COMMA ne= exp )*
									loop24:
									while (true) {
										int alt24=2;
										int LA24_0 = input.LA(1);
										if ( (LA24_0==COMMA) ) {
											alt24=1;
										}

										switch (alt24) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:516:49: COMMA ne= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value2499); 
											pushFollow(FOLLOW_exp_in_value2503);
											ne=exp();
											state._fsp--;

											parList.add(ne);
											}
											break;

										default :
											break loop24;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value2525); 

							              // creo il nodo che verrà restituito
							              ast = new ClassCallNode((i!=null?i.getText():null), entry, (mid!=null?mid.getText():null), methodEntry, parList,nestingLevel);
							            
							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "value"



	// $ANTLR start "type"
	// /home/acco/workspace/FOOL/FOOL.g:527:1: type returns [Node ast] : (b= basic |a= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		ParserRuleReturnScope b =null;
		Node a =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:527:27: (b= basic |a= arrow )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==BOOL||LA28_0==ID||LA28_0==INT) ) {
				alt28=1;
			}
			else if ( (LA28_0==LPAR) ) {
				alt28=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:528:10: b= basic
					{
					pushFollow(FOLLOW_basic_in_type2648);
					b=basic();
					state._fsp--;

					ast = (b!=null?((FOOLParser.basic_return)b).ast:null);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:529:10: a= arrow
					{
					pushFollow(FOLLOW_arrow_in_type2665);
					a=arrow();
					state._fsp--;

					ast = a;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "type"


	public static class basic_return extends ParserRuleReturnScope {
		public Node ast;
	};


	// $ANTLR start "basic"
	// /home/acco/workspace/FOOL/FOOL.g:535:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final FOOLParser.basic_return basic() throws RecognitionException {
		FOOLParser.basic_return retval = new FOOLParser.basic_return();
		retval.start = input.LT(1);

		Token i=null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:535:27: ( INT | BOOL |i= ID )
			int alt29=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt29=1;
				}
				break;
			case BOOL:
				{
				alt29=2;
				}
				break;
			case ID:
				{
				alt29=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:536:5: INT
					{
					match(input,INT,FOLLOW_INT_in_basic2698); 
					retval.ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:537:5: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic2709); 
					retval.ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:538:5: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic2733); 
					retval.ast = new ClassTypeNode((i!=null?i.getText():null));
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "basic"



	// $ANTLR start "arrow"
	// /home/acco/workspace/FOOL/FOOL.g:541:1: arrow returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node t =null;
		ParserRuleReturnScope b =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:541:27: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic )
			// /home/acco/workspace/FOOL/FOOL.g:542:3: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic
			{

			    //lista dei parametri
			    ArrayList<Node> parList = new ArrayList<Node>();
			  
			match(input,LPAR,FOLLOW_LPAR_in_arrow2786); 
			// /home/acco/workspace/FOOL/FOOL.g:546:8: (t= type ( COMMA t= type )* )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==BOOL||LA31_0==ID||LA31_0==INT||LA31_0==LPAR) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:546:9: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_arrow2791);
					t=type();
					state._fsp--;

					parList.add(t);
					// /home/acco/workspace/FOOL/FOOL.g:546:39: ( COMMA t= type )*
					loop30:
					while (true) {
						int alt30=2;
						int LA30_0 = input.LA(1);
						if ( (LA30_0==COMMA) ) {
							alt30=1;
						}

						switch (alt30) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:546:40: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow2796); 
							pushFollow(FOLLOW_type_in_arrow2800);
							t=type();
							state._fsp--;

							parList.add(t);
							}
							break;

						default :
							break loop30;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow2809); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow2811); 
			pushFollow(FOLLOW_basic_in_arrow2815);
			b=basic();
			state._fsp--;

			ast = new ArrowTypeNode(parList,(b!=null?((FOOLParser.basic_return)b).ast:null));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "arrow"

	// Delegated rules



	public static final BitSet FOLLOW_exp_in_prog53 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog55 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog80 = new BitSet(new long[]{0x0000100000400100L});
	public static final BitSet FOLLOW_cllist_in_prog101 = new BitSet(new long[]{0x0000100000400000L});
	public static final BitSet FOLLOW_declist_in_prog114 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_IN_in_prog126 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_prog140 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_cllist191 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_cllist195 = new BitSet(new long[]{0x0000000040100000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist224 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_cllist228 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist285 = new BitSet(new long[]{0x0000008001000000L});
	public static final BitSet FOLLOW_ID_in_cllist303 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist305 = new BitSet(new long[]{0x0000000009000080L});
	public static final BitSet FOLLOW_basic_in_cllist309 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist359 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_cllist363 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist365 = new BitSet(new long[]{0x0000000009000080L});
	public static final BitSet FOLLOW_basic_in_cllist369 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist396 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist416 = new BitSet(new long[]{0x0000000000402000L});
	public static final BitSet FOLLOW_FUN_in_cllist435 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_cllist439 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist441 = new BitSet(new long[]{0x0000000009000080L});
	public static final BitSet FOLLOW_basic_in_cllist445 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist476 = new BitSet(new long[]{0x0000008001000000L});
	public static final BitSet FOLLOW_ID_in_cllist512 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist514 = new BitSet(new long[]{0x0000000049000080L});
	public static final BitSet FOLLOW_type_in_cllist518 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist567 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_cllist571 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist573 = new BitSet(new long[]{0x0000000049000080L});
	public static final BitSet FOLLOW_type_in_cllist577 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist624 = new BitSet(new long[]{0x0000084F63204000L});
	public static final BitSet FOLLOW_LET_in_cllist649 = new BitSet(new long[]{0x0000100004000000L});
	public static final BitSet FOLLOW_VAR_in_cllist680 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_cllist684 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist686 = new BitSet(new long[]{0x0000000009000080L});
	public static final BitSet FOLLOW_basic_in_cllist690 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist692 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_cllist696 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist698 = new BitSet(new long[]{0x0000100004000000L});
	public static final BitSet FOLLOW_IN_in_cllist750 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_cllist802 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist825 = new BitSet(new long[]{0x0000000000402000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist881 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist981 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist985 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist987 = new BitSet(new long[]{0x0000000049000080L});
	public static final BitSet FOLLOW_type_in_declist991 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist993 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_declist997 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_FUN_in_declist1033 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist1037 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1039 = new BitSet(new long[]{0x0000000049000080L});
	public static final BitSet FOLLOW_type_in_declist1043 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_declist1098 = new BitSet(new long[]{0x0000008001000000L});
	public static final BitSet FOLLOW_ID_in_declist1134 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1136 = new BitSet(new long[]{0x0000000049000080L});
	public static final BitSet FOLLOW_type_in_declist1140 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist1214 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_declist1218 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1220 = new BitSet(new long[]{0x0000000049000080L});
	public static final BitSet FOLLOW_type_in_declist1224 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist1290 = new BitSet(new long[]{0x0000084F63204000L});
	public static final BitSet FOLLOW_LET_in_declist1315 = new BitSet(new long[]{0x0000100000400000L});
	public static final BitSet FOLLOW_declist_in_declist1319 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_IN_in_declist1321 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_declist1328 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist1353 = new BitSet(new long[]{0x0000100000400002L});
	public static final BitSet FOLLOW_term_in_exp1525 = new BitSet(new long[]{0x0000003080000002L});
	public static final BitSet FOLLOW_PLUS_in_exp1551 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_term_in_exp1555 = new BitSet(new long[]{0x0000003080000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1571 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_term_in_exp1575 = new BitSet(new long[]{0x0000003080000002L});
	public static final BitSet FOLLOW_OR_in_exp1591 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_term_in_exp1595 = new BitSet(new long[]{0x0000003080000002L});
	public static final BitSet FOLLOW_DEBUG_in_exp1617 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_exp1619 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_exp1623 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_exp1625 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_factor_in_term1654 = new BitSet(new long[]{0x0000040000008012L});
	public static final BitSet FOLLOW_TIMES_in_term1677 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_factor_in_term1681 = new BitSet(new long[]{0x0000040000008012L});
	public static final BitSet FOLLOW_DIV_in_term1695 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_factor_in_term1700 = new BitSet(new long[]{0x0000040000008012L});
	public static final BitSet FOLLOW_AND_in_term1714 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_factor_in_term1719 = new BitSet(new long[]{0x0000040000008012L});
	public static final BitSet FOLLOW_value_in_factor1804 = new BitSet(new long[]{0x0000000010840002L});
	public static final BitSet FOLLOW_EQ_in_factor1825 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_value_in_factor1829 = new BitSet(new long[]{0x0000000010840002L});
	public static final BitSet FOLLOW_GR_in_factor1841 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_value_in_factor1845 = new BitSet(new long[]{0x0000000010840002L});
	public static final BitSet FOLLOW_LE_in_factor1857 = new BitSet(new long[]{0x0000084F43200000L});
	public static final BitSet FOLLOW_value_in_factor1861 = new BitSet(new long[]{0x0000000010840002L});
	public static final BitSet FOLLOW_NAT_in_value1905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1915 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1976 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_value1980 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value1982 = new BitSet(new long[]{0x000008CF43204000L});
	public static final BitSet FOLLOW_exp_in_value2005 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_COMMA_in_value2010 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2014 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_RPAR_in_value2023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value2051 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2055 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value2094 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2098 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_THEN_in_value2100 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value2102 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2106 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value2108 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ELSE_in_value2127 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value2129 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2133 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value2135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value2157 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value2159 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2163 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value2179 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value2181 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2185 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value2203 = new BitSet(new long[]{0x0000000040010002L});
	public static final BitSet FOLLOW_LPAR_in_value2264 = new BitSet(new long[]{0x000008CF43204000L});
	public static final BitSet FOLLOW_exp_in_value2285 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_COMMA_in_value2304 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2308 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_RPAR_in_value2343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value2414 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ID_in_value2418 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LPAR_in_value2474 = new BitSet(new long[]{0x000008CF43204000L});
	public static final BitSet FOLLOW_exp_in_value2494 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_COMMA_in_value2499 = new BitSet(new long[]{0x0000084F43204000L});
	public static final BitSet FOLLOW_exp_in_value2503 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_RPAR_in_value2525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basic_in_type2648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type2665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic2698 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic2709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic2733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow2786 = new BitSet(new long[]{0x0000008049000080L});
	public static final BitSet FOLLOW_type_in_arrow2791 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow2796 = new BitSet(new long[]{0x0000000049000080L});
	public static final BitSet FOLLOW_type_in_arrow2800 = new BitSet(new long[]{0x0000008000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow2809 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow2811 = new BitSet(new long[]{0x0000000009000080L});
	public static final BitSet FOLLOW_basic_in_arrow2815 = new BitSet(new long[]{0x0000000000000002L});
}
