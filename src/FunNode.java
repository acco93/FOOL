import java.util.ArrayList;

public class FunNode implements Node, DecNode {

	// nome della funzione
	private String id;
	
	// tipo di ritorno
	private Node retType;
	
	// arraylist di parametri
	private ArrayList<Node> parameters;
	
	// dichiarazioni
	private ArrayList<Node> declarations;
	
	// corpo della funzione
	private Node body;	
	
	// tipo messo in Symbol Table
	private Node symType;
	
	FunNode(String id, Node type){
		this.id = id;
		this.retType = type;
		this.parameters = new ArrayList<Node>();
		this.declarations = new ArrayList<Node>();
	}
	
	//mi serve un metodo per riempire la lista di parametri
	//li aggiungo uno alla volta dopo
	
	public void addParameter(Node parameter){
		parameters.add(parameter);
	}
	
	public void addDec(ArrayList<Node> declarations){
		this.declarations = declarations;
	}
	
	public void addBody(Node body){
		this.body = body;
	}
	
	public void addSymType(Node functionType){
		this.symType = functionType;
	}
	
	@Override
	public String toPrint(String indent) {
		
		String result=	indent+
						"Fun: "+this.id+"\n"+
						this.retType.toPrint(indent+"  ");
		for(int i=0;i<parameters.size();i++){
			result+=parameters.get(i).toPrint(indent+"  ");
		}
		
		for(int i=0;i<declarations.size();i++){
			result+=declarations.get(i).toPrint(indent+"  ");
		}
		result+=this.body.toPrint(indent+"  ");
		return result;
	}

	@Override
	public Node typeCheck() {
		
		// per i parametri non devo controllare nulla perchè sono solo definizioni del tipo che voglio
		
		if(!FOOLLib.isSubType(this.body.typeCheck(), retType)){
			System.out.println("Wrong return type for function "+this.id);
			System.exit(0);
			
		}
		
		for(Node node:this.declarations){
			node.typeCheck();
		}
		
		return this.retType;
	}

	@Override
	public String codeGeneration() {
	
		/* Corpo della funzione:
		 * la chiamata mi setta il CL, i parametri e l'AL ora devo sistemare il
		 * return address e eventuali dichiarazioni.
		 * Il RA viene salvato da JS nel registro RA quindi mi basta pusharlo.
		 */
		
		String address = FOOLLib.freshFunctionLabel();
		
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
			// se la dichiarazione ha tipo funzione devo eliminare sia l'indirizzo che il suo FP
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
							"# Dichiarazioni della funzione \n"+
							declarationsCode	+	//ora metto le dichiarazioni
							"# Body della funzione\n"+
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
		
		
		// questo codice viene inserito nelle dichiarazioni
		return  "# code generation FUN NODE "+this.id+"\n"
				+ "lfp\n" +				// pusho l'FP a questo AR per poter successivamente recuperare il contesto
				"push " +address +"\n";	// pusho l'indirizzo della funzione
	
		
	}

	@Override
	public Node getSymType() {
		return this.symType;
	}

}
