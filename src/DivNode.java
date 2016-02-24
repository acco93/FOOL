public class DivNode implements Node{

	private Node left;
	private Node right;
	
	
	
	public DivNode(Node left, Node right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toPrint(String indent) {
		return 	indent+"Div\n"			
				+left.toPrint(indent+"  ")
				+right.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
				
		if(!(FOOLLib.isSubType(left.typeCheck(), new IntTypeNode()) &&
				FOOLLib.isSubType(right.typeCheck(), new IntTypeNode()))){
					System.out.println("Non integers in division!");
					System.exit(0);
				}

		return new IntTypeNode();
	}

	@Override
	public String codeGeneration() {
		return left.codeGeneration()+right.codeGeneration()+"div\n";
	}

}
