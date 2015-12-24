import java.util.ArrayList;

public class LetInNode implements Node {

	private ArrayList<Node> declarations;
	private Node exp;
	
	LetInNode(ArrayList<Node> declarations, Node exp){
		this.declarations = declarations;
		this.exp = exp;
	}
	
	@Override
	public String toPrint(String indent) {
		String result=indent+"LetIn\n";
		for(int i=0;i<declarations.size();i++){
			result+=declarations.get(i).toPrint(indent+"  ");
		}
		result+=this.exp.toPrint(indent+"  ");
		return result;
	}

	@Override
	public Node typeCheck() {
		// il let in node ha come figli le dichiarazioni globali e ritorna il tipo dell'espressione exp
		
		// prima però dobbiamo typecheckare le dichiarazioni
		// non ci interessa il valore di ritorno ma solo controllare se hanno errori
		
		for(Node node:this.declarations){
			node.typeCheck();
		}
		
		
		return exp.typeCheck();
	}

	@Override
	public String codeGeneration() {
		String code="";
		//metto il return value fittizio per uniformità
		code += "push 0\n\n";
		// metto sullo stack tutte le dichiarazioni
		for(int i=0;i<this.declarations.size();i++){
			//ci pensa ciascun codeGeneration a fare il push -> le var il valore, mentre le funzioni il proprio indirizzo
			code+=this.declarations.get(i).codeGeneration();
		}
		code+="\n";
		// terminazione del programma
		code+=this.exp.codeGeneration()+"halt\n";
		
		// aggiungo le funzioni alla fine del codice
		code+=FOOLLib.getCode();
		
		return code;
	}

}
