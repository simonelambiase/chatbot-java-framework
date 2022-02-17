package data.helper;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationHelper {

    public static boolean isClassHaveOtherEntities (Object o ) {
        boolean flag = true;
        for (Field f : o.getClass().getDeclaredFields() ) {
          flag = isFieldHaveOtherEntities(f);
        }
        return flag;
    }

    public static boolean isFieldHaveOtherEntities ( Field f ) {
        boolean flag = false;
        flag = f.isAnnotationPresent(OneToOne.class);
        flag &= f.isAnnotationPresent(OneToMany.class);
        flag &= f.isAnnotationPresent(ManyToOne.class);
        flag &= f.isAnnotationPresent(JoinTable.class);
        flag &= f.isAnnotationPresent(JoinColumn.class);
        return flag;
    }

    public static List<Class> findAnnotatedClass (Object o ) {
        List<Class> annotatedClasses = new ArrayList<>();
        for (Field f : o.getClass().getDeclaredFields()) {
            if (isFieldHaveOtherEntities(f)) {
                annotatedClasses.add(f.getType());
            }
        }
        return annotatedClasses;
    }
}
