
public class IntTypeNode implements Node{

	@Override
	public String toPrint(String indent) {
		return indent+"IntType\n";
	}

	@Override
	public Node typeCheck() {
		//non lo usa nessuno
		return null;
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
