import java.util.Vector;


public class Memento {
    private Command com;//command that have been done at this state

    public Memento(Command com) {
        this.com = com;
    }

    public Command getCom() {
        return com;
    }

}
