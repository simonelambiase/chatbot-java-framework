package data.sqlite;

import data.DataManager;
import data.helper.ConnectionFactory;
import org.hibernate.Session;

import java.util.List;

public class DataManagerSQLite implements DataManager {

    Session s;

    public DataManagerSQLite() {

        s = ConnectionFactory.openSQLiteSessionFactory();
    }

    public DataManagerSQLite( String fileName ) {
        s = ConnectionFactory.openSQLiteSessionFactory(fileName);

    }

    @Override
    public boolean save( Object obj) {
        s.save(obj);
        s.getTransaction().commit();
        return true;
    }

    @Override
    public List loadAll() {
        return null;
    }



}
