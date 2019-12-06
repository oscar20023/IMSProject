import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {
    public static void main(String[]args) {
        CommandStorage cs = new CommandStorage(); //create a command list
        CommandOptions co;
        Record record = new Record();
        CareTaker careTaker = new CareTaker();
        Command com;
        do {
            createMenu(cs.toString()); //create starting menu
            try {
 //make a save point
                co = new CommandOptions(record,careTaker,cs.getMap());
                //return Command Creator by comparing the character
                CommandCreator tmp = co.getOpt(getRequest());
                if(tmp != null) { //check any matched result
                    com = tmp.newCommand(); //new the matching command
                    com.execute();
                } else // if no matched result
                    System.out.println("Command not found.\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static void createMenu(String str) {
        System.out.println("Advanced Inventory Management System");
        System.out.println("Please enter command: ["+str+"]");
        System.out.println("c = create item,  s = show item,  g = receive item,  d = distribute item, " +
                            "u = undo,  r = redo,  l = list undo/redo,  x = exit system");
    }
	
    public static char getRequest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd=br.readLine();
        if(cmd.length()>1) {
        	return (char)0;
        }
        return cmd.charAt(0);
    }

}
