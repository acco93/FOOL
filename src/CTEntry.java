import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

	// insieme che contiene i metodi/campi dichiarati da questa classi e non dei quali
	// è stato fatto override
	HashSet<Integer> locals;
	
	// costruttore vuoto, caso in cui non eredito da alcuna classe
	CTEntry() {
		this.virtualTable = new HashMap<String, STEntry>();
		this.offsetFields = -1;
		this.offsetMethods = 0;
		this.allFields = new ArrayList<Node>();
		this.allMethods = new ArrayList<Node>();
		this.locals = new HashSet<Integer>();
	}

	// costruttore copia, se eridito da qualcuno copio tutte le sue info
	CTEntry(CTEntry entry) {
		this.virtualTable = new HashMap<String,STEntry>(entry.getVirtualTable());
		this.offsetFields = entry.getOffsetFields();
		this.offsetMethods = entry.getOffsetMethods();
		this.allFields = new ArrayList<Node>(entry.getAllFields());
		this.allMethods = new ArrayList<Node>(entry.getAllMethods());
		this.locals = new HashSet<Integer>();
		
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
		int offset;
		
		if(lastEntry != null){
			// caso 1: il campo esiste già nella virtual table => overriding (lo aggiorno)
			
			// leggo l'offset che era stato assegnato
			offset = lastEntry.getOffset();
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
			offset = this.offsetFields;
			// il quale va decrementato (in base al layout dell'oggetto)
			this.offsetFields--;
			// aggiungo semplicemente in fondo
			this.allFields.add(field);
		}
		
		// inserisco l'entry nella virtual table
		this.virtualTable.put(name, entry);
		
		// controllo che non sia già stato definito (tramite locals e l'offset)
		
		if(!this.locals.add(offset)){
			// ritorna true se non era presente
			System.out.println("Error: field "+name+ " declared twice!");
			System.exit(0);
		}
		
		return field;
		
	}

	public void addMethod(String name, MethodNode method) {
        
        STEntry lastEntry = this.virtualTable.get(name);
		STEntry entry;
		
		int offset;
		
		if(lastEntry != null){
			offset = lastEntry.getOffset();
			entry = new STEntry(1,method.getSymType(),offset);
			this.allMethods.set(offset, method);
		} else {
			entry = new STEntry(1,method.getSymType(),this.offsetMethods);
			offset = this.offsetMethods;
			entry.isMethod();
			this.offsetMethods++;
			this.allMethods.add(method);
			
		}
		
		entry.setAsMethod();
		this.virtualTable.put(name, entry);
	
		if(!this.locals.add(offset)){
			System.out.println("Error: method "+name+ " declared twice!");
			System.exit(0);
		}
		
	}

	public String toPrint(String indent) {
		return 	indent+"CTEntry: virtualTable = "+this.virtualTable.toString()+"\n"+
				indent+"CTEntry: offsetFields = "+this.offsetFields+"\n"+
				indent+"CTEntry: offsetMethods = "+this.offsetMethods+"\n"+
				indent+"CTEntry: locals = "+this.locals.toString()+"\n";
	}

	public HashSet<Integer> getLocals() {
		return this.locals;
	}


	
}
