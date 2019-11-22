import java.util.Vector;

/**
 * Created by kazuki on 2017/11/07.
 */
public class DisplayListCommand implements Command{
    Record rec;

    public DisplayListCommand(Record rec) {
        this.rec = rec;
    }

    @Override
    public void execute() {
        Vector tmpU = rec.get_undo();
        Vector tmpR = rec.get_redo();
        System.out.println();
        if(tmpU.size() > 0){
            /** when there are any record in undo list */
            System.out.println("Undo List :");
            for(int i = 0;i < tmpU.size();i++)
            /** get String data from list */
                System.out.println(tmpU.get(i).toString());
            System.out.println();
        } else /** if there are no record in undo list*/
            System.out.println("Undo List is empty.\n");
        if(tmpR.size() > 0) {
            /** when there are any record in redo list */
            System.out.println("Redo List :");
            for(int i = 0;i < tmpR.size();i++)
                System.out.println(tmpR.get(i).toString());
            System.out.println();
        }
        else/** if there are no record in redo list*/
            System.out.println("Redo List is empty.\n");
    }

    @Override
    public void process() {

    }

    @Override
    public void undo() {
        System.out.println("Can not undo this command.");
    }
}
