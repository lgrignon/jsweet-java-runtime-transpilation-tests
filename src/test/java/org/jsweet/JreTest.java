package org.jsweet;

import javaemul.internal.stream.StreamHelper;
import javaoverride.util.Collection;
import javaoverride.util.stream.Stream;

public class JreTest extends BaseJreTest {
    @Override
    protected <T> Stream<T> stream(Collection<T> c) {
        return new StreamHelper<>(c);
    }
}
