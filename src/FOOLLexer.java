// $ANTLR 3.5.2 /home/acco/workspace/FOOL/FOOL.g 2015-12-21 11:31:31

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLLexer extends Lexer {
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

	int lexicalErrors=0;
	/* Queste cose diventano un campo della classe SimpleExpLexer.java */


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public FOOLLexer() {} 
	public FOOLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/acco/workspace/FOOL/FOOL.g"; }

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:236:6: ( '+' )
			// /home/acco/workspace/FOOL/FOOL.g:236:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "TIMES"
	public final void mTIMES() throws RecognitionException {
		try {
			int _type = TIMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:237:7: ( '*' )
			// /home/acco/workspace/FOOL/FOOL.g:237:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMES"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:238:9: ( '-' )
			// /home/acco/workspace/FOOL/FOOL.g:238:11: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:239:7: ( '/' )
			// /home/acco/workspace/FOOL/FOOL.g:239:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "SEMIC"
	public final void mSEMIC() throws RecognitionException {
		try {
			int _type = SEMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:241:7: ( ';' )
			// /home/acco/workspace/FOOL/FOOL.g:241:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMIC"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:243:5: ( '||' )
			// /home/acco/workspace/FOOL/FOOL.g:243:7: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:244:5: ( '&&' )
			// /home/acco/workspace/FOOL/FOOL.g:244:7: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:245:5: ( 'not' )
			// /home/acco/workspace/FOOL/FOOL.g:245:7: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "GR"
	public final void mGR() throws RecognitionException {
		try {
			int _type = GR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:246:5: ( '>=' )
			// /home/acco/workspace/FOOL/FOOL.g:246:7: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GR"

	// $ANTLR start "LE"
	public final void mLE() throws RecognitionException {
		try {
			int _type = LE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:247:5: ( '<=' )
			// /home/acco/workspace/FOOL/FOOL.g:247:7: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:248:5: ( '==' )
			// /home/acco/workspace/FOOL/FOOL.g:248:7: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "NAT"
	public final void mNAT() throws RecognitionException {
		try {
			int _type = NAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:250:5: ( ( ( '1' .. '9' ) ( '0' .. '9' )* ) | '0' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= '1' && LA2_0 <= '9')) ) {
				alt2=1;
			}
			else if ( (LA2_0=='0') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:250:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// /home/acco/workspace/FOOL/FOOL.g:250:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// /home/acco/workspace/FOOL/FOOL.g:250:8: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// /home/acco/workspace/FOOL/FOOL.g:250:18: ( '0' .. '9' )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// /home/acco/workspace/FOOL/FOOL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop1;
						}
					}

					}

					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/FOOL.g:250:33: '0'
					{
					match('0'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAT"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:251:7: ( 'true' )
			// /home/acco/workspace/FOOL/FOOL.g:251:9: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:252:7: ( 'false' )
			// /home/acco/workspace/FOOL/FOOL.g:252:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:253:7: ( '(' )
			// /home/acco/workspace/FOOL/FOOL.g:253:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:254:7: ( ')' )
			// /home/acco/workspace/FOOL/FOOL.g:254:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "CLPAR"
	public final void mCLPAR() throws RecognitionException {
		try {
			int _type = CLPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:255:9: ( '{' )
			// /home/acco/workspace/FOOL/FOOL.g:255:11: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLPAR"

	// $ANTLR start "CRPAR"
	public final void mCRPAR() throws RecognitionException {
		try {
			int _type = CRPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:256:7: ( '}' )
			// /home/acco/workspace/FOOL/FOOL.g:256:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CRPAR"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:257:5: ( 'if' )
			// /home/acco/workspace/FOOL/FOOL.g:257:7: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:258:7: ( 'then' )
			// /home/acco/workspace/FOOL/FOOL.g:258:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:259:7: ( 'else' )
			// /home/acco/workspace/FOOL/FOOL.g:259:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:260:7: ( 'print' )
			// /home/acco/workspace/FOOL/FOOL.g:260:9: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "FUN"
	public final void mFUN() throws RecognitionException {
		try {
			int _type = FUN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:261:5: ( 'fun' )
			// /home/acco/workspace/FOOL/FOOL.g:261:7: 'fun'
			{
			match("fun"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUN"

	// $ANTLR start "LET"
	public final void mLET() throws RecognitionException {
		try {
			int _type = LET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:262:9: ( 'let' )
			// /home/acco/workspace/FOOL/FOOL.g:262:11: 'let'
			{
			match("let"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LET"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:263:9: ( 'in' )
			// /home/acco/workspace/FOOL/FOOL.g:263:11: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:264:9: ( 'var' )
			// /home/acco/workspace/FOOL/FOOL.g:264:11: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:265:9: ( ':' )
			// /home/acco/workspace/FOOL/FOOL.g:265:11: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:266:7: ( ',' )
			// /home/acco/workspace/FOOL/FOOL.g:266:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "ASS"
	public final void mASS() throws RecognitionException {
		try {
			int _type = ASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:267:5: ( '=' )
			// /home/acco/workspace/FOOL/FOOL.g:267:7: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASS"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:268:5: ( 'int' )
			// /home/acco/workspace/FOOL/FOOL.g:268:7: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:270:9: ( '->' )
			// /home/acco/workspace/FOOL/FOOL.g:270:11: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROW"

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:272:7: ( 'bool' )
			// /home/acco/workspace/FOOL/FOOL.g:272:9: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:274:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// /home/acco/workspace/FOOL/FOOL.g:274:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/acco/workspace/FOOL/FOOL.g:274:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WHITESP"
	public final void mWHITESP() throws RecognitionException {
		try {
			int _type = WHITESP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:278:9: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// /home/acco/workspace/FOOL/FOOL.g:278:11: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// /home/acco/workspace/FOOL/FOOL.g:278:11: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 _channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESP"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:281:9: ( '/*' ( . )* '*/' )
			// /home/acco/workspace/FOOL/FOOL.g:281:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /home/acco/workspace/FOOL/FOOL.g:281:16: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='*') ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1=='/') ) {
						alt5=2;
					}
					else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
						alt5=1;
					}

				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /home/acco/workspace/FOOL/FOOL.g:281:16: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match("*/"); 

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "ERR"
	public final void mERR() throws RecognitionException {
		try {
			int _type = ERR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:283:5: ( . )
			// /home/acco/workspace/FOOL/FOOL.g:283:7: .
			{
			matchAny(); 
			System.err.println("Invalid char: "+getText()); lexicalErrors++;
			             _channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ERR"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/acco/workspace/FOOL/FOOL.g:1:8: ( PLUS | TIMES | MINUS | DIV | SEMIC | OR | AND | NOT | GR | LE | EQ | NAT | TRUE | FALSE | LPAR | RPAR | CLPAR | CRPAR | IF | THEN | ELSE | PRINT | FUN | LET | IN | VAR | COLON | COMMA | ASS | INT | ARROW | BOOL | ID | WHITESP | COMMENT | ERR )
		int alt6=36;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// /home/acco/workspace/FOOL/FOOL.g:1:10: PLUS
				{
				mPLUS(); 

				}
				break;
			case 2 :
				// /home/acco/workspace/FOOL/FOOL.g:1:15: TIMES
				{
				mTIMES(); 

				}
				break;
			case 3 :
				// /home/acco/workspace/FOOL/FOOL.g:1:21: MINUS
				{
				mMINUS(); 

				}
				break;
			case 4 :
				// /home/acco/workspace/FOOL/FOOL.g:1:27: DIV
				{
				mDIV(); 

				}
				break;
			case 5 :
				// /home/acco/workspace/FOOL/FOOL.g:1:31: SEMIC
				{
				mSEMIC(); 

				}
				break;
			case 6 :
				// /home/acco/workspace/FOOL/FOOL.g:1:37: OR
				{
				mOR(); 

				}
				break;
			case 7 :
				// /home/acco/workspace/FOOL/FOOL.g:1:40: AND
				{
				mAND(); 

				}
				break;
			case 8 :
				// /home/acco/workspace/FOOL/FOOL.g:1:44: NOT
				{
				mNOT(); 

				}
				break;
			case 9 :
				// /home/acco/workspace/FOOL/FOOL.g:1:48: GR
				{
				mGR(); 

				}
				break;
			case 10 :
				// /home/acco/workspace/FOOL/FOOL.g:1:51: LE
				{
				mLE(); 

				}
				break;
			case 11 :
				// /home/acco/workspace/FOOL/FOOL.g:1:54: EQ
				{
				mEQ(); 

				}
				break;
			case 12 :
				// /home/acco/workspace/FOOL/FOOL.g:1:57: NAT
				{
				mNAT(); 

				}
				break;
			case 13 :
				// /home/acco/workspace/FOOL/FOOL.g:1:61: TRUE
				{
				mTRUE(); 

				}
				break;
			case 14 :
				// /home/acco/workspace/FOOL/FOOL.g:1:66: FALSE
				{
				mFALSE(); 

				}
				break;
			case 15 :
				// /home/acco/workspace/FOOL/FOOL.g:1:72: LPAR
				{
				mLPAR(); 

				}
				break;
			case 16 :
				// /home/acco/workspace/FOOL/FOOL.g:1:77: RPAR
				{
				mRPAR(); 

				}
				break;
			case 17 :
				// /home/acco/workspace/FOOL/FOOL.g:1:82: CLPAR
				{
				mCLPAR(); 

				}
				break;
			case 18 :
				// /home/acco/workspace/FOOL/FOOL.g:1:88: CRPAR
				{
				mCRPAR(); 

				}
				break;
			case 19 :
				// /home/acco/workspace/FOOL/FOOL.g:1:94: IF
				{
				mIF(); 

				}
				break;
			case 20 :
				// /home/acco/workspace/FOOL/FOOL.g:1:97: THEN
				{
				mTHEN(); 

				}
				break;
			case 21 :
				// /home/acco/workspace/FOOL/FOOL.g:1:102: ELSE
				{
				mELSE(); 

				}
				break;
			case 22 :
				// /home/acco/workspace/FOOL/FOOL.g:1:107: PRINT
				{
				mPRINT(); 

				}
				break;
			case 23 :
				// /home/acco/workspace/FOOL/FOOL.g:1:113: FUN
				{
				mFUN(); 

				}
				break;
			case 24 :
				// /home/acco/workspace/FOOL/FOOL.g:1:117: LET
				{
				mLET(); 

				}
				break;
			case 25 :
				// /home/acco/workspace/FOOL/FOOL.g:1:121: IN
				{
				mIN(); 

				}
				break;
			case 26 :
				// /home/acco/workspace/FOOL/FOOL.g:1:124: VAR
				{
				mVAR(); 

				}
				break;
			case 27 :
				// /home/acco/workspace/FOOL/FOOL.g:1:128: COLON
				{
				mCOLON(); 

				}
				break;
			case 28 :
				// /home/acco/workspace/FOOL/FOOL.g:1:134: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 29 :
				// /home/acco/workspace/FOOL/FOOL.g:1:140: ASS
				{
				mASS(); 

				}
				break;
			case 30 :
				// /home/acco/workspace/FOOL/FOOL.g:1:144: INT
				{
				mINT(); 

				}
				break;
			case 31 :
				// /home/acco/workspace/FOOL/FOOL.g:1:148: ARROW
				{
				mARROW(); 

				}
				break;
			case 32 :
				// /home/acco/workspace/FOOL/FOOL.g:1:154: BOOL
				{
				mBOOL(); 

				}
				break;
			case 33 :
				// /home/acco/workspace/FOOL/FOOL.g:1:159: ID
				{
				mID(); 

				}
				break;
			case 34 :
				// /home/acco/workspace/FOOL/FOOL.g:1:162: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 35 :
				// /home/acco/workspace/FOOL/FOOL.g:1:170: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 36 :
				// /home/acco/workspace/FOOL/FOOL.g:1:178: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\3\uffff\1\42\1\44\1\uffff\2\36\1\51\2\36\1\55\2\uffff\2\51\4\uffff\5"+
		"\51\2\uffff\1\51\14\uffff\1\51\6\uffff\4\51\4\uffff\1\106\1\110\4\51\2"+
		"\uffff\1\51\1\uffff\1\116\3\51\1\122\1\uffff\1\123\1\uffff\2\51\1\126"+
		"\1\127\1\51\1\uffff\1\131\1\132\1\51\2\uffff\1\134\1\51\2\uffff\1\136"+
		"\2\uffff\1\137\1\uffff\1\140\3\uffff";
	static final String DFA6_eofS =
		"\141\uffff";
	static final String DFA6_minS =
		"\1\0\2\uffff\1\76\1\52\1\uffff\1\174\1\46\1\157\3\75\2\uffff\1\150\1\141"+
		"\4\uffff\1\146\1\154\1\162\1\145\1\141\2\uffff\1\157\14\uffff\1\164\6"+
		"\uffff\1\165\1\145\1\154\1\156\4\uffff\2\60\1\163\1\151\1\164\1\162\2"+
		"\uffff\1\157\1\uffff\1\60\1\145\1\156\1\163\1\60\1\uffff\1\60\1\uffff"+
		"\1\145\1\156\2\60\1\154\1\uffff\2\60\1\145\2\uffff\1\60\1\164\2\uffff"+
		"\1\60\2\uffff\1\60\1\uffff\1\60\3\uffff";
	static final String DFA6_maxS =
		"\1\uffff\2\uffff\1\76\1\52\1\uffff\1\174\1\46\1\157\3\75\2\uffff\1\162"+
		"\1\165\4\uffff\1\156\1\154\1\162\1\145\1\141\2\uffff\1\157\14\uffff\1"+
		"\164\6\uffff\1\165\1\145\1\154\1\156\4\uffff\2\172\1\163\1\151\1\164\1"+
		"\162\2\uffff\1\157\1\uffff\1\172\1\145\1\156\1\163\1\172\1\uffff\1\172"+
		"\1\uffff\1\145\1\156\2\172\1\154\1\uffff\2\172\1\145\2\uffff\1\172\1\164"+
		"\2\uffff\1\172\2\uffff\1\172\1\uffff\1\172\3\uffff";
	static final String DFA6_acceptS =
		"\1\uffff\1\1\1\2\2\uffff\1\5\6\uffff\2\14\2\uffff\1\17\1\20\1\21\1\22"+
		"\5\uffff\1\33\1\34\1\uffff\1\41\1\42\1\44\1\1\1\2\1\37\1\3\1\43\1\4\1"+
		"\5\1\6\1\7\1\uffff\1\41\1\11\1\12\1\13\1\35\1\14\4\uffff\1\17\1\20\1\21"+
		"\1\22\6\uffff\1\33\1\34\1\uffff\1\42\5\uffff\1\23\1\uffff\1\31\5\uffff"+
		"\1\10\3\uffff\1\27\1\36\2\uffff\1\30\1\32\1\uffff\1\15\1\24\1\uffff\1"+
		"\25\1\uffff\1\40\1\16\1\26";
	static final String DFA6_specialS =
		"\1\0\140\uffff}>";
	static final String[] DFA6_transitionS = {
			"\11\36\2\35\2\36\1\35\22\36\1\35\5\36\1\7\1\36\1\20\1\21\1\2\1\1\1\32"+
			"\1\3\1\36\1\4\1\15\11\14\1\31\1\5\1\12\1\13\1\11\2\36\32\34\6\36\1\34"+
			"\1\33\2\34\1\25\1\17\2\34\1\24\2\34\1\27\1\34\1\10\1\34\1\26\3\34\1\16"+
			"\1\34\1\30\4\34\1\22\1\6\1\23\uff82\36",
			"",
			"",
			"\1\41",
			"\1\43",
			"",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\52",
			"\1\53",
			"\1\54",
			"",
			"",
			"\1\60\11\uffff\1\57",
			"\1\61\23\uffff\1\62",
			"",
			"",
			"",
			"",
			"\1\67\7\uffff\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"",
			"",
			"\1\77",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\101",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"",
			"",
			"",
			"",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"\12\51\7\uffff\32\51\6\uffff\23\51\1\107\6\51",
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"",
			"",
			"\1\115",
			"",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"\1\117",
			"\1\120",
			"\1\121",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"",
			"\1\124",
			"\1\125",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"\1\130",
			"",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"\1\133",
			"",
			"",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"\1\135",
			"",
			"",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"",
			"",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"",
			"\12\51\7\uffff\32\51\6\uffff\32\51",
			"",
			"",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( PLUS | TIMES | MINUS | DIV | SEMIC | OR | AND | NOT | GR | LE | EQ | NAT | TRUE | FALSE | LPAR | RPAR | CLPAR | CRPAR | IF | THEN | ELSE | PRINT | FUN | LET | IN | VAR | COLON | COMMA | ASS | INT | ARROW | BOOL | ID | WHITESP | COMMENT | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA6_0 = input.LA(1);
						s = -1;
						if ( (LA6_0=='+') ) {s = 1;}
						else if ( (LA6_0=='*') ) {s = 2;}
						else if ( (LA6_0=='-') ) {s = 3;}
						else if ( (LA6_0=='/') ) {s = 4;}
						else if ( (LA6_0==';') ) {s = 5;}
						else if ( (LA6_0=='|') ) {s = 6;}
						else if ( (LA6_0=='&') ) {s = 7;}
						else if ( (LA6_0=='n') ) {s = 8;}
						else if ( (LA6_0=='>') ) {s = 9;}
						else if ( (LA6_0=='<') ) {s = 10;}
						else if ( (LA6_0=='=') ) {s = 11;}
						else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {s = 12;}
						else if ( (LA6_0=='0') ) {s = 13;}
						else if ( (LA6_0=='t') ) {s = 14;}
						else if ( (LA6_0=='f') ) {s = 15;}
						else if ( (LA6_0=='(') ) {s = 16;}
						else if ( (LA6_0==')') ) {s = 17;}
						else if ( (LA6_0=='{') ) {s = 18;}
						else if ( (LA6_0=='}') ) {s = 19;}
						else if ( (LA6_0=='i') ) {s = 20;}
						else if ( (LA6_0=='e') ) {s = 21;}
						else if ( (LA6_0=='p') ) {s = 22;}
						else if ( (LA6_0=='l') ) {s = 23;}
						else if ( (LA6_0=='v') ) {s = 24;}
						else if ( (LA6_0==':') ) {s = 25;}
						else if ( (LA6_0==',') ) {s = 26;}
						else if ( (LA6_0=='b') ) {s = 27;}
						else if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='a'||(LA6_0 >= 'c' && LA6_0 <= 'd')||(LA6_0 >= 'g' && LA6_0 <= 'h')||(LA6_0 >= 'j' && LA6_0 <= 'k')||LA6_0=='m'||LA6_0=='o'||(LA6_0 >= 'q' && LA6_0 <= 's')||LA6_0=='u'||(LA6_0 >= 'w' && LA6_0 <= 'z')) ) {s = 28;}
						else if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 29;}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\b')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\u001F')||(LA6_0 >= '!' && LA6_0 <= '%')||LA6_0=='\''||LA6_0=='.'||(LA6_0 >= '?' && LA6_0 <= '@')||(LA6_0 >= '[' && LA6_0 <= '`')||(LA6_0 >= '~' && LA6_0 <= '\uFFFF')) ) {s = 30;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 6, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
