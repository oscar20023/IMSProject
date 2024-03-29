
public class CreateCreator implements CommandCreator {
    Record rec;
    CareTaker care;

    public CreateCreator(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public Command newCommand() {
        return new CreateCommand(rec,care);
    }
}
