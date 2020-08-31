package javaoverride.lang;

import javaoverride.lang.ThreadLocal;

public class InheritableThreadLocal<T> extends ThreadLocal<T> {

	protected T childValue(T parentValue) {
		return parentValue;
	}

}
