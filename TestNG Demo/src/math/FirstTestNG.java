package math;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;


public class FirstTestNG {
  private Calculator c; 
  private WebDriver driver;
  
  @Test(priority = 2,groups= {"basic"})
  public void testAdd() {
	  int a = 7, b = 10;
	  int actual = c.add(a, b);
	  assertEquals(actual,17);
  }
  @Test(priority = 1,groups= {"advance"})
  public void testDevide() {
	  int a = 9, b = 3;
	  int actual = c.devide(a, b);
	  assertEquals(actual,3);
  }
  //a test suite
  //group test 
  //ignore
  @Test(enabled = false, groups= {"basic"})
  public void testSub() {
	  int a = 7, b = 10;
	  int actual = c.sub(b, a);
	  assertEquals(actual,3);
  }
  @Test
  public void testText() {
	    driver.get("https://www.w3schools.com/");// launching the web browser and access the url
	    //explicit wait 
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("w3loginbtn")));
	    
	    driver.findElement(By.id("w3loginbtn")).click();
		System.out.println(driver.getTitle());
	    driver.findElement(By.id("modalusername")).click();
	    driver.findElement(By.id("modalusername")).sendKeys("abc");
	    driver.findElement(By.id("current-password")).click();
	    driver.findElement(By.id("current-password")).sendKeys("123");
	    //driver.findElement(By.cssSelector("html")).click();
	    driver.findElement(By.cssSelector(".\\_1VfsI")).click();
	    driver.navigate().to("http://fit.hanu.vn/");
	    driver.close();//close the current browser
  }
  @BeforeClass(groups= {"basic"})
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "D:\\FIT\\HCL\\ForAutoTest\\chromedriver_win32_9.3\\chromedriver.exe");
	  driver = new ChromeDriver();
	  c = new Calculator();
  }

  @AfterClass(groups= {"basic"})
  public void afterClass() {
	  driver.quit();
  }

}
