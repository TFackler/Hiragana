package Logic;

import java.util.ArrayList;

public class History<E> {

    private HistoryObjectCreater hoc;

    private ArrayList<E> historyList;

    private final Class<E> type;

    private int historyPos;

    private int capacity;

    public History(int capacity ,HistoryObjectCreater hoc, Class<E> type) {
        this.hoc = hoc;
        historyList = new ArrayList<E>(capacity);
        historyPos = -1;
        this.capacity = capacity;
        this.type = type;

        // test for right type of return of hoc
    }

    public void next() {
        if (historyPos == historyList.size()) {
            Object obj = hoc.createNewObject();
            if (obj != null && obj.getClass().equals(type)) {
                E newObject = (E) obj;
                if (historyPos == capacity - 1) {
                    historyList.remove(0);
                } else {
                    historyPos++;
                }
                historyList.add(newObject);
            } else {
                throw new RuntimeException("history and history creation type mismatch!");
            }
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


}
