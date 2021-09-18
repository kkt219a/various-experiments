package effective.chapter3.item14;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ComparatorExample implements Comparator<ComparatorExample> {

    public static void main(String[] args) {


    }

    @Override
    public int compare(ComparatorExample o1, ComparatorExample o2) {
        return 0;
    }

    @Override
    public Comparator<ComparatorExample> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<ComparatorExample> thenComparing(Comparator<? super ComparatorExample> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<ComparatorExample> thenComparing(Function<? super ComparatorExample, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<ComparatorExample> thenComparing(Function<? super ComparatorExample, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<ComparatorExample> thenComparingInt(ToIntFunction<? super ComparatorExample> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<ComparatorExample> thenComparingLong(ToLongFunction<? super ComparatorExample> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<ComparatorExample> thenComparingDouble(ToDoubleFunction<? super ComparatorExample> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
