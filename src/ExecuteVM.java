
public class ExecuteVM {

	// spazio in memoria per il codice creato
	public static final int CODESIZE = 10000;
	// spazio che può usare la vm durante l'esecuzione
	public static final int MEMSIZE = 10000;
	
	private int[] code;
	
	// stack (dall'alto) & heap (dal basso)
	private int[] memory = new int[MEMSIZE];
		
	// instruction pointer
	private int ip = 0;
	// stack pointer
	private int sp = MEMSIZE;
	// frame pointer
	private int fp = MEMSIZE;	//inizialmente punta al top dello stack
	
	// heap pointer
	private int hp = 0;
	
	// return address
	private int ra=0;
	// return value
	private int rv=0;
	
	// Costruttore
	ExecuteVM(int[] code){
		this.code = code;
	
	}

	void cpu() {
		while(true){
			// fetch
				
			/*System.out.println("IP:"+ip);
			System.out.println("RA:"+ra);
			System.out.println("FP:"+fp);
			System.out.println("SP:"+sp);
			System.out.println("HP: "+hp);
			
			System.out.println("");*/
			
			
			int bytecode = code[ip++];
			int arg1, arg2;
			int address;
			switch(bytecode){
			
				//push on the stack
				case SVMParser.PUSH:
					push(code[ip++]);
					break;
					
				//pop the top of the stack, tra {} c'è un'azione, POP è una costante definita nel parser
				case SVMParser.POP:
					pop();
					break;
					
				//replace the two values on top of the stack with their sum
				case SVMParser.ADD:
					arg2 = pop();
					arg1 = pop();
					push(arg1+arg2);
					break;
					
				//replace the two values on top of the stack with their product
				case SVMParser.MULT:
					arg2 = pop();
					arg1 = pop();
					push(arg1*arg2);
					break;
					
				//pop the two values v1 and v2 (respectively) and push v2 DIV v1
				case SVMParser.DIV:
					arg2 = pop();
					arg1 = pop();
					push(arg1/arg2);
					break;
					
				//pop the two values v1 and v2 (respectively) and push v2-v1
				case SVMParser.SUB:
					arg2 = pop();
					arg1 = pop();
					push(arg1-arg2);
					break;
					
				//pop two values: 
		  		//the second one is written at the memory address pointed by the first one
				case SVMParser.STOREW:
					arg1 = pop();
					arg2 = pop();
					memory[arg1]=arg2;
					break;
					
				//read the content of the memory cell pointed by the top of the stack
				//and replace the top of the stack with such value
				case SVMParser.LOADW:
					arg1 = pop();
					push(memory[arg1]);
					//System.out.println("LW:"+memory[arg1]);
					break;
					
				//jump at the instruction pointed by LABEL
				case SVMParser.BRANCH:
					address = code[ip];
					ip = address;
					break;
					
				//pop two values and jump if they are equal
				case SVMParser.BRANCHEQ:
					address =code[ip++];
					arg2 = pop();
					arg1 = pop();
					if(arg1 == arg2){
						ip = address;
					}
					break;
					
				//pop two values and jump if the second one is less or equal to the first one
				case SVMParser.BRANCHLESS:
					address = code[ip++];
					arg2 = pop();
					arg1 = pop();
					if(arg1 <= arg2){
						ip = address;
					}
					break;
					
				//pop one value from the stack:
				//copy the instruction pointer in the RA register and jump to the popped value
				case SVMParser.JS:
					address = pop();
					ra = ip;
					ip = address;
					break;
					
				//push in the stack the content of the RA register
				case SVMParser.LOADRA:
					push(ra);
					break;
					
				//pop the top of the stack and copy it in the RA register
				case SVMParser.STORERA:
					ra = pop(); 
					break;
					
				//push in the stack the content of the RV register
				case SVMParser.LOADRV:
					push(rv);
					break;
					
				//pop the top of the stack and copy it in the RV register
				case SVMParser.STORERV:
					rv = pop();
					break;
					
				//push in the stack the content of the FP register
				case SVMParser.LOADFP:
					push(fp);
					break;
					
				//pop the top of the stack and copy it in the FP register
				case SVMParser.STOREFP:
					fp = pop();
					break;
					
				//copy in the FP register the current stack pointer
				case SVMParser.COPYFP:
					fp = sp;
					break;
					
				//push in the stack the content of the HP register
				case SVMParser.LOADHP:
					push(hp);
					break;
					
				//pop the top of the stack and copy it in the HP register
				case SVMParser.STOREHP:
					hp = pop();
					break;
				
				//visualize the top of the stack without removing it
				case SVMParser.PRINT:
					System.out.println((sp<MEMSIZE)?memory[sp]:"Empty stack!");
					break;
					
				//interrupt the execution
				case SVMParser.HALT:
					System.out.println("\n--------------------\nSUCCESSFULLY EXECUTED.");
					this.memoryTrace();
					return;
				
					
			}

		}

	}
	
	private void memoryTrace() {
		/*
		System.out.println("MEMORY TRACE:");

		for(int i=MEMSIZE-1;i>=sp;i--){
			System.out.println(i+": "+memory[i]);
		}
		System.out.println("...");
		for(int i=hp-1;i>=0;i--){
			System.out.println(i+": "+memory[i]);
		}
		
		System.out.println("\n");
		 */
	}

	private int pop(){
		int value= memory[sp++];
		return value;
	}
	
	private void push(int value){
		memory[--sp] = value;
		memoryTrace();
	}
}
