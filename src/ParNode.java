
public class ParNode implements Node {

	private String id;
	private Node type;
	
	ParNode(String id, Node type){
		this.id = id;
		this.type = type;
	}
	
	@Override
	public String toPrint(String indent) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
