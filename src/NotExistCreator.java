
public class NotExistCreator implements CommandCreator {
    Record rec;
    CareTaker care;

    public NotExistCreator(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public Command newCommand() {
        return new NotExistCommand();
    }
}
