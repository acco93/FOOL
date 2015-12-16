/*
 * Classe madre per tutti i nodi.
 * */
public interface Node {
	
	// ritorno tutto l'albero che ha come radice il nodo
	String toPrint(String indent);
	
	// fa il type cheking e ritorna:
	// per una espressione, il suo tipo (oggetto BoolTypeNode o IntTypeNode)
	// per una dichiarazione, null 
	Node typeCheck();

	String codeGeneration();
	
}
