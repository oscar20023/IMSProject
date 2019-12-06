
public class UndoCreator implements CommandCreator {
    Record rec;
    CareTaker care;
 

    public UndoCreator(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public Command newCommand() {
        return new UndoCommand(rec,care);
    }
}
