package data;

import java.util.List;

public interface DataManager<T> {

    boolean save( Object obj );
    T loadAll();

}
