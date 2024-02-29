import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFolder {
    private List<String> listJson = new ArrayList<>();
    private List<String> listCsv = new ArrayList<>();
    public List<String> searchFolderWithJson(String path) {

        //проверяем существует ли данный путь и указывает ли он на каталог
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Такого пути нет");
        }
        if (!file.isDirectory()) {
            System.out.println("Это не каталог с папками");
        }
        else {

            //массив для хранения названий каталогов в данной папке
            String[] dirList = file.list();

            for (int i=0; i < dirList.length; i++) {
                File f1 = new File(path + File.separator + dirList[i]);
                if (f1.isFile()) {

                    if (f1.getName().endsWith("json")) {
                        String link = path + File.separator + dirList[i];
                        listJson.add(link);
                    }

                } else {
                    searchFolderWithJson(path + File.separator + dirList[i]);
                }
            }
        }
        return listJson;
    }

    public List<String> searchFolderWithCsv(String path) {

        //проверяем существует ли данный путь и указывает ли он на каталог
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Такого пути нет");
        }
        if (!file.isDirectory()) {
            System.out.println("Это не каталог с папками");
        }
        else {

            //массив для хранения названий каталогов в данной папке
            String[] dirList = file.list();

            for (int i=0; i < dirList.length; i++) {
                File f1 = new File(path + File.separator + dirList[i]);
                if (f1.isFile()) {

                    if (f1.getName().endsWith("csv")) {
                        String link = path + File.separator + dirList[i];
                        listCsv.add(link);
                    }

                } else {
                    searchFolderWithCsv(path + File.separator + dirList[i]);
                }
            }
        }
        return listCsv;
    }
    public void printFolderPath() {

        for (String path : listJson) {
            System.out.println("Путь к файлу json: " + path);
        }

        for (String path : listCsv) {
            System.out.println("Путь к файлу csv: " + path);
        }

    }
}

