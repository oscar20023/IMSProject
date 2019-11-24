    
public interface Command {
    void execute();
    void process(); //main process will do in this method
    void undo();
}

