package data.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.DataManager;
import lombok.SneakyThrows;

import java.io.*;

public class DataManagerJSON<T> implements DataManager {

    private File dataFile = new File("data.json");
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Data data = new Data();

    @SneakyThrows
    public DataManagerJSON() {
        if ( !dataFile.exists() ) {
            dataFile.createNewFile();
        }
    }

    @Override
    public boolean save(Object obj) {
        try (  FileWriter writer = new FileWriter(dataFile) ){
            gson.fromJson(new FileReader(dataFile), Data.class);
            data.addData(obj);
            gson.toJson(data,writer);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @SneakyThrows
    @Override
    public T loadAll() {
        return (T) gson.fromJson(new FileReader(dataFile),Object.class);
    }

}
