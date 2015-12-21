import java.util.ArrayList;


public class CallNode implements Node {

	// nome della funzione chiamata
	private String id;
	// entry contenente l'ArrowTypeNode della funzione
	private STEntry entry;
	// argomenti passati alla chiamata
	private ArrayList<Node> argList;
	// nesting level della chiamata della funzione, nella entry c'è quello della dichiarazione
	private int nestingLevel;
	
	CallNode(String id, STEntry entry, ArrayList<Node> argList, int nestingLevel){
		this.id = id;
		this.entry = entry;
		this.argList = argList;
		this.nestingLevel=nestingLevel;
	}

	@Override
	public String toPrint(String indent) {
		String string = indent+"Call: "+this.id+" at nesting level "+this.nestingLevel+"\n";
		string += this.entry.toPrint(indent+"  ");
		for(int i=0;i<argList.size();i++){
			string += this.argList.get(i).toPrint(indent+"  ");
		}
		return string;
	}

	@Override
	public Node typeCheck() {
		
		if(!(this.entry.getType() instanceof ArrowTypeNode)){
			System.out.println("Invocation of a non-function "+this.id);
			System.exit(0);
		}
	
		// tipo di ritorno della funzione definito nella dichiarazione
		ArrowTypeNode type = (ArrowTypeNode) this.entry.getType();
		Node node = type.getRet();
		
		// lista dei tipi dei parametri formali definiti nella dichiarazione
		ArrayList<Node> parList = type.getParList();
		
		if(parList.size()!=argList.size()){
			System.out.println("Wrong number of parameters in the invocation of "+this.id);
			System.exit(0);
		}
		
		for(int i=0;i<parList.size();i++){
			// il tipo degli argomenti deve essere <= del tipo dei parametri formali
			// argList sono espressioni => devo valutarle e ottenere il tipo con il typecheck
			if(!FOOLLib.isSubType(argList.get(i).typeCheck(),parList.get(i))){
				System.out.println("Wrong type for "+i+"-th parameter in the invocation of "+this.id);
				System.exit(0);
				
			}
		}
		
		//ritorno il tipo dichiarato dentro arrowTypeNode
		return node;
	}

	@Override
	public String codeGeneration() {
		// chiamata di una funzione, costruisce la prima
		// parte dell'activation record della funzione che sto invocando
		// setta la parte di layout fino al framepointer: i parametri, il frame pointer del chiamante e l'access link
		// vedi il layout
		
		String code = "";
		
		//inserisco il control link = framepointer al frame del chiamante, è nel registro fp, lo metto sullo stack
		code +="lfp\n";
		
		//metto i parametri in ordine inverso, che sono in parList
		for(int i=this.argList.size()-1;i>=0;i--){
			//dopo aver inserito il codice di tutti gli n parametri => sullo stack abbiamo gli n risultati
			code+=this.argList.get(i).codeGeneration();
		}
		
		//ora setto l'access link, il nuovo access link si trova:
		//l'access link deve puntare al frame della dichiarazione di quella funzione
		//salgo la catena statica degli AL tante volte quante la differenza di:
		//lvl nesting di questo nodo chiamante e lvl nesting di dove è definita la funzione
		
		String getAR = "";
		for(int i=0;i<this.nestingLevel-this.entry.getNestingLevel();i++){
			getAR+="lw\n";
		}
		
		//se siamo di pari lvl => l'access link è quello del chiamante
		
		code+="lfp\n"+getAR;
		
		//recupero l'indirizzo della funzione
		// lo trovo nell AR della dichiarazione della funzione e usare l'offset 
		
		code+= "push "+this.entry.getOffset()+"\n"+
				//lo devo sommare al valore del registro fp
				// carico fp
				"lfp\n"+
				getAR+	//risalgo la catena statica
				// lo sommmo
				"add\n"+
				//ora ho calcolato l'indirizzo dove andare a prendere l'indirizzo della funzione
				// lw si aspetta un indirizzo sulla cima dello stack e va prendere il valore che c'è a quell'indirizzo e 
				// lo sostituisce alla cima dello stack
				"lw\n"
				;
		
		//ora sono pronto a saltare
		//
		code+="js\n";
		
		
		return code;
	}
	


}
