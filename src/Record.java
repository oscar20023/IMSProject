import Stock.FoodItem;
import Stock.InstantNoodle;
import Stock.Rice;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;


public class Record {

    LinkedList<FoodItem>record = new LinkedList<FoodItem>();
    Vector _undo = new Vector();
    Vector _redo = new Vector();
    Command com;

    public LinkedList getRecord() {
        return record;
    }

    public FoodItem addRecord(FoodItemCreator fIC) {
        FoodItem fI = null;
        try {
            fI = fIC.createMethod();
            if(fI != null) {
            	for(int i=0;i<record.size();i++) {
            		if(fI.getItemID() == record.get(i).getItemID()) {
            			System.out.println("Item ID has already existed. Please change the ID. \n");
            			return null;
            		}
            	}
                record.add(fI);
                System.out.println("New item record created.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fI;
    }

    public void rmRecord(int id) {
        record.remove(id);
    }

    public int searchRecord(int id) {
        for(int i = 0; i < record.size();i++)
            if(((FoodItem)record.get(i)).getItemID() == id)
                return i;
        return record.size();
    }

    public void singleDisplay(FoodItem fI) {
        if (fI instanceof Rice) {
            Rice tmp = (Rice)fI;
            System.out.println("Type : "+tmp.getType());
        }
        if (fI instanceof InstantNoodle) {
            InstantNoodle tmp = (InstantNoodle)fI;
            System.out.println("Weight : "+tmp.getWeight());
        }
    }

    public void mutiDisplay() {
        FoodItem[] tmp = new FoodItem[record.size()];
        for(int i = 0; i < record.size();i++)
            tmp[i] = (FoodItem) record.get(i);
        System.out.println("ID\t\tName\t\t\t\tQuantity\t\tOther Info");
        for(int i = 0; i < tmp.length;i++)
            System.out.println(tmp[i].toString());
    }

    public void editQuantity(int qty,int id) {
        int pos = searchRecord(id);
        if(pos != record.size())
            ((FoodItem)record.get(pos)).setBalance(((FoodItem)record.get(pos)).getBalance()+qty);
    }

    public Vector get_undo() {
        return _undo;
    }

    public void add_undo(String comS) {
        _undo.add(comS);
    }

    public void rm_undo(String comS) {
        _undo.remove(comS);
    }

    public Vector get_redo() {
        return _redo;
    }

    public void add_redo(String comS) {
        _redo.add(comS);
    }

    public void rm_redo(String comS) {
        _redo.remove(comS);
    }

    public Command getCom() {
        return com;
    }

    public void setCom(Command com) {
        this.com = com;
    }

    public Memento saveComToMemento() {
        return new Memento(com);
    }

    public void getComFromMemento(Memento m) {
        com = m.getCom();
    }
}
