package data.mysql;

import data.DataManager;
import data.helper.AnnotationHelper;
import data.helper.ConnectionFactory;
import data.helper.ReflectionHelper;
import org.hibernate.AnnotationException;
import org.hibernate.Session;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataManagerMySQL implements DataManager {

    private Session session;
    private String address;
    private int port;
    private String database;
    private String username;
    private String password;
    private List<Class> annotatedClass = new ArrayList<>();


    public DataManagerMySQL( String address, int port, String database, String username, String password ) {
        this.address = address;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        this.session = ConnectionFactory.openMySQLSession(address,port,database,username,password);

    }

    public DataManagerMySQL( String address, String database, String username, String password ) {
        this.address = address;
        this.database = database;
        this.username = username;
        this.password = password;
        this.session = ConnectionFactory.openMySQLSession(address,database,username,password);
    }

    public DataManagerMySQL( String address, String database, String username, String password, List<Class> classToMap ) {
        this.address = address;
        this.database = database;
        this.username = username;
        this.password = password;
        this.annotatedClass.addAll(classToMap);
        this.session = ConnectionFactory.openMySQLSession(address,database,username,password,classToMap);
    }

    @Override
    public boolean save(Object obj) {
        annotatedClass.add(obj.getClass());
        annotatedClass.addAll(AnnotationHelper.findAnnotatedClass(obj));
        session = ConnectionFactory.openMySQLSession(address, port != 0 ? port : 3306, database, username, password, annotatedClass);
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        return false;
    }

    @Override
    public Object loadAll() {
        return null;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Class> getAnnotatedClass() {
        return annotatedClass;
    }

    public void setAnnotatedClass(List<Class> annotatedClass) {
        this.annotatedClass = annotatedClass;
    }
}
