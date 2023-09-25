package lnd.lotan.utility;

import java.util.ArrayList;
import java.util.List;

public class ListUtilities {
    public static <T> List<T> flushToNewList(List<T> list, int flushAmount) {
        List<T> removedItems = new ArrayList<>(list.subList(0, flushAmount));
        list.subList(0, flushAmount).clear();
        return removedItems;
    }
}
