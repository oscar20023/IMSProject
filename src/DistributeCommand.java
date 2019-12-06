import Stock.FoodItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistributeCommand implements Command {
	private CareTaker care;
	private Record rec;
    private int qty;
    private String id;
    private FoodItem fI;

    public DistributeCommand(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public void execute() {
        try {
            if(rec.getRecord().size() != 0) {//when there are any record
                System.out.println("Enter id :");
                //select item by searching the item ID
                InputStreamReader is = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(is);
                id = br.readLine();
                
                Integer.parseInt(id);//get ID
                
                int checked = rec.searchRecord(id);//find ID that existed
                if(checked != rec.getRecord().size()) {//when item found
                    System.out.println("Quantity to distribute :");
                    //input a number that want to be operate
                    qty = Integer.parseInt(br.readLine());
                    fI = (FoodItem)rec.getRecord().get(checked);
                    if(qty <= fI.getBalance()){//when quantity < Balance
                        process();
                        System.out.println("Distributed "+qty+" packs of "+fI.getItemID()
                                +". Current quantity is "+fI.getBalance()+".");
                        rec.add_undo(this.toString());
                        rec.setCom(this);
                        care.addMementoUndo(rec.saveComToMemento());
                    } else
                        System.out.println("Quantity is larger then the Item balance.Operation Fail.\n");
                } else
                    System.out.println("no record found.");
            } else
                System.out.println("Item List have no record.");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process() {
        rec.editQuantity(-qty,id);
    }

    @Override
    public void undo() {
        rec.editQuantity(qty,id);
    }

    @Override
    public String toString() {
        return "Distribute "+fI.getItemID()+" "+fI.getName();
    }
}
