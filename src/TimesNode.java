
public class TimesNode implements Node {

	Node left;
	Node right;
	
	TimesNode(Node l, Node r){
		this.left = l;
		this.right = r;
	}

	@Override
	public String toPrint(String indent) {
		return 		indent+"Times\n"				
				+left.toPrint(indent+"  ")	
				+right.toPrint(indent+"  ");
	}
	
	  @Override
		public Node typeCheck() {
			// ci va bene un qualsiasi sottotipo di intero
			if(!(FOOLLib.isSubType(left.typeCheck(), new IntTypeNode()) &&
			FOOLLib.isSubType(right.typeCheck(), new IntTypeNode()))){
				System.out.println("Non integers in mult!");
				System.exit(0);
			}

			return new IntTypeNode();
		}
	
		@Override
		public String codeGeneration() {
			return left.codeGeneration()+right.codeGeneration()+"mult\n";
		}
	  
}
