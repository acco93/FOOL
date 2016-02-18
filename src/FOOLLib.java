import java.util.ArrayList;
import java.util.HashMap;

public class FOOLLib {
	// contiene funzioni ausiliarie

	private static int labelCounter = 0;
	private static int functionLabelCounter = 0;

	private static String functionsCode = "";
	private static HashMap<String, String> superType;

	// valuta se il tipo di a <= del tipo b
	public static boolean isSubType(Node a, Node b) {

		// verifica se una classe è un nipote di un'altra classe

		boolean result;

		// se a e b hanno tipo funzionale
		if (a instanceof ArrowTypeNode && b instanceof ArrowTypeNode) {
			// relazione di co-varianza sul tipo di ritorno
			// cioè posso prendere un tipo di ritorno più specifico

			Node a_ret = ((ArrowTypeNode) a).getRet();
			Node b_ret = ((ArrowTypeNode) b).getRet();
			boolean result_ret = FOOLLib.isSubType(b_ret, a_ret);

			// relazione di contro-varianza sul tipo dei parametri
			// cioè posso prendere un argomenti più generali

			ArrayList<Node> a_par = ((ArrowTypeNode) a).getParList();
			ArrayList<Node> b_par = ((ArrowTypeNode) b).getParList();

			boolean result_par = true;

			for (int i = 0; i < a_par.size(); i++) {
				result_par &= FOOLLib.isSubType(a_par.get(i), b_par.get(i));
			}

			result = result_ret && result_par;

		} else if (a instanceof ClassTypeNode && b instanceof ClassTypeNode) {

			// se sono entrambi classi vado a vedere le relazioni nella mappa
			// superType
			String classA = ((ClassTypeNode) a).getType();
			String classB = ((ClassTypeNode) b).getType();

			// devo controllare che a sia sottotipo (o uguale) di b
			
			
			if (classA.equals(classB)) {
				// caso 1: è un oggetto della stessa classe
				result = true;
			} else {
				// caso 2: è un sottotipo
				// risalgo la mappa finche non incontro b (se lo incontro)
				result = false;
				String currentClass = classA;
				String superClass = null;
				do {

					superClass = FOOLLib.superType.get(currentClass);

					if (superClass != null && superClass.equals(classB)) {
						result = true;
					}
					currentClass = superClass;
				} while (result == false && superClass != null);

			}

		} else if (a instanceof EmptyTypeNode && b instanceof ClassTypeNode) {
			// oppure se a è null => è sottotipo di qualsiasi classe
			result = true;
		} else {
			// altrimenti faccio il controllo di subtyping normale
			result = a.getClass().equals(b.getClass()) || (a instanceof BoolTypeNode && b instanceof IntTypeNode);

			// == controlla i riferimenti mentre equals i contenuti degli
			// oggetti
		}

		return result;

	}

	public static String freshLabel() {
		return "label" + (labelCounter++);
	}

	public static String freshFunctionLabel() {
		return "function" + (functionLabelCounter++);
	}

	public static void putCode(String functionCode) {
		functionsCode += "\n" + functionCode;
	}

	public static String getCode() {
		return functionsCode;
	}

	public static void setSuperTypeMap(HashMap<String, String> superType) {
		FOOLLib.superType = superType;

	}

}
