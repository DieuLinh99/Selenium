package math;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class NewTestNG1 {
	 private Cal c; 
	 @Test (groups = {"basic"})
	 public void testAdd() throws Exception {
		  int x = 15, y = 10;
		  int actual = c.add(x, y);
		  assertEquals(actual,25);
	  }
	 @Test (groups = {"basic"})
	 public void testSub() throws Exception{
		 int x = 30, y = 10;
		 int actual = c.sub(x, y);
		 assertEquals(actual,20);
	 }
	 @Test (groups = {"advance"})
	 public void testDiv() throws Exception{
		 int x = 10, y = 2;
		 int actual = c.div(x, y);
		 assertEquals(actual,5);
	 }
	 @Test (groups = {"advance"})
	 public void testMul() throws Exception{
		 int x = 5, y = 3;
		 int actual = c.mul(x, y);
		 assertEquals(actual,15);
	 }
	 @BeforeClass (groups = {"basic", "advance"})
	  public void beforeClass() {
		  c = new Cal();
	  }

	  @AfterClass
	  public void afterClass() {
	  }
}	 
