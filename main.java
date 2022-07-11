import java.util.List;
import java.util.ArrayList;



public class main {

    public static void main(String[] args) {
        String filepath1 = "./data/sample_file_1.csv";
        String filepath2 = "./data/sample_file_3.csv";
        ArrayList<String> filecontent1 = csvreader.read(filepath1);
        ArrayList<String> filecontent2 = csvreader.read(filepath2);
        ArrayList filedifference = comparator.compare(filecontent1, filecontent2);
        csvgenerator.createCSV(filedifference);
    }
}
