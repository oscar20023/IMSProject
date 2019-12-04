
public class NotExistCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Command not found. Please try again.\n");
    }

    @Override
    public void process() {

    }

    @Override
    public void undo() {
        System.out.println("Can not undo this command.");
    }
}
