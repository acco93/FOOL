// $ANTLR 3.5.2 /home/acco/workspace/FOOL/FOOL.g 2016-02-22 18:41:18

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
		"CLASS", "CLPAR", "COLON", "COMMA", "COMMENT", "CRPAR", "DIV", "DOT", 
		"ELSE", "EQ", "ERR", "EXTENDS", "FALSE", "FUN", "GR", "ID", "IF", "IN", 
		"INT", "LE", "LET", "LPAR", "MINUS", "NAT", "NEW", "NOT", "NULL", "OR", 
		"PLUS", "PRINT", "RPAR", "SEMIC", "THEN", "TIMES", "TRUE", "VAR", "WHITESP"
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
	public static final int DIV=14;
	public static final int DOT=15;
	public static final int ELSE=16;
	public static final int EQ=17;
	public static final int ERR=18;
	public static final int EXTENDS=19;
	public static final int FALSE=20;
	public static final int FUN=21;
	public static final int GR=22;
	public static final int ID=23;
	public static final int IF=24;
	public static final int IN=25;
	public static final int INT=26;
	public static final int LE=27;
	public static final int LET=28;
	public static final int LPAR=29;
	public static final int MINUS=30;
	public static final int NAT=31;
	public static final int NEW=32;
	public static final int NOT=33;
	public static final int NULL=34;
	public static final int OR=35;
	public static final int PLUS=36;
	public static final int PRINT=37;
	public static final int RPAR=38;
	public static final int SEMIC=39;
	public static final int THEN=40;
	public static final int TIMES=41;
	public static final int TRUE=42;
	public static final int VAR=43;
	public static final int WHITESP=44;

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
	// /home/acco/workspace/FOOL/FOOL.g:37:1: prog returns [Node ast] : (e= exp SEMIC | LET c= cllist d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> c =null;
		ArrayList<Node> d =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:37:25: (e= exp SEMIC | LET c= cllist d= declist IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||LA1_0==LPAR||(LA1_0 >= NAT && LA1_0 <= NULL)||LA1_0==PRINT||LA1_0==TRUE) ) {
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
					// /home/acco/workspace/FOOL/FOOL.g:40:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog55);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog57); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:44:5: LET c= cllist d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog82); 

					         // all'inizio del parsing passo il riferimento della map supertype a FOOLLib per poterlo
					         // utilizzare nel typechecking
								   FOOLLib.setSuperTypeMap(superType);
						       // entro in un nuovo scope quindi incremento il nesting level
						       nestingLevel++; 
						       // creo la hashmap dove memorizzo le cose che incontro
						       HashMap<String,STEntry> hm = new HashMap<String,STEntry>();
						       // la aggiungo alla mia lista di hashmap (la ricaverò successivamente tramite .get(nestingLevel))
						       symbolTable.add(hm);
						       
					pushFollow(FOLLOW_cllist_in_prog103);
					c=cllist();
					state._fsp--;

					pushFollow(FOLLOW_declist_in_prog122);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog134); 
					pushFollow(FOLLOW_exp_in_prog148);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog150); 

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
	// /home/acco/workspace/FOOL/FOOL.g:75:1: cllist returns [ArrayList<Node> astList] : ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )* ;
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
			// /home/acco/workspace/FOOL/FOOL.g:75:42: ( ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )* )
			// /home/acco/workspace/FOOL/FOOL.g:77:5: ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )*
			{
			 
			    // inizializzo la lista di classi
			    astList = new ArrayList<Node>();
			    
			// /home/acco/workspace/FOOL/FOOL.g:82:3: ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:82:4: CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist199); 
					i=(Token)match(input,ID,FOLLOW_ID_in_cllist203); 
					    
					    
					    
					        
					    // la symbol table di livello 0 include STEntry per i nomi delle classi
					    // questo per controllare che nello stesso scope non vengano dichiarate altre cose
					    // con lo stesso nome
					    
					    // essendo le dichiarazione nell'ambiente globale è necessario che nestingLevel == 0
					    assert nestingLevel == 0;
					    
					    // l'offset della entry della dichiarazoine della classe non verrà mai utilizzato 
					    // la dichiarazione non viene messa in memoria (stack o heap)
					    
					    HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
					    if(hm.put((i!=null?i.getText():null),new STEntry(nestingLevel,null, 999))!=null){ 
					          System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
					          System.exit(0);
					         };
					    
					    // creo la CTEntry la quale conterra le info della classe
					    CTEntry entry = new CTEntry();
					    CTEntry superClassEntry = null;
					    
					    
					// /home/acco/workspace/FOOL/FOOL.g:110:4: ( EXTENDS ei= ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:111:5: EXTENDS ei= ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist232); 
							ei=(Token)match(input,ID,FOLLOW_ID_in_cllist236); 

							      // se finisco qua dentro significa che estendo da qualcuno, allora devo recuperare la CTEntry
							      // dalla class table (controllando che esista) e utilizzare il II costruttore di CTEntry (quello
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


					    
					    // creo una lista di metodi e una lista di campi vuote
					    ArrayList<Node> fieldsList = new ArrayList<Node>();
					    ArrayList<Node> methodsList = new ArrayList<Node>();
					    // creo un nodo di tipo classe contenente il nome della classe
					    ClassTypeNode classType = new ClassTypeNode((i!=null?i.getText():null));
					    // creo un nodo classe 
					    ClassNode c = new ClassNode(classType, fieldsList, methodsList, entry, superClassEntry);
					    // lo aggiungo alla lista delle classi (lista che viene poi restituita)
					    astList.add(c);
					    
					    // Inserisco l'entry anche nella class table (il controllo che non sia un nome già usato è stato fatto
					    // prima tramite la symbol table).
					    classTable.put((i!=null?i.getText():null), entry);
					    
					    // viene creato un nuovo livello e la relativa Symbol Table (anzichè creata vuota) viene 
					    // settata alla Virtual Table contenuta dentro la nuova CTentry
					    // incremento perchè la virtual table è sempre ad offset 1
					    // in questo modo alla fine riesco a rimuoverla correttamente
					    // i campi e metodi vengono settati a nesting level 1 di default (senza che glielo passi)
					     nestingLevel++; 
					     symbolTable.add(entry.getVirtualTable());
					    
					match(input,LPAR,FOLLOW_LPAR_in_cllist293); 
					// /home/acco/workspace/FOOL/FOOL.g:162:7: (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:162:8: pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )*
							{
							pfid=(Token)match(input,ID,FOLLOW_ID_in_cllist311); 
							match(input,COLON,FOLLOW_COLON_in_cllist313); 
							pushFollow(FOLLOW_basic_in_cllist317);
							pft=basic();
							state._fsp--;


							        // addField ritorna il nodo field
							        fieldsList.add(entry.addField((pfid!=null?pfid.getText():null),(pft!=null?((FOOLParser.basic_return)pft).ast:null)));
							        
							      
							// /home/acco/workspace/FOOL/FOOL.g:171:7: ( COMMA pnid= ID COLON pnt= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:172:7: COMMA pnid= ID COLON pnt= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist367); 
									pnid=(Token)match(input,ID,FOLLOW_ID_in_cllist371); 
									match(input,COLON,FOLLOW_COLON_in_cllist373); 
									pushFollow(FOLLOW_basic_in_cllist377);
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

					match(input,RPAR,FOLLOW_RPAR_in_cllist404); 
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist424); 
					// /home/acco/workspace/FOOL/FOOL.g:182:5: ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:183:7: FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist443); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_cllist447); 
							match(input,COLON,FOLLOW_COLON_in_cllist449); 
							pushFollow(FOLLOW_basic_in_cllist453);
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
							       
							match(input,LPAR,FOLLOW_LPAR_in_cllist484); 
							// /home/acco/workspace/FOOL/FOOL.g:212:9: (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:214:11: mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )*
									{
									mpfid=(Token)match(input,ID,FOLLOW_ID_in_cllist520); 
									match(input,COLON,FOLLOW_COLON_in_cllist522); 
									pushFollow(FOLLOW_type_in_cllist526);
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
									          
									// /home/acco/workspace/FOOL/FOOL.g:228:11: ( COMMA mpnid= ID COLON mtnt= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:229:13: COMMA mpnid= ID COLON mtnt= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist575); 
											mpnid=(Token)match(input,ID,FOLLOW_ID_in_cllist579); 
											match(input,COLON,FOLLOW_COLON_in_cllist581); 
											pushFollow(FOLLOW_type_in_cllist585);
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

							match(input,RPAR,FOLLOW_RPAR_in_cllist632); 
							// /home/acco/workspace/FOOL/FOOL.g:245:7: ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:246:9: LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist657); 
									// /home/acco/workspace/FOOL/FOOL.g:248:9: ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:249:11: VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist688); 
											vid=(Token)match(input,ID,FOLLOW_ID_in_cllist692); 
											match(input,COLON,FOLLOW_COLON_in_cllist694); 
											pushFollow(FOLLOW_basic_in_cllist698);
											vty=basic();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist700); 
											pushFollow(FOLLOW_exp_in_cllist704);
											vexp=exp();
											state._fsp--;

											match(input,SEMIC,FOLLOW_SEMIC_in_cllist706); 

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
									match(input,IN,FOLLOW_IN_in_cllist758); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_cllist795);
							mexp=exp();
							state._fsp--;

							method.addBody(mexp);
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist818); 

							        // è finito lo scope del metodo quindo posso rimuovere la symbol table corrispondente
							        // e decrementare il NL
							        symbolTable.remove(nestingLevel--);
							        // istanzio il nodo che rappresenta il tipo del metodo
							        ArrowTypeNode methodType = new ArrowTypeNode(parTypes,(mt!=null?((FOOLParser.basic_return)mt).ast:null));
							        // aggiungo il tipo complessivo al MethodNode
							        method.addSymType(methodType);  
							        // aggiungo il metodo alla virtual table e ad allMethods)
							        entry.addMethod((mid!=null?mid.getText():null), method);
							      
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist874); 

					        // devo ricordarmi di chiudere il livello della classe!
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
	// /home/acco/workspace/FOOL/FOOL.g:295:1: declist returns [ArrayList<Node> astList] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
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
			// /home/acco/workspace/FOOL/FOOL.g:295:43: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// /home/acco/workspace/FOOL/FOOL.g:297:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{

			      // creo l'arraylist vuoto, esso conterrà le dichiarazioni
			      astList = new ArrayList<Node>();
			      
			      // l'offset mi serve per recuperare le cose in fase di esecuzione
			      // inizializzo l'offset a -2 perchè nel caso di 
			      // AR dell'ambiente globale a -1 abbiamo il return address fittizio
			      // mentre nel caso di layout AR funzione a 0 c'è l'AL e a -1 il RA
			      int offset = -2;
			    
			// /home/acco/workspace/FOOL/FOOL.g:308:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
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
					// /home/acco/workspace/FOOL/FOOL.g:310:5: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// /home/acco/workspace/FOOL/FOOL.g:310:5: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
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
							// /home/acco/workspace/FOOL/FOOL.g:312:8: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist974); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist978); 
							match(input,COLON,FOLLOW_COLON_in_declist980); 
							pushFollow(FOLLOW_type_in_declist984);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist986); 
							pushFollow(FOLLOW_exp_in_declist990);
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
									      if(t instanceof ArrowTypeNode){offset--;}
									     
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:330:8: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist1026); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist1030); 
							match(input,COLON,FOLLOW_COLON_in_declist1032); 
							pushFollow(FOLLOW_type_in_declist1036);
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
							        
							         
							match(input,LPAR,FOLLOW_LPAR_in_declist1091); 
							// /home/acco/workspace/FOOL/FOOL.g:360:11: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:360:12: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist1127); 
									match(input,COLON,FOLLOW_COLON_in_declist1129); 
									pushFollow(FOLLOW_type_in_declist1133);
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
									              
									             
									// /home/acco/workspace/FOOL/FOOL.g:375:14: ( COMMA id= ID COLON ty= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:375:15: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist1207); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist1211); 
											match(input,COLON,FOLLOW_COLON_in_declist1213); 
											pushFollow(FOLLOW_type_in_declist1217);
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

							match(input,RPAR,FOLLOW_RPAR_in_declist1283); 
							// ora posso istanziare il nodo che rappresenta il tipo della funzione
							            ArrowTypeNode functionType = new ArrowTypeNode(parTypes,t);
							            entry.addType(functionType);
							            // aggiungo il tipo anche al FunNode
							            f.addSymType(functionType);
							          
							// /home/acco/workspace/FOOL/FOOL.g:396:10: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:396:11: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist1308); 
									pushFollow(FOLLOW_declist_in_declist1312);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist1314); 
									f.addDec(d);
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist1321);
							e=exp();
							state._fsp--;

							//chiudo lo scope
							            symbolTable.remove(nestingLevel--);
								          f.addBody(e);
							          
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist1346); 
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
	// /home/acco/workspace/FOOL/FOOL.g:405:1: exp returns [Node ast] : v= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node v =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:405:24: (v= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// /home/acco/workspace/FOOL/FOOL.g:406:3: v= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1518);
			v=term();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:407:9: ( PLUS l= term | MINUS l= term | OR l= term )*
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
					// /home/acco/workspace/FOOL/FOOL.g:408:13: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp1544); 
					pushFollow(FOLLOW_term_in_exp1548);
					l=term();
					state._fsp--;

					ast = new PlusNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:409:13: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp1564); 
					pushFollow(FOLLOW_term_in_exp1568);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:410:13: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp1584); 
					pushFollow(FOLLOW_term_in_exp1588);
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
	// /home/acco/workspace/FOOL/FOOL.g:414:1: term returns [Node ast] : f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:414:25: (f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* )
			// /home/acco/workspace/FOOL/FOOL.g:415:3: f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1618);
			f=factor();
			state._fsp--;

			ast = f;
			// /home/acco/workspace/FOOL/FOOL.g:416:7: ( TIMES l= factor | DIV l= factor | AND l= factor )*
			loop17:
			while (true) {
				int alt17=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt17=1;
					}
					break;
				case DIV:
					{
					alt17=2;
					}
					break;
				case AND:
					{
					alt17=3;
					}
					break;
				}
				switch (alt17) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:417:11: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term1641); 
					pushFollow(FOLLOW_factor_in_term1645);
					l=factor();
					state._fsp--;

					ast = new TimesNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:418:11: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1659); 
					pushFollow(FOLLOW_factor_in_term1664);
					l=factor();
					state._fsp--;

					ast = new DivNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:419:11: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1678); 
					pushFollow(FOLLOW_factor_in_term1683);
					l=factor();
					state._fsp--;

					ast = new AndNode(ast,l);
					}
					break;

				default :
					break loop17;
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
	// /home/acco/workspace/FOOL/FOOL.g:422:1: factor returns [Node ast] : v= value ( EQ v= value | GR v= value | LE v= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node v =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:422:26: (v= value ( EQ v= value | GR v= value | LE v= value )* )
			// /home/acco/workspace/FOOL/FOOL.g:423:3: v= value ( EQ v= value | GR v= value | LE v= value )*
			{
			pushFollow(FOLLOW_value_in_factor1768);
			v=value();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:424:7: ( EQ v= value | GR v= value | LE v= value )*
			loop18:
			while (true) {
				int alt18=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt18=1;
					}
					break;
				case GR:
					{
					alt18=2;
					}
					break;
				case LE:
					{
					alt18=3;
					}
					break;
				}
				switch (alt18) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:425:9: EQ v= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1789); 
					pushFollow(FOLLOW_value_in_factor1793);
					v=value();
					state._fsp--;

					ast = new EqualNode(ast,v);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:426:9: GR v= value
					{
					match(input,GR,FOLLOW_GR_in_factor1805); 
					pushFollow(FOLLOW_value_in_factor1809);
					v=value();
					state._fsp--;

					ast = new GreaterEqualNode(ast,v);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:427:9: LE v= value
					{
					match(input,LE,FOLLOW_LE_in_factor1821); 
					pushFollow(FOLLOW_value_in_factor1825);
					v=value();
					state._fsp--;

					ast = new LowerEqualNode(ast,v);
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
	// $ANTLR end "factor"



	// $ANTLR start "value"
	// /home/acco/workspace/FOOL/FOOL.g:431:1: value returns [Node ast] : (n= NAT | TRUE | FALSE | NULL | NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )? );
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
			// /home/acco/workspace/FOOL/FOOL.g:431:26: (n= NAT | TRUE | FALSE | NULL | NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )? )
			int alt26=10;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt26=1;
				}
				break;
			case TRUE:
				{
				alt26=2;
				}
				break;
			case FALSE:
				{
				alt26=3;
				}
				break;
			case NULL:
				{
				alt26=4;
				}
				break;
			case NEW:
				{
				alt26=5;
				}
				break;
			case LPAR:
				{
				alt26=6;
				}
				break;
			case IF:
				{
				alt26=7;
				}
				break;
			case NOT:
				{
				alt26=8;
				}
				break;
			case PRINT:
				{
				alt26=9;
				}
				break;
			case ID:
				{
				alt26=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}
			switch (alt26) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:432:9: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_value1869); 
					 ast = new NatNode(Integer.parseInt((n!=null?n.getText():null))); 
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:433:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1879); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:434:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1891); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// /home/acco/workspace/FOOL/FOOL.g:435:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1931); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// /home/acco/workspace/FOOL/FOOL.g:436:5: NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1940); 
					nid=(Token)match(input,ID,FOLLOW_ID_in_value1944); 
					match(input,LPAR,FOLLOW_LPAR_in_value1946); 

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
									
					// /home/acco/workspace/FOOL/FOOL.g:451:6: (nfe= exp ( COMMA nne= exp )* )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==FALSE||(LA20_0 >= ID && LA20_0 <= IF)||LA20_0==LPAR||(LA20_0 >= NAT && LA20_0 <= NULL)||LA20_0==PRINT||LA20_0==TRUE) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:451:7: nfe= exp ( COMMA nne= exp )*
							{
							pushFollow(FOLLOW_exp_in_value1969);
							nfe=exp();
							state._fsp--;

							parList.add(nfe);
							// /home/acco/workspace/FOOL/FOOL.g:451:40: ( COMMA nne= exp )*
							loop19:
							while (true) {
								int alt19=2;
								int LA19_0 = input.LA(1);
								if ( (LA19_0==COMMA) ) {
									alt19=1;
								}

								switch (alt19) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:451:41: COMMA nne= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value1974); 
									pushFollow(FOLLOW_exp_in_value1978);
									nne=exp();
									state._fsp--;

									parList.add(nne);
									}
									break;

								default :
									break loop19;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_value1987); 
					ast = nn;
					}
					break;
				case 6 :
					// /home/acco/workspace/FOOL/FOOL.g:454:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value2015); 
					pushFollow(FOLLOW_exp_in_value2019);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value2021); 
					ast = e;
					}
					break;
				case 7 :
					// /home/acco/workspace/FOOL/FOOL.g:455:9: IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value2058); 
					pushFollow(FOLLOW_exp_in_value2062);
					c=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value2064); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value2066); 
					pushFollow(FOLLOW_exp_in_value2070);
					t=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value2072); 
					match(input,ELSE,FOLLOW_ELSE_in_value2091); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value2093); 
					pushFollow(FOLLOW_exp_in_value2097);
					e=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value2099); 
					ast = new IfElseNode(c, t, e);
					}
					break;
				case 8 :
					// /home/acco/workspace/FOOL/FOOL.g:457:9: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value2121); 
					match(input,LPAR,FOLLOW_LPAR_in_value2123); 
					pushFollow(FOLLOW_exp_in_value2127);
					e=exp();
					state._fsp--;

					ast = new NotNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value2131); 
					}
					break;
				case 9 :
					// /home/acco/workspace/FOOL/FOOL.g:458:9: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value2143); 
					match(input,LPAR,FOLLOW_LPAR_in_value2145); 
					pushFollow(FOLLOW_exp_in_value2149);
					e=exp();
					state._fsp--;

					ast = new PrintNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value2153); 
					}
					break;
				case 10 :
					// /home/acco/workspace/FOOL/FOOL.g:459:9: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value2167); 
					        
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
					          
					            
					// /home/acco/workspace/FOOL/FOOL.g:479:13: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )?
					int alt25=3;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==LPAR) ) {
						alt25=1;
					}
					else if ( (LA25_0==DOT) ) {
						alt25=2;
					}
					switch (alt25) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:481:15: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value2228); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// /home/acco/workspace/FOOL/FOOL.g:482:15: (fa= exp ( COMMA a= exp )* )?
							int alt22=2;
							int LA22_0 = input.LA(1);
							if ( (LA22_0==FALSE||(LA22_0 >= ID && LA22_0 <= IF)||LA22_0==LPAR||(LA22_0 >= NAT && LA22_0 <= NULL)||LA22_0==PRINT||LA22_0==TRUE) ) {
								alt22=1;
							}
							switch (alt22) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:482:16: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value2249);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// /home/acco/workspace/FOOL/FOOL.g:483:15: ( COMMA a= exp )*
									loop21:
									while (true) {
										int alt21=2;
										int LA21_0 = input.LA(1);
										if ( (LA21_0==COMMA) ) {
											alt21=1;
										}

										switch (alt21) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:483:16: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value2268); 
											pushFollow(FOLLOW_exp_in_value2272);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop21;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value2307); 
							ast = new CallNode((i!=null?i.getText():null), entry, argList, nestingLevel);
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:489:13: DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value2378); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_value2382); 

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
							            
							match(input,LPAR,FOLLOW_LPAR_in_value2438); 
							// /home/acco/workspace/FOOL/FOOL.g:517:14: (fe= exp ( COMMA ne= exp )* )?
							int alt24=2;
							int LA24_0 = input.LA(1);
							if ( (LA24_0==FALSE||(LA24_0 >= ID && LA24_0 <= IF)||LA24_0==LPAR||(LA24_0 >= NAT && LA24_0 <= NULL)||LA24_0==PRINT||LA24_0==TRUE) ) {
								alt24=1;
							}
							switch (alt24) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:517:15: fe= exp ( COMMA ne= exp )*
									{
									pushFollow(FOLLOW_exp_in_value2458);
									fe=exp();
									state._fsp--;

									parList.add(fe);
									// /home/acco/workspace/FOOL/FOOL.g:517:48: ( COMMA ne= exp )*
									loop23:
									while (true) {
										int alt23=2;
										int LA23_0 = input.LA(1);
										if ( (LA23_0==COMMA) ) {
											alt23=1;
										}

										switch (alt23) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:517:49: COMMA ne= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value2463); 
											pushFollow(FOLLOW_exp_in_value2467);
											ne=exp();
											state._fsp--;

											parList.add(ne);
											}
											break;

										default :
											break loop23;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value2489); 

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
	// /home/acco/workspace/FOOL/FOOL.g:528:1: type returns [Node ast] : (b= basic |a= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		ParserRuleReturnScope b =null;
		Node a =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:528:27: (b= basic |a= arrow )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==BOOL||LA27_0==ID||LA27_0==INT) ) {
				alt27=1;
			}
			else if ( (LA27_0==LPAR) ) {
				alt27=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:529:10: b= basic
					{
					pushFollow(FOLLOW_basic_in_type2612);
					b=basic();
					state._fsp--;

					ast = (b!=null?((FOOLParser.basic_return)b).ast:null);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:530:10: a= arrow
					{
					pushFollow(FOLLOW_arrow_in_type2629);
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
	// /home/acco/workspace/FOOL/FOOL.g:536:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final FOOLParser.basic_return basic() throws RecognitionException {
		FOOLParser.basic_return retval = new FOOLParser.basic_return();
		retval.start = input.LT(1);

		Token i=null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:536:27: ( INT | BOOL |i= ID )
			int alt28=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt28=1;
				}
				break;
			case BOOL:
				{
				alt28=2;
				}
				break;
			case ID:
				{
				alt28=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:537:5: INT
					{
					match(input,INT,FOLLOW_INT_in_basic2662); 
					retval.ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:538:5: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic2673); 
					retval.ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:539:5: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic2697); 
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
	// /home/acco/workspace/FOOL/FOOL.g:542:1: arrow returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node t =null;
		ParserRuleReturnScope b =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:542:27: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic )
			// /home/acco/workspace/FOOL/FOOL.g:543:3: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic
			{

			    //lista dei parametri
			    ArrayList<Node> parList = new ArrayList<Node>();
			  
			match(input,LPAR,FOLLOW_LPAR_in_arrow2750); 
			// /home/acco/workspace/FOOL/FOOL.g:547:8: (t= type ( COMMA t= type )* )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==BOOL||LA30_0==ID||LA30_0==INT||LA30_0==LPAR) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:547:9: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_arrow2755);
					t=type();
					state._fsp--;

					parList.add(t);
					// /home/acco/workspace/FOOL/FOOL.g:547:39: ( COMMA t= type )*
					loop29:
					while (true) {
						int alt29=2;
						int LA29_0 = input.LA(1);
						if ( (LA29_0==COMMA) ) {
							alt29=1;
						}

						switch (alt29) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:547:40: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow2760); 
							pushFollow(FOLLOW_type_in_arrow2764);
							t=type();
							state._fsp--;

							parList.add(t);
							}
							break;

						default :
							break loop29;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow2773); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow2775); 
			pushFollow(FOLLOW_basic_in_arrow2779);
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



	public static final BitSet FOLLOW_exp_in_prog55 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog82 = new BitSet(new long[]{0x0000080000200100L});
	public static final BitSet FOLLOW_cllist_in_prog103 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_declist_in_prog122 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IN_in_prog134 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_prog148 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_cllist199 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist203 = new BitSet(new long[]{0x0000000020080000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist232 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist236 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist293 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist311 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist313 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist317 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist367 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist371 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist373 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist377 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist404 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist424 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_FUN_in_cllist443 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist447 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist449 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist453 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist484 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist520 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist522 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_cllist526 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist575 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist579 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist581 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_cllist585 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist632 = new BitSet(new long[]{0x00000427B1900000L});
	public static final BitSet FOLLOW_LET_in_cllist657 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_VAR_in_cllist688 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist692 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist694 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist698 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist700 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_cllist704 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist706 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_IN_in_cllist758 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_cllist795 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist818 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist874 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist974 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist978 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist980 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_declist984 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist986 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_declist990 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist1026 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist1030 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1032 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_declist1036 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_declist1091 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_declist1127 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1129 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_declist1133 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist1207 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist1211 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1213 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_declist1217 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist1283 = new BitSet(new long[]{0x00000427B1900000L});
	public static final BitSet FOLLOW_LET_in_declist1308 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_declist_in_declist1312 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IN_in_declist1314 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_declist1321 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist1346 = new BitSet(new long[]{0x0000080000200002L});
	public static final BitSet FOLLOW_term_in_exp1518 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_PLUS_in_exp1544 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_term_in_exp1548 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1564 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_term_in_exp1568 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_OR_in_exp1584 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_term_in_exp1588 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_factor_in_term1618 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_TIMES_in_term1641 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_factor_in_term1645 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_DIV_in_term1659 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_factor_in_term1664 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_AND_in_term1678 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_factor_in_term1683 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_value_in_factor1768 = new BitSet(new long[]{0x0000000008420002L});
	public static final BitSet FOLLOW_EQ_in_factor1789 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_value_in_factor1793 = new BitSet(new long[]{0x0000000008420002L});
	public static final BitSet FOLLOW_GR_in_factor1805 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_value_in_factor1809 = new BitSet(new long[]{0x0000000008420002L});
	public static final BitSet FOLLOW_LE_in_factor1821 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_value_in_factor1825 = new BitSet(new long[]{0x0000000008420002L});
	public static final BitSet FOLLOW_NAT_in_value1869 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1891 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1931 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1940 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value1944 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1946 = new BitSet(new long[]{0x00000467A1900000L});
	public static final BitSet FOLLOW_exp_in_value1969 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1974 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value1978 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value2015 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2019 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2021 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value2058 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2062 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value2064 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value2066 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2070 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value2072 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ELSE_in_value2091 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value2093 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2097 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value2099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value2121 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value2123 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2127 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value2143 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value2145 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2149 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value2167 = new BitSet(new long[]{0x0000000020008002L});
	public static final BitSet FOLLOW_LPAR_in_value2228 = new BitSet(new long[]{0x00000467A1900000L});
	public static final BitSet FOLLOW_exp_in_value2249 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value2268 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2272 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value2307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value2378 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value2382 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value2438 = new BitSet(new long[]{0x00000467A1900000L});
	public static final BitSet FOLLOW_exp_in_value2458 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value2463 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2467 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value2489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basic_in_type2612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type2629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic2662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic2673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic2697 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow2750 = new BitSet(new long[]{0x0000004024800080L});
	public static final BitSet FOLLOW_type_in_arrow2755 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow2760 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_arrow2764 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow2773 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow2775 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_arrow2779 = new BitSet(new long[]{0x0000000000000002L});
}
