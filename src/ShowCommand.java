import Stock.FoodItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowCommand implements Command {
	Record rec;

	public ShowCommand(Record rec) {
		this.rec = rec;
	}

	@Override
	public void execute() {

		try {
			if(rec.getRecord().size() != 0) {
				System.out.println("Enter id (* to show all):");
				InputStreamReader is = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(is);
				String tmp = br.readLine();
				displayHeader();
				if(tmp.equals("*"))
					muti();
				else {
					single(tmp);
				}
			} else
				System.out.println("Item List have no record.");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process() {

	}

	@Override
	public void undo() {
		System.out.println("Can not undo this command.");
	}
	
	public void muti() {
		rec.mutiDisplay();
	}
	
	public void single(String str) {
		try {
			Integer.parseInt(str);
			
			int pos = rec.searchRecord(str);
			if(pos != rec.getRecord().size()) {
				FoodItem tmp = (FoodItem)rec.getRecord().get(pos);
				simpleDisplay(tmp);
				rec.singleDisplay(tmp);
			} else
				System.out.println("no record found.");
		} catch (NumberFormatException e) {
            System.out.println("Input Error. Please try again.\n");
		}	
	}

	public void displayHeader() {
		System.out.println("Food item information");
	}

	public void simpleDisplay(FoodItem fI) {
		System.out.println("ID : " + fI.getItemID());
		System.out.println("Name : " + fI.getName());
		System.out.println("Quantity : " + fI.getBalance());
	}

}