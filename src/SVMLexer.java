// $ANTLR 3.5.2 /home/acco/workspace/FOOL/SVM.g 2015-12-24 14:14:57

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SVMLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int BRANCH=5;
	public static final int BRANCHEQ=6;
	public static final int BRANCHLESS=7;
	public static final int COL=8;
	public static final int COMMENT=9;
	public static final int COPYFP=10;
	public static final int DIV=11;
	public static final int ERR=12;
	public static final int HALT=13;
	public static final int JS=14;
	public static final int LABEL=15;
	public static final int LOADFP=16;
	public static final int LOADHP=17;
	public static final int LOADRA=18;
	public static final int LOADRV=19;
	public static final int LOADW=20;
	public static final int MULT=21;
	public static final int NUMBER=22;
	public static final int POP=23;
	public static final int PRINT=24;
	public static final int PUSH=25;
	public static final int STOREFP=26;
	public static final int STOREHP=27;
	public static final int STORERA=28;
	public static final int STORERV=29;
	public static final int STOREW=30;
	public static final int SUB=31;
	public static final int WHITESP=32;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public SVMLexer() {} 
	public SVMLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public SVMLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/acco/workspace/FOOL/SVM.g"; }

	// $ANTLR start "PUSH"
	public final void mPUSH() throws RecognitionException {
		try {
			int _type = PUSH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:80:7: ( 'push' )
			// /home/acco/workspace/FOOL/SVM.g:80:9: 'push'
			{
			match("push"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUSH"

	// $ANTLR start "POP"
	public final void mPOP() throws RecognitionException {
		try {
			int _type = POP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:81:6: ( 'pop' )
			// /home/acco/workspace/FOOL/SVM.g:81:8: 'pop'
			{
			match("pop"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POP"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:82:6: ( 'add' )
			// /home/acco/workspace/FOOL/SVM.g:82:8: 'add'
			{
			match("add"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "SUB"
	public final void mSUB() throws RecognitionException {
		try {
			int _type = SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:83:6: ( 'sub' )
			// /home/acco/workspace/FOOL/SVM.g:83:8: 'sub'
			{
			match("sub"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:84:7: ( 'mult' )
			// /home/acco/workspace/FOOL/SVM.g:84:9: 'mult'
			{
			match("mult"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:85:6: ( 'div' )
			// /home/acco/workspace/FOOL/SVM.g:85:8: 'div'
			{
			match("div"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "STOREW"
	public final void mSTOREW() throws RecognitionException {
		try {
			int _type = STOREW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:86:9: ( 'sw' )
			// /home/acco/workspace/FOOL/SVM.g:86:11: 'sw'
			{
			match("sw"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREW"

	// $ANTLR start "LOADW"
	public final void mLOADW() throws RecognitionException {
		try {
			int _type = LOADW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:87:8: ( 'lw' )
			// /home/acco/workspace/FOOL/SVM.g:87:10: 'lw'
			{
			match("lw"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADW"

	// $ANTLR start "BRANCH"
	public final void mBRANCH() throws RecognitionException {
		try {
			int _type = BRANCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:88:9: ( 'b' )
			// /home/acco/workspace/FOOL/SVM.g:88:11: 'b'
			{
			match('b'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCH"

	// $ANTLR start "BRANCHEQ"
	public final void mBRANCHEQ() throws RecognitionException {
		try {
			int _type = BRANCHEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:89:10: ( 'beq' )
			// /home/acco/workspace/FOOL/SVM.g:89:12: 'beq'
			{
			match("beq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCHEQ"

	// $ANTLR start "BRANCHLESS"
	public final void mBRANCHLESS() throws RecognitionException {
		try {
			int _type = BRANCHLESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:90:11: ( 'bless' )
			// /home/acco/workspace/FOOL/SVM.g:90:12: 'bless'
			{
			match("bless"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCHLESS"

	// $ANTLR start "JS"
	public final void mJS() throws RecognitionException {
		try {
			int _type = JS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:91:5: ( 'js' )
			// /home/acco/workspace/FOOL/SVM.g:91:7: 'js'
			{
			match("js"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JS"

	// $ANTLR start "LOADRA"
	public final void mLOADRA() throws RecognitionException {
		try {
			int _type = LOADRA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:92:9: ( 'lra' )
			// /home/acco/workspace/FOOL/SVM.g:92:11: 'lra'
			{
			match("lra"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADRA"

	// $ANTLR start "STORERA"
	public final void mSTORERA() throws RecognitionException {
		try {
			int _type = STORERA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:93:10: ( 'sra' )
			// /home/acco/workspace/FOOL/SVM.g:93:12: 'sra'
			{
			match("sra"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STORERA"

	// $ANTLR start "LOADRV"
	public final void mLOADRV() throws RecognitionException {
		try {
			int _type = LOADRV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:94:9: ( 'lrv' )
			// /home/acco/workspace/FOOL/SVM.g:94:11: 'lrv'
			{
			match("lrv"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADRV"

	// $ANTLR start "STORERV"
	public final void mSTORERV() throws RecognitionException {
		try {
			int _type = STORERV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:95:10: ( 'srv' )
			// /home/acco/workspace/FOOL/SVM.g:95:12: 'srv'
			{
			match("srv"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STORERV"

	// $ANTLR start "LOADFP"
	public final void mLOADFP() throws RecognitionException {
		try {
			int _type = LOADFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:96:9: ( 'lfp' )
			// /home/acco/workspace/FOOL/SVM.g:96:11: 'lfp'
			{
			match("lfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADFP"

	// $ANTLR start "STOREFP"
	public final void mSTOREFP() throws RecognitionException {
		try {
			int _type = STOREFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:97:10: ( 'sfp' )
			// /home/acco/workspace/FOOL/SVM.g:97:12: 'sfp'
			{
			match("sfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREFP"

	// $ANTLR start "COPYFP"
	public final void mCOPYFP() throws RecognitionException {
		try {
			int _type = COPYFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:98:10: ( 'cfp' )
			// /home/acco/workspace/FOOL/SVM.g:98:12: 'cfp'
			{
			match("cfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COPYFP"

	// $ANTLR start "LOADHP"
	public final void mLOADHP() throws RecognitionException {
		try {
			int _type = LOADHP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:99:9: ( 'lhp' )
			// /home/acco/workspace/FOOL/SVM.g:99:11: 'lhp'
			{
			match("lhp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADHP"

	// $ANTLR start "STOREHP"
	public final void mSTOREHP() throws RecognitionException {
		try {
			int _type = STOREHP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:100:10: ( 'shp' )
			// /home/acco/workspace/FOOL/SVM.g:100:12: 'shp'
			{
			match("shp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREHP"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:101:8: ( 'print' )
			// /home/acco/workspace/FOOL/SVM.g:101:10: 'print'
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

	// $ANTLR start "HALT"
	public final void mHALT() throws RecognitionException {
		try {
			int _type = HALT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:102:7: ( 'halt' )
			// /home/acco/workspace/FOOL/SVM.g:102:9: 'halt'
			{
			match("halt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HALT"

	// $ANTLR start "COL"
	public final void mCOL() throws RecognitionException {
		try {
			int _type = COL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:104:6: ( ':' )
			// /home/acco/workspace/FOOL/SVM.g:104:8: ':'
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
	// $ANTLR end "COL"

	// $ANTLR start "LABEL"
	public final void mLABEL() throws RecognitionException {
		try {
			int _type = LABEL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:105:8: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// /home/acco/workspace/FOOL/SVM.g:105:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/acco/workspace/FOOL/SVM.g:105:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/acco/workspace/FOOL/SVM.g:
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
					break loop1;
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
	// $ANTLR end "LABEL"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:106:9: ( '0' | ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='0') ) {
				alt4=1;
			}
			else if ( (LA4_0=='-'||(LA4_0 >= '1' && LA4_0 <= '9')) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/acco/workspace/FOOL/SVM.g:106:11: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/SVM.g:106:17: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// /home/acco/workspace/FOOL/SVM.g:106:17: ( '-' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0=='-') ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// /home/acco/workspace/FOOL/SVM.g:106:18: '-'
							{
							match('-'); 
							}
							break;

					}

					// /home/acco/workspace/FOOL/SVM.g:106:23: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// /home/acco/workspace/FOOL/SVM.g:106:24: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// /home/acco/workspace/FOOL/SVM.g:106:34: ( '0' .. '9' )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /home/acco/workspace/FOOL/SVM.g:
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
							break loop3;
						}
					}

					}

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
	// $ANTLR end "NUMBER"

	// $ANTLR start "WHITESP"
	public final void mWHITESP() throws RecognitionException {
		try {
			int _type = WHITESP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/acco/workspace/FOOL/SVM.g:108:10: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// /home/acco/workspace/FOOL/SVM.g:108:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// /home/acco/workspace/FOOL/SVM.g:108:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /home/acco/workspace/FOOL/SVM.g:
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
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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
			// /home/acco/workspace/FOOL/SVM.g:109:9: ( '#' ( . )* '\\n' )
			// /home/acco/workspace/FOOL/SVM.g:109:11: '#' ( . )* '\\n'
			{
			match('#'); 
			// /home/acco/workspace/FOOL/SVM.g:109:15: ( . )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\n') ) {
					alt6=2;
				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/acco/workspace/FOOL/SVM.g:109:15: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop6;
				}
			}

			match('\n'); 
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
			// /home/acco/workspace/FOOL/SVM.g:110:9: ( . )
			// /home/acco/workspace/FOOL/SVM.g:110:11: .
			{
			matchAny(); 
			 System.err.println("Invalid char: "+getText()); _channel=HIDDEN; 
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
		// /home/acco/workspace/FOOL/SVM.g:1:8: ( PUSH | POP | ADD | SUB | MULT | DIV | STOREW | LOADW | BRANCH | BRANCHEQ | BRANCHLESS | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT | COL | LABEL | NUMBER | WHITESP | COMMENT | ERR )
		int alt7=29;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// /home/acco/workspace/FOOL/SVM.g:1:10: PUSH
				{
				mPUSH(); 

				}
				break;
			case 2 :
				// /home/acco/workspace/FOOL/SVM.g:1:15: POP
				{
				mPOP(); 

				}
				break;
			case 3 :
				// /home/acco/workspace/FOOL/SVM.g:1:19: ADD
				{
				mADD(); 

				}
				break;
			case 4 :
				// /home/acco/workspace/FOOL/SVM.g:1:23: SUB
				{
				mSUB(); 

				}
				break;
			case 5 :
				// /home/acco/workspace/FOOL/SVM.g:1:27: MULT
				{
				mMULT(); 

				}
				break;
			case 6 :
				// /home/acco/workspace/FOOL/SVM.g:1:32: DIV
				{
				mDIV(); 

				}
				break;
			case 7 :
				// /home/acco/workspace/FOOL/SVM.g:1:36: STOREW
				{
				mSTOREW(); 

				}
				break;
			case 8 :
				// /home/acco/workspace/FOOL/SVM.g:1:43: LOADW
				{
				mLOADW(); 

				}
				break;
			case 9 :
				// /home/acco/workspace/FOOL/SVM.g:1:49: BRANCH
				{
				mBRANCH(); 

				}
				break;
			case 10 :
				// /home/acco/workspace/FOOL/SVM.g:1:56: BRANCHEQ
				{
				mBRANCHEQ(); 

				}
				break;
			case 11 :
				// /home/acco/workspace/FOOL/SVM.g:1:65: BRANCHLESS
				{
				mBRANCHLESS(); 

				}
				break;
			case 12 :
				// /home/acco/workspace/FOOL/SVM.g:1:76: JS
				{
				mJS(); 

				}
				break;
			case 13 :
				// /home/acco/workspace/FOOL/SVM.g:1:79: LOADRA
				{
				mLOADRA(); 

				}
				break;
			case 14 :
				// /home/acco/workspace/FOOL/SVM.g:1:86: STORERA
				{
				mSTORERA(); 

				}
				break;
			case 15 :
				// /home/acco/workspace/FOOL/SVM.g:1:94: LOADRV
				{
				mLOADRV(); 

				}
				break;
			case 16 :
				// /home/acco/workspace/FOOL/SVM.g:1:101: STORERV
				{
				mSTORERV(); 

				}
				break;
			case 17 :
				// /home/acco/workspace/FOOL/SVM.g:1:109: LOADFP
				{
				mLOADFP(); 

				}
				break;
			case 18 :
				// /home/acco/workspace/FOOL/SVM.g:1:116: STOREFP
				{
				mSTOREFP(); 

				}
				break;
			case 19 :
				// /home/acco/workspace/FOOL/SVM.g:1:124: COPYFP
				{
				mCOPYFP(); 

				}
				break;
			case 20 :
				// /home/acco/workspace/FOOL/SVM.g:1:131: LOADHP
				{
				mLOADHP(); 

				}
				break;
			case 21 :
				// /home/acco/workspace/FOOL/SVM.g:1:138: STOREHP
				{
				mSTOREHP(); 

				}
				break;
			case 22 :
				// /home/acco/workspace/FOOL/SVM.g:1:146: PRINT
				{
				mPRINT(); 

				}
				break;
			case 23 :
				// /home/acco/workspace/FOOL/SVM.g:1:152: HALT
				{
				mHALT(); 

				}
				break;
			case 24 :
				// /home/acco/workspace/FOOL/SVM.g:1:157: COL
				{
				mCOL(); 

				}
				break;
			case 25 :
				// /home/acco/workspace/FOOL/SVM.g:1:161: LABEL
				{
				mLABEL(); 

				}
				break;
			case 26 :
				// /home/acco/workspace/FOOL/SVM.g:1:167: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 27 :
				// /home/acco/workspace/FOOL/SVM.g:1:174: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 28 :
				// /home/acco/workspace/FOOL/SVM.g:1:182: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 29 :
				// /home/acco/workspace/FOOL/SVM.g:1:190: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\1\uffff\6\26\1\45\3\26\3\uffff\1\22\2\uffff\1\22\1\uffff\3\26\1\uffff"+
		"\2\26\1\62\5\26\1\71\5\26\1\uffff\1\100\2\26\4\uffff\1\26\1\104\1\26\1"+
		"\106\1\107\1\uffff\1\110\1\111\1\112\1\113\1\26\1\115\1\uffff\1\116\1"+
		"\117\1\120\1\121\1\122\1\26\1\uffff\1\124\1\26\1\126\1\uffff\1\26\6\uffff"+
		"\1\130\6\uffff\1\26\1\uffff\1\132\1\uffff\1\133\1\uffff\1\134\3\uffff";
	static final String DFA7_eofS =
		"\135\uffff";
	static final String DFA7_minS =
		"\1\0\1\157\1\144\1\146\1\165\1\151\1\146\1\60\1\163\1\146\1\141\3\uffff"+
		"\1\61\2\uffff\1\0\1\uffff\1\163\1\160\1\151\1\uffff\1\144\1\142\1\60\1"+
		"\141\2\160\1\154\1\166\1\60\1\141\2\160\1\161\1\145\1\uffff\1\60\1\160"+
		"\1\154\4\uffff\1\150\1\60\1\156\2\60\1\uffff\4\60\1\164\1\60\1\uffff\5"+
		"\60\1\163\1\uffff\1\60\1\164\1\60\1\uffff\1\164\6\uffff\1\60\6\uffff\1"+
		"\163\1\uffff\1\60\1\uffff\1\60\1\uffff\1\60\3\uffff";
	static final String DFA7_maxS =
		"\1\uffff\1\165\1\144\1\167\1\165\1\151\1\167\1\172\1\163\1\146\1\141\3"+
		"\uffff\1\71\2\uffff\1\uffff\1\uffff\1\163\1\160\1\151\1\uffff\1\144\1"+
		"\142\1\172\1\166\2\160\1\154\1\166\1\172\1\166\2\160\1\161\1\145\1\uffff"+
		"\1\172\1\160\1\154\4\uffff\1\150\1\172\1\156\2\172\1\uffff\4\172\1\164"+
		"\1\172\1\uffff\5\172\1\163\1\uffff\1\172\1\164\1\172\1\uffff\1\164\6\uffff"+
		"\1\172\6\uffff\1\163\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\3\uffff";
	static final String DFA7_acceptS =
		"\13\uffff\1\30\1\31\1\32\1\uffff\1\32\1\33\1\uffff\1\35\3\uffff\1\31\16"+
		"\uffff\1\11\3\uffff\1\30\1\32\1\33\1\34\5\uffff\1\7\6\uffff\1\10\6\uffff"+
		"\1\14\3\uffff\1\2\1\uffff\1\3\1\4\1\16\1\20\1\22\1\25\1\uffff\1\6\1\15"+
		"\1\17\1\21\1\24\1\12\1\uffff\1\23\1\uffff\1\1\1\uffff\1\5\1\uffff\1\27"+
		"\1\26\1\13";
	static final String DFA7_specialS =
		"\1\1\20\uffff\1\0\113\uffff}>";
	static final String[] DFA7_transitionS = {
			"\11\22\2\20\2\22\1\20\22\22\1\20\2\22\1\21\11\22\1\16\2\22\1\15\11\17"+
			"\1\13\6\22\32\14\6\22\1\2\1\7\1\11\1\5\3\14\1\12\1\14\1\10\1\14\1\6\1"+
			"\4\2\14\1\1\2\14\1\3\7\14\uff85\22",
			"\1\24\2\uffff\1\25\2\uffff\1\23",
			"\1\27",
			"\1\33\1\uffff\1\34\11\uffff\1\32\2\uffff\1\30\1\uffff\1\31",
			"\1\35",
			"\1\36",
			"\1\41\1\uffff\1\42\11\uffff\1\40\4\uffff\1\37",
			"\12\26\7\uffff\32\26\6\uffff\4\26\1\43\6\26\1\44\16\26",
			"\1\46",
			"\1\47",
			"\1\50",
			"",
			"",
			"",
			"\11\52",
			"",
			"",
			"\0\54",
			"",
			"\1\55",
			"\1\56",
			"\1\57",
			"",
			"\1\60",
			"\1\61",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\1\63\24\uffff\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\1\72\24\uffff\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\1\101",
			"\1\102",
			"",
			"",
			"",
			"",
			"\1\103",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\1\105",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\1\114",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\1\123",
			"",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"\1\125",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"",
			"\1\127",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\131",
			"",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"",
			"\12\26\7\uffff\32\26\6\uffff\32\26",
			"",
			"",
			""
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( PUSH | POP | ADD | SUB | MULT | DIV | STOREW | LOADW | BRANCH | BRANCHEQ | BRANCHLESS | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT | COL | LABEL | NUMBER | WHITESP | COMMENT | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA7_17 = input.LA(1);
						s = -1;
						if ( ((LA7_17 >= '\u0000' && LA7_17 <= '\uFFFF')) ) {s = 44;}
						else s = 18;
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA7_0 = input.LA(1);
						s = -1;
						if ( (LA7_0=='p') ) {s = 1;}
						else if ( (LA7_0=='a') ) {s = 2;}
						else if ( (LA7_0=='s') ) {s = 3;}
						else if ( (LA7_0=='m') ) {s = 4;}
						else if ( (LA7_0=='d') ) {s = 5;}
						else if ( (LA7_0=='l') ) {s = 6;}
						else if ( (LA7_0=='b') ) {s = 7;}
						else if ( (LA7_0=='j') ) {s = 8;}
						else if ( (LA7_0=='c') ) {s = 9;}
						else if ( (LA7_0=='h') ) {s = 10;}
						else if ( (LA7_0==':') ) {s = 11;}
						else if ( ((LA7_0 >= 'A' && LA7_0 <= 'Z')||(LA7_0 >= 'e' && LA7_0 <= 'g')||LA7_0=='i'||LA7_0=='k'||(LA7_0 >= 'n' && LA7_0 <= 'o')||(LA7_0 >= 'q' && LA7_0 <= 'r')||(LA7_0 >= 't' && LA7_0 <= 'z')) ) {s = 12;}
						else if ( (LA7_0=='0') ) {s = 13;}
						else if ( (LA7_0=='-') ) {s = 14;}
						else if ( ((LA7_0 >= '1' && LA7_0 <= '9')) ) {s = 15;}
						else if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {s = 16;}
						else if ( (LA7_0=='#') ) {s = 17;}
						else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\b')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '\u001F')||(LA7_0 >= '!' && LA7_0 <= '\"')||(LA7_0 >= '$' && LA7_0 <= ',')||(LA7_0 >= '.' && LA7_0 <= '/')||(LA7_0 >= ';' && LA7_0 <= '@')||(LA7_0 >= '[' && LA7_0 <= '`')||(LA7_0 >= '{' && LA7_0 <= '\uFFFF')) ) {s = 18;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 7, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
