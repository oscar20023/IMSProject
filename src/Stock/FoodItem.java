package Stock;

public class FoodItem {
    private String itemID;
    private int balance;
    private final int DEFAULT_Q = 0;
    private String name;

    public FoodItem(String itemID, String name) {
        this.itemID = itemID;
        this.name = name;
        setBalance(DEFAULT_Q);
    }

    public String getItemID() {
        return itemID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public String toString() { //item detail
        return null;
    }
    
    public String tableize() {
    	return null;
    }
}