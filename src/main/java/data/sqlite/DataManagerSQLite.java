package data.sqlite;

import data.DataManager;
import data.helper.AnnotationHelper;
import data.helper.ConnectionFactory;
import data.helper.ReflectionHelper;
import org.hibernate.Session;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataManagerSQLite implements DataManager {

    private Session session;
    private String fileName;
    private List<Class> annotatedClass = new ArrayList<>();

    public DataManagerSQLite() {

        this.session = ConnectionFactory.openSQLiteSession();
    }

    public DataManagerSQLite( String fileName ) {
        this.fileName = fileName.contains(".sqlite") ? "jdbc:sqlite:" + fileName : "jdbc:sqlite" + fileName + ".sqlite";
        this.session = ConnectionFactory.openSQLiteSession(fileName);

    }

    @Override
    public boolean save( Object obj) {
        annotatedClass.add(obj.getClass());
        annotatedClass.addAll(AnnotationHelper.findAnnotatedClass(obj));
        session = ConnectionFactory.openSQLiteSession(fileName != null ? fileName : "data.sqlite", annotatedClass);
        session.persist(obj);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public List loadAll() {
        return null;
    }



}
