package Logic;

import java.util.ArrayList;

/**
 * A class that provides easy access to a typed history of elements.
 * The history consists of a list consisting of a maximum of a specified amount
 * of objects.
 * It is possible to navigate through the history. If the user tries to exceed
 * the maximum capacity the oldest element is deleted and a new one is created
 * using the <Code>createNew()</Code>-method.
 * @param <E> the type of object to be saved in the history.
 */
public abstract class History<E> {

    // the internal list used to organize the objects
    private ArrayList<E> historyList;

    // the current position in the history
    private int historyPos;

    // the maximum count of objects in the list
    private int maxCapacity;

    /**
     * Creates a new History object with a maximum capacity.
     * @param capacity the maximum amount of objects in the history
     */
    public History(int capacity) {
        historyList = new ArrayList<>();
        historyPos = -1;
        this.maxCapacity = capacity;
    }

    /**
     * Moves the current position in the history to the next object.
     * If the maximum capacity is not yet reached and the next object does not
     * exist yet, this method creates a new object using the <Code>createNew()
     * </Code>-method and adds it to the history.
     * If the maximum capacity is reached and the current object is the last
     * in the list, the method will remove the oldest object and will create a
     * new object using the <Code>createNew()</Code>-method. The new object
     * will be added to the list as the newest object.
     */
    public void next() {
        if (historyPos == historyList.size() - 1) {
            if (historyPos == maxCapacity - 1) {
                historyList.remove(0);
            } else {
                historyPos++;
            }
            historyList.add(createNew());
        } else {
            historyPos++;
        }
    }

    /**
     * Moves the current position in the history to the position of the previous
     * object.
     * If no previous object exists, the position stays the same.
     */
    public void previous() {
        if (historyPos > 0) {
            historyPos--;
        }
    }

    /**
     * This method returns the object at the current position of the history.
     * @return the current object in the history
     */
    public E getCurrent() {
        if (historyPos == -1)
            return null;
        return historyList.get(historyPos);
    }

    /**
     * This method is used if a new object has to be created.
     * @return the newly created object
     */
    public abstract E createNew();
}
