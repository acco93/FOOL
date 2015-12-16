
public class OrNode implements Node {

	private Node left;
	private Node right;
	
	public OrNode(Node left, Node right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toPrint(String indent) {
		return 	indent+"Or\n"			
				+left.toPrint(indent+"  ")
				+right.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		// ci va bene un qualsiasi sottotipo di bool
		if(!(FOOLLib.isSubType(left.typeCheck(), new BoolTypeNode()) &&
		FOOLLib.isSubType(right.typeCheck(), new BoolTypeNode()))){
			System.out.println("Non boolean in or!");
			System.exit(0);
		}

		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		
		/*
		 * Quando ho OR tra due cose:
		 * 
		 * e1 || e2 =>
		 * 
		 * salto se almeno una delle due espressioni valuta 1:
		 * 
		 * controllo e1, pusho 1 sullo stack e salto se sono uguali
		 * se non sono uguali
		 * controllo e2, pusho 1 sullo stack e salto se sono uguali
		 * se non sono uguali salto via
		 * 
		 * 
		 * */
		
		String labelA = FOOLLib.freshLabel();
		String labelB = FOOLLib.freshLabel();
		
		return 	//valuto l'espressione sinistra e salto a labelA se valuta true
				left.codeGeneration()+
				"push 1\n"+
				"beq "+labelA+ "\n" +
				//valuto l'espessione destra e salto a labelA se valuta true
				right.codeGeneration()+
				"push 1\n"+
				"beq "+labelA+ "\n" +
				//se arrivo qui non ho saltato => nessuno dei due era true
				//metto lo 0 che serve al livello superiore
				"push 0\n"+
				//salto a labelB che mi evita il push 1
				"b "+labelB+"\n"+
				labelA+":  \n"+
				"push 1 \n"+
				labelB+":\n";
	}

}
