import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class comparator{
    public static ArrayList compare(ArrayList filecontent1, ArrayList filecontent2) {
        ArrayList filedifference = new ArrayList<>();
        for (int i = 0; i < filecontent1.size(); i++) {
            if (filecontent1.get(i).equals(filecontent2.get(i))) {
                continue;
            } else {
                filedifference.add(filecontent2.get(i));
                filedifference.add(filecontent1.get(i));

            }
        }
        return filedifference;
    }
}
    
    
