import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseJSON {
    Storage storage;
    public void parseJsonFile(List<String> path) {

        for (int i=0; i < path.size(); i++) {
            try {
                JSONParser parser = new JSONParser();
                FileReader reader = new FileReader(path.get(i));
                JSONArray array = (JSONArray) parser.parse(reader);
                for (int j=0; j < array.size(); j++) {
                    JSONObject o = (JSONObject) array.get(j);
                    String nameStation = o.get("station_name").toString();
                    String depthStation = o.get("depth").toString();
                    storage.stations.forEach(station ->
                    {
                        if (station.getNameStation().equals(nameStation)) {
                            station.setDepth(depthStation);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
