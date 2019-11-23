
public class ExitCreator implements CommandCreator {
    Record rec;
    CareTaker care;

    public ExitCreator(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public Command newCommand() {
        return new ExitCommand();
    }
}
