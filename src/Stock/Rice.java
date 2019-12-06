package Stock;

public class Rice extends FoodItem {

    private String type;

    public Rice(int itemID, String name) {
        super(itemID, name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return getItemID()+"\t\t"+getName()+"\t\t\t\t"+getBalance()+"\t\t"+getType();
    }
    
    public String tableize() {
    	return getItemID()+ "\t" +getName()+ "\t" + getBalance() + "\t" + "Type" + "\t" + getType();
    }
}