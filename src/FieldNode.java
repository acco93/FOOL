
public class FieldNode implements Node, DecNode {

	private String id;
	private Node type;
	
	FieldNode(String id, Node type){
		this.id = id;
		this.type = type;
	}
	
	@Override
	public Node getSymType() {
		return this.type;
	}

	@Override
	public String toPrint(String indent) {
		
		return 	indent+
				"Field: "+this.id+ "\n"+
				this.type.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
