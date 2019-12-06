import Stock.Drink;
import Stock.FoodItem;
import Stock.Rice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DrinkCreator implements FoodItemCreator {
    String[] detail = new String[3];

    public String getInfo() throws IOException {
        System.out.println("Enter id, name and type:");
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        return br.readLine();
    }
    public FoodItem createMethod() throws IOException {
        int tmp = 0, param = 0;
        String line = getInfo();
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ',') {
                detail[tmp] = line.substring(param, i).trim();
                param = i+1;
                tmp++;
            }
        }
        detail[tmp] = line.substring(param, line.length()).trim();
        try {
        	Integer.parseInt(detail[0]);
        	
        	Drink r = new Drink(detail[0], detail[1]);
            r.setType(detail[2]);
            return r;
        } catch (NumberFormatException e) {
            System.out.println("Input Error. Please try again.\n");
        }
        return null;
    }

}
