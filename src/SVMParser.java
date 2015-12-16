// $ANTLR 3.5.2 /home/acco/workspace/FOOL/SVM.g 2015-12-11 15:26:48

  import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SVMParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "BRANCH", "BRANCHEQ", "BRANCHLESS", 
		"COL", "COPYFP", "DIV", "ERR", "HALT", "JS", "LABEL", "LOADFP", "LOADHP", 
		"LOADRA", "LOADRV", "LOADW", "MULT", "NUMBER", "POP", "PRINT", "PUSH", 
		"STOREFP", "STOREHP", "STORERA", "STORERV", "STOREW", "SUB", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int BRANCH=5;
	public static final int BRANCHEQ=6;
	public static final int BRANCHLESS=7;
	public static final int COL=8;
	public static final int COPYFP=9;
	public static final int DIV=10;
	public static final int ERR=11;
	public static final int HALT=12;
	public static final int JS=13;
	public static final int LABEL=14;
	public static final int LOADFP=15;
	public static final int LOADHP=16;
	public static final int LOADRA=17;
	public static final int LOADRV=18;
	public static final int LOADW=19;
	public static final int MULT=20;
	public static final int NUMBER=21;
	public static final int POP=22;
	public static final int PRINT=23;
	public static final int PUSH=24;
	public static final int STOREFP=25;
	public static final int STOREHP=26;
	public static final int STORERA=27;
	public static final int STORERV=28;
	public static final int STOREW=29;
	public static final int SUB=30;
	public static final int WHITESP=31;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SVMParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SVMParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SVMParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/acco/workspace/FOOL/SVM.g"; }


	  
	  // spazio di memoria per metterci il codice, non può essere privato perchè poi va passato alla virtual machine
	  int[] code = new int[ExecuteVM.CODESIZE];
	  //contatore, per riempire l'array col codice
	  private int i = 0;
	  
	  // per le etichette
	  // HashMap da etichette a posti dove occorrono nel asm, la aggiorniamo ad ogni dichiarazione di etichetta LABEL COL
	  private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
	  
	  // per i riferimenti ad etichetti (che sono nelle istruzioni di salto)
	  private HashMap<Integer, String> labelRef = new HashMap<Integer, String>();
	  



	// $ANTLR start "assembly"
	// /home/acco/workspace/FOOL/SVM.g:28:1: assembly : ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESS l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* ;
	public final void assembly() throws RecognitionException {
		Token n=null;
		Token l=null;

		try {
			// /home/acco/workspace/FOOL/SVM.g:28:9: ( ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESS l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* )
			// /home/acco/workspace/FOOL/SVM.g:28:11: ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESS l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			{
			// /home/acco/workspace/FOOL/SVM.g:28:11: ( PUSH n= NUMBER | PUSH l= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |l= LABEL COL | BRANCH l= LABEL | BRANCHEQ l= LABEL | BRANCHLESS l= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			loop1:
			while (true) {
				int alt1=26;
				switch ( input.LA(1) ) {
				case PUSH:
					{
					int LA1_2 = input.LA(2);
					if ( (LA1_2==NUMBER) ) {
						alt1=1;
					}
					else if ( (LA1_2==LABEL) ) {
						alt1=2;
					}

					}
					break;
				case POP:
					{
					alt1=3;
					}
					break;
				case ADD:
					{
					alt1=4;
					}
					break;
				case SUB:
					{
					alt1=5;
					}
					break;
				case MULT:
					{
					alt1=6;
					}
					break;
				case DIV:
					{
					alt1=7;
					}
					break;
				case STOREW:
					{
					alt1=8;
					}
					break;
				case LOADW:
					{
					alt1=9;
					}
					break;
				case LABEL:
					{
					alt1=10;
					}
					break;
				case BRANCH:
					{
					alt1=11;
					}
					break;
				case BRANCHEQ:
					{
					alt1=12;
					}
					break;
				case BRANCHLESS:
					{
					alt1=13;
					}
					break;
				case JS:
					{
					alt1=14;
					}
					break;
				case LOADRA:
					{
					alt1=15;
					}
					break;
				case STORERA:
					{
					alt1=16;
					}
					break;
				case LOADRV:
					{
					alt1=17;
					}
					break;
				case STORERV:
					{
					alt1=18;
					}
					break;
				case LOADFP:
					{
					alt1=19;
					}
					break;
				case STOREFP:
					{
					alt1=20;
					}
					break;
				case COPYFP:
					{
					alt1=21;
					}
					break;
				case LOADHP:
					{
					alt1=22;
					}
					break;
				case STOREHP:
					{
					alt1=23;
					}
					break;
				case PRINT:
					{
					alt1=24;
					}
					break;
				case HALT:
					{
					alt1=25;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// /home/acco/workspace/FOOL/SVM.g:30:7: PUSH n= NUMBER
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly38); 
					n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_assembly42); 
					code[i++] = PUSH; code[i++]=Integer.parseInt((n!=null?n.getText():null));
					}
					break;
				case 2 :
					// /home/acco/workspace/FOOL/SVM.g:31:6: PUSH l= LABEL
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly51); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly55); 
					code[i++] = PUSH; labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 3 :
					// /home/acco/workspace/FOOL/SVM.g:32:6: POP
					{
					match(input,POP,FOLLOW_POP_in_assembly66); 
					code[i++]=POP;
					}
					break;
				case 4 :
					// /home/acco/workspace/FOOL/SVM.g:33:6: ADD
					{
					match(input,ADD,FOLLOW_ADD_in_assembly76); 
					code[i++]=ADD;
					}
					break;
				case 5 :
					// /home/acco/workspace/FOOL/SVM.g:34:6: SUB
					{
					match(input,SUB,FOLLOW_SUB_in_assembly86); 
					code[i++]=SUB;
					}
					break;
				case 6 :
					// /home/acco/workspace/FOOL/SVM.g:35:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_assembly96); 
					code[i++]=MULT;
					}
					break;
				case 7 :
					// /home/acco/workspace/FOOL/SVM.g:36:6: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_assembly106); 
					code[i++]=DIV;
					}
					break;
				case 8 :
					// /home/acco/workspace/FOOL/SVM.g:37:6: STOREW
					{
					match(input,STOREW,FOLLOW_STOREW_in_assembly118); 
					code[i++]=STOREW;
					}
					break;
				case 9 :
					// /home/acco/workspace/FOOL/SVM.g:39:6: LOADW
					{
					match(input,LOADW,FOLLOW_LOADW_in_assembly133); 
					code[i++]=LOADW;
					}
					break;
				case 10 :
					// /home/acco/workspace/FOOL/SVM.g:41:6: l= LABEL COL
					{
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly168); 
					match(input,COL,FOLLOW_COL_in_assembly170); 
					labelAdd.put((l!=null?l.getText():null),i);
					}
					break;
				case 11 :
					// /home/acco/workspace/FOOL/SVM.g:42:6: BRANCH l= LABEL
					{
					match(input,BRANCH,FOLLOW_BRANCH_in_assembly212); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly216); 
					code[i++]=BRANCH; labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 12 :
					// /home/acco/workspace/FOOL/SVM.g:43:6: BRANCHEQ l= LABEL
					{
					match(input,BRANCHEQ,FOLLOW_BRANCHEQ_in_assembly240); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly244); 
					code[i++]=BRANCHEQ; labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 13 :
					// /home/acco/workspace/FOOL/SVM.g:44:6: BRANCHLESS l= LABEL
					{
					match(input,BRANCHLESS,FOLLOW_BRANCHLESS_in_assembly260); 
					l=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly264); 
					code[i++]=BRANCHLESS; labelRef.put(i++,(l!=null?l.getText():null));
					}
					break;
				case 14 :
					// /home/acco/workspace/FOOL/SVM.g:45:6: JS
					{
					match(input,JS,FOLLOW_JS_in_assembly276); 
					code[i++]=JS;
					}
					break;
				case 15 :
					// /home/acco/workspace/FOOL/SVM.g:47:6: LOADRA
					{
					match(input,LOADRA,FOLLOW_LOADRA_in_assembly430); 
					code[i++]=LOADRA;
					}
					break;
				case 16 :
					// /home/acco/workspace/FOOL/SVM.g:48:6: STORERA
					{
					match(input,STORERA,FOLLOW_STORERA_in_assembly444); 
					code[i++]=STORERA;
					}
					break;
				case 17 :
					// /home/acco/workspace/FOOL/SVM.g:49:6: LOADRV
					{
					match(input,LOADRV,FOLLOW_LOADRV_in_assembly457); 
					code[i++]=LOADRV;
					}
					break;
				case 18 :
					// /home/acco/workspace/FOOL/SVM.g:50:6: STORERV
					{
					match(input,STORERV,FOLLOW_STORERV_in_assembly471); 
					code[i++]=STORERV;
					}
					break;
				case 19 :
					// /home/acco/workspace/FOOL/SVM.g:51:6: LOADFP
					{
					match(input,LOADFP,FOLLOW_LOADFP_in_assembly484); 
					code[i++]=LOADFP;
					}
					break;
				case 20 :
					// /home/acco/workspace/FOOL/SVM.g:52:6: STOREFP
					{
					match(input,STOREFP,FOLLOW_STOREFP_in_assembly498); 
					code[i++]=STOREFP;
					}
					break;
				case 21 :
					// /home/acco/workspace/FOOL/SVM.g:53:6: COPYFP
					{
					match(input,COPYFP,FOLLOW_COPYFP_in_assembly511); 
					code[i++]=COPYFP;
					}
					break;
				case 22 :
					// /home/acco/workspace/FOOL/SVM.g:54:6: LOADHP
					{
					match(input,LOADHP,FOLLOW_LOADHP_in_assembly525); 
					code[i++]=LOADHP;
					}
					break;
				case 23 :
					// /home/acco/workspace/FOOL/SVM.g:55:6: STOREHP
					{
					match(input,STOREHP,FOLLOW_STOREHP_in_assembly539); 
					code[i++]=STOREHP;
					}
					break;
				case 24 :
					// /home/acco/workspace/FOOL/SVM.g:56:6: PRINT
					{
					match(input,PRINT,FOLLOW_PRINT_in_assembly552); 
					code[i++]=PRINT;
					}
					break;
				case 25 :
					// /home/acco/workspace/FOOL/SVM.g:57:6: HALT
					{
					match(input,HALT,FOLLOW_HALT_in_assembly567); 
					code[i++]=HALT;
					}
					break;

				default :
					break loop1;
				}
			}


				        for(Integer refAdd : labelRef.keySet()){
				        //ciclo sull'insieme delle chiavi di label ref
				     
				        code[refAdd]=labelAdd.get(labelRef.get(refAdd));
				        
				        
				        
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
	}
	// $ANTLR end "assembly"

	// Delegated rules



	public static final BitSet FOLLOW_PUSH_in_assembly38 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_NUMBER_in_assembly42 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_PUSH_in_assembly51 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LABEL_in_assembly55 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_POP_in_assembly66 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_ADD_in_assembly76 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_SUB_in_assembly86 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_MULT_in_assembly96 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_DIV_in_assembly106 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STOREW_in_assembly118 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADW_in_assembly133 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LABEL_in_assembly168 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COL_in_assembly170 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_BRANCH_in_assembly212 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LABEL_in_assembly216 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_BRANCHEQ_in_assembly240 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LABEL_in_assembly244 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_BRANCHLESS_in_assembly260 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LABEL_in_assembly264 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_JS_in_assembly276 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADRA_in_assembly430 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STORERA_in_assembly444 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADRV_in_assembly457 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STORERV_in_assembly471 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADFP_in_assembly484 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STOREFP_in_assembly498 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_COPYFP_in_assembly511 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADHP_in_assembly525 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STOREHP_in_assembly539 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_PRINT_in_assembly552 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_HALT_in_assembly567 = new BitSet(new long[]{0x000000007FDFF6F2L});
}
