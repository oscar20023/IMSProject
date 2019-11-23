
public class DisplayListCreator implements CommandCreator{
    Record rec;
    CareTaker care;

    public DisplayListCreator(Record rec,CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public Command newCommand() {
        return new DisplayListCommand(rec);
    }
}
