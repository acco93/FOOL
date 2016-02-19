import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ClassNode implements Node, DecNode {

	private ClassTypeNode type;
	// definizione dei metodi definiti dalla classe (non da eventuali super)
	private ArrayList<Node> methods;
	// definizione dei campi definiti dalla classe (non da eventuali super)
	private ArrayList<Node> fields;
	private CTEntry classEntry;
	private CTEntry superEntry;
	
	
	ClassNode(ClassTypeNode type, ArrayList<Node> fields, ArrayList<Node> methods,
				CTEntry classEntry,CTEntry superEntry ){
		this.fields = fields;
		this.methods = methods;
		this.type = type;
		this.classEntry = classEntry;
		this.superEntry = superEntry;
	}
	
	@Override
	public String toPrint(String indent) {
				
		String result=indent+"Class: "+type.getType()+"\n";
		for(int i=0;i<fields.size();i++){
			result+=fields.get(i).toPrint(indent+"  ");
		}
		for(int i=0;i<methods.size();i++){
			result+=methods.get(i).toPrint(indent+"  ");
		}
		return result;
	}

	@Override
	public Node typeCheck() {
		
		System.out.println("class typechecking");
		
		// verifico che effettivamente le espressioni definite nel metodo
		// ritornino il tipo di ritorno dichiarato
		for(int i=0;i<this.methods.size();i++){
			this.methods.get(i).typeCheck();
		}
		
		// in caso di eredetarietà verifico che l'overriding sia corretto (per campi e metodi)
		if(this.superEntry!=null){
			
			// recupero il tipo dei campi dalla CTEntry che descrive la classe
			ArrayList<Node> classFields = this.classEntry.getAllFields();
			// recupero il tipo dei campi dalla CTEntry che descrive la super classe
			ArrayList<Node> superFields = this.superEntry.getAllFields();
			
			// recupero il tipo dei metodi dalla CTEntry che descrive la classe
			ArrayList<Node> classMethods = this.classEntry.getAllFields();
			// recupero il tipo dei campi dalla CTEntry che descrive la super classe
			ArrayList<Node> superMethods = this.superEntry.getAllFields();
			
			// recupero i campi che potrebbero essere stati ridefiniti
			HashSet<Integer> locals = this.classEntry.getLocals();
			
			// i metodi sono covarianti: il tipo dei campi della sottoclasse deve essere maggiore del tipo dei campi della super classe
			// in questo modo non ci sono problemi nell'utilizzatli con metodi della sopraclasse
			
			// itero sugli offset ... 
			Iterator<Integer> it = locals.iterator();
			while(it.hasNext()){
				int offset = it.next();
				if(offset<0){
					// ... dei campi se sono negativi
					int i = -(offset)-1;
					// estraggo i tipi (altrimenti ho FieldNode)
					DecNode classField = (DecNode) classFields.get(i);
					DecNode superField = (DecNode) superFields.get(i);
					System.out.println(classField.getSymType()+" "+superField.getSymType());
					if(FOOLLib.lowestCommonAncestor(superField.getSymType(),classField.getSymType()) == null){
						System.out.println("Wrong type for "+i+"-th overridden field in "+this.type.getType());
						System.exit(0);
					}
				} else {
					int i = offset;
					// ... dei metodi se sono positivi o zero
					// estraggo i tipi (altrimenti ho MethodNode)
					DecNode classMethod = (DecNode) classMethods.get(i);
					DecNode superMethod = (DecNode) superMethods.get(i);
					System.out.println(classMethod+" "+superMethod);
					/*if(!FOOLLib.isSubType(classMethod.getSymType(),superMethod.getSymType())){
						System.out.println("Wrong type for "+i+"-th field");
						System.exit(0);
						
					}*/
					if(FOOLLib.lowestCommonAncestor(classMethod.getSymType(),superMethod.getSymType())==null){
						System.out.println("Wrong type for "+i+"-th overridden method in "+this.type.getType());
						System.exit(0);
						
					}
				}
			}
			
		}
		
		//ritorniamo null perchè è una dichiarazione
		return null;
	}

	@Override
	public String codeGeneration() {
		// genero le etichette per tutti i metodo contenuti in methods
		for(int i=0;i<this.methods.size();i++){
			String label = FOOLLib.freshFunctionLabel();
			((MethodNode)this.methods.get(i)).setLabel(label);
		}
		// mi richiamo su ciascun metodo
		for(int i=0;i<this.methods.size();i++){
						this.methods.get(i).codeGeneration();
		}
		
		return "";
	}

	@Override
	public Node getSymType() {
		return this.type;
	}

}
