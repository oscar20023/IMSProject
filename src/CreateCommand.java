
import Stock.FoodItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateCommand implements Command {
	CareTaker care;
	Record rec;
	private FoodItem fI;
	private FoodTypeStorage fts = FoodTypeStorage.getInstance();

	public CreateCommand(Record rec, CareTaker care) {
		this.rec = rec;
		this.care = care;
	}

	@Override
	public void execute() {
		FoodItemCreator fIC = null;

		System.out.println("Enter food type: [ri = Rice, in = Instance Noodle, dr = Drink]");

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		try {
			String str = br.readLine().trim();//read line
			Object obj = fts.getMap().get(str);//get object from HashMap
			if(obj != null) {
				str = obj.toString();//get class name
				try {
					//new a FoodItemCreator
					fIC = ((FoodItemCreator) Class.forName(str).newInstance());
				}catch (Exception e) {

				}
			}
			if(fIC != null) { /** if type found */
				fI = rec.addRecord(fIC);
				if(fI != null) { /** if add record process finish correctly */
					rec.add_undo(this.toString()); /** add this command to undo list */
					rec.setCom(this);
					care.addMementoUndo(rec.saveComToMemento()); //save new Memento
				}
				System.out.println();
			} else /** type not found */
				System.out.println("Food Type not found. Please try again.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process() {
		rec.getRecord().add(fI);
	}

	@Override
	public void undo() {
		rec.rmRecord(rec.searchRecord(fI.getItemID()));
	} /** remove item record */

	@Override
	public String toString() {
		return "Create "+fI.getItemID()+" "+fI.getName();
	}
}
