import java.util.ArrayList;
import java.util.HashMap;

public class FOOLLib {
	// contiene funzioni ausiliarie

	// label utilizzate dalle condizioni
	private static int labelCounter = 0;
	// label utilizzate per le funzioni
	private static int functionLabelCounter = 0;
	// contiene tutto il codice delle funzioni, verrà aggiunto in fondo all'assembly
	private static String functionsCode = "";
	// map: classID -> superClassID
	private static HashMap<String, String> superType;

	// valuta se il tipo di a <= del tipo b
	public static boolean isSubType(Node a, Node b) {

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

			// == controlla i riferimenti mentre equals i contenuti degli oggetti
		}

		return result;

	}

	public static Node lowestCommonAncestor(Node a, Node b){
		
		// casi particolari: ho un null => torno l'altro
		if(a instanceof EmptyTypeNode){ return b;}
		if(b instanceof EmptyTypeNode){ return a;}
		
		
		if(a instanceof ClassTypeNode && b instanceof ClassTypeNode){
			// se sto lavorando con classi
			
			
			// considero a, risalgo le sue superclassi tramite la map superType
			String currentClassID = ((ClassTypeNode) a).getType();
			
			Node currentType = a;
			String superClassID = null;
			
			do {
		
				// controllo che b non sia un sottotipo della classe attualmente considerata
				if(FOOLLib.isSubType(b, currentType)){
					// nel caso in cui lo sia => ritorno la classe corrente
					return currentType;
				}
				// altrimenti ricavo l'ID della superclasse tramite la map superType
				superClassID = FOOLLib.superType.get(currentClassID);
				currentClassID = superClassID;
				// e con quello costruisco un nodo ClassTypeNode per il tipo della super classe
				// (aggiornando la var utilizzata nel controllo)
				currentType = new ClassTypeNode(superClassID);
				
			} while(superClassID!=null);
			
			
		} else if (a instanceof ArrowTypeNode && b instanceof ArrowTypeNode){
			// se sto lavorando con tipo funzionali (con lo stesso numero di parametri)
			
			ArrowTypeNode typeA = (ArrowTypeNode) a;
			ArrowTypeNode typeB = (ArrowTypeNode) b;
			
			if(typeA.getParList().size() != typeB.getParList().size()){return null;}
			
			// controllo il tipo di ritorno ricorsivamente
			Node retType = FOOLLib.lowestCommonAncestor(typeA.getRet(), typeB.getRet()); 
			if(retType==null) {
				retType = FOOLLib.lowestCommonAncestor(typeB.getRet(), typeA.getRet());
				if(retType == null){
					// fallisco
					return null;
				}
			}
			
			ArrayList<Node> parList = new ArrayList<Node>();
			for(int i=0;i<typeA.getParList().size();i++){
				if(FOOLLib.isSubType(typeA.getParList().get(i), typeB.getParList().get(i))){
					parList.add(typeA.getParList().get(i));
				} else if(FOOLLib.isSubType(typeB.getParList().get(i), typeA.getParList().get(i))){
					parList.add(typeB.getParList().get(i));
				} else
					// fallisco
					return null;
			}
			
			// sono arrivato in fondo, ritorno il tipo lowestCommonAncestor
			return new ArrowTypeNode(parList, retType);
			
		} else {
			// sto lavorando con tipi primitivi (faccio quello che facevo prima)
			
			if(a instanceof IntTypeNode || b instanceof IntTypeNode){
				return new IntTypeNode();
			} else {
				return new BoolTypeNode();
			}

			
		}
			
		return null;
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
