package solver.utils;

import com.google.gson.Gson;
import solver.entities.Table;

public class CloningUtility {

    public static String serializeObject(Table o) {
        return new Gson().toJson(o);
    }

    public static Table deserializeObject(String s, Table o) {
        return new Gson().fromJson(s, o.getClass());
    }

    public static Table copyTable(Table o) {
        return deserializeObject(serializeObject(o), o);
    }
}
