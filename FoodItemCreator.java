import Stock.FoodItem;

import java.io.IOException;

/**
 * Created by kazuki on 2017/10/31.
 */
public interface FoodItemCreator {

    FoodItem createMethod() throws IOException;
    String getInfo() throws IOException;
}
