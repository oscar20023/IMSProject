package Stock;

public class InstantNoodle extends FoodItem {

    private int weight;

    public InstantNoodle(int itemID, String name) {
        super(itemID, name);
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return getItemID()+"\t\t"+getName()+"\t\t\t\t"+getBalance()+"\t\t"+getWeight();
    }
    
    public String tableize() {
    	return getItemID()+ "\t" +getName()+ "\t" + getBalance() + "\t" + "Weight" + "\t" + getWeight();
    }
}