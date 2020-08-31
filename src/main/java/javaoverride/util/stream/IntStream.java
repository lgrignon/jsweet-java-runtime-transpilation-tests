package javaoverride.util.stream;

import javaoverride.util.stream.Stream;

import javaoverride.util.ArrayList;
import javaoverride.util.Collections;
import javaoverride.util.List;

public interface IntStream {
    static Stream<Integer> range(int startInclusive, int endExclusive) {
        if (startInclusive >= endExclusive) {
            return Collections.<Integer>emptyList().stream();
        } else {
            List<Integer> result = new ArrayList<>();
            for (;startInclusive < endExclusive; ++startInclusive) {
                result.add(startInclusive);
            }
            return result.stream();
        }
    }
}
