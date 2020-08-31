package org.jsweet.extension;

import javax.lang.model.element.TypeElement;

import org.jsweet.transpiler.extension.Java2TypeScriptAdapter;
import org.jsweet.transpiler.extension.PrinterAdapter;

public class JavaRuntimeSourcesTranspilationAdapter extends Java2TypeScriptAdapter {

    public JavaRuntimeSourcesTranspilationAdapter(PrinterAdapter parent) {
        super(parent);
        System.out.println("Parent adapter: " + parent);

        // sometimes, package name mapping is ignored (with inheritance)
        addTypeMapping("javaoverride.lang.Class", "java.lang.Class");
        addTypeMapping("javaoverride.util.Date", "java.util.Date");

        // trick to declare RuntimeException as an error and a Java runtime exception at the same time. Not great.
        addTypeMapping("java.lang.RuntimeException", "Error");
    }

    @Override
    public boolean eraseSuperInterface(TypeElement type, TypeElement superInterface) {
        boolean erase = superInterface != null
                && (type.toString().endsWith("." + java.util.Iterator.class.getSimpleName())
                        || type.toString().endsWith("." + java.lang.Iterable.class.getSimpleName()));
        if (erase) {
            return true;
        }
        return super.eraseSuperInterface(type, superInterface);
    }

    @Override
    public boolean isSubstituteSuperTypes() {
        return true;
    }
}
