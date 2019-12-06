import java.util.HashMap;

public class CommandStorage implements Storage {
    //store the long form of CommandCreator
    private final static String[] storageLF = {"CreateCreator","ShowCreator","ReceiveCreator","DistributeCreator"
            ,"UndoCreator","RedoCreator","DisplayListCreator","ExitCreator", "Output as CSV"};
    //store the short form of CommandCreator
    private final static char[] storageSF = {'c','s','g','d','u','r','l','x','o'};
    
    private static HashMap<Character, String> map;
    private static CommandStorage instance = null;
    		
    private CommandStorage() {
        //save SF and LF as Key and Value
        map = new HashMap<Character,String>();
        for (int i = 0; i < storageLF.length; i++) {
            map.put(storageSF[i],storageLF[i]);
        }
    }
    
    public static CommandStorage getInstance() {
    	if (null == instance) {
    		instance = new CommandStorage();
    	}
    	return instance;
    }

    public HashMap<Character, String> getMap() { 
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
