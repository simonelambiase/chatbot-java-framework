package data.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReflectionHelper {

    public static Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    public static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    public static List<Class> getAnnotatedClass ( Class entityClass ) {
        List<Class> classes = new ArrayList<>();
        for ( Package p : Package.getPackages() ) {
            Set<Class> classesPkg = findAllClassesUsingClassLoader(p.getName());
            for ( Class c : classesPkg ) {
                if ( c.getAnnotations().getClass().equals(entityClass)) {
                    classes.add(c);
                }
            }
        }
        return classes;
    }
}
