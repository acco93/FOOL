import java.util.ArrayList;

// rappresenta il tipo delle funzioni/metodi
public class ArrowTypeNode implements Node {

	// tipo dei parametri
	private ArrayList<Node> parList;
	// tipo del valore di ritorno
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
		return null;
	}

}
