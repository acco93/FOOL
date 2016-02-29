
public class EmptyTypeNode implements Node {

	@Override
	public String toPrint(String indent) {
		return 	indent+
				"EmptyTypeNode\n";
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		return null;
	}

}
