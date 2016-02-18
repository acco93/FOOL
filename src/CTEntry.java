import java.util.ArrayList;
import java.util.HashMap;

public class CTEntry {

	// la virtual table mappa simboli dichiarati dentro la
	// classe o ereditati (se non hanno subito overriding)
	// in loro STentry
	private HashMap<String, STEntry> virtualTable;

	// ad ogni campo incontrato DECREMENTO
	private int offsetFields;

	// ad ogni metodo incontrato INCREMENTO
	private int offsetMethods;

	// contiene tutti i figli virtuali che sono campi.
	// Essi sono ordinati in base al loro offset che viene mappato
	// nelle posizioni dell'array come: -(offsetCampo)-1
	private ArrayList<Node> allFields;

	// contiene tutti i figli virtuali che sono metodi.
	// Essi sono ordinati in base al loro offset e sono mappati nell'
	// array come: offset metodo
	private ArrayList<Node> allMethods;

	// costruttore vuoto, caso in cui non eredito da alcuna classe
	CTEntry() {
		this.virtualTable = new HashMap<String, STEntry>();
		this.offsetFields = -1;
		this.offsetMethods = 0;
		this.allFields = new ArrayList<Node>();
		this.allMethods = new ArrayList<Node>();
	}

	// costruttore copie, se eridito da qualcuno
	CTEntry(CTEntry entry) {
		this.virtualTable = new HashMap<String,STEntry>(entry.getVirtualTable());
		this.offsetFields = entry.getOffsetFields();
		this.offsetMethods = entry.getOffsetMethods();
		this.allFields = new ArrayList<Node>(entry.getAllFields());
		this.allMethods = new ArrayList<Node>(entry.getAllMethods());
		
	}

	public HashMap<String, STEntry> getVirtualTable() {
		return virtualTable;
	}

	public int getOffsetFields() {
		return offsetFields;
	}

	public int getOffsetMethods() {
		return offsetMethods;
	}

	public ArrayList<Node> getAllFields() {
		return allFields;
	}

	public ArrayList<Node> getAllMethods() {
		return allMethods;
	}

	// vado ad aggiungere un campo realmente della classe, non ereditato da nessuno
	// esso va quindi aggiunto alla virtual table (se non esiste) oppure va fatto l'overriding
	// di quello ereditato
	public FieldNode addField(String name, Node type) {
		
		STEntry lastEntry = this.virtualTable.get(name);
		STEntry entry;
		FieldNode field = new FieldNode(name, type);
		if(lastEntry != null){
			// caso 1: il campo esiste già nella virtual table => overriding (lo aggiorno)
			// leggo l'offset che era stato assegnato
			int offset = lastEntry.getOffset();
			// creo una nuova STEntry che sostituisce la precedente
			entry = new STEntry(1,type,offset);
			// sostituisco anche in allFields
			
			this.allFields.set(-(offset)-1, field);
		} else {
			// caso 2: campo nuovo
			
			// creo una nuova STENtry
			// il nesting level è per forza 1
			// utilizzo l'offset dei campi al quale ero arrivato
			entry = new STEntry(1,type,this.offsetFields);
			// il quale va decrementato (in base al layout dell'oggetto)
			this.offsetFields--;
			// aggiungo semplicemente in fondo
			this.allFields.add(field);
		}
		
		// inserisco l'entry nella virtual table
		this.virtualTable.put(name, entry);
		return field;
		
	}

	public void addMethod(String name, MethodNode method) {
        
        STEntry lastEntry = this.virtualTable.get(name);
		STEntry entry;
		
		if(lastEntry != null){
			
			int offset = lastEntry.getOffset();
			entry = new STEntry(1,method.getSymType(),offset);
			this.allMethods.set(offset, method);
		} else {
			entry = new STEntry(1,method.getSymType(),this.offsetMethods);
			entry.isMethod();
			this.offsetMethods++;
			this.allMethods.add(method);
			
		}
		
		this.virtualTable.put(name, entry);
	
		
	}

	public String toPrint(String string) {
		return "";
	}


	
}
