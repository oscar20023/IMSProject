import java.util.HashMap;

public class FoodTypeStorage implements Storage {

    private String[] storageLF = {"RiceCreator","InstantNoodleCreator","DrinkCreator"};
    private String[] storageSF = {"ri","in","dr"};
    private HashMap map;

    public FoodTypeStorage() {
        map = new HashMap<String,String>();
        for (int i = 0; i < storageLF.length; i++) {
            map.put(storageSF[i],storageLF[i]);
        }
    }

    @Override
    public HashMap getMap() {
        return map;
    }
}
