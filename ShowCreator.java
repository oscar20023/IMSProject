/**
 * Created by kazuki on 2017/11/10.
 */
public class ShowCreator implements CommandCreator {
    Record rec;
    CareTaker care;

    public ShowCreator(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public Command newCommand() {
        return new ShowCommand(rec);
    }
}
