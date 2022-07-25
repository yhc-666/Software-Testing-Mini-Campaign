
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.JUnit4TestAdapter;

@RunWith (Suite.class)
//
@Suite.SuiteClasses ({read_csv_file_Test.class, compare_csv_file_Test.class, systemTest.class})

public class Testall {
        // Execution begins at main().  In this test class, we will execute
    // a text test runner that will tell you if any of your tests fail.
    public static void main (String[] args)
    {
    	JUnit4TestAdapter suite = new JUnit4TestAdapter (Testall.class);
    	junit.textui.TestRunner.run(suite);
    	
    	/*List<Test> list = suite.getTests();
    	System.out.println("test count " + list.size());
    	for (int i = 0; i < list.size(); i++) {
    		junit.textui.TestRunner.run(list.get(i));
    	}*/
    }
}
