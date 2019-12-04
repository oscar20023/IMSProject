import Stock.FoodItem;

import java.io.IOException;

public interface FoodItemCreator {

    FoodItem createMethod() throws IOException;
    String getInfo() throws IOException;
}
