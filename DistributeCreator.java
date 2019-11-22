/**
 * Created by kazuki on 2017/11/10.
 */
public class DistributeCreator implements CommandCreator{
    Record rec;
    CareTaker care;

    public DistributeCreator(Record rec, CareTaker care) {
        this.rec = rec;
        this.care = care;
    }

    @Override
    public Command newCommand() {
        return new DistributeCommand(rec,care);
    }
}
