
public class ClassTypeNode implements Node{

	private String name;

	ClassTypeNode(String name){
		this.name = name;
	}
	
	public String getType(){
		return this.name;
	}
	
	@Override
	public String toPrint(String indent) {
		return 	indent+
				"ClassType "+this.name+"\n";
	}

	@Override
	public Node typeCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
