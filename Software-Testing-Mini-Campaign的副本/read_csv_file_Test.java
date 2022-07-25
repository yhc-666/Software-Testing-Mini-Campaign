import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert.*;


public class read_csv_file_Test { 
    // the input space is partitioned based on Check if both files' extensions are .csv
    
    // 1.Test when two input files are both ended with .csv
    @Test
    public void testReadcsv1 () {
    String expect = "[[\"ID1\", \"BOS963211\", \"USD\", \"SAVINGS\", \"962510\"], [\"ID2\", \"BOS85992\", \"AUD\", \"CURRENT\", \"989898\"]]";
    String result = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/read_csv_file_Test/two files both ended with csv/test1.csv").toString();
    assertEquals(expect,result);
    String expect2 = "[[\"ID1\", \"BOS963211\", \"USD\", \"SAVINGS\", \"962510\"], [\"ID2\", \"BOS85992\", \"AUD\", \"CURRENT\", \"989898\"]]";
    String result2 = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/read_csv_file_Test/two files both ended with csv/test2.csv").toString();
    assertEquals(expect2,result2);
    }
    

    // 2.Test when One of the files is not ended with .csv
    @Test
    public void testReadcsv2 () {
    String expect = "[[\"ID1\", \"BOS963211\", \"USD\", \"SAVINGS\", \"962510\"], [\"ID2\", \"BOS85992\", \"AUD\", \"CURRENT\", \"989898\"]]";
    String result = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/read_csv_file_Test/One of the files is not ended with .csv/test1.csv").toString();
    assertEquals(expect,result);
    try { 
        CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/read_csv_file_Test/One of the files is not ended with .csv/test2.png");
          fail("didn't catch wrong file type error)");
     } catch (Exception e) {
         System.out.println("successfully caught wrong file type error");
     } 
    }

    // 3.Test when Both files are not ended with .csv
    @Test
    public void testReadcsv3 () {
    try { 
        CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/read_csv_file_Test/Both files are not ended with .csv/test1.jpeg.png");
        fail("didn't catch wrong file type error)");
         } catch (Exception e) {
             System.out.println("successfully caught wrong file type error");
         } 
    try { 
        CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/read_csv_file_Test/Both files are not ended with .csv/test2.png");
          fail("didn't catch wrong file type error)");
     } catch (Exception e) {
         System.out.println("successfully caught wrong file type error");
     } 
    }
}

