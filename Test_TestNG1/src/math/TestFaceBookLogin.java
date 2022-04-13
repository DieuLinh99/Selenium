package math;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestFaceBookLogin {
	private WebDriver driver;
  @Test(groups = {"basic"})
  public void testFBLogin() {
	  driver.get("https://www.facebook.com/");
	  
	  driver.findElement(By.id("email")).click();
	  driver.findElement(By.id("email")).sendKeys("0266535748");
	   driver.findElement(By.id("pass")).click();
	   driver.findElement(By.id("pass")).sendKeys("abcndh");
	   driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  @BeforeClass(groups = {"basic"})
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\HCL\\Technical\\XPath\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	    
  }

  @AfterClass(groups = {"basic"})
  public void afterClass() {
	  driver.quit();
  }
  
}
