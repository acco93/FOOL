
public class STEntry {

	private int nestingLevel;
	private Node type;
	// mi serve poi durante la generazione di codice per definire il layout
	private int offset;
	
	private boolean isMethod;

	
	// per variabili e parametri
	STEntry(int nestingLevel, Node type, int offset){
		this.nestingLevel = nestingLevel;
		this.type = type;
		this.offset = offset;
	}	
	
	// per le funzioni
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
				indent+ "STEntry: type\n"+this.type.toPrint(indent+"  ");
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
