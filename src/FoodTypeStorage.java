import java.util.HashMap;

public class FoodTypeStorage implements Storage {

    private final static String[] storageLF = {"RiceCreator","InstantNoodleCreator", "DrinkCreator"};
    private final static String[] storageSF = {"ri","in","dr"};
    
    private static HashMap<String, String> map;
    private static FoodTypeStorage instance = null;
    
    private FoodTypeStorage() {
        map = new HashMap<String,String>();
        for (int i = 0; i < storageLF.length; i++) {
            map.put(storageSF[i],storageLF[i]);
        }
    }
    
    public static FoodTypeStorage getInstance() {
    	if (null == instance) {
    		instance = new FoodTypeStorage();
    	}
    	return instance;
    }

    @Override
    public HashMap<String, String> getMap() {
        return map;
    }
}
