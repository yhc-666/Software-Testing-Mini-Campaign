import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert.*;


public class systemTest {
    // Test when any file has records with missing values
    @Test
    public void testCompcsv1() {
        List<List<String>> list1 = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with missing values/test1.csv");
        List<List<String>> list2 = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with missing values/test2.csv");
        List<List<String>> diff = CSVcomparator.compare_csv_file(list1, list2);
        CSVcomparator.generate_csv_file(diff);
        List<List<String>> result = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/result/result.csv");
        List<List<String>> expect = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with missing values/target.csv");
        assertEquals(expect,result);
    }

    // Test when one of file has repeat customer ID
    @Test
    public void testCompcsv2() {
        List<List<String>> list1 = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with repeat customer ID/test1.csv");
        List<List<String>> list2 = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with repeat customer ID/test2.csv");
        List<List<String>> diff = CSVcomparator.compare_csv_file(list1, list2);
        CSVcomparator.generate_csv_file(diff);
        List<List<String>> result = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/result/result.csv");
        List<List<String>> expect = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with repeat customer ID/target.csv");
        assertEquals(expect,result);
    }
    // Test when Both files have several(>=1) repeat customer IDs.
    @Test
    public void testCompcsv3() {
        List<List<String>> list1 = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on if any file has records with missing values/Both files have several(>=1) repeat customer IDs/test1.csv");
        List<List<String>> list2 = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on if any file has records with missing values/Both files have several(>=1) repeat customer IDs/test2.csv");
        List<List<String>> diff = CSVcomparator.compare_csv_file(list1, list2);
        CSVcomparator.generate_csv_file(diff);
        List<List<String>> result = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/result/result.csv");
        List<List<String>> expect = CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/both file has repeat id/target.csv");
        assertEquals(expect,result);
    }
    // Test when if files' extensions are .csv
    @Test
    public void testCompcsv4() {
    try { 
        CSVcomparator.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file not end with csv/test2.png");
          fail("didn't catch wrong file type error)");
     } catch (Exception e) {
         System.out.println("successfully caught wrong file type error");
     } 
    }


}
