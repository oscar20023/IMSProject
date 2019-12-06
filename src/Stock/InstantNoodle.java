package Stock;

public class InstantNoodle extends FoodItem {

    private int weight;

    public InstantNoodle(String itemID, String name) {
        super(itemID, name);
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
    	return String.format("%-20s%-12s%-30s%-12d%s", "InstantNoodle", getItemID(), getName(), getBalance(), getWeight());
        // return "InstantNoodle\t" + getItemID()+"\t"+getName()+"\t\t\t"+getBalance()+"\t\t"+getWeight();
    }
    
    public String tableize() {
    	return "InstantNoodle\t" + getItemID()+ "\t" +getName()+ "\t" + getBalance() + "\t" + "Weight" + "\t" + getWeight();
    }
}