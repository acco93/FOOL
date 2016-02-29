
public class STEntry {

	// nesting level dichiarazione oggetto
	private int nestingLevel;
	private Node type;
	// utilizzato durante la generazione di codice in base al layout per individuare questo oggetto
	private int offset;
	// permette di identificare entry di metodi in modo che vengano trattate diversamente da CallNode
	private boolean isMethod;

	
	// per variabili e parametri
	STEntry(int nestingLevel, Node type, int offset){
		this.nestingLevel = nestingLevel;
		this.type = type;
		this.offset = offset;
	}	
	
	// per le funzioni/metodi
	STEntry(int nestingLevel, int offset){
		this.nestingLevel = nestingLevel;
		this.offset = offset;
	}	

	public void setAsMethod(){
		this.isMethod = true;
	}
	
	public boolean isMethod(){
		return this.isMethod;
	}
	
	void addType(Node type){
		this.type = type;
	}
	
	String toPrint(String indent){
		return 	indent+
				"STEntry: nesting lvl = "+this.nestingLevel+"\n"+
				indent+ "STEntry: offset = "+this.offset+"\n"+
				indent+ "STEntry: type\n"+this.type.toPrint(indent+"  ")+
				indent+ "STEntry: isMethod = "+this.isMethod+"\n";
	}

	public Node getType() {
		return this.type;
	}
	
	public int getOffset(){
		return this.offset;
	}

	public int getNestingLevel() {
		return this.nestingLevel;
		
	}
	
}
