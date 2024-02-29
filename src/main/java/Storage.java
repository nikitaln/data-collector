import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    static List<Station> stations = new ArrayList<>();
    static List<Line> lines = new ArrayList<>();

    public List<Station> getStations() {
        return new ArrayList<>();
    }

    public void printStations() {
        for (Station station : stations) {
            System.out.println(station);
        }
    }

    public void printLines() {
        for (Line line : lines) {
            System.out.println(line);
        }
    }

    public void createJsonFileWithStationsInfo() {

        JSONObject jsonObjectStations = new JSONObject();
        JSONArray arrayAllStations = new JSONArray();

        for (int i = 0; i < stations.size(); i++) {

            String name = stations.get(i).getNameStation();
            String nameLine = stations.get(i).getNameLine();
            String date = stations.get(i).getDateOpen();
            String depth = stations.get(i).getDepth();
            boolean isConnection = stations.get(i).isHasConnection();

            JSONObject jsonOneStation = new JSONObject();

            if (name != null) {
                jsonOneStation.put("name:", name);
            }
            if (nameLine != null) {
                jsonOneStation.put("line:", nameLine);
            }
            if (date != null) {
                jsonOneStation.put("date:", date);
            }
            if (depth != null) {
                jsonOneStation.put("depth:", depth);
            }
            jsonOneStation.put("hasConnection:", isConnection);
            arrayAllStations.add(jsonOneStation);
        }
        jsonObjectStations.put("stations: ", arrayAllStations);


        try {
            FileWriter file = new FileWriter("output/stations.json");
            file.write(jsonObjectStations.toJSONString());
            file.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();

        Path path = Paths.get("output/stations.json");

        String str = null;
        try {
            str = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.write(Paths.get("output/stations.json"),
                    mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(mapper.readTree(str)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void createJsonFileWithMetroStation() {

        JSONObject jsonObjectMain = new JSONObject();
        JSONObject jsonObjectWithLine = new JSONObject();

        for (int i = 0; i < lines.size(); i++) {
            JSONArray arrayStations = new JSONArray();
            int x = i;
            stations.forEach(station -> {
                if (station.getNumberLine().equals(lines.get(x).getNumberLine())) {
                    arrayStations.add(station.getNameStation());
                }
                jsonObjectWithLine.put(lines.get(x).getNumberLine(), arrayStations);
            });
        }

        JSONArray arrayLines = new JSONArray();

        for (int i = 0; i < lines.size(); i++) {
            JSONObject jsonObjectOneLine = new JSONObject();
            jsonObjectOneLine.put("number:", lines.get(i).getNumberLine());
            jsonObjectOneLine.put("name:", lines.get(i).getNameLine());
            arrayLines.add(jsonObjectOneLine);
        }

        jsonObjectMain.put("stations:", jsonObjectWithLine);
        jsonObjectMain.put("lines: ", arrayLines);

        try {
            FileWriter file = new FileWriter("output/metro.json");
            file.write(jsonObjectMain.toJSONString());
            file.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();

        Path path = Paths.get("output/metro.json");

        String str = null;
        try {
            str = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.write(Paths.get("output/metro.json"), mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(mapper.readTree(str)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

