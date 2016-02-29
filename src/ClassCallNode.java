import java.util.ArrayList;

public class ClassCallNode implements Node{

	// entry dell'oggetto
	private STEntry entry;
	// nome dell'oggetto
	private String objId;
	// entry del metodo chiamato
	private STEntry methodEntry;
	// nome del metodo
	private String methodId;
	// parametri passati al metodo
	private ArrayList<Node> argList;
	// livello di dove è la chiamata del metodo
	private int nestingLevel;

	ClassCallNode(String objId,STEntry classEntry, String methodId, STEntry methodEntry, ArrayList<Node> parList, int nestingLevel){
		this.objId = objId;
		this.entry = classEntry;
		this.methodEntry = methodEntry;
		this.methodId = methodId;
		this.argList = parList;
		this.nestingLevel = nestingLevel;
	}
	
	@Override
	public String toPrint(String indent) {
		String result=indent+"ClassCall "+this.objId+"."+this.methodId+"\n";
		result += indent+"Object entry ("+this.objId+")\n";
		result += this.entry.toPrint(indent+"  ");
		result += indent+"Method entry ("+this.methodId+")\n";
		result += this.methodEntry.toPrint(indent+"  ");
		for(int i=0;i<this.argList.size();i++){
			result += this.argList.get(i).toPrint(indent+"  ");			
		}
		return result;
	}

	@Override
	public Node typeCheck() {
		
		if(!(this.entry.getType() instanceof ClassTypeNode)){
			System.out.println("Object usage of a non object identifier "+this.objId);
			System.exit(0);
		}
	
		// tipo di ritorno del metodo definito nella dichiarazione
		ArrowTypeNode type = (ArrowTypeNode) this.methodEntry.getType();
		Node retType = type.getRet();
		
		// lista dei tipi dei parametri formali definiti nella dichiarazione
		ArrayList<Node> parList = type.getParList();
		
		if(parList.size()!=argList.size()){
			System.out.println("Wrong number of parameters in the invocation of "+this.objId+"."+this.methodId);
			System.exit(0);
		}
		
		for(int i=0;i<parList.size();i++){
			
			// il tipo degli argomenti deve essere <= del tipo dei parametri formali
			// argList sono espressioni => devo valutarle e ottenere il tipo con il typecheck
			if(!FOOLLib.isSubType(argList.get(i).typeCheck(),parList.get(i))){
				System.out.println("Wrong type for "+i+"-th parameter in the invocation of "+this.objId+"."+this.methodId);
				System.exit(0);
				
			}
		}
		
		//ritorno il tipo dichiarato dentro arrowTypeNode
		return retType;
	}

	@Override
	public String codeGeneration() {
		String code="";
		
		
		code +="#setto il CL\nlfp\n";	// control link
		
		// parametri (dall'ultimo al primo (vedi layout))
		for(int i=this.argList.size()-1;i>=0;i--){
			code+=this.argList.get(i).codeGeneration();
		}
		
		// ora devo settare l'AL
		
		// calcolo la risalita della catena statica
		String getAR = "";
		for(int i=0;i<this.nestingLevel-this.entry.getNestingLevel();i++){
			getAR+="lw\n";
		}
		
		code+=  "# setto l'AL recuperando l'object pointer\n"
				+ "push "+(this.entry.getOffset())+"\n"+	//pusho l'offset della dichiarazione dell'oggetto nel suo AR
				"lfp\n"+	// pusho FP (che punta all'AL) 
				getAR+		// mi permette di risalire la catena statica
				"add\n"+	// sommando mi posiziono sull'FP della funzione
				"lw\n"+		// ne vado a prendere il valore e lo metto sullo stack,
							// in questo modo setto l'AL per il chiamato
							// cioè vado a dirgli che si riferisce a questo AR in caso ad esempio di variabili libere
							
				
				//ora vado a recuperare l'indirizzo del metodo			
				"# setto l'indirizzo a cui saltare\n"+
				// riprendo l'object pointer
				"push "+(this.entry.getOffset())+"\n"+
				"lfp\n"+	
				getAR+		
				"add\n"+	
				"lw\n"+	
				// pusho l'offset del metodo
				"push " +(this.methodEntry.getOffset())+"\n"+		
				"add\n"+
				"lw\n"
				;
		
		code+="js\n";
		
		return code;
	}

}
