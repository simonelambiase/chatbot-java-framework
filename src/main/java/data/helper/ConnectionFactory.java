package data.helper;

import data.mysql.DataManagerMySQL;
import data.sqlite.DataManagerSQLite;
import entities.Bot.telegram.wrapper.TelegramMessageWrapper;
import entities.Bot.telegram.wrapper.TelegramUserWrapper;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Entity;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConnectionFactory {

    public static Session openSQLiteSession() {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.sqlite.JDBC");
        settings.put(Environment.URL, "jdbc:sqlite:data.sqlite");
        settings.put(Environment.DIALECT, "com.enigmabridge.hibernate.dialect.SQLiteDialect");
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }

    public static Session openSQLiteSession( String fileName ) {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.sqlite.JDBC");
        settings.put(Environment.URL, fileName.contains(".sqlite") ? "jdbc:sqlite:" + fileName : "jdbc:sqlite" + fileName + ".sqlite");
        settings.put(Environment.DIALECT, "com.enigmabridge.hibernate.dialect.SQLiteDialect");
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }

    public static Session openSQLiteSession (String fileName, Class classToMap ) {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.sqlite.JDBC");
        settings.put(Environment.URL, fileName.contains(".sqlite") ? "jdbc:sqlite:" + fileName : "jdbc:sqlite" + fileName + ".sqlite");
        settings.put(Environment.DIALECT, "com.enigmabridge.hibernate.dialect.SQLiteDialect");
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.addAnnotatedClass(classToMap);
        configuration.setProperties(settings);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }

    public static Session openSQLiteSession (String fileName, List<Class> classToMap ) {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.sqlite.JDBC");
        settings.put(Environment.URL, fileName.contains(".sqlite") ? "jdbc:sqlite:" + fileName : "jdbc:sqlite" + fileName + ".sqlite");
        settings.put(Environment.DIALECT, "com.enigmabridge.hibernate.dialect.SQLiteDialect");
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        for ( Class clazz : classToMap ) {
            configuration.addAnnotatedClass(clazz);
        }
        configuration.setProperties(settings);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }


    public static Session openMySQLSession(String address, int port, String database, String username, String password) {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://" + address + ":" + port + "/" + database);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        settings.put(Environment.USER,username);
        settings.put(Environment.PASS,password);
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }

    public static Session openMySQLSession( String address, String database, String username, String password) {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://" + address + ":3306" + "/" + database);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        settings.put(Environment.USER,username);
        settings.put(Environment.PASS,password);
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        List<Package> packageWithAnnotation = Arrays.stream(Package.getPackages()).filter(c -> c.isAnnotationPresent(Entity.class)).collect(Collectors.toList());
        configuration.setProperties(settings);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }

    public static Session openMySQLSession( String address, String database, String username, String password, Class classToMap ) {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://" + address + ":3306" + "/" + database);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        settings.put(Environment.USER,username);
        settings.put(Environment.PASS,password);
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        configuration.addAnnotatedClass(classToMap);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }

    public static Session openMySQLSession(String address, int port, String database, String username, String password, List<Class> classToMap ) {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://" + address + ":" + port + "/" + database);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        settings.put(Environment.USER,username);
        settings.put(Environment.PASS,password);
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        for ( Class clazz : classToMap ) {
            configuration.addAnnotatedClass(clazz);
        }
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }


    public static Session openMySQLSession( String address, String database, String username, String password, List<Class> classToMap ) {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://" + address + ":3306" + "/" + database);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        settings.put(Environment.USER,username);
        settings.put(Environment.PASS,password);
        settings.put(Environment.SHOW_SQL, "false");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);
        for ( Class clazz : classToMap ) {
            configuration.addAnnotatedClass(clazz);
        }
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).openSession();
    }

}
