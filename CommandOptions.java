import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by kazuki on 2017/11/10.
 */
public class CommandOptions {
    Record rec;
    CareTaker care;
    private HashMap map; //stored those command creator string

    public CommandOptions(Record rec,CareTaker care,HashMap map) {
        this.rec = rec;
        this.care = care;
        this.map = map;
    }

    public CommandCreator getOpt(char c) {
        String str;
        Object tmp = map.get(c);//get object from HashMap
        if(tmp != null) {//when tmp have content
            str = tmp.toString();// get CommandCreator String
            try {
                //set Constructor parameters
                Constructor con = Class.forName(str).getConstructor(Record.class,CareTaker.class);
                return ((CommandCreator) con.newInstance(rec,care));
            }catch (Exception e) {

            }
        }
        return null;
    }
}
