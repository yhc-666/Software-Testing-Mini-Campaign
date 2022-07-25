import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVcomparator {

    public static void main(String[] args) {
        List<List<String>> list1 = read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/data/sample_file_1.csv");
        List<List<String>> list2 = read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/data/sample_file_3.csv");

        List<List<String>> exceptions = compare_csv_file(list1, list2);

        generate_csv_file(exceptions);

        //List<List<String>> list3 = read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class1/class1_boundary2.csv");
        //System.out.println(list3);
    }

    public static List<List<String>> read_csv_file(String csv_path) {
        List<List<String>> list = new ArrayList<>();
        
        try{
            File csv = new File(csv_path);
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            String lineDta = "";

            while ((lineDta = textFile.readLine()) != null){

                String[] user = lineDta.split(",");

                List<String> entry = new ArrayList<>();
                entry.add(user[0]);
                entry.add(user[1]);
                entry.add(user[2]);
                entry.add(user[3]);
                entry.add(user[4]);
                list.add(entry);
            }

        }catch (FileNotFoundException e){
            System.out.println("No such file");
        }catch (IOException e){
            System.out.println("read failed");
        }catch (Exception e){}

        list.remove(0);
        return list;
    }

    public static List<List<String>> compare_csv_file(List<List<String>> list1, List<List<String>> list2) {

        List<List<String>> exceptions = new ArrayList<>();
    
        if (list1.size() > list2.size()) {
            for(int i = 0; i < list1.size(); i++){
                for(int j = 0; j < list2.size(); j++){
                    if(list1.get(i).equals(list2.get(j))){
                        list1.remove(i);
                        list2.remove(j);
                        j -= 1;
                    }
                }
            }
        }
        else{
            for(int i = 0; i < list2.size(); i++){
                for(int j = 0; j < list1.size(); j++){
                    if(list2.get(i).equals(list1.get(j))){
                        list2.remove(i);
                        list1.remove(j);
                        j -= 1;
                    }
                }
            }
        }
        exceptions.addAll(list1);
        exceptions.addAll(list2);
        return exceptions;
    }

    public static void generate_csv_file(List<List<String>> exceptions) {
        List<List<Object>> dataList = new ArrayList<>();
        List<Object> entryList;

        for (int i = 0; i < exceptions.size(); i++) {
            List<String> entryData = exceptions.get(i);

            entryList = new ArrayList<>();
            entryList.add(entryData.get(0));
            entryList.add(entryData.get(1));
            entryList.add(entryData.get(2));
            entryList.add(entryData.get(3));
            entryList.add(entryData.get(4));
            dataList.add(entryList);

        }

        String fileName = "result.csv";
        String filePath = "result/";

        File csvFile = null;
        BufferedWriter csvWriter = null;
        try {
            csvFile = new File(filePath + fileName);
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);

            for (List<Object> entry : dataList) {
                writeEntry(entry, csvWriter);
            }
            csvWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeEntry(List<Object> entry, BufferedWriter csvWriter) throws IOException {
        for (Object data : entry) {
            StringBuffer stringBuffer = new StringBuffer();
            String entryStr = stringBuffer.append(data).append(",").toString();
            csvWriter.write(entryStr);
        }
        csvWriter.newLine();
    }
}







