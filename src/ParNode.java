
public class ParNode implements Node, DecNode {

	private String id;
	private Node type;
	
	ParNode(String id, Node type){
		this.id = id;
		this.type = type;
	}
	
	@Override
	public String toPrint(String indent) {
		
		System.out.println(this.id+": "+this.type);
		
		return 	indent+
				"Par: "+this.id+"\n"+
				this.type.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		//non dobbiamo controllare niente e nessuno lo chiama
		return null;
	}

	@Override
	public String codeGeneration() {
		return null;
	}

	@Override
	public Node getSymType() {
		return this.type;
	}

}
