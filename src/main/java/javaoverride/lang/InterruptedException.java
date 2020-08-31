package javaoverride.lang;

import javaoverride.lang.Exception;
import java.lang.String;
import javaoverride.lang.SuppressWarnings;

@SuppressWarnings("serial")
public class InterruptedException extends Exception {

    /**
     * Constructs an <code>InterruptedException</code> with no detail  message.
     */
    public InterruptedException() {
        super();
    }

    /**
     * Constructs an <code>InterruptedException</code> with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public InterruptedException(String s) {
        super(s);
    }
}
