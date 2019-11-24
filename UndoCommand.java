import java.util.Vector;

public class UndoCommand implements Command {
    Record rec;
    CareTaker care;

    public UndoCommand(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public void execute() {
        if(rec != null&&rec._undo != null && rec._undo.size() > 0) {
            rec.getComFromMemento(care.getMementoUndo()); //set to the last command
            Command c = rec.getCom(); //get command
            c.undo(); //undo command
            rec.rm_undo(c.toString());// remove the command string in undo list
            rec.add_redo(c.toString());// add the command string to redo list
            care.addMementoRedo(rec.saveComToMemento());
            System.out.println("undo completed.\n");
        } else {
            System.out.println("No command had done\n");
        }
    }

    @Override
    public void process() {

    }

    @Override
    public void undo() {
        System.out.println("Bug exist");
    }
}
