import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert.*;


public class systemTest {
    // Test when any file has records with missing values
    @Test
    public void testCompcsv1() {
        CSVComparer comparator_shiyu = new CSVComparer()
        List<List<String>> list1 = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with missing values/test1.csv");
        List<List<String>> list2 = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with missing values/test2.csv");
        List<List<String>> diff = comparator_shiyu.compare_csv_file(list1, list2);
        CSVcomparator.generate_csv_file(diff);
        List<List<String>> result = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/result/result.csv");
        List<List<String>> expect = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with missing values/target.csv");
        assertEquals(expect,result);
    }

    // Test when one of file has repeat customer ID
    @Test
    public void testCompcsv2() {
        CSVComparer comparator_shiyu = new CSVComparer()
        List<List<String>> list1 = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with one repeat customer ID/test1.csv");
        List<List<String>> list2 = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with one repeat customer ID/test2.csv");
        List<List<String>> diff = comparator_shiyu.compare_csv_file(list1, list2);
        CSVcomparator.generate_csv_file(diff);
        List<List<String>> result = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/result/result.csv");
        List<List<String>> expect = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file with one repeat customer ID/target.csv");
        assertEquals(expect,result);
    }
    // Test when Both files have several(>=1) repeat customer IDs.
    @Test
    public void testCompcsv3() {
        CSVComparer comparator_shiyu = new CSVComparer()
        List<List<String>> list1 = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/both file has several repeat id/test1.csv");
        List<List<String>> list2 = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/both file has several repeat id/test2.csv");
        List<List<String>> diff = comparator_shiyu.compare_csv_file(list1, list2);
       comparator_shiyu.generate_csv_file(diff);
        List<List<String>> result = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/result/result.csv");
        List<List<String>> expect = comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/both file has several repeat id/target.csv");
        assertEquals(expect,result);
    }
    // Test when if files' extensions are .csv
    @Test
    public void testCompcsv4() {
    try { 
        CSVComparer comparator_shiyu = new CSVComparer()
        comparator_shiyu.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/systest/file not end with csv/test2.png");
          fail("didn't catch wrong file type error)");
     } catch (Exception e) {
         System.out.println("successfully caught wrong file type error");
     } 
    }


}
