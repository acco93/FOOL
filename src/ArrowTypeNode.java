import java.util.ArrayList;

public class ArrowTypeNode implements Node {

	private ArrayList<Node> parList;
	private Node returnNode;
	
	ArrowTypeNode(ArrayList<Node> parList, Node ret){
		this.parList = parList;
		this.returnNode = ret;
	}
	
	@Override
	public String toPrint(String indent) {
		String string = indent+"ArrowType\n";
		for(int i=0;i<parList.size();i++){
			string+=parList.get(i).toPrint(indent+"  ");
		}
		string+=returnNode.toPrint(indent+"  -> ");
		return string;
	}

	@Override
	public Node typeCheck() {
		//non lo usa nessuno
		return null;
	}

	public Node getRet() {
		return this.returnNode;
	}

	public ArrayList<Node> getParList() {
		return this.parList;		
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
