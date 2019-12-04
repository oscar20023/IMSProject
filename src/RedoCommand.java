
public class RedoCommand implements Command {
    CareTaker care;
    Record rec;

    public RedoCommand(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public void execute() {
        if(rec != null&&rec.get_redo() != null && rec.get_redo().size() > 0) {
            rec.getComFromMemento(care.getMementoRedo());
            Command c = rec.getCom();
            rec.rm_redo(c.toString());
            c.process();
            System.out.println("redo completed.\n");
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
