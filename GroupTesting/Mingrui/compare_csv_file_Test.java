import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert.*;


public class compare_csv_file_Test {
    // 1.The input space is partitioned based on if any file has records with missing values
    
    // 1.1 Only one record has one missing value
    @Test
    public void testCompcsv1() {
        csvComparer comparator_mingrui = new csvComparer()
        List<List<String>> list1 = comparator_mingrui.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on any file has two repeat customer ID(which covers if two files have the same number of records)/Only one record has one missing value/test1.csv");
        List<List<String>> list2 = comparator_mingrui.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on any file has two repeat customer ID(which covers if two files have the same number of records)/Only one record has one missing value/test2.csv");
        String expect = "[[\"ID1\", \"\", \"USD\", \"SAVINGS\", \"962510\"], [\"ID1\", \"BOS963211\", \"USD\", \"SAVINGS\", \"962510\"]]";
        String result = comparator_mingrui.compare_csv_file(list1, list2).toString();
        assertEquals(expect,result);
    }

    // 1.2 Several records has several missing values in both files
    @Test
    public void testCompcsv2() {
        csvComparer comparator_mingrui = new csvComparer()
        List<List<String>> list1 = comparator_mingrui.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on any file has two repeat customer ID(which covers if two files have the same number of records)/Several records has several missing values in both files/test1.csv");
        List<List<String>> list2 = comparator_mingrui.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on any file has two repeat customer ID(which covers if two files have the same number of records)/Several records has several missing values in both files/test2.csv");
        String expect = "[[\"ID1\", \"\", \"USD\", \"SAVINGS\", \"962510\"], [\"ID2\", \"BOS85992\", \"AUD\", \"CURRENT\", \"\"], [\"ID1\", \"BOS963211\", \"USD\", \"SAVINGS\", \"962510\"], [\"ID2\", \"\", \"AUD\", \"CURRENT\", \"989898\"]]";
        String result = CSVcomparator.compare_csv_file(list1, list2).toString();
        assertEquals(expect,result);
    }

    // 2. The input space is partitioned based on any file has two repeat customer ID(which covers "if two files have the same number of records")
    // 2.1 One of the files has one repeat customer ID, the other one has no repeat customer ID.
    @Test
    public void testCompcsv3() {
        csvComparer comparator_mingrui = new csvComparer()
        List<List<String>> list1 = comparator_mingrui.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on if any file has records with missing values/One of the files has one repeat customer ID, the other one has no repeat customer ID/test1.csv");
        List<List<String>> list2 = comparator_mingrui.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on if any file has records with missing values/One of the files has one repeat customer ID, the other one has no repeat customer ID/test2.csv");
        String expect = "[[\"ID1\", \"BOS963211\", \"USD\", \"SAVINGS\", \"962510\"]]";
        String result = comparator_mingrui.compare_csv_file(list1, list2).toString();
        assertEquals(expect,result);
    }
    
    // 2.2 Both files have several(>=1) repeat customer IDs.
    @Test
    public void testCompcsv4() {
        csvComparer comparator_mingrui = new csvComparer()
        List<List<String>> list1 = comparator_mingrui.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on if any file has records with missing values/Both files have several(>=1) repeat customer IDs/test1.csv");
        List<List<String>> list2 = comparator_mingrui.read_csv_file("/Users/haochengyang/Desktop/Study/term5/software_engineering/Software-Testing-Mini-Campaign/Test_data/compare_csv_file_Test/The input space is partitioned based on if any file has records with missing values/Both files have several(>=1) repeat customer IDs/test2.csv");
        String expect = "[[\"ID1\", \"BOS963211\", \"USD\", \"SAVINGS\", \"962510\"]]";
        String result = CSVcomparator.compare_csv_file(list1, list2).toString();
        assertEquals(expect,result);
    }
}
