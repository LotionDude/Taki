package lnd.lotan.utility;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Zipper {
    public static <T, U, R> List<R> zipLists(List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        int size = Math.min(list1.size(), list2.size());
        return IntStream.range(0, size)
                .mapToObj(i -> combiner.apply(list1.get(i), list2.get(i)))
                .collect(Collectors.toList());
    }
}
