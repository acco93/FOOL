
public class DebugNode implements Node {

	private Node exp;

	DebugNode(Node exp){
		this.exp = exp;
	}
	
	@Override
	public String toPrint(String indent) {
		return indent+"DebugNode\n"+this.exp.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		return this.exp.typeCheck();
	}

	@Override
	public String codeGeneration() {
		return "debug\n"+this.exp.codeGeneration()+"nodebug\n";
	}

}
