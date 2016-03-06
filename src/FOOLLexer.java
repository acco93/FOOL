// $ANTLR 3.5.2 /home/acco/workspace/FOOL/FOOL.g 2016-03-06 12:58:46

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

	int lexicalErrors=0;


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

	// $ANTLR start "DEBUG"
	public final void mDEBUG() throws RecognitionException {
		try {
			int _type = DEBUG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:554:7: ( 'debug' )
			// /home/acco/workspace/FOOL/FOOL.g:554:9: 'debug'
			{
			match("debug"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEBUG"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:556:6: ( '+' )
			// /home/acco/workspace/FOOL/FOOL.g:556:8: '+'
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
			// /home/acco/workspace/FOOL/FOOL.g:557:7: ( '*' )
			// /home/acco/workspace/FOOL/FOOL.g:557:9: '*'
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
			// /home/acco/workspace/FOOL/FOOL.g:558:9: ( '-' )
			// /home/acco/workspace/FOOL/FOOL.g:558:11: '-'
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
			// /home/acco/workspace/FOOL/FOOL.g:559:7: ( '/' )
			// /home/acco/workspace/FOOL/FOOL.g:559:9: '/'
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
			// /home/acco/workspace/FOOL/FOOL.g:561:7: ( ';' )
			// /home/acco/workspace/FOOL/FOOL.g:561:9: ';'
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
			// /home/acco/workspace/FOOL/FOOL.g:563:5: ( '||' )
			// /home/acco/workspace/FOOL/FOOL.g:563:7: '||'
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
			// /home/acco/workspace/FOOL/FOOL.g:564:5: ( '&&' )
			// /home/acco/workspace/FOOL/FOOL.g:564:7: '&&'
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
			// /home/acco/workspace/FOOL/FOOL.g:565:5: ( 'not' )
			// /home/acco/workspace/FOOL/FOOL.g:565:7: 'not'
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
			// /home/acco/workspace/FOOL/FOOL.g:566:5: ( '>=' )
			// /home/acco/workspace/FOOL/FOOL.g:566:7: '>='
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
			// /home/acco/workspace/FOOL/FOOL.g:567:5: ( '<=' )
			// /home/acco/workspace/FOOL/FOOL.g:567:7: '<='
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
			// /home/acco/workspace/FOOL/FOOL.g:568:5: ( '==' )
			// /home/acco/workspace/FOOL/FOOL.g:568:7: '=='
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
			// /home/acco/workspace/FOOL/FOOL.g:570:5: ( ( ( '1' .. '9' ) ( '0' .. '9' )* ) | '0' )
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
					// /home/acco/workspace/FOOL/FOOL.g:570:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// /home/acco/workspace/FOOL/FOOL.g:570:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// /home/acco/workspace/FOOL/FOOL.g:570:8: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// /home/acco/workspace/FOOL/FOOL.g:570:18: ( '0' .. '9' )*
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
					// /home/acco/workspace/FOOL/FOOL.g:570:33: '0'
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
			// /home/acco/workspace/FOOL/FOOL.g:571:7: ( 'true' )
			// /home/acco/workspace/FOOL/FOOL.g:571:9: 'true'
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
			// /home/acco/workspace/FOOL/FOOL.g:572:7: ( 'false' )
			// /home/acco/workspace/FOOL/FOOL.g:572:9: 'false'
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
			// /home/acco/workspace/FOOL/FOOL.g:573:7: ( '(' )
			// /home/acco/workspace/FOOL/FOOL.g:573:9: '('
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
			// /home/acco/workspace/FOOL/FOOL.g:574:7: ( ')' )
			// /home/acco/workspace/FOOL/FOOL.g:574:9: ')'
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
			// /home/acco/workspace/FOOL/FOOL.g:575:9: ( '{' )
			// /home/acco/workspace/FOOL/FOOL.g:575:11: '{'
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
			// /home/acco/workspace/FOOL/FOOL.g:576:7: ( '}' )
			// /home/acco/workspace/FOOL/FOOL.g:576:9: '}'
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
			// /home/acco/workspace/FOOL/FOOL.g:577:5: ( 'if' )
			// /home/acco/workspace/FOOL/FOOL.g:577:7: 'if'
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
			// /home/acco/workspace/FOOL/FOOL.g:578:7: ( 'then' )
			// /home/acco/workspace/FOOL/FOOL.g:578:9: 'then'
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
			// /home/acco/workspace/FOOL/FOOL.g:579:7: ( 'else' )
			// /home/acco/workspace/FOOL/FOOL.g:579:9: 'else'
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
			// /home/acco/workspace/FOOL/FOOL.g:580:7: ( 'print' )
			// /home/acco/workspace/FOOL/FOOL.g:580:9: 'print'
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
			// /home/acco/workspace/FOOL/FOOL.g:581:5: ( 'fun' )
			// /home/acco/workspace/FOOL/FOOL.g:581:7: 'fun'
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

	// $ANTLR start "CLASS"
	public final void mCLASS() throws RecognitionException {
		try {
			int _type = CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:582:7: ( 'class' )
			// /home/acco/workspace/FOOL/FOOL.g:582:9: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLASS"

	// $ANTLR start "EXTENDS"
	public final void mEXTENDS() throws RecognitionException {
		try {
			int _type = EXTENDS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:583:9: ( 'extends' )
			// /home/acco/workspace/FOOL/FOOL.g:583:11: 'extends'
			{
			match("extends"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTENDS"

	// $ANTLR start "NEW"
	public final void mNEW() throws RecognitionException {
		try {
			int _type = NEW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:584:7: ( 'new' )
			// /home/acco/workspace/FOOL/FOOL.g:584:9: 'new'
			{
			match("new"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEW"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:585:9: ( 'null' )
			// /home/acco/workspace/FOOL/FOOL.g:585:11: 'null'
			{
			match("null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "LET"
	public final void mLET() throws RecognitionException {
		try {
			int _type = LET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:586:9: ( 'let' )
			// /home/acco/workspace/FOOL/FOOL.g:586:11: 'let'
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
			// /home/acco/workspace/FOOL/FOOL.g:587:9: ( 'in' )
			// /home/acco/workspace/FOOL/FOOL.g:587:11: 'in'
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
			// /home/acco/workspace/FOOL/FOOL.g:588:9: ( 'var' )
			// /home/acco/workspace/FOOL/FOOL.g:588:11: 'var'
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
			// /home/acco/workspace/FOOL/FOOL.g:589:9: ( ':' )
			// /home/acco/workspace/FOOL/FOOL.g:589:11: ':'
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
			// /home/acco/workspace/FOOL/FOOL.g:590:7: ( ',' )
			// /home/acco/workspace/FOOL/FOOL.g:590:9: ','
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

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:591:5: ( '.' )
			// /home/acco/workspace/FOOL/FOOL.g:591:7: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "ASS"
	public final void mASS() throws RecognitionException {
		try {
			int _type = ASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/FOOL.g:592:5: ( '=' )
			// /home/acco/workspace/FOOL/FOOL.g:592:7: '='
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
			// /home/acco/workspace/FOOL/FOOL.g:593:5: ( 'int' )
			// /home/acco/workspace/FOOL/FOOL.g:593:7: 'int'
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
			// /home/acco/workspace/FOOL/FOOL.g:595:9: ( '->' )
			// /home/acco/workspace/FOOL/FOOL.g:595:11: '->'
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
			// /home/acco/workspace/FOOL/FOOL.g:597:7: ( 'bool' )
			// /home/acco/workspace/FOOL/FOOL.g:597:9: 'bool'
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
			// /home/acco/workspace/FOOL/FOOL.g:599:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// /home/acco/workspace/FOOL/FOOL.g:599:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/acco/workspace/FOOL/FOOL.g:599:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
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
			// /home/acco/workspace/FOOL/FOOL.g:603:9: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// /home/acco/workspace/FOOL/FOOL.g:603:11: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// /home/acco/workspace/FOOL/FOOL.g:603:11: ( ' ' | '\\t' | '\\n' | '\\r' )+
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
			// /home/acco/workspace/FOOL/FOOL.g:606:9: ( '/*' ( . )* '*/' )
			// /home/acco/workspace/FOOL/FOOL.g:606:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /home/acco/workspace/FOOL/FOOL.g:606:16: ( . )*
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
					// /home/acco/workspace/FOOL/FOOL.g:606:16: .
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
			// /home/acco/workspace/FOOL/FOOL.g:608:5: ( . )
			// /home/acco/workspace/FOOL/FOOL.g:608:7: .
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
		// /home/acco/workspace/FOOL/FOOL.g:1:8: ( DEBUG | PLUS | TIMES | MINUS | DIV | SEMIC | OR | AND | NOT | GR | LE | EQ | NAT | TRUE | FALSE | LPAR | RPAR | CLPAR | CRPAR | IF | THEN | ELSE | PRINT | FUN | CLASS | EXTENDS | NEW | NULL | LET | IN | VAR | COLON | COMMA | DOT | ASS | INT | ARROW | BOOL | ID | WHITESP | COMMENT | ERR )
		int alt6=42;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// /home/acco/workspace/FOOL/FOOL.g:1:10: DEBUG
				{
				mDEBUG(); 

				}
				break;
			case 2 :
				// /home/acco/workspace/FOOL/FOOL.g:1:16: PLUS
				{
				mPLUS(); 

				}
				break;
			case 3 :
				// /home/acco/workspace/FOOL/FOOL.g:1:21: TIMES
				{
				mTIMES(); 

				}
				break;
			case 4 :
				// /home/acco/workspace/FOOL/FOOL.g:1:27: MINUS
				{
				mMINUS(); 

				}
				break;
			case 5 :
				// /home/acco/workspace/FOOL/FOOL.g:1:33: DIV
				{
				mDIV(); 

				}
				break;
			case 6 :
				// /home/acco/workspace/FOOL/FOOL.g:1:37: SEMIC
				{
				mSEMIC(); 

				}
				break;
			case 7 :
				// /home/acco/workspace/FOOL/FOOL.g:1:43: OR
				{
				mOR(); 

				}
				break;
			case 8 :
				// /home/acco/workspace/FOOL/FOOL.g:1:46: AND
				{
				mAND(); 

				}
				break;
			case 9 :
				// /home/acco/workspace/FOOL/FOOL.g:1:50: NOT
				{
				mNOT(); 

				}
				break;
			case 10 :
				// /home/acco/workspace/FOOL/FOOL.g:1:54: GR
				{
				mGR(); 

				}
				break;
			case 11 :
				// /home/acco/workspace/FOOL/FOOL.g:1:57: LE
				{
				mLE(); 

				}
				break;
			case 12 :
				// /home/acco/workspace/FOOL/FOOL.g:1:60: EQ
				{
				mEQ(); 

				}
				break;
			case 13 :
				// /home/acco/workspace/FOOL/FOOL.g:1:63: NAT
				{
				mNAT(); 

				}
				break;
			case 14 :
				// /home/acco/workspace/FOOL/FOOL.g:1:67: TRUE
				{
				mTRUE(); 

				}
				break;
			case 15 :
				// /home/acco/workspace/FOOL/FOOL.g:1:72: FALSE
				{
				mFALSE(); 

				}
				break;
			case 16 :
				// /home/acco/workspace/FOOL/FOOL.g:1:78: LPAR
				{
				mLPAR(); 

				}
				break;
			case 17 :
				// /home/acco/workspace/FOOL/FOOL.g:1:83: RPAR
				{
				mRPAR(); 

				}
				break;
			case 18 :
				// /home/acco/workspace/FOOL/FOOL.g:1:88: CLPAR
				{
				mCLPAR(); 

				}
				break;
			case 19 :
				// /home/acco/workspace/FOOL/FOOL.g:1:94: CRPAR
				{
				mCRPAR(); 

				}
				break;
			case 20 :
				// /home/acco/workspace/FOOL/FOOL.g:1:100: IF
				{
				mIF(); 

				}
				break;
			case 21 :
				// /home/acco/workspace/FOOL/FOOL.g:1:103: THEN
				{
				mTHEN(); 

				}
				break;
			case 22 :
				// /home/acco/workspace/FOOL/FOOL.g:1:108: ELSE
				{
				mELSE(); 

				}
				break;
			case 23 :
				// /home/acco/workspace/FOOL/FOOL.g:1:113: PRINT
				{
				mPRINT(); 

				}
				break;
			case 24 :
				// /home/acco/workspace/FOOL/FOOL.g:1:119: FUN
				{
				mFUN(); 

				}
				break;
			case 25 :
				// /home/acco/workspace/FOOL/FOOL.g:1:123: CLASS
				{
				mCLASS(); 

				}
				break;
			case 26 :
				// /home/acco/workspace/FOOL/FOOL.g:1:129: EXTENDS
				{
				mEXTENDS(); 

				}
				break;
			case 27 :
				// /home/acco/workspace/FOOL/FOOL.g:1:137: NEW
				{
				mNEW(); 

				}
				break;
			case 28 :
				// /home/acco/workspace/FOOL/FOOL.g:1:141: NULL
				{
				mNULL(); 

				}
				break;
			case 29 :
				// /home/acco/workspace/FOOL/FOOL.g:1:146: LET
				{
				mLET(); 

				}
				break;
			case 30 :
				// /home/acco/workspace/FOOL/FOOL.g:1:150: IN
				{
				mIN(); 

				}
				break;
			case 31 :
				// /home/acco/workspace/FOOL/FOOL.g:1:153: VAR
				{
				mVAR(); 

				}
				break;
			case 32 :
				// /home/acco/workspace/FOOL/FOOL.g:1:157: COLON
				{
				mCOLON(); 

				}
				break;
			case 33 :
				// /home/acco/workspace/FOOL/FOOL.g:1:163: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 34 :
				// /home/acco/workspace/FOOL/FOOL.g:1:169: DOT
				{
				mDOT(); 

				}
				break;
			case 35 :
				// /home/acco/workspace/FOOL/FOOL.g:1:173: ASS
				{
				mASS(); 

				}
				break;
			case 36 :
				// /home/acco/workspace/FOOL/FOOL.g:1:177: INT
				{
				mINT(); 

				}
				break;
			case 37 :
				// /home/acco/workspace/FOOL/FOOL.g:1:181: ARROW
				{
				mARROW(); 

				}
				break;
			case 38 :
				// /home/acco/workspace/FOOL/FOOL.g:1:187: BOOL
				{
				mBOOL(); 

				}
				break;
			case 39 :
				// /home/acco/workspace/FOOL/FOOL.g:1:192: ID
				{
				mID(); 

				}
				break;
			case 40 :
				// /home/acco/workspace/FOOL/FOOL.g:1:195: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 41 :
				// /home/acco/workspace/FOOL/FOOL.g:1:203: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 42 :
				// /home/acco/workspace/FOOL/FOOL.g:1:211: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\1\uffff\1\43\2\uffff\1\47\1\51\1\uffff\2\41\1\43\2\41\1\63\2\uffff\2"+
		"\43\4\uffff\6\43\3\uffff\1\43\3\uffff\1\43\12\uffff\3\43\5\uffff\4\43"+
		"\4\uffff\1\122\1\124\6\43\3\uffff\1\43\1\uffff\1\43\1\135\1\136\4\43\1"+
		"\143\1\uffff\1\144\1\uffff\4\43\1\151\1\152\2\43\2\uffff\1\155\1\156\1"+
		"\157\1\43\2\uffff\1\161\3\43\2\uffff\1\165\1\166\3\uffff\1\167\1\uffff"+
		"\1\43\1\171\1\172\3\uffff\1\43\2\uffff\1\174\1\uffff";
	static final String DFA6_eofS =
		"\175\uffff";
	static final String DFA6_minS =
		"\1\0\1\145\2\uffff\1\76\1\52\1\uffff\1\174\1\46\1\145\3\75\2\uffff\1\150"+
		"\1\141\4\uffff\1\146\1\154\1\162\1\154\1\145\1\141\3\uffff\1\157\3\uffff"+
		"\1\142\12\uffff\1\164\1\167\1\154\5\uffff\1\165\1\145\1\154\1\156\4\uffff"+
		"\2\60\1\163\1\164\1\151\1\141\1\164\1\162\3\uffff\1\157\1\uffff\1\165"+
		"\2\60\1\154\1\145\1\156\1\163\1\60\1\uffff\1\60\1\uffff\2\145\1\156\1"+
		"\163\2\60\1\154\1\147\2\uffff\3\60\1\145\2\uffff\1\60\1\156\1\164\1\163"+
		"\2\uffff\2\60\3\uffff\1\60\1\uffff\1\144\2\60\3\uffff\1\163\2\uffff\1"+
		"\60\1\uffff";
	static final String DFA6_maxS =
		"\1\uffff\1\145\2\uffff\1\76\1\52\1\uffff\1\174\1\46\1\165\3\75\2\uffff"+
		"\1\162\1\165\4\uffff\1\156\1\170\1\162\1\154\1\145\1\141\3\uffff\1\157"+
		"\3\uffff\1\142\12\uffff\1\164\1\167\1\154\5\uffff\1\165\1\145\1\154\1"+
		"\156\4\uffff\2\172\1\163\1\164\1\151\1\141\1\164\1\162\3\uffff\1\157\1"+
		"\uffff\1\165\2\172\1\154\1\145\1\156\1\163\1\172\1\uffff\1\172\1\uffff"+
		"\2\145\1\156\1\163\2\172\1\154\1\147\2\uffff\3\172\1\145\2\uffff\1\172"+
		"\1\156\1\164\1\163\2\uffff\2\172\3\uffff\1\172\1\uffff\1\144\2\172\3\uffff"+
		"\1\163\2\uffff\1\172\1\uffff";
	static final String DFA6_acceptS =
		"\2\uffff\1\2\1\3\2\uffff\1\6\6\uffff\2\15\2\uffff\1\20\1\21\1\22\1\23"+
		"\6\uffff\1\40\1\41\1\42\1\uffff\1\47\1\50\1\52\1\uffff\1\47\1\2\1\3\1"+
		"\45\1\4\1\51\1\5\1\6\1\7\1\10\3\uffff\1\12\1\13\1\14\1\43\1\15\4\uffff"+
		"\1\20\1\21\1\22\1\23\10\uffff\1\40\1\41\1\42\1\uffff\1\50\10\uffff\1\24"+
		"\1\uffff\1\36\10\uffff\1\11\1\33\4\uffff\1\30\1\44\4\uffff\1\35\1\37\2"+
		"\uffff\1\34\1\16\1\25\1\uffff\1\26\3\uffff\1\46\1\1\1\17\1\uffff\1\27"+
		"\1\31\1\uffff\1\32";
	static final String DFA6_specialS =
		"\1\0\174\uffff}>";
	static final String[] DFA6_transitionS = {
			"\11\41\2\40\2\41\1\40\22\41\1\40\5\41\1\10\1\41\1\21\1\22\1\3\1\2\1\34"+
			"\1\4\1\35\1\5\1\16\11\15\1\33\1\6\1\13\1\14\1\12\2\41\32\37\6\41\1\37"+
			"\1\36\1\30\1\1\1\26\1\20\2\37\1\25\2\37\1\31\1\37\1\11\1\37\1\27\3\37"+
			"\1\17\1\37\1\32\4\37\1\23\1\7\1\24\uff82\41",
			"\1\42",
			"",
			"",
			"\1\46",
			"\1\50",
			"",
			"\1\53",
			"\1\54",
			"\1\56\11\uffff\1\55\5\uffff\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"",
			"",
			"\1\66\11\uffff\1\65",
			"\1\67\23\uffff\1\70",
			"",
			"",
			"",
			"",
			"\1\75\7\uffff\1\76",
			"\1\77\13\uffff\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"",
			"",
			"",
			"\1\110",
			"",
			"",
			"",
			"\1\112",
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
			"\1\113",
			"\1\114",
			"\1\115",
			"",
			"",
			"",
			"",
			"",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"",
			"",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\23\43\1\123\6\43",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"",
			"",
			"",
			"\1\133",
			"",
			"\1\134",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\1\153",
			"\1\154",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\1\160",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\1\162",
			"\1\163",
			"\1\164",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"\1\170",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"",
			"",
			"\1\173",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
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
			return "1:1: Tokens : ( DEBUG | PLUS | TIMES | MINUS | DIV | SEMIC | OR | AND | NOT | GR | LE | EQ | NAT | TRUE | FALSE | LPAR | RPAR | CLPAR | CRPAR | IF | THEN | ELSE | PRINT | FUN | CLASS | EXTENDS | NEW | NULL | LET | IN | VAR | COLON | COMMA | DOT | ASS | INT | ARROW | BOOL | ID | WHITESP | COMMENT | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA6_0 = input.LA(1);
						s = -1;
						if ( (LA6_0=='d') ) {s = 1;}
						else if ( (LA6_0=='+') ) {s = 2;}
						else if ( (LA6_0=='*') ) {s = 3;}
						else if ( (LA6_0=='-') ) {s = 4;}
						else if ( (LA6_0=='/') ) {s = 5;}
						else if ( (LA6_0==';') ) {s = 6;}
						else if ( (LA6_0=='|') ) {s = 7;}
						else if ( (LA6_0=='&') ) {s = 8;}
						else if ( (LA6_0=='n') ) {s = 9;}
						else if ( (LA6_0=='>') ) {s = 10;}
						else if ( (LA6_0=='<') ) {s = 11;}
						else if ( (LA6_0=='=') ) {s = 12;}
						else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {s = 13;}
						else if ( (LA6_0=='0') ) {s = 14;}
						else if ( (LA6_0=='t') ) {s = 15;}
						else if ( (LA6_0=='f') ) {s = 16;}
						else if ( (LA6_0=='(') ) {s = 17;}
						else if ( (LA6_0==')') ) {s = 18;}
						else if ( (LA6_0=='{') ) {s = 19;}
						else if ( (LA6_0=='}') ) {s = 20;}
						else if ( (LA6_0=='i') ) {s = 21;}
						else if ( (LA6_0=='e') ) {s = 22;}
						else if ( (LA6_0=='p') ) {s = 23;}
						else if ( (LA6_0=='c') ) {s = 24;}
						else if ( (LA6_0=='l') ) {s = 25;}
						else if ( (LA6_0=='v') ) {s = 26;}
						else if ( (LA6_0==':') ) {s = 27;}
						else if ( (LA6_0==',') ) {s = 28;}
						else if ( (LA6_0=='.') ) {s = 29;}
						else if ( (LA6_0=='b') ) {s = 30;}
						else if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='a'||(LA6_0 >= 'g' && LA6_0 <= 'h')||(LA6_0 >= 'j' && LA6_0 <= 'k')||LA6_0=='m'||LA6_0=='o'||(LA6_0 >= 'q' && LA6_0 <= 's')||LA6_0=='u'||(LA6_0 >= 'w' && LA6_0 <= 'z')) ) {s = 31;}
						else if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 32;}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\b')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\u001F')||(LA6_0 >= '!' && LA6_0 <= '%')||LA6_0=='\''||(LA6_0 >= '?' && LA6_0 <= '@')||(LA6_0 >= '[' && LA6_0 <= '`')||(LA6_0 >= '~' && LA6_0 <= '\uFFFF')) ) {s = 33;}
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
