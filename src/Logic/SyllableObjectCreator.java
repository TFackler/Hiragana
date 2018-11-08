package Logic;

import Util.HiraganaRandomizer;

public class SyllableObjectCreator implements HistoryObjectCreater {

    public HiraganaRandomizer randomizer = HiraganaRandomizer.getInstance();

    @Override
    public Object createNewObject() {
        return randomizer.getRandomSyllable();
    }
}
