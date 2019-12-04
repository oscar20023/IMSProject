import Stock.FoodItem;
import Stock.InstantNoodle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InstantNoodleCreator implements FoodItemCreator {
    String[] detail = new String[3];
    @Override
    public String getInfo() throws IOException {
        System.out.println("Enter id, name and weight:");
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        return br.readLine();
    }

    @Override
    public FoodItem createMethod() throws IOException {
        int tmp = 0, param = 0;
        String line = getInfo();
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ',') {
                detail[tmp] = line.substring(param, i);
                param = i+1;
                tmp++;
            }
        }
        detail[tmp] = line.substring(param, line.length());
        try {
            InstantNoodle i = new InstantNoodle(Integer.parseInt(detail[0]),detail[1]);
            i.setWeight(Integer.parseInt(detail[2]));
            return i;
        } catch (NumberFormatException e) {
            System.out.println("Input Error. Please try again.\n");
        }
        return null;
    }
}
