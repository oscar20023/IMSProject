import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import Stock.FoodItem;

public class ExitCommand implements Command {

    @Override
    public void execute() {
    	System.out.print("\n\nLeaving ... \n");
        
        Record record = Record.getInstance();
        BufferedWriter writer = null;

        int size = record.getRecord().size();
    	String filename = System.getProperty("user.dir") + "\\Report_" + 
    						LocalDateTime.now().toString().replace(':', '-')
    						+ ".bak";

    	try {
			new File(filename).createNewFile();
			
    	    writer = new BufferedWriter(new FileWriter(filename));
    	    
	    	writer.write("ID\tName\tQuantity\tOther Info\tValue\n");

    	    for(int i = 0; i < size; i++) {
    	    	writer.write(((FoodItem) record.getRecord().get(i)).tableize());
    	    }                
    	    
            System.out.printf("Backup will be saved to %s.\n", filename); 	

		} catch (IOException ex) {
			ex.printStackTrace();
    	} finally {
    	   try {writer.close();} catch (Exception ex) {ex.printStackTrace();}
    	   writer = null;
    	}
    	

        System.exit(0);
    }

    @Override
    public void process() {

    }

    @Override
    public void undo() {
        System.out.println("Can not undo this command.");
    }
}
