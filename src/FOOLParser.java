// $ANTLR 3.5.2 /home/acco/workspace/FOOL/FOOL.g 2016-02-18 21:53:24

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


	// queste diventano campi delle classi generate del parser

	// all'ingresso di ogni scope il nesting level viene incrementato
	// quando entro nel primo scope passa a 0 il che è il livello dell'ambiente globale
	// qui sono dichiarate anche le classi (i loro nomi)
	// le virtual table sono a nesting level 1
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

						        // all'inizio del parsing passo il riferimento della map supertype a FOOLLib 
									   // lo metto qui perchè venga eseguito sempre (quando c'è almeno una dichiarazione di classe)
									   FOOLLib.setSuperTypeMap(superType);
						      
						       // entro in un nuovo scope quindi incremento il nesting level
						       nestingLevel++; 
						       // creo la hashmap dove memorizzo le cose che incontro
						       HashMap<String,STEntry> hm = new HashMap<String,STEntry>();
						       // la aggiungo alla mia lista di hashmap (la ricaverò tramite get(nestingLevel)
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

					      // ora esco dallo scope in cui sono quindi rimuovo la tabella nel fronte
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
	// /home/acco/workspace/FOOL/FOOL.g:77:1: cllist returns [ArrayList<Node> astList] : ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )* ;
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
			// /home/acco/workspace/FOOL/FOOL.g:77:42: ( ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )* )
			// /home/acco/workspace/FOOL/FOOL.g:78:3: ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )*
			{
			 // inizializzo la lista di classi
			    astList = new ArrayList<Node>();
			    // le classi stanno tutte nell'ambiente globale
			  
			// /home/acco/workspace/FOOL/FOOL.g:83:3: ( CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:83:4: CLASS i= ID ( EXTENDS ei= ID )? LPAR (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )? RPAR CLPAR ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist195); 
					i=(Token)match(input,ID,FOLLOW_ID_in_cllist199); 
					    
					    
					    // creo una lista di metodi e una lista di campi
					    ArrayList<Node> fieldsList = new ArrayList<Node>();
					    ArrayList<Node> methodsList = new ArrayList<Node>();
					    // creo un nodo di tipo classe contenente il nome della classe
					    ClassTypeNode classType = new ClassTypeNode((i!=null?i.getText():null));
					    
					        
					    // la symbol table di livello 0 include STEntry per i nomi delle classi
					    // questo per controllare che nello stesso scope non vengano dichiarate altre cose
					    // con lo stesso nome
					    
					    // l'offset credo non sia importante ò.ò
					    HashMap<String,STEntry> hm = symbolTable.get(0);
					    if(hm.put((i!=null?i.getText():null),new STEntry(nestingLevel,null, 999))!=null){ 
					          System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
					          System.exit(0);
					         };
					    
					    // la CTEntry contiene le info della classe
					    CTEntry entry = new CTEntry();
					    
					    CTEntry superClassEntry = null;
					    
					    
					// /home/acco/workspace/FOOL/FOOL.g:112:4: ( EXTENDS ei= ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:113:5: EXTENDS ei= ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist228); 
							ei=(Token)match(input,ID,FOLLOW_ID_in_cllist232); 

							      // se finisco qua dentro significa che estendo da qualcuno, allora devo recuperare la CTEntry
							      // dalla class table (controllando che esiste) e utilizzare il II costruttore di CTEntry (quello
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


					    
					    // creo un nodo classe
					    ClassNode c = new ClassNode(classType, fieldsList, methodsList, entry, superClassEntry);
					    // lo aggiungo alla lista delle classi (lista che viene poi restituita)
					    astList.add(c);
					    
					    // se va tutto bene => posso inserire l'entry anche nella class table
					    classTable.put((i!=null?i.getText():null), entry);
					    // viene creato un nuovo livello e la relativa Symbol Table (anzichè creata vuota) viene 
					    // settata alla Virtual Table contenuta dentro la nuova CTentry
					    // incremento perchè la virtual table è sempre ad offset 1
					    // in questo modo alla fine riesco a rimuoverla correttamente
					    // i campi e metodi vengono settati a nesting level 1 di default (senza che glielo passi)
					     nestingLevel++; 
					     symbolTable.add(entry.getVirtualTable());
					    
					match(input,LPAR,FOLLOW_LPAR_in_cllist289); 
					// /home/acco/workspace/FOOL/FOOL.g:157:7: (pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:157:8: pfid= ID COLON pft= basic ( COMMA pnid= ID COLON pnt= basic )*
							{
							pfid=(Token)match(input,ID,FOLLOW_ID_in_cllist307); 
							match(input,COLON,FOLLOW_COLON_in_cllist309); 
							pushFollow(FOLLOW_basic_in_cllist313);
							pft=basic();
							state._fsp--;


							        // addField ritorna il nodo field
							        fieldsList.add(entry.addField((pfid!=null?pfid.getText():null),(pft!=null?((FOOLParser.basic_return)pft).ast:null)));
							        
							      
							// /home/acco/workspace/FOOL/FOOL.g:166:7: ( COMMA pnid= ID COLON pnt= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:167:7: COMMA pnid= ID COLON pnt= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist363); 
									pnid=(Token)match(input,ID,FOLLOW_ID_in_cllist367); 
									match(input,COLON,FOLLOW_COLON_in_cllist369); 
									pushFollow(FOLLOW_basic_in_cllist373);
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

					match(input,RPAR,FOLLOW_RPAR_in_cllist400); 
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist420); 
					// /home/acco/workspace/FOOL/FOOL.g:178:5: ( FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:179:7: FUN mid= ID COLON mt= basic LPAR (mpfid= ID COLON mpft= type ( COMMA mpnid= ID COLON mtnt= type )* )? RPAR ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )? mexp= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist439); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_cllist443); 
							match(input,COLON,FOLLOW_COLON_in_cllist445); 
							pushFollow(FOLLOW_basic_in_cllist449);
							mt=basic();
							state._fsp--;



							       // creo anche il nodo dell'AST
							       MethodNode method = new MethodNode((mid!=null?mid.getText():null), (mt!=null?((FOOLParser.basic_return)mt).ast:null));
							       
							       // aggiungo il metodo alla lista dei metodi (tutte le info: espressione, ecc..)
							       methodsList.add(method);
							       
							       // mi memorizzo il tipo dei parametri il quale andrà insieme al tipo di ritorno a comporre il tipo complessivo del metodo
							        ArrayList<Node> parTypes = new ArrayList<Node>();
							        
							        // creo la symbol table che rappresenta il contesto del metodo
							        nestingLevel++; 
							        HashMap<String,STEntry> hmn = new HashMap<String,STEntry>();
							        symbolTable.add(hmn);
							        // qua mi salvo le dichiarazioni
							        ArrayList<Node> varList = new ArrayList<Node>();
							        // nelle funzioni i parametri iniziano dall'offset 1 e incremento
							        int parOffset = 1;
							        
							        
							        
							match(input,LPAR,FOLLOW_LPAR_in_cllist480); 
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
									mpfid=(Token)match(input,ID,FOLLOW_ID_in_cllist516); 
									match(input,COLON,FOLLOW_COLON_in_cllist518); 
									pushFollow(FOLLOW_type_in_cllist522);
									mpft=type();
									state._fsp--;


									            ParNode firstPar = new ParNode((mpfid!=null?mpfid.getText():null),mpft);
									            method.addParameter(firstPar);
									            parTypes.add(mpft);
									                        
									            // verifico eventuali duplicati e aggiungo alla symboltable (primo par) [Remember: i parametri sono allo stesso livello del corpo della fun]
									            if(hmn.put((mpfid!=null?mpfid.getText():null),new STEntry(nestingLevel,mpft, parOffset++))!=null){ 
										            System.out.println("Error: id "+(mpfid!=null?mpfid.getText():null) +" at line "+ (mpfid!=null?mpfid.getLine():0) +" already declared!");
										            System.exit(0);
									            };
									            
									          
									            
									          
									// /home/acco/workspace/FOOL/FOOL.g:223:11: ( COMMA mpnid= ID COLON mtnt= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:224:13: COMMA mpnid= ID COLON mtnt= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist571); 
											mpnid=(Token)match(input,ID,FOLLOW_ID_in_cllist575); 
											match(input,COLON,FOLLOW_COLON_in_cllist577); 
											pushFollow(FOLLOW_type_in_cllist581);
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

							match(input,RPAR,FOLLOW_RPAR_in_cllist628); 
							// /home/acco/workspace/FOOL/FOOL.g:240:7: ( LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:241:9: LET ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist653); 

									          // il metodo quando verrà invocato avrà l'AR delle funzioni
									          int varOffset = -2;
									        
									// /home/acco/workspace/FOOL/FOOL.g:247:9: ( VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:248:11: VAR vid= ID COLON vty= basic ASS vexp= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist694); 
											vid=(Token)match(input,ID,FOLLOW_ID_in_cllist698); 
											match(input,COLON,FOLLOW_COLON_in_cllist700); 
											pushFollow(FOLLOW_basic_in_cllist704);
											vty=basic();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist706); 
											pushFollow(FOLLOW_exp_in_cllist710);
											vexp=exp();
											state._fsp--;

											match(input,SEMIC,FOLLOW_SEMIC_in_cllist712); 

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
									match(input,IN,FOLLOW_IN_in_cllist764); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_cllist801);
							mexp=exp();
							state._fsp--;

							method.addBody(mexp);
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist824); 

							        // è finito lo scope del metodo quindo posso rimuovere la symbol table corrispondente
							        // e decremento il NL
							        symbolTable.remove(nestingLevel--);
							        // ed istanziare il nodo che rappresenta il tipo del metodo
							        ArrowTypeNode methodType = new ArrowTypeNode(parTypes,(mt!=null?((FOOLParser.basic_return)mt).ast:null));
							        // aggiungo il tipo complessivo al MethodNode
							        method.addSymType(methodType);  
							        // aggiungo il metodo alla virtual table (nome +metodo che viene aggiunto ad allMethods)
							        entry.addMethod((mid!=null?mid.getText():null), method);
							        
							        
							      
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist880); 

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
	// /home/acco/workspace/FOOL/FOOL.g:296:1: declist returns [ArrayList<Node> astList] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
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
			// /home/acco/workspace/FOOL/FOOL.g:296:43: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// /home/acco/workspace/FOOL/FOOL.g:298:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{

			      // creo l'arraylist vuoto, esso conterrà le dichiarazioni
			      astList = new ArrayList<Node>();
			      
			      // l'offset mi serve per recuperare le cose in fase di esecuzione
			      // inizializzo l'offset a -2 perchè nel caso di 
			      // AR dell'ambiente globale a -1 abbiamo il return address fittizio
			      // mentre nel caso di layout AR funzione a 0 c'è l'AL e a -1 il RA
			      int offset = -2;
			    
			// /home/acco/workspace/FOOL/FOOL.g:309:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
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
					// /home/acco/workspace/FOOL/FOOL.g:311:5: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// /home/acco/workspace/FOOL/FOOL.g:311:5: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
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
							// /home/acco/workspace/FOOL/FOOL.g:313:8: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist980); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist984); 
							match(input,COLON,FOLLOW_COLON_in_declist986); 
							pushFollow(FOLLOW_type_in_declist990);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist992); 
							pushFollow(FOLLOW_exp_in_declist996);
							e=exp();
							state._fsp--;


							          System.out.println("Dich var "+(id!=null?id.getText():null)+" con offset "+offset);
							          VarNode v = new VarNode((i!=null?i.getText():null), t, e);
							          astList.add(v);
							          // ora che ho dichiarato la var la aggiungo alla symbol table
							          // recupero l'hash table dell'ambiente dove sto parsando
							          HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
							          // controllo che niente sia dichiarato con lo stesso nome
							          
							          if(hm.put((i!=null?i.getText():null),new STEntry(nestingLevel,t, offset--))!=null){ 
							            //l'offset lo calcolo in base all'ordine in cui incontro le variabili
									        System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
									        System.exit(0);
									        };
									      // se la variabile è di tipo funzione occupa due offset
									      // TODO: è da verificare se può esistere
									      if(t instanceof ArrowTypeNode){offset--;}
									     
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:334:8: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist1034); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist1038); 
							match(input,COLON,FOLLOW_COLON_in_declist1040); 
							pushFollow(FOLLOW_type_in_declist1044);
							t=type();
							state._fsp--;


							          FunNode f = new FunNode((i!=null?i.getText():null), t); 
							          astList.add(f);  
							          HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
							         // creo una entry con solo il nesting level e l'offset
							         // ci metterò il tipo quando lo saprò (lo capisco dopo aver letto tutti i parametri)
							         STEntry entry = new STEntry(nestingLevel,offset);
							         System.out.println("Dich fun "+(i!=null?i.getText():null)+" con offset "+offset);
							         // la funzione occupa due offset
							         offset-=2;
							         // inserisco l'ID della funzione nella symbol table	                                             
							         if(hm.put((i!=null?i.getText():null),entry)!=null){
							          System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
								        System.exit(0);
								       };
								       //i parametri assumiamo facciano parte del corpo della funzione
								       //quindi creo una hashmap che rappresenta il contesto interno alla funzione
							         nestingLevel++; 
							         HashMap<String,STEntry> hmn = new HashMap<String,STEntry>();
							         symbolTable.add(hmn);
							         
							match(input,LPAR,FOLLOW_LPAR_in_declist1087); 

							          ArrayList<Node> parTypes = new ArrayList<Node>();
							          int parOffset = 1; //i parametri iniziano da 1 nel layout e l'offset si incrementa
							         
							// /home/acco/workspace/FOOL/FOOL.g:363:11: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:363:12: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist1114); 
									match(input,COLON,FOLLOW_COLON_in_declist1116); 
									pushFollow(FOLLOW_type_in_declist1120);
									fty=type();
									state._fsp--;

									 
									              System.out.println((fid!=null?fid.getText():null)+" con offset "+parOffset);
									              parTypes.add(fty);
									              ParNode fpar = new ParNode((fid!=null?fid.getText():null), fty);
									              f.addParameter(fpar);
									             if(fty instanceof ArrowTypeNode){parOffset++;}
									              if(hmn.put((fid!=null?fid.getText():null),new STEntry(nestingLevel,fty,parOffset++))!=null){
									                System.out.println("Error: id "+(fid!=null?fid.getText():null) +" at line "+ (fid!=null?fid.getLine():0) +" already declared!");
									                System.exit(0);
									              };
									              
									             
									// /home/acco/workspace/FOOL/FOOL.g:379:14: ( COMMA id= ID COLON ty= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:379:15: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist1225); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist1229); 
											match(input,COLON,FOLLOW_COLON_in_declist1231); 
											pushFollow(FOLLOW_type_in_declist1235);
											ty=type();
											state._fsp--;

											 
											                System.out.println("Par "+(id!=null?id.getText():null)+" con offset "+parOffset);
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

							match(input,RPAR,FOLLOW_RPAR_in_declist1301); 
							// ora posso istanziare il nodo che rappresenta il tipo della funzione
							            ArrowTypeNode functionType = new ArrowTypeNode(parTypes,t);
							            entry.addType(functionType);
							            // aggiungo il tipo anche al FunNode
							            f.addSymType(functionType);
							          
							// /home/acco/workspace/FOOL/FOOL.g:401:10: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:401:11: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist1326); 
									pushFollow(FOLLOW_declist_in_declist1330);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist1332); 
									f.addDec(d);
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist1339);
							e=exp();
							state._fsp--;

							//chiudo lo scope
							            symbolTable.remove(nestingLevel--);
								          f.addBody(e);
							          
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist1364); 
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
	// /home/acco/workspace/FOOL/FOOL.g:413:1: exp returns [Node ast] : v= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node v =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:413:24: (v= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// /home/acco/workspace/FOOL/FOOL.g:414:3: v= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1539);
			v=term();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:415:9: ( PLUS l= term | MINUS l= term | OR l= term )*
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
					// /home/acco/workspace/FOOL/FOOL.g:416:13: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp1565); 
					pushFollow(FOLLOW_term_in_exp1569);
					l=term();
					state._fsp--;

					ast = new PlusNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:417:13: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp1585); 
					pushFollow(FOLLOW_term_in_exp1589);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:418:13: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp1605); 
					pushFollow(FOLLOW_term_in_exp1609);
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
	// /home/acco/workspace/FOOL/FOOL.g:422:1: term returns [Node ast] : f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:422:25: (f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* )
			// /home/acco/workspace/FOOL/FOOL.g:423:3: f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1639);
			f=factor();
			state._fsp--;

			ast = f;
			// /home/acco/workspace/FOOL/FOOL.g:424:7: ( TIMES l= factor | DIV l= factor | AND l= factor )*
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
					// /home/acco/workspace/FOOL/FOOL.g:425:11: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term1662); 
					pushFollow(FOLLOW_factor_in_term1666);
					l=factor();
					state._fsp--;

					ast = new TimesNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:426:11: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1680); 
					pushFollow(FOLLOW_factor_in_term1685);
					l=factor();
					state._fsp--;

					ast = new DivNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:427:11: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1699); 
					pushFollow(FOLLOW_factor_in_term1704);
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
	// /home/acco/workspace/FOOL/FOOL.g:430:1: factor returns [Node ast] : v= value ( EQ v= value | GR v= value | LE v= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node v =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:430:26: (v= value ( EQ v= value | GR v= value | LE v= value )* )
			// /home/acco/workspace/FOOL/FOOL.g:431:3: v= value ( EQ v= value | GR v= value | LE v= value )*
			{
			pushFollow(FOLLOW_value_in_factor1789);
			v=value();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:432:7: ( EQ v= value | GR v= value | LE v= value )*
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
					// /home/acco/workspace/FOOL/FOOL.g:433:9: EQ v= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1810); 
					pushFollow(FOLLOW_value_in_factor1814);
					v=value();
					state._fsp--;

					ast = new EqualNode(ast,v);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:434:9: GR v= value
					{
					match(input,GR,FOLLOW_GR_in_factor1826); 
					pushFollow(FOLLOW_value_in_factor1830);
					v=value();
					state._fsp--;

					ast = new GreaterEqualNode(ast,v);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:435:9: LE v= value
					{
					match(input,LE,FOLLOW_LE_in_factor1842); 
					pushFollow(FOLLOW_value_in_factor1846);
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
	// /home/acco/workspace/FOOL/FOOL.g:439:1: value returns [Node ast] : (n= NAT | TRUE | FALSE | NULL | NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )? );
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
			// /home/acco/workspace/FOOL/FOOL.g:439:26: (n= NAT | TRUE | FALSE | NULL | NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )? )
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
					// /home/acco/workspace/FOOL/FOOL.g:440:9: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_value1890); 
					 ast = new NatNode(Integer.parseInt((n!=null?n.getText():null))); 
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:441:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1900); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:442:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1912); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// /home/acco/workspace/FOOL/FOOL.g:443:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1952); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// /home/acco/workspace/FOOL/FOOL.g:444:5: NEW nid= ID LPAR (nfe= exp ( COMMA nne= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1961); 
					nid=(Token)match(input,ID,FOLLOW_ID_in_value1965); 
					match(input,LPAR,FOLLOW_LPAR_in_value1967); 

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
									
					// /home/acco/workspace/FOOL/FOOL.g:459:6: (nfe= exp ( COMMA nne= exp )* )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==FALSE||(LA20_0 >= ID && LA20_0 <= IF)||LA20_0==LPAR||(LA20_0 >= NAT && LA20_0 <= NULL)||LA20_0==PRINT||LA20_0==TRUE) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:459:7: nfe= exp ( COMMA nne= exp )*
							{
							pushFollow(FOLLOW_exp_in_value1990);
							nfe=exp();
							state._fsp--;

							parList.add(nfe);
							// /home/acco/workspace/FOOL/FOOL.g:459:40: ( COMMA nne= exp )*
							loop19:
							while (true) {
								int alt19=2;
								int LA19_0 = input.LA(1);
								if ( (LA19_0==COMMA) ) {
									alt19=1;
								}

								switch (alt19) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:459:41: COMMA nne= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value1995); 
									pushFollow(FOLLOW_exp_in_value1999);
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

					match(input,RPAR,FOLLOW_RPAR_in_value2008); 
					ast = nn;
					}
					break;
				case 6 :
					// /home/acco/workspace/FOOL/FOOL.g:463:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value2042); 
					pushFollow(FOLLOW_exp_in_value2046);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value2048); 
					ast = e;
					}
					break;
				case 7 :
					// /home/acco/workspace/FOOL/FOOL.g:464:9: IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value2085); 
					pushFollow(FOLLOW_exp_in_value2089);
					c=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value2091); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value2093); 
					pushFollow(FOLLOW_exp_in_value2097);
					t=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value2099); 
					match(input,ELSE,FOLLOW_ELSE_in_value2118); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value2120); 
					pushFollow(FOLLOW_exp_in_value2124);
					e=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value2126); 
					ast = new IfElseNode(c, t, e);
					}
					break;
				case 8 :
					// /home/acco/workspace/FOOL/FOOL.g:466:9: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value2148); 
					match(input,LPAR,FOLLOW_LPAR_in_value2150); 
					pushFollow(FOLLOW_exp_in_value2154);
					e=exp();
					state._fsp--;

					ast = new NotNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value2158); 
					}
					break;
				case 9 :
					// /home/acco/workspace/FOOL/FOOL.g:467:9: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value2170); 
					match(input,LPAR,FOLLOW_LPAR_in_value2172); 
					pushFollow(FOLLOW_exp_in_value2176);
					e=exp();
					state._fsp--;

					ast = new PrintNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value2180); 
					}
					break;
				case 10 :
					// /home/acco/workspace/FOOL/FOOL.g:468:9: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value2194); 
					        
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
					              
					               
					              ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
					              //quando trovo un id ricerco nella symbol table
					              //perchè vogliamo associare all'idNode corrispondente a questo id la sua dichiarazione nella symbol table (cioè la STEntry).
					          
					            
					// /home/acco/workspace/FOOL/FOOL.g:490:13: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR )?
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
							// /home/acco/workspace/FOOL/FOOL.g:492:15: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value2254); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// /home/acco/workspace/FOOL/FOOL.g:494:15: (fa= exp ( COMMA a= exp )* )?
							int alt22=2;
							int LA22_0 = input.LA(1);
							if ( (LA22_0==FALSE||(LA22_0 >= ID && LA22_0 <= IF)||LA22_0==LPAR||(LA22_0 >= NAT && LA22_0 <= NULL)||LA22_0==PRINT||LA22_0==TRUE) ) {
								alt22=1;
							}
							switch (alt22) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:494:16: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value2290);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// /home/acco/workspace/FOOL/FOOL.g:495:15: ( COMMA a= exp )*
									loop21:
									while (true) {
										int alt21=2;
										int LA21_0 = input.LA(1);
										if ( (LA21_0==COMMA) ) {
											alt21=1;
										}

										switch (alt21) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:495:16: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value2309); 
											pushFollow(FOLLOW_exp_in_value2313);
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

							match(input,RPAR,FOLLOW_RPAR_in_value2348); 
							ast = new CallNode((i!=null?i.getText():null), entry, argList, nestingLevel);
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:500:13: DOT mid= ID LPAR (fe= exp ( COMMA ne= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value2384); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_value2388); 

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
							            
							match(input,LPAR,FOLLOW_LPAR_in_value2444); 
							// /home/acco/workspace/FOOL/FOOL.g:527:14: (fe= exp ( COMMA ne= exp )* )?
							int alt24=2;
							int LA24_0 = input.LA(1);
							if ( (LA24_0==FALSE||(LA24_0 >= ID && LA24_0 <= IF)||LA24_0==LPAR||(LA24_0 >= NAT && LA24_0 <= NULL)||LA24_0==PRINT||LA24_0==TRUE) ) {
								alt24=1;
							}
							switch (alt24) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:527:15: fe= exp ( COMMA ne= exp )*
									{
									pushFollow(FOLLOW_exp_in_value2464);
									fe=exp();
									state._fsp--;

									parList.add(fe);
									// /home/acco/workspace/FOOL/FOOL.g:527:48: ( COMMA ne= exp )*
									loop23:
									while (true) {
										int alt23=2;
										int LA23_0 = input.LA(1);
										if ( (LA23_0==COMMA) ) {
											alt23=1;
										}

										switch (alt23) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:527:49: COMMA ne= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value2469); 
											pushFollow(FOLLOW_exp_in_value2473);
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

							match(input,RPAR,FOLLOW_RPAR_in_value2495); 

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
	// /home/acco/workspace/FOOL/FOOL.g:538:1: type returns [Node ast] : (b= basic |a= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		ParserRuleReturnScope b =null;
		Node a =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:538:27: (b= basic |a= arrow )
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
					// /home/acco/workspace/FOOL/FOOL.g:539:10: b= basic
					{
					pushFollow(FOLLOW_basic_in_type2618);
					b=basic();
					state._fsp--;

					ast = (b!=null?((FOOLParser.basic_return)b).ast:null);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:540:10: a= arrow
					{
					pushFollow(FOLLOW_arrow_in_type2635);
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
	// /home/acco/workspace/FOOL/FOOL.g:546:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final FOOLParser.basic_return basic() throws RecognitionException {
		FOOLParser.basic_return retval = new FOOLParser.basic_return();
		retval.start = input.LT(1);

		Token i=null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:546:27: ( INT | BOOL |i= ID )
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
					// /home/acco/workspace/FOOL/FOOL.g:547:5: INT
					{
					match(input,INT,FOLLOW_INT_in_basic2668); 
					retval.ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:548:5: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic2679); 
					retval.ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:549:5: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic2703); 
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
	// /home/acco/workspace/FOOL/FOOL.g:552:1: arrow returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node t =null;
		ParserRuleReturnScope b =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:552:27: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic )
			// /home/acco/workspace/FOOL/FOOL.g:553:3: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic
			{

			    //lista dei parametri
			    ArrayList<Node> parList = new ArrayList<Node>();
			  
			match(input,LPAR,FOLLOW_LPAR_in_arrow2756); 
			// /home/acco/workspace/FOOL/FOOL.g:557:8: (t= type ( COMMA t= type )* )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==BOOL||LA30_0==ID||LA30_0==INT||LA30_0==LPAR) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:557:9: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_arrow2761);
					t=type();
					state._fsp--;

					parList.add(t);
					// /home/acco/workspace/FOOL/FOOL.g:557:39: ( COMMA t= type )*
					loop29:
					while (true) {
						int alt29=2;
						int LA29_0 = input.LA(1);
						if ( (LA29_0==COMMA) ) {
							alt29=1;
						}

						switch (alt29) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:557:40: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow2766); 
							pushFollow(FOLLOW_type_in_arrow2770);
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

			match(input,RPAR,FOLLOW_RPAR_in_arrow2779); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow2781); 
			pushFollow(FOLLOW_basic_in_arrow2785);
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
	public static final BitSet FOLLOW_CLASS_in_cllist195 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist199 = new BitSet(new long[]{0x0000000020080000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist228 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist232 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist289 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist307 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist309 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist313 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist363 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist367 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist369 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist373 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist400 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist420 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_FUN_in_cllist439 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist443 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist445 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist449 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist480 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_cllist516 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist518 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_cllist522 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist571 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist575 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist577 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_cllist581 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist628 = new BitSet(new long[]{0x00000427B1900000L});
	public static final BitSet FOLLOW_LET_in_cllist653 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_VAR_in_cllist694 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_cllist698 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist700 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_cllist704 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist706 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_cllist710 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist712 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_IN_in_cllist764 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_cllist801 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist824 = new BitSet(new long[]{0x0000000000202000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist880 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist980 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist984 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist986 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_declist990 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist992 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_declist996 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist1034 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist1038 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1040 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_declist1044 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_declist1087 = new BitSet(new long[]{0x0000004000800000L});
	public static final BitSet FOLLOW_ID_in_declist1114 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1116 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_declist1120 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist1225 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_declist1229 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist1231 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_declist1235 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist1301 = new BitSet(new long[]{0x00000427B1900000L});
	public static final BitSet FOLLOW_LET_in_declist1326 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_declist_in_declist1330 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IN_in_declist1332 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_declist1339 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist1364 = new BitSet(new long[]{0x0000080000200002L});
	public static final BitSet FOLLOW_term_in_exp1539 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_PLUS_in_exp1565 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_term_in_exp1569 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1585 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_term_in_exp1589 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_OR_in_exp1605 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_term_in_exp1609 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_factor_in_term1639 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_TIMES_in_term1662 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_factor_in_term1666 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_DIV_in_term1680 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_factor_in_term1685 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_AND_in_term1699 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_factor_in_term1704 = new BitSet(new long[]{0x0000020000004012L});
	public static final BitSet FOLLOW_value_in_factor1789 = new BitSet(new long[]{0x0000000008420002L});
	public static final BitSet FOLLOW_EQ_in_factor1810 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_value_in_factor1814 = new BitSet(new long[]{0x0000000008420002L});
	public static final BitSet FOLLOW_GR_in_factor1826 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_value_in_factor1830 = new BitSet(new long[]{0x0000000008420002L});
	public static final BitSet FOLLOW_LE_in_factor1842 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_value_in_factor1846 = new BitSet(new long[]{0x0000000008420002L});
	public static final BitSet FOLLOW_NAT_in_value1890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1912 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1961 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value1965 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1967 = new BitSet(new long[]{0x00000467A1900000L});
	public static final BitSet FOLLOW_exp_in_value1990 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1995 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value1999 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value2008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value2042 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2046 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2048 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value2085 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2089 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value2091 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value2093 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2097 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value2099 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ELSE_in_value2118 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value2120 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2124 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CRPAR_in_value2126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value2148 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value2150 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2154 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value2170 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value2172 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2176 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value2180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value2194 = new BitSet(new long[]{0x0000000020008002L});
	public static final BitSet FOLLOW_LPAR_in_value2254 = new BitSet(new long[]{0x00000467A1900000L});
	public static final BitSet FOLLOW_exp_in_value2290 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value2309 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2313 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value2348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value2384 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_value2388 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value2444 = new BitSet(new long[]{0x00000467A1900000L});
	public static final BitSet FOLLOW_exp_in_value2464 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value2469 = new BitSet(new long[]{0x00000427A1900000L});
	public static final BitSet FOLLOW_exp_in_value2473 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value2495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basic_in_type2618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type2635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic2668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic2679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic2703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow2756 = new BitSet(new long[]{0x0000004024800080L});
	public static final BitSet FOLLOW_type_in_arrow2761 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow2766 = new BitSet(new long[]{0x0000000024800080L});
	public static final BitSet FOLLOW_type_in_arrow2770 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow2779 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow2781 = new BitSet(new long[]{0x0000000004800080L});
	public static final BitSet FOLLOW_basic_in_arrow2785 = new BitSet(new long[]{0x0000000000000002L});
}
