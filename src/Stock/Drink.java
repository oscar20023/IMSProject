package Stock;

public class Drink extends FoodItem {

    private String type;

    public Drink(String itemID, String name) {
        super(itemID, name);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
    	return String.format("%-20s%-12s%-30s%-12d%s", "Drink", getItemID(), getName(), getBalance(), getType());
    }
}