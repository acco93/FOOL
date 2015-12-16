
public class VarNode implements Node {

	private String id;
	private Node type;
	private Node exp;
	
	VarNode(String id, Node type, Node exp){
		this.id = id;
		this.type = type;
		this.exp = exp;
	}
	
	@Override
	public String toPrint(String indent) {
		return 	indent+
				"Var: "+this.id+ "\n"+
				this.type.toPrint(indent+"  ")+
				this.exp.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		
		//l'exp deve essere sottotipo di type
		if(!FOOLLib.isSubType(exp.typeCheck(), this.type)){
			System.out.println("Incompatible value for variable "+this.id);
			System.exit(0);
		}
		
		//ritorniamo null perchè è una dichiarazione
		return null;
	}

	@Override
	public String codeGeneration() {
		return this.exp.codeGeneration();
	}

}
