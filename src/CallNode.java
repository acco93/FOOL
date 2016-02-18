import java.util.ArrayList;

public class CallNode implements Node {

	// nome della funzione chiamata
	private String id;
	// entry contenente l'ArrowTypeNode della funzione
	private STEntry entry;
	// argomenti passati alla chiamata
	private ArrayList<Node> argList;
	// nesting level della chiamata della funzione, nella entry c'è quello della
	// dichiarazione
	private int nestingLevel;

	CallNode(String id, STEntry entry, ArrayList<Node> argList, int nestingLevel) {
		this.id = id;
		this.entry = entry;
		this.argList = argList;
		this.nestingLevel = nestingLevel;
	}

	@Override
	public String toPrint(String indent) {
		String string = indent + "Call: " + this.id + " at nesting level " + this.nestingLevel + "\n";
		string += this.entry.toPrint(indent + "  ");
		for (int i = 0; i < argList.size(); i++) {
			string += this.argList.get(i).toPrint(indent + "  ");
		}
		return string;
	}

	@Override
	public Node typeCheck() {

		if (!(this.entry.getType() instanceof ArrowTypeNode)) {
			System.out.println("Invocation of a non-function " + this.id);
			System.exit(0);
		}

		// tipo di ritorno della funzione definito nella dichiarazione
		ArrowTypeNode type = (ArrowTypeNode) this.entry.getType();
		Node node = type.getRet();

		// lista dei tipi dei parametri formali definiti nella dichiarazione
		ArrayList<Node> parList = type.getParList();

		if (parList.size() != argList.size()) {
			System.out.println("Wrong number of parameters in the invocation of " + this.id);
			System.exit(0);
		}

		for (int i = 0; i < parList.size(); i++) {
			// il tipo degli argomenti deve essere <= del tipo dei parametri
			// formali
			// argList sono espressioni => devo valutarle e ottenere il tipo con
			// il typecheck
			if (!FOOLLib.isSubType(argList.get(i).typeCheck(), parList.get(i))) {
				System.out.println("Wrong type for " + i + "-th parameter in the invocation of " + this.id);
				System.exit(0);

			}
		}

		// ritorno il tipo dichiarato dentro arrowTypeNode
		return node;
	}

	@Override
	public String codeGeneration() {

		/*
		 * Chiamata di una funzione: devo costruire la prima parte
		 * dell'Activation Record della funzione che sto invocando. Devo settare
		 * (in ordine): - CL: indirizzo dell'AR chiamante (che è questo in cui
		 * sono) - parametri: dall'ultimo al primo - AL: indirizzo dell'AR dove
		 * è dichiarata la funzione, per poter recuperare il contesto
		 * 
		 */

		String code = "# CALL NODE di " + this.id + "\n";

		/*
		 * In questo momento sono ancora nell'AR prima della chiamata quindi
		 * quindi FP contiene il puntatore a questo AR che quindi metto sullo
		 * stack nella posizione di CL
		 */

		code += "# Control link\n";
		code += "lfp\n";

		/*
		 * Metto sullo stack i parametri in ordine inverso. La codeGeneration
		 * crea il codice per valutare eventuali espressioni le quali metteranno
		 * alla fine soltanto il risultato.
		 */

		code += "# parametri (" + this.argList.size() + ")\n";
		for (int i = this.argList.size() - 1; i >= 0; i--) {
			code += this.argList.get(i).codeGeneration();
		}

		/*
		 * Ora devo settare l'Access Link cioè il puntatore all'AR dove è
		 * DICHIARATA la funzione. Per trovarso è sufficiente risalire la catena
		 * statica (quella identificata dai precedenti access link) tante volte
		 * quanto è la differenza del livello di nesting di questo nodo
		 * chiamante e il livello di nesting della definizione della funzione:
		 * 
		 * salite = lvl_nesting_chiamata - lvl_nesting_definizione;
		 * 
		 * FP punta di default all'AL cioè l'AL è a offset 0 rispetto al punto
		 * fisso definito da FP allora per risalire la catena degli AL è
		 * sufficiente caricare sullo stack questo FP e fare tanti lw quante
		 * sono le salite da fare.
		 */

		String getAR = "# risalgo la catena statica " + (this.nestingLevel - this.entry.getNestingLevel()) + " volte\n";
		for (int i = 0; i < this.nestingLevel - this.entry.getNestingLevel(); i++) {
			getAR += "lw\n";
		}

		// se siamo di pari lvl => l'access link è quello del chiamante

		// recupero l'indirizzo della funzione
		// lo trovo nell AR della dichiarazione della funzione e usare l'offset

		/*
		 * Le dichiarazioni di funzione (dopo l'high order) occupano due offset
		 * nello stack: - ad offset definito nella sym table è presente l'FP al
		 * loro AR - ad (offset definito nella sym table)-1 è presente
		 * l'indirizzo della funzione
		 */

		if (this.entry.isMethod()) {
			/* Devo recuperare solamente l'indirizzo*/
			code += "push "+this.entry.getOffset()+"\n" +
					"lfp\n"+
					getAR+
					"add\n"+
					"lw\n";			
			
		} else {
			/*
			 * Risalgo la catena statica degli access link e ad offset di sym
			 * table arrivo direttamente sull'FP mentre a quello di sym table -1
			 * trovo l'indirizzo della funzione
			 */
			code += "# setto l'AL\n" +
					"push " +
					(this.entry.getOffset()) + "\n" + // pusho l'offset della dichiarazione della f nel suo AR
					"lfp\n" + // pusho FP (che punta all'AL)
					getAR + // mi permette di risalire la catena statica
					"add\n" + // sommando mi posiziono sull'FP della funzione
					"lw\n" + // ne vado a prendere il valore e lo metto sullo
								// stack,
								// in questo modo setto l'AL per il chiamato
								// cioè vado a dirgli che si riferisce a questo
								// AR in caso ad esempio di variabili libere

			// ora vado a recuperare l'indirizzo della funzione nello stesso
			// modo (spostandomi di -1)
			"# setto l'indirizzo a cui saltare\n" + "push " + (this.entry.getOffset() - 1) + "\n" + "lfp\n" + getAR
					+ "add\n" + "lw\n";

		}
		/*
		 * Ora che ho l'indirizzo in cima allo stack posso saltare al corpo
		 * della funzione JS mi salva l'IP (instruction pointer) in RA (return
		 * address) poppa l'indirizzo della funzione e setta IP al quel valore
		 */

		code += "js\n" + "# ============= \n";

		/*
		 * L'esecuzione della funzione continua in FunNode
		 */

		return code;
	}

}
