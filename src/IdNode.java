import java.util.HashMap;

public class IdNode implements Node {

	private String id;
	// l'entry della dichiarazione dell'ID
	private STEntry entry;
	// nesting level dell'utilizzo
	private int nestingLevel;
	
	
	IdNode(String id, STEntry entry, int nestingLevel){
		this.id = id;
		this.entry = entry;
		//questo è il nesting level di dove è usato l'ID, nella entry c'è quello della dichiarazione
		this.nestingLevel = nestingLevel;
	}
	
	@Override
	public String toPrint(String indent) {
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
		
		// controllo che non sia un metodo
		if(this.entry.isMethod()){
			System.out.println("Wrong usage of method identifier");
			System.exit(0);
		}
		// o null
		
		if(this.id.equals("null")){
			System.out.println("Wrong usage of class identifier");
			System.exit(0);
		}
		
		return entry.getType();
	}

	@Override
	public String codeGeneration() {
		
		/* IdNode rappresenta un qualsiasi ID -> variabile o funzione.
		 * La entry collegata mi individua la dichiarazione di questo ID (grazie al lavoro fatto durante la creazione
		 * della symbol table). Per recuperare il valore della variabile o FP e ind funzione
		 * utilizzo il frame pointer FP (punto fisso sul quale posso contare) che qualcuno avrà settato (la chiamata a funzione).
		 * Se l'ID è dichiarato localmente allora semplicemente lo raggiungo tramite il
		 * FP e l'offset. Nel caso in cui non lo sia devo risalire la catena statica e andare
		 * a recuperare i valori/e nell'AR della dichiarazione.
		 * Per risalire la catena statica si fa nel solito modo:
		 * FP mi punta all'AL (che è a offset 0) => pusho FP sullo stack
		 * faccio delle lw tante volte quanto è lvl_nesting_utilizzo - lvl nesting_dichiarazione
		 * */
		
		// mi preparo gli lw per la risalita
		String getAR = "# risalgo la catena statica "+ (this.nestingLevel-this.entry.getNestingLevel()) +" volte\n";
		for(int i=0;i<this.nestingLevel-this.entry.getNestingLevel();i++){
			getAR+="lw\n";
		}
		
		/*
		 * Se l'ID ha tipo funzionale allora devo recuperare due cose.
		 * */

		String code = "# ID "+this.id+"\n";
		
		if(this.entry.getType() instanceof ArrowTypeNode){
			// caso ID funzionale
			code += "# ID funzionale\n";
			code += "# recupero il valore del FP\n";
			code += "push "+(this.entry.getOffset())+"\n"+
					"lfp\n"+
					getAR+
					"add\n"+
					"lw\n"+	//recupero il valore del FP
					
					"# recupero l'indirizzo della funzione \n"+
					"push "+(this.entry.getOffset()-1)+"\n"+
					"lfp\n"+
					getAR+
					"add\n"+
					"lw\n";	//recupero l'indirizzo della funzione
		} else {
			// caso ID normale
			code += "# ID normale (non funzionale) recupero il valore\n";
			code += "push "+this.entry.getOffset()+"\n" +
					"lfp\n"+
					getAR+
					"add\n"+
					"lw\n";			
		}
		
		return code;

	}

}
