package Stock;

public class FoodItem {
    private int itemID, balance;
    private final int DEFAULT_Q = 0;
    private String name;

    public FoodItem(int itemID, String name) {
        this.itemID = itemID;
        this.name = name;
        setBalance(DEFAULT_Q);
    }

    public int getItemID() {
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