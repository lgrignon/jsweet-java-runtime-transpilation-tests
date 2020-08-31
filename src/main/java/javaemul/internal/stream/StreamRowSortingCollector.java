package javaemul.internal.stream;

import javaoverride.util.Collections;
import javaoverride.util.Comparator;
import javaoverride.util.List;

public class StreamRowSortingCollector extends StreamRowCollector {
    private Comparator comparator;

    public StreamRowSortingCollector(List collection, Comparator comparator) {
        super(collection);
        this.comparator = comparator;
    }

    @Override
    public void end() {
        Collections.sort((List) collection, comparator);
        super.end();
    }
}
