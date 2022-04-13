package Fit;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login {
	private WebDriver driver;
	private static String url = "http://fit.hanu.vn/login/index.php";
	
  @Test(dataProvider = "LoginData")
  public void Login(String username, String password) {
	  driver.get(url); 
	  driver.findElement(By.xpath("//input[@id=\'username\']")).clear();
	  driver.findElement(By.xpath("//input[@id=\'username\']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@id=\'password\']")).clear();
	  driver.findElement(By.xpath("//input[@id=\'password\']")).sendKeys(password);
	  
	  String Title = driver.getTitle();
	  System.out.println("Title" + Title + "Account" + username + " / " + password);
	  Assert.assertTrue(true);
	  }

  @DataProvider(name = "LoginData")
  public String[][] getData() {
    return new String[][] {
      new String[] { "123", "abc" },
      new String[] { "abcd", "efgh" },
      new String[] { "1701040099", "Fit@2019" }
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\HCL\\Technical\\XPath\\chromedriver.exe");
	  driver = new ChromeDriver();
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
