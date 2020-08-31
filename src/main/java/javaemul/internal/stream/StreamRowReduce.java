package javaemul.internal.stream;

import java.util.function.BinaryOperator;

import javaoverride.util.Optional;

public class StreamRowReduce extends TerminalStreamRow {
    private Optional result;
    private final BinaryOperator operator;

    public StreamRowReduce(Optional result, BinaryOperator operator) {
        this.result = result;
        this.operator = operator;
    }

    public Optional getResult() {
        return result;
    }

    @SuppressWarnings("unchecked")
    public boolean item(Object a) {
        result = Optional.of(result.map(v -> operator.apply(v, a)).orElse(a));
        return true;
    }
}
