
public class IfElseNode implements Node{

	private Node conditionNode;
	private Node thenNode;
	private Node elseNode;

	IfElseNode(Node conditionNode, Node thenNode, Node elseNode){
		this.conditionNode = conditionNode;
		this.thenNode = thenNode;
		this.elseNode = elseNode;
	}
	
	@Override
	public String toPrint(String indent) {
			
		return indent+"If\n" +
				this.conditionNode.toPrint(indent+"  ")+
				this.thenNode.toPrint(indent+"  ")+
				this.elseNode.toPrint(indent+"  ");
		
	}

	@Override
	public Node typeCheck() {
		// i tipi ritornati da then e else devono essere compatibili
		// le sono => torno la superclasse
	
		if(!(FOOLLib.isSubType(this.conditionNode.typeCheck(), new BoolTypeNode()))){
			System.out.println("Non boolean condition in if");
			System.exit(0);			
		}
		
		Node t = this.thenNode.typeCheck();
		Node e = this.elseNode.typeCheck();
		
		Node lca = null;
		
		// richiamo lowestCommonAncestor sul tipo dell' espressione del then
		lca = FOOLLib.lowestCommonAncestor(t, e);
		if(lca != null){
			return lca;
		}
		
		// richiamo lowestCommonAncestor sul tipo dell' espressione dell'else
		lca = FOOLLib.lowestCommonAncestor(e, t);
		if(lca != null){
			return lca;
		}
		
		System.out.println("Incompatible types in then & else branches");
		System.exit(0);
		
		// in generale non è possibile controllare le esecuzioni con il typechecking
		// infatti ora vuole la return
		
		
		return null;
	}

	@Override
	public String codeGeneration() {
		String labelA = FOOLLib.freshLabel();
		String labelB = FOOLLib.freshLabel();
		return this.conditionNode.codeGeneration()+	//mi mette sullo stack 0 o 1 => lo confronto
				"push 1\n"+							// con 1 cioè se è true
				"beq "+labelA+ "\n"+
				//se sono diversi pushamo 0, false
				this.elseNode.codeGeneration()+
				"b "+labelB+"\n"+
				labelA+": \n"+
				this.thenNode.codeGeneration()+
				labelB+":\n";
	}
	
}
