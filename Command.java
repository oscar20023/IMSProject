/**
 * Created by kazuki on 2017/11/06.
 */
public interface Command {
    void execute();
    void process(); //main process will do in this method
    void undo();
}
