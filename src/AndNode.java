
public class AndNode implements Node {

	private Node left;
	private Node right;
	
	
	public AndNode(Node left, Node right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public String toPrint(String indent) {
		return 	indent+"And\n"			
				+left.toPrint(indent+"  ")
				+right.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		// ci va bene un qualsiasi sottotipo di bool
				if(!(FOOLLib.isSubType(left.typeCheck(), new BoolTypeNode()) &&
				FOOLLib.isSubType(right.typeCheck(), new BoolTypeNode()))){
					System.out.println("Non boolean in and!");
					System.exit(0);
				}

				return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		String labelA = FOOLLib.freshLabel();
		String labelB = FOOLLib.freshLabel();
		
		return 	//valuto l'espressione sinistra e salto a labelA se valuta false (regola del cortocircuito)
				left.codeGeneration()+
				"push 0\n"+
				"beq "+labelA+ "\n" +
				//valuto l'espessione destra e salto a labelA se valuta false
				right.codeGeneration()+
				"push 0\n"+
				"beq "+labelA+ "\n" +
				//se arrivo fin qui ho sempre trovato dei true => l'and è true
				//metto 1 che serve al livello superiore
				"push 1\n"+
				//salto a labelB che mi evita il push 0
				"b "+labelB+"\n"+
				labelA+":  \n"+
				"push 0 \n"+
				labelB+":\n";
	}

}
