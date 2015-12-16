
public class FOOLLib {
	//contiene funzioni ausiliarie
	
	private static int labelCounter=0;
	private static int functionLabelCounter = 0;
	
	private static String functionsCode ="";
	
	//valuta se il tipo di a <= del tipo b
	public static boolean isSubType(Node a, Node b){
		//verifica se una classe è un nipote di un'altra classe
		
	
		// == controlla i riferimenti mentre equals i contenuti degli oggetti
		return a.getClass().equals(b.getClass()) || (a instanceof BoolTypeNode && b instanceof IntTypeNode);
		
	}
	
	public static String freshLabel(){
		return "label"+(labelCounter++);
	}

	public static String freshFunctionLabel() {
		return "function"+(functionLabelCounter ++);
	} 
	
	public static void putCode(String functionCode){
		functionsCode+="\n"+functionCode;
	}

	public static String getCode() {
		return functionsCode;
	}
	
}
