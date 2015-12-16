
public class MinusNode implements Node {

	private Node left;
	private Node right;
	
	
	
	public MinusNode(Node left, Node right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toPrint(String indent) {
		return 	indent+"Minus\n"			
				+left.toPrint(indent+"  ")
				+right.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		
		//per fare la sottrazione è sufficiente controllare che le
		//le espressioni a dx e sx restituiscano un intero
		
		if(!(FOOLLib.isSubType(left.typeCheck(), new IntTypeNode()) &&
				FOOLLib.isSubType(right.typeCheck(), new IntTypeNode()))){
					System.out.println("Non integers in subtraction!");
					System.exit(0);
				}

		return new IntTypeNode();
	}

	@Override
	public String codeGeneration() {
		return left.codeGeneration()+right.codeGeneration()+"sub\n";
	}

}
