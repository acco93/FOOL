
public class EqualNode implements Node {

	private Node left;
	private Node right;
	
	EqualNode(Node l, Node r){
		this.left = l;
		this.right = r;
	}
	
	@Override
	public String toPrint(String indent) {
		return 		indent+"Equal\n"				
				+left.toPrint(indent+"  ")	
				+right.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		
		Node l = left.typeCheck();
		Node r = right.typeCheck();
		
		if(l instanceof ArrowTypeNode || r instanceof ArrowTypeNode){
			System.out.println("Type error: function in == !");
			System.exit(0);
		}
		
		
		if(!(FOOLLib.isSubType(l, r) ||
				FOOLLib.isSubType(r, l))){
					System.out.println("Incompatible types in equal!");
					System.exit(0);
				}

		return new BoolTypeNode();
	}
	
	//  == ha senso se tra le due cose che sto confrontando c'è una relazione di <=

	@Override
	public String codeGeneration() {
		String labelA = FOOLLib.freshLabel();
		String labelB = FOOLLib.freshLabel();
		return left.codeGeneration()+
				right.codeGeneration()+
				"beq "+labelA+ "\n" +
				//se sono diversi pushamo 0, false
				"push 0\n"+
				// salto via cioè non faccio il push 1
				"b "+labelB+"\n"+
				labelA+":  \n"+
				// se sono uguali pusho l'1 che verrà poi gestito nell'IfElseNode
				"push 1 \n"+
				labelB+":\n";
	}

	
	
}
