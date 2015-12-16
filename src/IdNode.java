
public class IdNode implements Node {

	private String id;
	private STEntry entry;
	private int nestingLevel;
	
	
	IdNode(String id, STEntry entry, int nestingLevel){
		this.id = id;
		this.entry = entry;
		//questo è il nesting level di dove sono usati, nella entry c'è quello della dichiarazione
		this.nestingLevel = nestingLevel;
	}
	
	@Override
	public String toPrint(String indent) {
		//aggiungere come figlio la stampa dell'STEntry
		return indent+"Id: "+this.id+" at nesting level "+this.nestingLevel+"\n"+
				this.entry.toPrint(indent+"  ");
	}

	@Override
	public Node typeCheck() {
		if(this.entry.getType() instanceof ArrowTypeNode){
			System.out.println("Wrong usage of function identifies");
			System.exit(0);
		}
		
		return entry.getType();
	}

	@Override
	public String codeGeneration() {
		// tramite la symbol table recupero l'offset
		// il frame pointer mi fa da punto fisso con il quale usare gli offset
		
		//se l'id non è dichiarato localmente =>
		// il nesting level della dichiarazione è this.entry.getNestingLevel();
		// quello di dove uso è this.nestingLevel
		
		//se la differenza è >= devo seguire l'access link che è puntato dal frame pointer
		// lo faccio facendo lfp e poi lw lw lw tante volte quanto è la differenza
		// in questo caso lw mi da l'indirizzo dell'access point più in alto
		
		String getAR = "";
		for(int i=0;i<this.nestingLevel-this.entry.getNestingLevel();i++){
			getAR+="lw\n";
		}
		
		
		return 	"push "+this.entry.getOffset()+"\n"+
				//lo devo sommare al valore del registro fp
				// carico fp
				"lfp\n"+
				getAR+	//risalgo la catena statica
				// lo sommmo
				"add\n"+
				//ora ho calcolato l'indirizzo dove andare a prendere il valoredella var
				// lw si aspetta un indirizzo sulla cima dello stack e va prendere il valore che c'è a quell'indirizzo e 
				// lo sostituisce alla cima dello stack
				"lw\n"
				;
	}

}
