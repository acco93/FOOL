
public class NotNode implements Node {

	private Node exp;
	
	public NotNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent+"Not: \n"+this.exp.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		if(!FOOLLib.isSubType(exp.typeCheck(), new BoolTypeNode())){
			System.out.println("Non boolean in not!");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		String labelA = FOOLLib.freshLabel();
		String labelB = FOOLLib.freshLabel();
		return 	exp.codeGeneration()+
				"push 1\n"+
				"beq "+labelA+ "\n" +
				//salto a labelA se è true
				//se non salto => è false quindi pusho true
				"push 1\n"+
				// salto via cioè non faccio il push true
				"b "+labelB+"\n"+
				labelA+":  \n"+
				// se è true pusho false
				"push 0 \n"+
				labelB+":\n";
	}

}
