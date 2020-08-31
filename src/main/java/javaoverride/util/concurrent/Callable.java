package javaoverride.util.concurrent;

@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}

