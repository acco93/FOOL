import java.util.ArrayList;

public class FOOLLib {
	//contiene funzioni ausiliarie
	
	private static int labelCounter=0;
	private static int functionLabelCounter = 0;
	
	private static String functionsCode ="";
	
	//valuta se il tipo di a <= del tipo b
	public static boolean isSubType(Node a, Node b){
		
		System.out.println(a + " <= "+ b+" ???");
		
		//verifica se una classe è un nipote di un'altra classe
		
		boolean result;
		
		//se a e b hanno tipo funzionale
		if(a instanceof ArrowTypeNode && b instanceof ArrowTypeNode){
			//relazione di co-varianza sul tipo di ritorno 
			//cioè posso prendere un tipo di ritorno più specifico
			
			Node a_ret = ((ArrowTypeNode)a).getRet();
			Node b_ret = ((ArrowTypeNode)b).getRet();
			boolean result_ret = FOOLLib.isSubType(b_ret, a_ret);
			
			//relazione di contro-varianza sul tipo dei parametri
			//cioè posso prendere un argomenti più generali
			
			ArrayList<Node> a_par = ((ArrowTypeNode)a).getParList();
			ArrayList<Node> b_par = ((ArrowTypeNode)b).getParList();
			
			boolean result_par = true;
			
			for(int i=0;i<a_par.size();i++){
				result_par &= FOOLLib.isSubType(a_par.get(i), b_par.get(i)); 
			}
			
			
			
			result = result_ret && result_par;
			
		} else {
			// altrimenti faccio il controllo di subtyping normale
			result = a.getClass().equals(b.getClass()) || (a instanceof BoolTypeNode && b instanceof IntTypeNode);
			
			// == controlla i riferimenti mentre equals i contenuti degli oggetti				
		}
		
		
		return result;
		
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
