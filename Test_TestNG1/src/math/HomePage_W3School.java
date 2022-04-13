package math;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class HomePage_W3School {
	private WebDriver driver;
	public static Boolean LearnHTMLTextPresent;
	public static Boolean VideoTutorialTextPresent;
	public static Boolean HTMLReferenceTextPresent;
	public static String link1;
	public static String link2;
	public static String link3;

	@Test
	public void TestHomePage() {
		driver.get("https://www.w3schools.com/");
		
		LearnHTMLTextPresent = driver.findElement(By.linkText("Learn HTML")).isDisplayed();
		VideoTutorialTextPresent= driver.findElement(By.xpath("//a[@title='HTML video tutorial']")).isDisplayed();
		HTMLReferenceTextPresent = driver.findElement(By.linkText("HTML Reference")).isDisplayed();
		
		driver.findElement(By.linkText("Learn HTML")).click();
		link1 = driver.getCurrentUrl();
		
		driver.navigate().to("https://www.w3schools.com/");
		driver.findElement(By.xpath("//a[@title='HTML video tutorial']")).click();
		link2 = driver.getCurrentUrl();
		
		driver.navigate().to("https://www.w3schools.com/");
		driver.findElement(By.linkText("HTML Reference")).click();
		link3 = driver.getCurrentUrl();
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\HCL\\Technical\\XPath\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}
}
