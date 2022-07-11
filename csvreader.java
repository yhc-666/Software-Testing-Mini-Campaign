import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class csvreader {

    public static ArrayList read(String filepath) {


        ArrayList<Map> list = new ArrayList<>();

        
        try{
            File csv = new File(filepath);

            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            
            String lineDta = "";

            String cvsSplitBy = ",";
        

            while ((lineDta = textFile.readLine()) != null){
                String[] userc = lineDta.split(cvsSplitBy);
                Map dict = new HashMap();
                dict.put("Customer ID", userc[0]);
                dict.put("Account No.", userc[1]);
                dict.put("Currency", userc[2]);
                dict.put("Type", userc[3]);
                dict.put("Balance", userc[4]);

                list.add(dict);

            }


        
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }
        return list;

    }
}