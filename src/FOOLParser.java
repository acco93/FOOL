// $ANTLR 3.5.2 /home/acco/workspace/FOOL/FOOL.g 2015-12-16 12:55:17

  import java.util.ArrayList;
  import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASS", "BOOL", "CLPAR", 
		"COLON", "COMMA", "COMMENT", "CRPAR", "DIV", "ELSE", "EQ", "ERR", "FALSE", 
		"FUN", "GR", "ID", "IF", "IN", "INT", "LE", "LET", "LPAR", "MINUS", "NAT", 
		"NOT", "OR", "PLUS", "PRINT", "RPAR", "SEMIC", "THEN", "TIMES", "TRUE", 
		"VAR", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ASS=5;
	public static final int BOOL=6;
	public static final int CLPAR=7;
	public static final int COLON=8;
	public static final int COMMA=9;
	public static final int COMMENT=10;
	public static final int CRPAR=11;
	public static final int DIV=12;
	public static final int ELSE=13;
	public static final int EQ=14;
	public static final int ERR=15;
	public static final int FALSE=16;
	public static final int FUN=17;
	public static final int GR=18;
	public static final int ID=19;
	public static final int IF=20;
	public static final int IN=21;
	public static final int INT=22;
	public static final int LE=23;
	public static final int LET=24;
	public static final int LPAR=25;
	public static final int MINUS=26;
	public static final int NAT=27;
	public static final int NOT=28;
	public static final int OR=29;
	public static final int PLUS=30;
	public static final int PRINT=31;
	public static final int RPAR=32;
	public static final int SEMIC=33;
	public static final int THEN=34;
	public static final int TIMES=35;
	public static final int TRUE=36;
	public static final int VAR=37;
	public static final int WHITESP=38;

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
	// /home/acco/workspace/FOOL/FOOL.g:28:1: prog returns [Node ast] : (e= exp SEMIC | LET d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> d =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:28:25: (e= exp SEMIC | LET d= declist IN e= exp SEMIC )
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
					// /home/acco/workspace/FOOL/FOOL.g:29:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog51);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog53); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:32:5: LET d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog97); 
					nestingLevel++; 
						       HashMap<String,STEntry> hm = new HashMap<String,STEntry>();
						       symbolTable.add(hm);
					pushFollow(FOLLOW_declist_in_prog116);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog118); 
					pushFollow(FOLLOW_exp_in_prog122);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog124); 
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
	// /home/acco/workspace/FOOL/FOOL.g:43:1: declist returns [ArrayList<Node> astList] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ ;
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
			// /home/acco/workspace/FOOL/FOOL.g:43:43: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+ )
			// /home/acco/workspace/FOOL/FOOL.g:45:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
			{
			astList = new ArrayList<Node>();
			    //inizializzo l'offset
			    int offset = -2;//perchè abbiamo aggiunto l'access link
			    
			// /home/acco/workspace/FOOL/FOOL.g:49:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )+
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
					// /home/acco/workspace/FOOL/FOOL.g:49:7: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// /home/acco/workspace/FOOL/FOOL.g:49:7: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
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
							// /home/acco/workspace/FOOL/FOOL.g:50:8: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist185); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist189); 
							match(input,COLON,FOLLOW_COLON_in_declist191); 
							pushFollow(FOLLOW_type_in_declist195);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist197); 
							pushFollow(FOLLOW_exp_in_declist201);
							e=exp();
							state._fsp--;

							VarNode v = new VarNode((i!=null?i.getText():null), t, e);
							         astList.add(v);
							         //ora che ho dichiarato la var la aggiungo alla symbol table
							         //recupero l'hash table dell'ambiente locale
							         HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
							         //ora controllo che non ci sia già
								       if(hm.put((i!=null?i.getText():null),new STEntry(nestingLevel,t, offset--))!=null){ //l'offset lo calcolo in base all'ordine in cui incontro le variabili
								        System.out.println("Error: id "+(i!=null?i.getText():null) +" at line "+ (i!=null?i.getLine():0) +" already declared!");
								        System.exit(0);
								       };
							         
							}
							break;
						case 2 :
							// /home/acco/workspace/FOOL/FOOL.g:63:8: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist239); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist243); 
							match(input,COLON,FOLLOW_COLON_in_declist245); 
							pushFollow(FOLLOW_type_in_declist249);
							t=type();
							state._fsp--;

							FunNode f = new FunNode((i!=null?i.getText():null), t); 
							         astList.add(f);  
							         HashMap<String,STEntry> hm = symbolTable.get(nestingLevel);
							         //creo una entry con solo il nesting level, ci metterò il tipo quando lo saprò (lo leggo dopo aver letto tutti i parametri)
							         STEntry entry = new STEntry(nestingLevel,offset--);
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
							         
							match(input,LPAR,FOLLOW_LPAR_in_declist292); 
							ArrayList<Node> parTypes = new ArrayList<Node>();
							              int parOffset = 1; //i parametri iniziano da 1 nel layout e l'offset si incrementa
							         
							// /home/acco/workspace/FOOL/FOOL.g:88:11: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( (LA3_0==ID) ) {
								alt3=1;
							}
							switch (alt3) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:88:12: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist339); 
									match(input,COLON,FOLLOW_COLON_in_declist341); 
									pushFollow(FOLLOW_type_in_declist345);
									fty=type();
									state._fsp--;

									 parTypes.add(fty);
									              ParNode fpar = new ParNode((fid!=null?fid.getText():null), fty);
									              f.addParameter(fpar);
									              if(hm.put((fid!=null?fid.getText():null),new STEntry(nestingLevel,fty,parOffset++))!=null){
									                System.out.println("Error: id "+(fid!=null?fid.getText():null) +" at line "+ (fid!=null?fid.getLine():0) +" already declared!");
									                System.exit(0);
									              };
									             
									// /home/acco/workspace/FOOL/FOOL.g:100:14: ( COMMA id= ID COLON ty= type )*
									loop2:
									while (true) {
										int alt2=2;
										int LA2_0 = input.LA(1);
										if ( (LA2_0==COMMA) ) {
											alt2=1;
										}

										switch (alt2) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:100:15: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist450); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist454); 
											match(input,COLON,FOLLOW_COLON_in_declist456); 
											pushFollow(FOLLOW_type_in_declist460);
											ty=type();
											state._fsp--;

											 parTypes.add(ty);
											                ParNode par = new ParNode((id!=null?id.getText():null), ty);
											                f.addParameter(par);
											                if(hm.put((id!=null?id.getText():null),new STEntry(nestingLevel,ty, parOffset++))!=null){
											                  System.out.println("Error: id "+(id!=null?id.getText():null) +" at line "+ (id!=null?id.getLine():0) +" already declared!");
											                  System.exit(0);
											                };
											               
											}
											break;

										default :
											break loop2;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_declist526); 
							// ora posso istanziare il nodo che rappresenta il tipo della funzione
							            entry.addType(new ArrowTypeNode(parTypes,t));
							          
							// /home/acco/workspace/FOOL/FOOL.g:115:10: ( LET d= declist IN )?
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==LET) ) {
								alt4=1;
							}
							switch (alt4) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:115:11: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist551); 
									pushFollow(FOLLOW_declist_in_declist555);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist557); 
									f.addDec(d);
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist564);
							e=exp();
							state._fsp--;

							//chiudo lo scope
							            symbolTable.remove(nestingLevel--);
								          f.addBody(e);
							          
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist589); 
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



	// $ANTLR start "type"
	// /home/acco/workspace/FOOL/FOOL.g:124:1: type returns [Node ast] : ( INT | BOOL );
	public final Node type() throws RecognitionException {
		Node ast = null;


		try {
			// /home/acco/workspace/FOOL/FOOL.g:124:25: ( INT | BOOL )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==INT) ) {
				alt7=1;
			}
			else if ( (LA7_0==BOOL) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:125:5: INT
					{
					match(input,INT,FOLLOW_INT_in_type698); 
					ast = new IntTypeNode();
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:126:5: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_type710); 
					ast = new BoolTypeNode();
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



	// $ANTLR start "exp"
	// /home/acco/workspace/FOOL/FOOL.g:135:1: exp returns [Node ast] : v= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node v =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:135:24: (v= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// /home/acco/workspace/FOOL/FOOL.g:136:3: v= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp803);
			v=term();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:137:9: ( PLUS l= term | MINUS l= term | OR l= term )*
			loop8:
			while (true) {
				int alt8=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt8=1;
					}
					break;
				case MINUS:
					{
					alt8=2;
					}
					break;
				case OR:
					{
					alt8=3;
					}
					break;
				}
				switch (alt8) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:138:13: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp829); 
					pushFollow(FOLLOW_term_in_exp833);
					l=term();
					state._fsp--;

					ast = new PlusNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:139:13: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp849); 
					pushFollow(FOLLOW_term_in_exp853);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:140:13: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp869); 
					pushFollow(FOLLOW_term_in_exp873);
					l=term();
					state._fsp--;

					ast = new OrNode(ast,l);
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
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// /home/acco/workspace/FOOL/FOOL.g:146:1: term returns [Node ast] : f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:146:25: (f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )* )
			// /home/acco/workspace/FOOL/FOOL.g:147:3: f= factor ( TIMES l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term905);
			f=factor();
			state._fsp--;

			ast = f;
			// /home/acco/workspace/FOOL/FOOL.g:148:7: ( TIMES l= factor | DIV l= factor | AND l= factor )*
			loop9:
			while (true) {
				int alt9=4;
				switch ( input.LA(1) ) {
				case TIMES:
					{
					alt9=1;
					}
					break;
				case DIV:
					{
					alt9=2;
					}
					break;
				case AND:
					{
					alt9=3;
					}
					break;
				}
				switch (alt9) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:149:11: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term928); 
					pushFollow(FOLLOW_factor_in_term932);
					l=factor();
					state._fsp--;

					ast = new TimesNode(ast,l);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:150:11: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term946); 
					pushFollow(FOLLOW_factor_in_term951);
					l=factor();
					state._fsp--;

					ast = new DivNode(ast,l);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:151:11: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term965); 
					pushFollow(FOLLOW_factor_in_term970);
					l=factor();
					state._fsp--;

					ast = new AndNode(ast,l);
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
	// $ANTLR end "term"



	// $ANTLR start "factor"
	// /home/acco/workspace/FOOL/FOOL.g:154:1: factor returns [Node ast] : v= value ( EQ v= value | GR v= value | LE v= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node v =null;

		try {
			// /home/acco/workspace/FOOL/FOOL.g:154:26: (v= value ( EQ v= value | GR v= value | LE v= value )* )
			// /home/acco/workspace/FOOL/FOOL.g:155:3: v= value ( EQ v= value | GR v= value | LE v= value )*
			{
			pushFollow(FOLLOW_value_in_factor1055);
			v=value();
			state._fsp--;

			ast = v;
			// /home/acco/workspace/FOOL/FOOL.g:156:7: ( EQ v= value | GR v= value | LE v= value )*
			loop10:
			while (true) {
				int alt10=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt10=1;
					}
					break;
				case GR:
					{
					alt10=2;
					}
					break;
				case LE:
					{
					alt10=3;
					}
					break;
				}
				switch (alt10) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:157:9: EQ v= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1076); 
					pushFollow(FOLLOW_value_in_factor1080);
					v=value();
					state._fsp--;

					ast = new EqualNode(ast,v);
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:158:9: GR v= value
					{
					match(input,GR,FOLLOW_GR_in_factor1092); 
					pushFollow(FOLLOW_value_in_factor1096);
					v=value();
					state._fsp--;

					ast = new GreaterEqualNode(ast,v);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:159:9: LE v= value
					{
					match(input,LE,FOLLOW_LE_in_factor1108); 
					pushFollow(FOLLOW_value_in_factor1112);
					v=value();
					state._fsp--;

					ast = new LowerEqualNode(ast,v);
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
		return ast;
	}
	// $ANTLR end "factor"



	// $ANTLR start "value"
	// /home/acco/workspace/FOOL/FOOL.g:167:1: value returns [Node ast] : (n= NAT | TRUE | FALSE | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? );
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
			// /home/acco/workspace/FOOL/FOOL.g:167:26: (n= NAT | TRUE | FALSE | LPAR e= exp RPAR | IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR | NOT LPAR e= exp RPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? )
			int alt14=8;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt14=1;
				}
				break;
			case TRUE:
				{
				alt14=2;
				}
				break;
			case FALSE:
				{
				alt14=3;
				}
				break;
			case LPAR:
				{
				alt14=4;
				}
				break;
			case IF:
				{
				alt14=5;
				}
				break;
			case NOT:
				{
				alt14=6;
				}
				break;
			case PRINT:
				{
				alt14=7;
				}
				break;
			case ID:
				{
				alt14=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:168:9: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_value1160); 
					 ast = new NatNode(Integer.parseInt((n!=null?n.getText():null))); 
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:169:5: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1170); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/FOOL.g:170:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1182); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// /home/acco/workspace/FOOL/FOOL.g:171:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1222); 
					pushFollow(FOLLOW_exp_in_value1226);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1228); 
					ast = e;
					}
					break;
				case 5 :
					// /home/acco/workspace/FOOL/FOOL.g:172:9: IF c= exp THEN CLPAR t= exp CRPAR ELSE CLPAR e= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value1265); 
					pushFollow(FOLLOW_exp_in_value1269);
					c=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value1271); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1273); 
					pushFollow(FOLLOW_exp_in_value1277);
					t=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1279); 
					match(input,ELSE,FOLLOW_ELSE_in_value1298); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1300); 
					pushFollow(FOLLOW_exp_in_value1304);
					e=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1306); 
					ast = new IfElseNode(c, t, e);
					}
					break;
				case 6 :
					// /home/acco/workspace/FOOL/FOOL.g:174:9: NOT LPAR e= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value1328); 
					match(input,LPAR,FOLLOW_LPAR_in_value1330); 
					pushFollow(FOLLOW_exp_in_value1334);
					e=exp();
					state._fsp--;

					ast = new NotNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value1338); 
					}
					break;
				case 7 :
					// /home/acco/workspace/FOOL/FOOL.g:175:9: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1350); 
					match(input,LPAR,FOLLOW_LPAR_in_value1352); 
					pushFollow(FOLLOW_exp_in_value1356);
					e=exp();
					state._fsp--;

					ast = new PrintNode(e);
					match(input,RPAR,FOLLOW_RPAR_in_value1360); 
					}
					break;
				case 8 :
					// /home/acco/workspace/FOOL/FOOL.g:176:9: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1374); 

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
					          
					            
					// /home/acco/workspace/FOOL/FOOL.g:196:13: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==LPAR) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:196:14: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1393); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// /home/acco/workspace/FOOL/FOOL.g:198:15: (fa= exp ( COMMA a= exp )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==FALSE||(LA12_0 >= ID && LA12_0 <= IF)||LA12_0==LPAR||(LA12_0 >= NAT && LA12_0 <= NOT)||LA12_0==PRINT||LA12_0==TRUE) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// /home/acco/workspace/FOOL/FOOL.g:198:16: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1429);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// /home/acco/workspace/FOOL/FOOL.g:199:15: ( COMMA a= exp )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// /home/acco/workspace/FOOL/FOOL.g:199:16: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1448); 
											pushFollow(FOLLOW_exp_in_value1452);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop11;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value1487); 
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

	// Delegated rules



	public static final BitSet FOLLOW_exp_in_prog51 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog53 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog97 = new BitSet(new long[]{0x0000002000020000L});
	public static final BitSet FOLLOW_declist_in_prog116 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_IN_in_prog118 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_prog122 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_declist185 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_declist189 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COLON_in_declist191 = new BitSet(new long[]{0x0000000000400040L});
	public static final BitSet FOLLOW_type_in_declist195 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASS_in_declist197 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_declist201 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_FUN_in_declist239 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_declist243 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COLON_in_declist245 = new BitSet(new long[]{0x0000000000400040L});
	public static final BitSet FOLLOW_type_in_declist249 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_LPAR_in_declist292 = new BitSet(new long[]{0x0000000100080000L});
	public static final BitSet FOLLOW_ID_in_declist339 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COLON_in_declist341 = new BitSet(new long[]{0x0000000000400040L});
	public static final BitSet FOLLOW_type_in_declist345 = new BitSet(new long[]{0x0000000100000200L});
	public static final BitSet FOLLOW_COMMA_in_declist450 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_declist454 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COLON_in_declist456 = new BitSet(new long[]{0x0000000000400040L});
	public static final BitSet FOLLOW_type_in_declist460 = new BitSet(new long[]{0x0000000100000200L});
	public static final BitSet FOLLOW_RPAR_in_declist526 = new BitSet(new long[]{0x000000109B190000L});
	public static final BitSet FOLLOW_LET_in_declist551 = new BitSet(new long[]{0x0000002000020000L});
	public static final BitSet FOLLOW_declist_in_declist555 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_IN_in_declist557 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_declist564 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist589 = new BitSet(new long[]{0x0000002000020002L});
	public static final BitSet FOLLOW_INT_in_type698 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_type710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp803 = new BitSet(new long[]{0x0000000064000002L});
	public static final BitSet FOLLOW_PLUS_in_exp829 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_term_in_exp833 = new BitSet(new long[]{0x0000000064000002L});
	public static final BitSet FOLLOW_MINUS_in_exp849 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_term_in_exp853 = new BitSet(new long[]{0x0000000064000002L});
	public static final BitSet FOLLOW_OR_in_exp869 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_term_in_exp873 = new BitSet(new long[]{0x0000000064000002L});
	public static final BitSet FOLLOW_factor_in_term905 = new BitSet(new long[]{0x0000000800001012L});
	public static final BitSet FOLLOW_TIMES_in_term928 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_factor_in_term932 = new BitSet(new long[]{0x0000000800001012L});
	public static final BitSet FOLLOW_DIV_in_term946 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_factor_in_term951 = new BitSet(new long[]{0x0000000800001012L});
	public static final BitSet FOLLOW_AND_in_term965 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_factor_in_term970 = new BitSet(new long[]{0x0000000800001012L});
	public static final BitSet FOLLOW_value_in_factor1055 = new BitSet(new long[]{0x0000000000844002L});
	public static final BitSet FOLLOW_EQ_in_factor1076 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_value_in_factor1080 = new BitSet(new long[]{0x0000000000844002L});
	public static final BitSet FOLLOW_GR_in_factor1092 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_value_in_factor1096 = new BitSet(new long[]{0x0000000000844002L});
	public static final BitSet FOLLOW_LE_in_factor1108 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_value_in_factor1112 = new BitSet(new long[]{0x0000000000844002L});
	public static final BitSet FOLLOW_NAT_in_value1160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1222 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_value1226 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_RPAR_in_value1228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value1265 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_value1269 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_THEN_in_value1271 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLPAR_in_value1273 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_value1277 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CRPAR_in_value1279 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ELSE_in_value1298 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLPAR_in_value1300 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_value1304 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_CRPAR_in_value1306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value1328 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_LPAR_in_value1330 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_value1334 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_RPAR_in_value1338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1350 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_LPAR_in_value1352 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_value1356 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_RPAR_in_value1360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1374 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_LPAR_in_value1393 = new BitSet(new long[]{0x000000119A190000L});
	public static final BitSet FOLLOW_exp_in_value1429 = new BitSet(new long[]{0x0000000100000200L});
	public static final BitSet FOLLOW_COMMA_in_value1448 = new BitSet(new long[]{0x000000109A190000L});
	public static final BitSet FOLLOW_exp_in_value1452 = new BitSet(new long[]{0x0000000100000200L});
	public static final BitSet FOLLOW_RPAR_in_value1487 = new BitSet(new long[]{0x0000000000000002L});
}
