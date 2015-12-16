
public class ProgNode implements Node {

	private Node root;
	
	ProgNode (Node root){
		this.root = root;
	}
	
	@Override
	public String toPrint(String indent) {
		return "Prog\n" +
				root.toPrint("  ");
	}

	@Override
	public Node typeCheck() {
		return this.root.typeCheck();
	}

	@Override
	public String codeGeneration() {
		// non abbiamo dichiarazioni
		// ma solo l'espressione che è il main del programma
		return this.root.codeGeneration()+
				"halt\n";
	}

}
