package Fit;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class EX2_Fit {
	private WebDriver driver;
	String baseUrl = "https://fit.hanu.vn/login/index.php";
	String afterUrl = "https://fit.hanu.vn/my/";
	@Test(dataProvider = "LoginData")
	public void TestLogin(String username, String pass, String result ) {
		driver.get(baseUrl);
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		
		driver.findElement(By.id("loginbtn")).click();
		
		if(result.equals("pass")) {
			if(driver.getCurrentUrl().equals(afterUrl)){
				driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
				driver.findElement(By.xpath("//em[text()='Thoát']")).click();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}else {
			if(driver.getCurrentUrl().equals(afterUrl)) {
				Assert.assertTrue(false);
			}else {
				
				Assert.assertTrue(true);
			}
		}
	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() {
		return 
				new String[][] { 
			new String[] { "1234", "fit", "fail" }, 
			new String[] { "1701040099", "Fit@2019", "pass" }, 
			new String[] { "1701040093", "Cho Thui av6", "pass" }, 
			new String[] { "1701040188", "345", "fail"},
			
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

