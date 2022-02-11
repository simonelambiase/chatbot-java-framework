package data.mysql;

import data.DataManager;
import data.helper.ConnectionFactory;
import org.hibernate.Session;

public class DataManagerMySQL implements DataManager {

    Session s;

    public DataManagerMySQL( String address, int port, String database, String username, String password ) {
        s = ConnectionFactory.openMySQLSession(address,port,database,username,password);

    }

    public DataManagerMySQL( String address, String database, String username, String password ) {
        s = ConnectionFactory.openMySQLSession(address,database,username,password);

    }

    @Override
    public boolean save(Object obj) {
        s.saveOrUpdate(obj);
        s.getTransaction().commit();
        return false;
    }

    @Override
    public Object loadAll() {
        return null;
    }
}
