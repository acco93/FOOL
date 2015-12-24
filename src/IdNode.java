
public class IdNode implements Node {

	private String id;
	// l'entry della dichiarazione dell'ID
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
		//ora è permesso che esistano IdNode di tipo funzione
		
		/*if(this.entry.getType() instanceof ArrowTypeNode){
			System.out.println("Wrong usage of function identifier");
			System.exit(0);
		}*/
		
		return entry.getType();
	}

	@Override
	public String codeGeneration() {
		
		/* IdNode rappresenta un qualsiasi ID -> variabile o funzione.
		 * La entry collegata mi individua la dichiarazione di questo ID (grazie al lavoro fatto durante la creazione
		 * della symbol table). Per recuperare il valore della variabile o FP e ind funzione
		 * utilizzo il frame pointer FP (punto fisso sul quale posso contare) che qualcuno avrà settato.
		 * Se l'ID è dichiarato localmente allora semplicemente lo raggiungo tramite il
		 * FP e l'offset. Nel caso in cui non lo sia devo risalire la catena statica e andare
		 * a recuperare i valori/e nell'AR della dichiarazione.
		 * Per risalire la catena statica si fa nel solito modo:
		 * FP mi punta all'AL (che è a offset 0) => pusho FP sullo stack
		 * faccio delle lw tante volte quanto è lvl_nesting_utilizzo - lvl nesting_dichiarazione
		 * */
		
		// mi preparo gli lw per la risalita
		String getAR = "";
		for(int i=0;i<this.nestingLevel-this.entry.getNestingLevel();i++){
			getAR+="lw\n";
		}
		
		/*
		 * Se l'ID ha tipo funzionale allora devo recuperare due cose.
		 * Faccio un if per leggibilità.
		 * */
		
		String code = "# ID "+this.id+"\n";
		
		if(this.entry.getType() instanceof ArrowTypeNode){
			
			System.out.println("ID funzionale "+this.id);
			System.out.println("offset "+this.entry.getOffset());
			System.out.println(this.toPrint(">___"));
			code += "push "+(this.entry.getOffset())+"\n"+
					"lfp\n"+
					getAR+
					"add\n"+
					"lw\n"+	//recupero il valore del FP
					
					"push "+(this.entry.getOffset()-1)+"\n"+
					"lfp\n"+
					getAR+
					"add\n"+
					"lw\n";	//recupero l'indirizzo della funzione
		} else {
			code += "push "+this.entry.getOffset()+"\n" +
					"lfp\n"+
					getAR+
					"add\n"+
					"lw\n";			
		}
		
		return code;

	}

}
