import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParseCSV {
    Storage storage;
    public void parseCsvFile(List<String> path) {

        for (int i=0; i<path.size(); i++) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(path.get(i)));

                for (String line : lines) {

                    String[] fragments = line.split(",");
                    if (fragments.length == 2) {
                        String nameStations = fragments[0];
                        String dateOpen = fragments[1];
                        storage.stations.forEach(station -> {
                            if (station.getNameStation().equals(nameStations)) {
                                station.setDateOpen(dateOpen);
                            }
                        });
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
