package javaoverride.nio.file;

import def.js.Array;

import static jsweet.util.Lang.array;
import static jsweet.util.Lang.string;

import javaoverride.nio.file.Path;

public class Paths {
    private Paths() {

    }

    public static Path get(String... paths) {
        return new Path(string(array(paths).join(Path.PATH_SEPARATOR)));
    }

}