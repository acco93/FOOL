import java.util.ArrayList;

public class FunNode implements Node, DecNode {

	// nome della funzione
	private String id;
	
	// tipo di ritorno
	private Node type;
	
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
		this.type = type;
		this.parameters = new ArrayList<Node>();
		this.declarations = new ArrayList<Node>();
	}
	
	//mi serve un metodo per riempire la lista di paramtri
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
						this.type.toPrint(indent+"  ");
		for(int i=0;i<parameters.size();i++){
			result+=parameters.get(i).toPrint(indent+"  ");
		}
		//if(declarations!=null) ho inizializzato l'array nel costruttore
		for(int i=0;i<declarations.size();i++){
			result+=declarations.get(i).toPrint(indent+"  ");
		}
		result+=this.body.toPrint(indent+"  ");
		return result;
	}

	@Override
	public Node typeCheck() {
		
		// per i parametri non devo controllare nulla
		
		if(!FOOLLib.isSubType(this.body.typeCheck(), type)){
			System.out.println("Wrong return type for function "+this.id);
			System.exit(0);
			
		}
		
		//if(declarations!=null)//devo controllare il caso in cui non ci sono dichiarazioni
		for(Node node:this.declarations){
			node.typeCheck();
		}
		
		return this.type;
	}

	@Override
	public String codeGeneration() {
		String address = FOOLLib.freshFunctionLabel();
		
		String code="";
		String popDec="";
		String popPar ="";
		
		for(int i=0;i<this.declarations.size();i++){
			code+=this.declarations.get(i).codeGeneration();
			popDec+="pop\n";
		}
		
		for(int i=0;i<this.parameters.size();i++){
			popPar+="pop\n";
		}
		
		
		
		
		FOOLLib.putCode(address+":\n"+
							//aggiungo quello che manca dell'AR: dal return address in poi
							"cfp\n"+	//setta il registro fp
							"lra\n"+		//metto il return address che è in RA nello stack
							code	+	//ora metto le dichiarazioni
							this.body.codeGeneration()+	//chiamo il corpo della funzione
							"srv\n"	+	// salvo il risultato in un registro
										//disalloco tutto e risalto a chi mi ha chiamato
							popDec +	//poppo le dichiarazioni
							"sra\n"+	//salvo il return address
							"pop\n"+		//pop dell'AL
							popPar+		//poppo i parametri
										//nel control link c'è il frame pointer del chiamante
							"sfp\n"+	//ripristino il frame pointer
							"lrv\n"+		//metto il return value sullo stack
							"lra\n"+			//metto ra sullo stack che poi uso per saltare
							"js\n"		//salto all'indirizzo che c'è sul top dello stack
				);
		
		return "push "+address +"\n";
		
		//devo anche generare il codice della funzione a qualche indirizzo più avanti
	}

	@Override
	public Node getSymType() {
		return this.symType;
	}

}
