import java.util.HashMap;

/**
 * Created by kazuki on 2017/11/10.
 */
public class CommandStorage implements Storage {
    //store the long form of CommandCreator
    private String[] storageLF = {"CreateCreator","ShowCreator","ReceiveCreator","DistributeCreator"
            ,"UndoCreator","RedoCreator","DisplayListCreator","ExitCreator"};
    //store the short form of CommandCreator
    private char[] storageSF = {'c','s','g','d','u','r','l','x'};
    private HashMap map;

    public CommandStorage() {
        //save SF and LF as Key and Value
        map = new HashMap<Character,String>();
        for (int i = 0; i < storageLF.length; i++) {
            map.put(storageSF[i],storageLF[i]);
        }
    }

    public HashMap getMap() {
        return map;
    }

    public String toString() {
        String tmp = " ";
        for(int i = 0; i < storageSF.length; i++){
            if(i != storageSF.length-1)
                tmp += storageSF[i]+" | ";
            else
                tmp += storageSF[i]+" ";
        }
        return tmp;
    }
}
