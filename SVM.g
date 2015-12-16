grammar SVM;

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

@header {
  import java.util.HashMap;
}

// crea dei campi
@parser::members {
  
  // spazio di memoria per metterci il codice, non può essere privato perchè poi va passato alla virtual machine
  int[] code = new int[ExecuteVM.CODESIZE];
  //contatore, per riempire l'array col codice
  private int i = 0;
  
  // per le etichette
  // HashMap da etichette a posti dove occorrono nel asm, la aggiorniamo ad ogni dichiarazione di etichetta LABEL COL
  private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
  
  // per i riferimenti ad etichetti (che sono nelle istruzioni di salto)
  private HashMap<Integer, String> labelRef = new HashMap<Integer, String>();
  
}

assembly: ( 

      PUSH n=NUMBER	{code[i++] = PUSH; code[i++]=Integer.parseInt($n.text);}//push NUMBER on the stack
	  | PUSH l=LABEL {code[i++] = PUSH; labelRef.put(i++,$l.text);} 	//push the location address pointed by LABEL on the stack	     
	  | POP	{code[i++]=POP;}	//pop the top of the stack, tra {} c'è un'azione, POP è una costante definita nel parser
	  | ADD	{code[i++]=ADD;}	//replace the two values on top of the stack with their sum
	  | SUB	{code[i++]=SUB;}	//pop the two values v1 and v2 (respectively) and push v2-v1
	  | MULT {code[i++]=MULT;}	//replace the two values on top of the stack with their product	
	  | DIV	 {code[i++]=DIV;}  //pop the two values v1 and v2 (respectively) and push v2 DIV v1
	  | STOREW {code[i++]=STOREW;}//pop two values:                                                    //si chiama indirezione
	  		//  the second one is written at the memory address pointed by the first one
	  | LOADW  {code[i++]=LOADW;}     //read the content of the memory cell pointed by the top of the stack
	                //  and replace the top of the stack with such value
	  | l=LABEL COL        {labelAdd.put($l.text,i);}                          //LABEL points at the location of the subsequent instruction, i è l'indice della prossima instruzione l1: print mi da l'indice di print
	  | BRANCH l=LABEL     {code[i++]=BRANCH; labelRef.put(i++,$l.text);}       /*code[] indirizzo a cui salto, lo so solo quando la incontro*/   //jump at the instruction pointed by LABEL
	  | BRANCHEQ l=LABEL   {code[i++]=BRANCHEQ; labelRef.put(i++,$l.text);}     //pop two values and jump if they are equal
	  | BRANCHLESS l=LABEL {code[i++]=BRANCHLESS; labelRef.put(i++,$l.text);}   //pop two values and jump if the second one is less or equal to the first one
	  | JS /*jump subroutine*/                 {code[i++]=JS;}                                                    //pop one value from the stack:
	  		                                                                     //  copy the instruction pointer in the RA register and jump to the popped value    
	  | LOADRA      {code[i++]=LOADRA;}//push in the stack the content of the RA register   
	  | STORERA     {code[i++]=STORERA;}//pop the top of the stack and copy it in the RA register     
	  | LOADRV      {code[i++]=LOADRV;}//push in the stack the content of the RV register    
	  | STORERV     {code[i++]=STORERV;}//pop the top of the stack and copy it in the RV register    
	  | LOADFP      {code[i++]=LOADFP;}//push in the stack the content of the FP register   
	  | STOREFP     {code[i++]=STOREFP;}//pop the top of the stack and copy it in the FP register    
	  | COPYFP      {code[i++]=COPYFP;}//copy in the FP register the currest stack pointer    
	  | LOADHP      {code[i++]=LOADHP;}//push in the stack the content of the HP register    
	  | STOREHP     {code[i++]=STOREHP;}//pop the top of the stack and copy it in the HP register    
	  | PRINT       {code[i++]=PRINT;}//visualize the top of the stack without removing it   
	  | HALT        {code[i++]=HALT;}//interrupt the execution    
	  )* {
	        for(Integer refAdd : labelRef.keySet()){
	        //ciclo sull'insieme delle chiavi di label ref
	     
	        code[refAdd]=labelAdd.get(labelRef.get(refAdd));
	        
	        
	        
	        }
	  }
	  /* dopo la stella c'è  il codice eseguito dopo il parsing, scandiamo i buchi e li rimpiamo con gli indirizzi associati a quel bugo*/
	  
 ;
 /*
 la sintassi è una stella di or
 */
 	 
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PUSH	 : 'push' ; 	
POP	 : 'pop' ; 	
ADD	 : 'add' ;  	
SUB	 : 'sub' ;	
MULT	 : 'mult' ;  	
DIV	 : 'div' ;	
STOREW	 : 'sw' ; 	
LOADW	 : 'lw' ;	
BRANCH	 : 'b' ;	
BRANCHEQ : 'beq' ;	
BRANCHLESS:'bless' ;	
JS	 : 'js' ;	
LOADRA	 : 'lra' ;	
STORERA  : 'sra' ;	 
LOADRV	 : 'lrv' ;	
STORERV  : 'srv' ;	
LOADFP	 : 'lfp' ;	
STOREFP	 : 'sfp' ;	
COPYFP   : 'cfp' ;      
LOADHP	 : 'lhp' ;	
STOREHP	 : 'shp' ;	
PRINT	 : 'print' ;	
HALT	 : 'halt' ;	

COL	 : ':' ;
LABEL	 : ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;
NUMBER	 : '0' | ('-')?(('1'..'9')('0'..'9')*) ;

WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+    { $channel=HIDDEN; } ;

ERR   	 : . { System.err.println("Invalid char: "+$text); $channel=HIDDEN; } ; 

