import Stock.FoodItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kazuki on 2017/11/07.
 */
public class ReceiveCommand implements Command {
    CareTaker care;
    Record rec;
    private int id,qty;
    private FoodItem fI;

    public ReceiveCommand(Record rec, CareTaker care) {
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
                id = Integer.parseInt(br.readLine());//get ID
                int checked = rec.searchRecord(id);//find ID that existed
                if(checked != rec.getRecord().size()) {//when item found
                    fI = (FoodItem)rec.getRecord().get(checked);
                    System.out.println("Quantity to receive :");
                    //input a number that want to be operate
                    qty = Integer.parseInt(br.readLine());
                    process();
                    System.out.println("Received "+qty+" packs of "+fI.getItemID()
                            +". Current quantity is "+fI.getBalance()+".");
                    rec.add_undo(this.toString());
                    rec.setCom(this);
                    care.addMementoUndo(rec.saveComToMemento());
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
        rec.editQuantity(qty,id);
    }

    @Override
    public void undo() {
        rec.editQuantity(-qty,id);
    }

    @Override
    public String toString() {
        return "Receive "+fI.getItemID()+" "+fI.getName();
    }
}
