import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseHTML {
    Storage storage;
    public void parseHtmlFormat(String link) {

        try {
            Document doc = Jsoup.connect(link).get();

            //имя линии и номер
            Elements el1 = doc.select(".t-metrostation-list-header");
            el1.forEach(element -> {
                String nameLine = element.text();
                String numLine = element.attr("data-line");
                storage.lines.add(new Line(nameLine, numLine));
            });

            //номер линии и станции
            Elements el2 = doc.select(".t-metrostation-list-table");

            el2.forEach(element -> {
                String num = element.attr("data-line");

                Elements el3 = element.select("> p.single-station > span");

                el3.forEach(element1 -> {

                    if (element1.hasClass("name")) {
                        String name = element1.text();
                        storage.lines.forEach(line -> {
                            if (line.getNumberLine().equals(num)) {
                                String nameLine = line.getNameLine();
                                storage.stations.add(new Station(name,num,nameLine));
                            }
                        });

                    } else if (element1.hasAttr("title")) {
                        int index = storage.stations.size();
                        storage.stations.get(index-1).setHasConnection(true);

                    } else if (!element1.hasClass("num")) {
                        int index = storage.stations.size();
                        storage.stations.get(index-1).setHasConnection(false);
                    }
                });
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//    public void printHtml() {
//
//        System.out.println("Station count: " + listStation.size());
//
//        for (Line line : listLine) {
//            System.out.println(line);
//        }
//
//        for (Station station : listStation) {
//            System.out.println(station);
//        }
//    }


}
