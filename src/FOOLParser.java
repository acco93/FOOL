// $ANTLR 3.5.2 /home/acco/workspace/FOOL/FOOL.g 2015-12-24 16:25:29

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
		"CLPAR", "COLON", "COMMA", "COMMENT", "CRPAR", "DIV", "ELSE", "EQ", "ERR", 
		"FALSE", "FUN", "GR", "ID", "IF", "IN", "INT", "LE", "LET", "LPAR", "MINUS", 
		"NAT", "NOT", "OR", "PLUS", "PRINT", "RPAR", "SEMIC", "THEN", "TIMES", 
		"TRUE", "VAR", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARROW=5;
	public static final int ASS=6;
	public static final int BOOL=7;
	public static final int CLPAR=8;
	public static final int COLON=9;
	public static final int COMMA=10;
	public static final int COMMENT=11;
	public static final int CRPAR=12;
	public static final int DIV=13;
	public static final int ELSE=14;
	public static final int EQ=15;
	public static final int ERR=16;
	public static final int FALSE=17;
	public static final int FUN=18;
	public static final int GR=19;
	public static final int ID=20;
	public static final int IF=21;
	public static final int IN=22;
	public static final int INT=23;
	public static final int LE=24;
	public static final int LET=25;
	public static final int LPAR=26;
	public static final int MINUS=27;
	public static final int NAT=28;
	public static final int NOT=29;
	public static final int OR=30;
	public static final int PLUS=31;
	public static final int PRINT=32;
	public static final int RPAR=33;
	public static final int SEMIC=34;
	public static final int THEN=35;
	public static final int TIMES=36;
	public static final int TRUE=37;
	public static final int VAR=38;
	public static final int WHITESP=39;

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


	// Queste diventano variabili globali

	// è il livello dell'ambiente globale
	private int nestingLevel = -1; 

	private  ArrayList<HashMap<String,STEntry>> symbolTable = new ArrayList<HashMap<String,STEntry>>(); 




	// $ANTLR start "prog"
	// /home/acco/workspace/FOOL/FOOL.g:29:1: prog returns [Node ast] : (e= exp SEMIC | LET d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> d =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:29:25: (e= exp SEMIC | LET d= declist IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||LA1_0==LPAR||(LA1_0 >= NAT && LA1_0 <= NOT)||LA1_0==PRINT||LA1_0==TRUE) ) {
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
					// /home/acco/workspace/FOOL/FOOL.g:31:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog57);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog59); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:33:7: LET d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog95); 

						       nestingLevel++; 
						       HashMap<String,STEntry> hm = new HashMap<String,STEntry>();
						       symbolTable.add(hm);
					pushFollow(FOLLOW_declist_in_prog114);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog116); 
					pushFollow(FOLLOW_exp_in_prog120);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog122); 
					//ora esco dall'ambiente => rimuovo la tabella nel fronte
					          symbolTable.remove(nestingLevel--);
					          ast = new LetInNode(d, e);
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



	// $ANTLR start "declist"
	// /home/acco/workspace/FOOL/FOOL.g:45:1: declist returns [ArrayList<Node> astList] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
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
			// /home/acco/workspace/FOOL/FOOL.g:45:43: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// /home/acco/workspace/FOOL/FOOL.g:47:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{
			astList = new ArrayList<Node>();
			    //inizializzo l'offset
			    int offset = -2;//perchè abbiamo aggiunto l'access link
			    
			// /home/acco/workspace/FOOL/FOOL.g:51:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==FUN||LA6_0==VAR) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:51:7: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// /home/acco/workspace/FOOL/FOOL.g:51:7: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==VAR) ) {
						alt5=1;
					}
					else if ( (LA5_0==FUN) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:52:8: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist183); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist187); 
							match(input,COLON,FOLLOW_COLON_in_declist189); 
							pushFollow(FOLLOW_type_in_declist193);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist195); 
							pushFollow(FOLLOW_exp_in_declist199);
							e=exp();
							state._fsp--;

							VarNode v = new VarNode((i!=null?i.getText():null), t, e);
							         astList.add(v);
							         System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+t);
							         //ora che ho dichiarato la var la aggiungo alla symbol table
							         //recupero l'hash table dell'ambiente locale
							         HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
							         //ora controllo che non ci sia già
								       if(hm.put((i!=null?i.getText():null),new STEntry(nestingLevel,t, offset--))!=null){ //l'offset lo calcolo in base all'ordine in cui incontro le variabili
								        System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
								        System.exit(0);
								       };
								       if(t instanceof ArrowTypeNode){offset--;}
							         
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:67:8: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist237); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist241); 
							match(input,COLON,FOLLOW_COLON_in_declist243); 
							pushFollow(FOLLOW_type_in_declist247);
							t=type();
							state._fsp--;

							FunNode f = new FunNode((i!=null?i.getText():null), t); 
							        
							         astList.add(f);  
							         HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
							         //creo una entry con solo il nesting level, ci metterò il tipo quando lo saprò (lo leggo dopo aver letto tutti i parametri)
							         STEntry entry = new STEntry(nestingLevel,offset);
							         //ora la funzione occupa due offset
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
							         
							match(input,LPAR,FOLLOW_LPAR_in_declist290); 

							          ArrayList<Node> parTypes = new ArrayList<Node>();
							          int parOffset = 1; //i parametri iniziano da 1 nel layout e l'offset si incrementa
							         
							// /home/acco/workspace/FOOL/FOOL.g:96:11: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( (LA3_0==ID) ) {
								alt3=1;
							}
							switch (alt3) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:96:12: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist337); 
									match(input,COLON,FOLLOW_COLON_in_declist339); 
									pushFollow(FOLLOW_type_in_declist343);
									fty=type();
									state._fsp--;

									 parTypes.add(fty);
									             
									              ParNode fpar = new ParNode((fid!=null?fid.getText():null), fty);
									              f.addParameter(fpar);
									              if(hmn.put((fid!=null?fid.getText():null),new STEntry(nestingLevel,fty,parOffset++))!=null){
									                System.out.println("Error: id "+(fid!=null?fid.getText():null) +" at line "+ (fid!=null?fid.getLine():0) +" already declared!");
									                System.exit(0);
									              };
									              if(fty instanceof ArrowTypeNode){parOffset++;}
									             
									// /home/acco/workspace/FOOL/FOOL.g:110:14: ( COMMA id= ID COLON ty= type )*
									loop2:
									while (true) {
										int alt2=2;
										int LA2_0 = input.LA(1);
										if ( (LA2_0==COMMA) ) {
											alt2=1;
										}

										switch (alt2) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:110:15: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist448); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist452); 
											match(input,COLON,FOLLOW_COLON_in_declist454); 
											pushFollow(FOLLOW_type_in_declist458);
											ty=type();
											state._fsp--;

											 parTypes.add(ty);
											                ParNode par = new ParNode((id!=null?id.getText():null), ty);
											                f.addParameter(par);
											                if(hmn.put((id!=null?id.getText():null),new STEntry(nestingLevel,ty, parOffset++))!=null){
											                  System.out.println("Error: id "+(id!=null?id.getText():null) +" at line "+ (id!=null?id.getLine():0) +" already declared!");
											                  System.exit(0);
											                };
											               if(ty instanceof ArrowTypeNode){parOffset++;}
											               
											}
											break;

										default :
											break loop2;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_declist524); 
							// ora posso istanziare il nodo che rappresenta il tipo della funzione
							            ArrowTypeNode functionType = new ArrowTypeNode(parTypes,t);
							            entry.addType(functionType);
							            // aggiungo il tipo anche al FunNode
							            f.addSymType(functionType);
							          
							// /home/acco/workspace/FOOL/FOOL.g:129:10: ( LET d= declist IN )?
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==LET) ) {
								alt4=1;
							}
							switch (alt4) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:129:11: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist549); 
									pushFollow(FOLLOW_declist_in_declist553);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist555); 
									f.addDec(d);
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist562);
							e=exp();
							state._fsp--;

							//chiudo lo scope
							            symbolTable.remove(nestingLevel--);
								          f.addBody(e);
							          
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist587); 
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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
	// /home/acco/workspace/FOOL/FOOL.g:141:1: exp returns [Node ast] : v= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node v =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:141:24: (v= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// /home/acco/workspace/FOOL/FOOL.g:142:3: v= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp762);
			v=term();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:143:9: ( PLUS l= term | MINUS l= term | OR l= term )*
			loop7:
			while (true) {
				int alt7=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt7=1;
					}
					break;
				case MINUS:
					{
					alt7=2;
					}
					break;
				case OR:
					{
					alt7=3;
					}
					break;
				}
				switch (alt7) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:144:13: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp788); 
					pushFollow(FOLLOW_term_in_exp792);
					l=term();
					state._fsp--;

					ast = new PlusNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:145:13: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp808); 
					pushFollow(FOLLOW_term_in_exp812);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:146:13: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp828); 
					pushFollow(FOLLOW_term_in_exp832);
					l=term();
					state._fsp--;

					ast = new OrNode(ast,l);
					}
					break;

				default :
					break loop7;
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
	// /home/acco/workspace/FOOL/FOOL.g:152:1: term returns [Node ast] : f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:152:25: (f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* )
			// /home/acco/workspace/FOOL/FOOL.g:153:3: f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term864);
			f=factor();
			state._fsp--;

			ast = f;
			// /home/acco/workspace/FOOL/FOOL.g:154:7: ( TIMES l= factor | DIV l= factor | AND l= factor )*
			loop8:
			while (true) {
				int alt8=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt8=1;
					}
					break;
				case DIV:
					{
					alt8=2;
					}
					break;
				case AND:
					{
					alt8=3;
					}
					break;
				}
				switch (alt8) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:155:11: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term887); 
					pushFollow(FOLLOW_factor_in_term891);
					l=factor();
					state._fsp--;

					ast = new TimesNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:156:11: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term905); 
					pushFollow(FOLLOW_factor_in_term910);
					l=factor();
					state._fsp--;

					ast = new DivNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:157:11: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term924); 
					pushFollow(FOLLOW_factor_in_term929);
					l=factor();
					state._fsp--;

					ast = new AndNode(ast,l);
					}
					break;

				default :
					break loop8;
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
	// /home/acco/workspace/FOOL/FOOL.g:160:1: factor returns [Node ast] : v= value ( EQ v= value | GR v= value | LE v= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node v =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:160:26: (v= value ( EQ v= value | GR v= value | LE v= value )* )
			// /home/acco/workspace/FOOL/FOOL.g:161:3: v= value ( EQ v= value | GR v= value | LE v= value )*
			{
			pushFollow(FOLLOW_value_in_factor1014);
			v=value();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:162:7: ( EQ v= value | GR v= value | LE v= value )*
			loop9:
			while (true) {
				int alt9=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt9=1;
					}
					break;
				case GR:
					{
					alt9=2;
					}
					break;
				case LE:
					{
					alt9=3;
					}
					break;
				}
				switch (alt9) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:163:9: EQ v= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1035); 
					pushFollow(FOLLOW_value_in_factor1039);
					v=value();
					state._fsp--;

					ast = new EqualNode(ast,v);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:164:9: GR v= value
					{
					match(input,GR,FOLLOW_GR_in_factor1051); 
					pushFollow(FOLLOW_value_in_factor1055);
					v=value();
					state._fsp--;

					ast = new GreaterEqualNode(ast,v);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:165:9: LE v= value
					{
					match(input,LE,FOLLOW_LE_in_factor1067); 
					pushFollow(FOLLOW_value_in_factor1071);
					v=value();
					state._fsp--;

					ast = new LowerEqualNode(ast,v);
					}
					break;

				default :
					break loop9;
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
	// /home/acco/workspace/FOOL/FOOL.g:173:1: value returns [Node ast] : (n= NAT | TRUE | FALSE | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Node e =null;
		Node c =null;
		Node t =null;
		Node fa =null;
		Node a =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:173:26: (n= NAT | TRUE | FALSE | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? )
			int alt13=8;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt13=1;
				}
				break;
			case TRUE:
				{
				alt13=2;
				}
				break;
			case FALSE:
				{
				alt13=3;
				}
				break;
			case LPAR:
				{
				alt13=4;
				}
				break;
			case IF:
				{
				alt13=5;
				}
				break;
			case NOT:
				{
				alt13=6;
				}
				break;
			case PRINT:
				{
				alt13=7;
				}
				break;
			case ID:
				{
				alt13=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:174:9: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_value1119); 
					 ast = new NatNode(Integer.parseInt((n!=null?n.getText():null))); 
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:175:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1129); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:176:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1141); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// /home/acco/workspace/FOOL/FOOL.g:177:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1181); 
					pushFollow(FOLLOW_exp_in_value1185);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1187); 
					ast = e;
					}
					break;
				case 5 :
					// /home/acco/workspace/FOOL/FOOL.g:178:9: IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value1224); 
					pushFollow(FOLLOW_exp_in_value1228);
					c=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value1230); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1232); 
					pushFollow(FOLLOW_exp_in_value1236);
					t=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1238); 
					match(input,ELSE,FOLLOW_ELSE_in_value1257); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1259); 
					pushFollow(FOLLOW_exp_in_value1263);
					e=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1265); 
					ast = new IfElseNode(c, t, e);
					}
					break;
				case 6 :
					// /home/acco/workspace/FOOL/FOOL.g:180:9: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value1287); 
					match(input,LPAR,FOLLOW_LPAR_in_value1289); 
					pushFollow(FOLLOW_exp_in_value1293);
					e=exp();
					state._fsp--;

					ast = new NotNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value1297); 
					}
					break;
				case 7 :
					// /home/acco/workspace/FOOL/FOOL.g:181:9: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1309); 
					match(input,LPAR,FOLLOW_LPAR_in_value1311); 
					pushFollow(FOLLOW_exp_in_value1315);
					e=exp();
					state._fsp--;

					ast = new PrintNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value1319); 
					}
					break;
				case 8 :
					// /home/acco/workspace/FOOL/FOOL.g:182:9: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1333); 

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
					          
					            
					// /home/acco/workspace/FOOL/FOOL.g:202:13: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==LPAR) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:202:14: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1352); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// /home/acco/workspace/FOOL/FOOL.g:204:15: (fa= exp ( COMMA a= exp )* )?
							int alt11=2;
							int LA11_0 = input.LA(1);
							if ( (LA11_0==FALSE||(LA11_0 >= ID && LA11_0 <= IF)||LA11_0==LPAR||(LA11_0 >= NAT && LA11_0 <= NOT)||LA11_0==PRINT||LA11_0==TRUE) ) {
								alt11=1;
							}
							switch (alt11) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:204:16: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1388);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// /home/acco/workspace/FOOL/FOOL.g:205:15: ( COMMA a= exp )*
									loop10:
									while (true) {
										int alt10=2;
										int LA10_0 = input.LA(1);
										if ( (LA10_0==COMMA) ) {
											alt10=1;
										}

										switch (alt10) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:205:16: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1407); 
											pushFollow(FOLLOW_exp_in_value1411);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop10;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value1446); 
							ast = new CallNode((i!=null?i.getText():null), entry, argList, nestingLevel);
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
	// /home/acco/workspace/FOOL/FOOL.g:216:1: type returns [Node ast] : (b= basic |a= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node b =null;
		Node a =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:216:27: (b= basic |a= arrow )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==BOOL||LA14_0==ID||LA14_0==INT) ) {
				alt14=1;
			}
			else if ( (LA14_0==LPAR) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:217:10: b= basic
					{
					pushFollow(FOLLOW_basic_in_type1546);
					b=basic();
					state._fsp--;

					ast = b;
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:218:10: a= arrow
					{
					pushFollow(FOLLOW_arrow_in_type1563);
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



	// $ANTLR start "basic"
	// /home/acco/workspace/FOOL/FOOL.g:224:1: basic returns [Node ast] : ( INT | BOOL | ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		try {
			// /home/acco/workspace/FOOL/FOOL.g:224:27: ( INT | BOOL | ID )
			int alt15=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt15=1;
				}
				break;
			case BOOL:
				{
				alt15=2;
				}
				break;
			case ID:
				{
				alt15=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:225:5: INT
					{
					match(input,INT,FOLLOW_INT_in_basic1596); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:226:5: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic1607); 
					ast = new BoolTypeNode();
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:227:5: ID
					{
					match(input,ID,FOLLOW_ID_in_basic1629); 
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
	// $ANTLR end "basic"



	// $ANTLR start "arrow"
	// /home/acco/workspace/FOOL/FOOL.g:232:1: arrow returns [Node ast] : LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node t =null;
		Node b =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:232:27: ( LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic )
			// /home/acco/workspace/FOOL/FOOL.g:233:3: LPAR (t= type ( COMMA t= type )* )? RPAR ARROW b= basic
			{

			    //lista dei parametri
			    ArrayList<Node> parList = new ArrayList<Node>();
			  
			match(input,LPAR,FOLLOW_LPAR_in_arrow1688); 
			// /home/acco/workspace/FOOL/FOOL.g:237:8: (t= type ( COMMA t= type )* )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==BOOL||LA17_0==ID||LA17_0==INT||LA17_0==LPAR) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:237:9: t= type ( COMMA t= type )*
					{
					pushFollow(FOLLOW_type_in_arrow1693);
					t=type();
					state._fsp--;

					parList.add(t);
					// /home/acco/workspace/FOOL/FOOL.g:237:39: ( COMMA t= type )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0==COMMA) ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:237:40: COMMA t= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow1698); 
							pushFollow(FOLLOW_type_in_arrow1702);
							t=type();
							state._fsp--;

							parList.add(t);
							}
							break;

						default :
							break loop16;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow1711); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow1713); 
			pushFollow(FOLLOW_basic_in_arrow1717);
			b=basic();
			state._fsp--;

			ast = new ArrowTypeNode(parList,b);
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



	public static final BitSet FOLLOW_exp_in_prog57 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog59 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog95 = new BitSet(new long[]{0x0000004000040000L});
	public static final BitSet FOLLOW_declist_in_prog114 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_IN_in_prog116 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_prog120 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist183 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_declist187 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_declist189 = new BitSet(new long[]{0x0000000004900080L});
	public static final BitSet FOLLOW_type_in_declist193 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist195 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_declist199 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_FUN_in_declist237 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_declist241 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_declist243 = new BitSet(new long[]{0x0000000004900080L});
	public static final BitSet FOLLOW_type_in_declist247 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_declist290 = new BitSet(new long[]{0x0000000200100000L});
	public static final BitSet FOLLOW_ID_in_declist337 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_declist339 = new BitSet(new long[]{0x0000000004900080L});
	public static final BitSet FOLLOW_type_in_declist343 = new BitSet(new long[]{0x0000000200000400L});
	public static final BitSet FOLLOW_COMMA_in_declist448 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_declist452 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_declist454 = new BitSet(new long[]{0x0000000004900080L});
	public static final BitSet FOLLOW_type_in_declist458 = new BitSet(new long[]{0x0000000200000400L});
	public static final BitSet FOLLOW_RPAR_in_declist524 = new BitSet(new long[]{0x0000002136320000L});
	public static final BitSet FOLLOW_LET_in_declist549 = new BitSet(new long[]{0x0000004000040000L});
	public static final BitSet FOLLOW_declist_in_declist553 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_IN_in_declist555 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_declist562 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist587 = new BitSet(new long[]{0x0000004000040002L});
	public static final BitSet FOLLOW_term_in_exp762 = new BitSet(new long[]{0x00000000C8000002L});
	public static final BitSet FOLLOW_PLUS_in_exp788 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_term_in_exp792 = new BitSet(new long[]{0x00000000C8000002L});
	public static final BitSet FOLLOW_MINUS_in_exp808 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_term_in_exp812 = new BitSet(new long[]{0x00000000C8000002L});
	public static final BitSet FOLLOW_OR_in_exp828 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_term_in_exp832 = new BitSet(new long[]{0x00000000C8000002L});
	public static final BitSet FOLLOW_factor_in_term864 = new BitSet(new long[]{0x0000001000002012L});
	public static final BitSet FOLLOW_TIMES_in_term887 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_factor_in_term891 = new BitSet(new long[]{0x0000001000002012L});
	public static final BitSet FOLLOW_DIV_in_term905 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_factor_in_term910 = new BitSet(new long[]{0x0000001000002012L});
	public static final BitSet FOLLOW_AND_in_term924 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_factor_in_term929 = new BitSet(new long[]{0x0000001000002012L});
	public static final BitSet FOLLOW_value_in_factor1014 = new BitSet(new long[]{0x0000000001088002L});
	public static final BitSet FOLLOW_EQ_in_factor1035 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_value_in_factor1039 = new BitSet(new long[]{0x0000000001088002L});
	public static final BitSet FOLLOW_GR_in_factor1051 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_value_in_factor1055 = new BitSet(new long[]{0x0000000001088002L});
	public static final BitSet FOLLOW_LE_in_factor1067 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_value_in_factor1071 = new BitSet(new long[]{0x0000000001088002L});
	public static final BitSet FOLLOW_NAT_in_value1119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1181 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_value1185 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_RPAR_in_value1187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value1224 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_value1228 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_THEN_in_value1230 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLPAR_in_value1232 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_value1236 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value1238 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ELSE_in_value1257 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLPAR_in_value1259 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_value1263 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value1265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value1287 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_value1289 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_value1293 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_RPAR_in_value1297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1309 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_value1311 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_value1315 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_RPAR_in_value1319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1333 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_LPAR_in_value1352 = new BitSet(new long[]{0x0000002334320000L});
	public static final BitSet FOLLOW_exp_in_value1388 = new BitSet(new long[]{0x0000000200000400L});
	public static final BitSet FOLLOW_COMMA_in_value1407 = new BitSet(new long[]{0x0000002134320000L});
	public static final BitSet FOLLOW_exp_in_value1411 = new BitSet(new long[]{0x0000000200000400L});
	public static final BitSet FOLLOW_RPAR_in_value1446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basic_in_type1546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type1563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic1596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic1607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic1629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow1688 = new BitSet(new long[]{0x0000000204900080L});
	public static final BitSet FOLLOW_type_in_arrow1693 = new BitSet(new long[]{0x0000000200000400L});
	public static final BitSet FOLLOW_COMMA_in_arrow1698 = new BitSet(new long[]{0x0000000004900080L});
	public static final BitSet FOLLOW_type_in_arrow1702 = new BitSet(new long[]{0x0000000200000400L});
	public static final BitSet FOLLOW_RPAR_in_arrow1711 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow1713 = new BitSet(new long[]{0x0000000000900080L});
	public static final BitSet FOLLOW_basic_in_arrow1717 = new BitSet(new long[]{0x0000000000000002L});
}
