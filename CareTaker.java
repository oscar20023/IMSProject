import java.util.Vector;

public class CareTaker {
    private Vector<Memento> mementoUndo = new Vector<>();
    private Vector<Memento> mementoRedo = new Vector<>();

    // add new memento to the list
    public void addMementoUndo(Memento m) {
        mementoUndo.add(m);
    }

    public void addMementoRedo(Memento m) {
        mementoRedo.add(m);
    }

    public Memento getMementoUndo() {
        //remove and return last memento in the list
        Memento memento = mementoUndo.remove(mementoUndo.size()-1);
        return memento;
    }

    public Memento getMementoRedo() {
        //remove and return last memento in the list
        Memento memento = mementoRedo.remove(mementoRedo.size()-1);
        return memento;
    }
}
