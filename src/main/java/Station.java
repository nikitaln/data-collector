public class Station {
    private String nameStation;
    private String numberLine;
    private String nameLine;
    private String dateOpen;
    private String depth;
    boolean hasConnection;

    public Station(String nameStation, String numberLine, String nameLine) {
        this.nameStation = nameStation;
        this.numberLine = numberLine;
        this.nameLine = nameLine;
    }

    public Station(String nameStation, String numberLine, String nameLine, String dateOpen, String depth, boolean hasConnection) {
        this.nameStation = nameStation;
        this.numberLine = numberLine;
        this.nameLine = nameLine;
        this.dateOpen = dateOpen;
        this.depth = depth;
        this.hasConnection = hasConnection;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    @Override
    public String toString() {
        return "Станция:\n " +
                "\tназвание: " + nameStation + "\n" +
                "\tномер линии: " + numberLine + "\n" +
                "\tназвание линии: " + nameLine + "\n" +
                "\tдата открытия: " + dateOpen + "\n" +
                "\tглубина: " + depth + "\n" +
                "\tпересадка: " + hasConnection;
    }
}
