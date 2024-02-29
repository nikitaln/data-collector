import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ParseHTML html = new ParseHTML();
            html.parseHtmlFormat("https://skillbox-java.github.io/");

        Storage storage = new Storage();

        SearchFolder folder = new SearchFolder();

        ParseJSON json = new ParseJSON();
            json.parseJsonFile(folder.searchFolderWithJson("data"));
        ParseCSV csv = new ParseCSV();
            csv.parseCsvFile(folder.searchFolderWithCsv("data"));

            storage.createJsonFileWithStationsInfo();
            storage.createJsonFileWithMetroStation();

    }
}
