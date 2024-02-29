import java.util.ArrayList;
import java.util.List;

public class Line {

    private String nameLine;
    private String numberLine;
    private List<Station> stations;

    public Line(String nameLine, String numberLine)
    {
        this.nameLine = nameLine;
        this.numberLine = numberLine;
        stations = new ArrayList<>();
    }


    public String getNameLine() {
        return nameLine;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }

    public List<Station> getStations()
    {
        return stations;
    }


    @Override
    public String toString() {
        return "Line{" +
                "nameLine='" + nameLine + '\'' +
                ", numberLine='" + numberLine + '\'' +
                '}';
    }
}
