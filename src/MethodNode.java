import java.util.ArrayList;

public class MethodNode implements Node, DecNode {

	// nome del metodo
	private String id;

	// tipo di ritorno
	private Node type;

	// parametri
	private ArrayList<Node> parameters;

	// dichiarazioni
	private ArrayList<Node> declarations;

	// corpo del metodo
	private Node body;

	// tipo messo in Symbol Table
	private Node symType;
	
	// label utilizzata durante la generazione di codice
	private String label;
	
	MethodNode(String id, Node type) {
		this.id = id;
		this.type = type;
		this.parameters = new ArrayList<Node>();
		this.declarations = new ArrayList<Node>();
	}


	public void addParameter(Node parameter) {
		parameters.add(parameter);
	}

	public void addDec(ArrayList<Node> declarations) {
		this.declarations = declarations;
	}

	public void addBody(Node body) {
		this.body = body;
	}

	public void addSymType(Node functionType) {
		this.symType = functionType;
	}

	@Override
	public String toPrint(String indent) {
		String result = indent + "Method: " +
						this.id + "\n" + this.type.toPrint(indent + "  ");
		for (int i = 0; i < parameters.size(); i++) {
			result += parameters.get(i).toPrint(indent + "  ");
		}
		for (int i = 0; i < declarations.size(); i++) {
			result += declarations.get(i).toPrint(indent + "  ");
		}
		result += this.body.toPrint(indent + "  ");
		return result;
	}

	@Override
	public Node getSymType() {
		return this.symType;
	}

	// setto la label (definita dalla classe)
	public void setLabel(String label){
		this.label = label;
	}
	
	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		// come per le funzioni

		/* Corpo della funzione:
		 * la chiamata mi setta il CL, i parametri e l'AL ora devo sistemare il
		 * return address e eventuali dichiarazioni.
		 * Il RA viene salvato da JS nel registro RA quindi mi basta pusharlo.
		 */
		
		String address = this.label;
		
		String declarationsCode="";
		String popDec="";
		String popPar ="";
		
		/*
		 * Creo il codice per le dichiarazioni
		 * */
		
		for(int i=0;i<this.declarations.size();i++){
			declarationsCode+=this.declarations.get(i).codeGeneration();
		}
		
		/*
		 * Creo i pop per la deallocazione delle dichiarazioni
		 * */

		for(Node dec:declarations){
			popDec+="pop\n";
			// se la dichiarazione ha tipo funzione devo eliminare sia l'indirizzo che il suo FP (TODO: non possono esserci dichiarazioni di fun credo)
			if(((DecNode)dec).getSymType() instanceof ArrowTypeNode){
				popDec+="pop\n";
			}
		}
		
		/*
		 * Creo i pop per la deallocazione dei parametri
		 * */
		
		for(Node par:parameters){
			popPar+="pop\n";
			if(((DecNode)par).getSymType() instanceof ArrowTypeNode){
				popPar+="pop\n";
			}
		}
		
		/*
		 * Il codice della funzione verrà inserito in fondo nell'assembly.
		 * */
		
		
		FOOLLib.putCode(	address+":\n"+
							//aggiungo quello che manca dell'AR: dal return address in poi
							"cfp\n"+	//ora sto puntanto all'AL => devo settare il FP per questo AR a questo indirizzo quindi FP = SP
							"lra\n"+	//metto il return address che è in RA sullo stack. JS della chiamata copia l'IP e lo mette in RA
							"# Dichiarazioni del metodo \n"+
							declarationsCode	+	//ora metto le dichiarazioni
							"# Body del metodo\n"+
							this.body.codeGeneration()+	//chiamo il corpo della funzione
							"srv\n"	+	// salvo il risultato in un registro
										//disalloco tutto e risalto a chi mi ha chiamato
							popDec +	//poppo le dichiarazioni
							"sra\n"+	//salvo il return address e lo poppo
							"pop\n"+	//pop dell'AL
							popPar+		//poppo i parametri
										//nel control link c'è il frame pointer del chiamante
							"sfp\n"+	//ripristino il frame pointer
							"lrv\n"+	//metto il return value sullo stack
							"lra\n"+	//metto ra sullo stack che poi uso per saltare
							"js\n"		//salto all'indirizzo che c'è sul top dello stack
				);
		
		
		return  "";	
		
	}


	public String getLabel() {
		return this.label;
	}

}
