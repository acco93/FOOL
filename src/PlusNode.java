
public class PlusNode implements Node {

	private Node left;
	private Node right;
	
	PlusNode(Node l, Node r){
		this.left = l;
		this.right = r;
	}

	@Override
	public String toPrint(String indent) {
			  	
		return 		indent+"Plus\n"				//stampo me stesso
					+left.toPrint(indent+"  ")	//stampo i miei figli con una indentazione in più
					+right.toPrint(indent+"  ");
		
	}

	@Override
	public Node typeCheck() {
		// ci va bene un qualsiasi sottotipo di intero
		if(!(FOOLLib.isSubType(left.typeCheck(), new IntTypeNode()) &&
		FOOLLib.isSubType(right.typeCheck(), new IntTypeNode()))){
			System.out.println("Non integers in sum!");
			System.exit(0);
		}

		return new IntTypeNode();
	}

	@Override
	public String codeGeneration() {
		return left.codeGeneration()+right.codeGeneration()+"add\n";
	}
	
}
