package math;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewMathTest {
 
	 Calculator c;
	 @Test
	  public void testSub() {
		  int a = 7, b = 10;
		  int actual = c.sub(b, a);
		  assertEquals(actual,3);
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  c = new Calculator();
	  }

	  @AfterClass
	  public void afterClass() {
	  }
}
