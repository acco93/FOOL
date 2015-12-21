
public class LowerEqualNode implements Node {

	private Node left;
	private Node right;
	
	
	
	public LowerEqualNode(Node left, Node right) {
		super();
		this.left = left;
		this.right = right;
	}
	@Override
	public String toPrint(String indent) {
		return 		
				indent+"LowerOrEqual\n"				
				+left.toPrint(indent+"  ")	
				+right.toPrint(indent+"  ");
	}
	@Override
	public Node typeCheck() {
		Node l = left.typeCheck();
		Node r = right.typeCheck();
		
		if(l instanceof ArrowTypeNode || r instanceof ArrowTypeNode){
			System.out.println("Type error: function in <= !");
			System.exit(0);
		}
		
		if(!(FOOLLib.isSubType(l, r) ||
				FOOLLib.isSubType(r, l))){
					System.out.println("Incompatible types in <= !");
					System.exit(0);
				}

		return new BoolTypeNode();
	}
	@Override
	public String codeGeneration() {
		
		String labelA = FOOLLib.freshLabel();
		String labelB = FOOLLib.freshLabel();
				//metto sullo stack il risultato delle due espressioni
		return 	left.codeGeneration()+
				right.codeGeneration()+
				"bless "+labelA+ "\n" +
				// se left < di right salto a labelA
				left.codeGeneration()+
				right.codeGeneration()+
				"beq "+labelA+ "\n" +
				//se sono uguali salto a labelA
				//se nessuna delle due => metto false
				"push 0\n"+
				// salto via cioè non faccio il push true
				"b "+labelB+"\n"+
				labelA+":  \n"+
				// se sono <=
				"push 1 \n"+
				labelB+":\n";
	}
	
}
