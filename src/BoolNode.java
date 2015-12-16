
public class BoolNode implements Node {

	private boolean value;
	
	BoolNode (boolean value){
		this.value=value;
	}
	
	@Override
	public String toPrint(String indent) {
		return indent+"Bool: "+this.value+"\n";
	}

	@Override
	public Node typeCheck() {
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		return this.value?"push 1\n":"push 0\n";
	}

}
