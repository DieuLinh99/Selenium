package EX4;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.*;

import EX4.XLSReader;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Demo {
	private WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	String baseUrl = "https://fit.hanu.vn/login/index.php";
	String afterUrl = "https://fit.hanu.vn/my/";
	
	
	
	@Test(dataProvider = "LoginData")
	public void TestLogin(String username, String pass, String result) {
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
				test.log(LogStatus.PASS, "Navigated to the specified URL");
			}else {
				Assert.assertTrue(false);
				test.log(LogStatus.FAIL, "Test Failed");
			}
		}else {
			if(driver.getCurrentUrl().equals(afterUrl)) {
				Assert.assertTrue(false);
				test.log(LogStatus.PASS, "Navigated to the specified URL");
			}else {
				
				Assert.assertTrue(true);
				test.log(LogStatus.FAIL, "Test Failed");
			}
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() {
		String[][] rowCol = null;
		try {
			XLSReader reader = new XLSReader("C:\\Users\\User\\Downloads\\HCL\\Technical\\test2.xlsx");
			String sheetName = "Account";
			
			int noOfRow = reader.getRow(sheetName);
			int noOfCell = reader.getCell(sheetName, 1);
			
			int a, b;
			rowCol = new String[noOfRow-1][noOfCell];
			a = 0;
			for(int i = 1; i < noOfRow; i++) {
				b = 0;
				for(int j = 0; j < noOfCell; j++) {
					//System.out.print(reader.getCellData(sheetName, i, j) + " ");
					rowCol[a][b] = reader.getCellData(sheetName, i, j);
					b++;
				}
			a++;
			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCol;
			//new String[] { "1234", "fit", "fail" }, 
			//new String[] { "1701040099", "Fit@2019", "pass" }, 
			//new String[] { "1701040093", "Cho Thui av6", "pass" }, 
			//new String[] { "1701040188", "345", "fail"},
			
	}

  @BeforeClass
  public void beforeClass() {
	  report = new ExtentReports(System.getProperty("user.dir")+"/test-output/MenuTestResults.html");
		test = report.startTest("W3School");
		
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\HCL\\Technical\\XPath\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
  }

  @AfterClass
  public void afterClass() {
	  report.endTest(test);
		report.flush();
	  driver.quit();
  }

}
