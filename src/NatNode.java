
public class NatNode implements Node {

	private int value;
	
	NatNode(int value){
		this.value = value;
	}

	@Override
	public String toPrint(String indent) {
		return indent+"Nat: "+this.value+"\n";
	}

	@Override
	public Node typeCheck() {
		return new IntTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "push "+this.value+"\n";
	}
	
}
