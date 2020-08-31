package javaemul.internal.stream;

import java.util.function.BinaryOperator;

import javaoverride.util.Comparator;

public class ChooseSmallest<T> implements BinaryOperator<T> {
    private final Comparator<T> comparator;

    public ChooseSmallest(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T apply(T t1, T t2) {
        if (comparator.compare(t1, t2) <= 0) {
            return t1;
        }
        return t2;
    }
}
