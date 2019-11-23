import java.util.Vector;

/**
 * Created by kazuki on 2017/11/07.
 */
public class Memento {
    private Command com;//command that have been done at this state

    public Memento(Command com) {
        this.com = com;
    }

    public Command getCom() {
        return com;
    }

}
