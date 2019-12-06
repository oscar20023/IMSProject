package Stock;

public class Rice extends FoodItem {

    private String type;

    public Rice(String itemID, String name) {
        super(itemID, name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return String.format("%-20s%-12s%-30s%-12d%s", "Rice", getItemID(), getName(), getBalance(), getType());
        		// "Rice\t\t" + getItemID()+"\t"+getName()+"\t\t\t"+getBalance()+"\t\t"+getType();
    }
    
    public String tableize() {
    	return "Rice\t" + getItemID()+ "\t" +getName()+ "\t" + getBalance() + "\t" + "Type" + "\t" + getType();
    }
}