package math;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;

public class NewTestNG {
	Cal c;

	// @Test (enabled = false)
	@Test(priority = 4, groups = { "basic1" })
	public void testAdd() throws Exception {
		int x = 10, y = 10;
		int actual = c.add(x, y);
		assertEquals(actual, 20);
	}

	@Test(priority = 1, groups = { "advance" })
	public void testSub() throws Exception {
		int x = 10, y = 10;
		int actual = c.sub(x, y);
		assertEquals(actual, 0);
	}

	@Test(priority = 2, groups = { "basic1" })
	public void testDiv() throws Exception {
		int x = 24, y = 6;
		int actual = c.div(x, y);
		assertEquals(actual, 4);
	}

	@Test(priority = 3, groups = { "basic2" })
	public void testMul() throws Exception {
		int x = 5, y = 3;
		int actual = c.mul(x, y);
		assertEquals(actual, 15);
	}

	@BeforeClass(groups = { "basic1", "basic2", "advance" })
	public void beforeClass() {
		c = new Cal();
	}

	@AfterClass
	public void afterClass() {
	}

}
