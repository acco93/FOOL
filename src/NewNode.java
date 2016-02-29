import java.util.ArrayList;

public class NewNode implements Node{

	// id della classe che sto istanziando
	private String classId;
	// class entry che la descrive
	private CTEntry entry;
	// argomenti passati alla new
	private ArrayList<Node> argList;

	
	public NewNode(String classId,CTEntry entry, ArrayList<Node> parList) {
		this.classId = classId;
		this.entry = entry;
		this.argList = parList;
	}

	@Override
	public String toPrint(String indent) {
		String string = ""+indent;
		string+="NewNode "+this.classId+"\n";
		string+=this.entry.toPrint(indent+"  ");
		for(int i=0;i<argList.size();i++){
			string+=this.argList.get(i).toPrint(indent+"  ");
		}
		return string;
	}

	@Override
	public Node typeCheck() {
	
		// controllo che il numero degli argomenti passati sia quello richiesto
		if(this.entry.getAllFields().size()!=argList.size()){
			System.out.println("Wrong number of parameters in the creation of an object of class "+this.classId);
			System.exit(0);
		}
		
		// recupero i tipi dei campi tramite campo allFields della CTentry
		for(int i=0;i<this.entry.getAllFields().size();i++){
			DecNode d = (DecNode) this.entry.getAllFields().get(i);
			if(!FOOLLib.isSubType(argList.get(i).typeCheck(),d.getSymType())){
				System.out.println("Wrong type for "+i+"-th parameter in the creation of an object of class "+this.classId);
				System.exit(0);
				
			}
		}
		
		return new ClassTypeNode(classId);
	}

	@Override
	public String codeGeneration() {
		String code="# creazione oggetto di classe "+this.classId+"\n";
		// mi richiamo su tutti i parametri
		for(int i=0;i<this.argList.size();i++){
			code+="# pusho l'"+i+"-esimo parametro della new sullo stack\n";
			code+=this.argList.get(i).codeGeneration();
		}
		// alloco un nuovo oggetto nello heap
		// poppo i parametri e quindi li metto nello heap dall'ultimo al primo
		// (ps. non ho istruzioni per gestire lo heap direttamente)
		
		
		for(int i=0;i<this.argList.size();i++){
			// pusho l'hp sullo stack
			code+="# salvo l'"+(this.argList.size()-1-i)+"-esimo campo nell'heap\n";
			code+="lhp\n";
			// store word: poppa due valore, e memorizza il secondo all'indirizzo del primo
			code+="sw\n";
			// ora ho il parametro nell'heap, devo incrementare l'heap pointer => lo carico e sommo 1
			code+="# incremento hp\n";
			code+="lhp\n";
			code+="push 1\n";
			code+="add\n";
			// salvo il valore
			code+="# salvo hp\n";
			code+="shp\n";
		}
		
		// lascio sullo stack l'object pointer (subito dopo i parametri che punta al primo metodo, vedi layout)
		code+="# metto hp sullo stack (object pointer)\n";
		code+="lhp\n";
		
		// ora tratto i metodi (dispatch table)

		for(int i=0;i<this.entry.getAllMethods().size();i++){
			MethodNode m = (MethodNode) this.entry.getAllMethods().get(i);
			String label = m.getLabel();
			code+="# metto l'indirizzo dell'"+i+"-esimo metodo nell'heap \n";
			// pusho la label
			code+="push "+label+" \n";
			// pusho l'hp sullo stack
			code+="lhp\n";
			// salvo l'indirizzo del metodo a dove punta hp
			code+="sw\n";
			// hp++
			code+="# incremento hp\n";
			code+="lhp\n";
			code+="push 1\n";
			code+="add\n";
			// salvo hp
			code+="# salvo hp\n";
			code+="shp\n";
		}
		
		// caso particolare: classe senza campi ne metodi
		if(this.entry.getAllFields().size()==0 && this.entry.getAllMethods().size()==0){
			code+="# caso particolare: classe senza campi ne metodi\n";
			//occupo uno spazietto
			code+="# incremento hp\n";
			code+="lhp\n";
			code+="push 1\n";
			code+="add\n";
			// salvo il valore
			code+="# salvo hp\n";
			code+="shp\n";
		}
		
		return code;
	}

}
