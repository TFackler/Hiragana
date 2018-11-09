package Logic;

import java.util.ArrayList;

public abstract class History<E> {

    private ArrayList<E> historyList;

    private int historyPos;

    private int maxCapacity;

    public History(int capacity) {
        historyList = new ArrayList<>();
        historyPos = -1;
        this.maxCapacity = capacity;
    }

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

    public void previous() {
        if (historyPos > 0) {
            historyPos--;
        }
    }

    public E getCurrent() {
        if (historyPos == -1)
            return null;
        return historyList.get(historyPos);
    }

    public abstract E createNew();
}
