
public class PrintNode implements Node {

	private Node node;
	
	PrintNode(Node node){
		this.node = node;
	}
	
	@Override
	public String toPrint(String indent) {
	
		return indent+"Print \n"+this.node.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		return this.node.typeCheck();
	}

	@Override
	public String codeGeneration() {
		return node.codeGeneration()+
				"print\n";
	}

}
