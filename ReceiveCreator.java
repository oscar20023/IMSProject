
public class ReceiveCreator implements CommandCreator {
    Record rec;
    CareTaker care;

    public ReceiveCreator(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public Command newCommand() {
        return new ReceiveCommand(rec,care);
    }
}
