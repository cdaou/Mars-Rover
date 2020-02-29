import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTest {
	
	public static void main(String[] args) {
		
		//RUNNING THE TEST(S) IMPLEMENTED IN TestJUnit CLASS
		Result result = JUnitCore.runClasses(TestJUnit.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}
}
	
	
	
	
	

