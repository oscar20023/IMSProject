
public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("\n\nLeaving System...");
        System.exit(0);
    }

    @Override
    public void process() {

    }

    @Override
    public void undo() {
        System.out.println("Can not undo this command.");
    }
}
