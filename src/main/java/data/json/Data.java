package data.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    private Map<String, List<Object>> data = new HashMap<>();
    private int classCount = 0;
    private int totalRecord = 0;

    public Data() {

    }

    public void addData ( Object o ) {
        if ( !data.containsKey(o.getClass().getName())) {
            data.put(o.getClass().getName(), new ArrayList<>());
        }
        data.get(o.getClass().getName()).add(o);
        classCount = data.keySet().size();
        totalRecord++;
    }

    public boolean empty() {
        return data.entrySet().size() != 0;
    }

}
