package Test;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.*;

public class TestLogin {
	WebDriver driver;
	Login login;
	
	HomePage homePage;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\HCL\\Technical\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void TestLogin() {
		driver.get("https://www.w3schools.com/");
		homePage = new HomePage(driver);
		homePage.ClickButton();
		login = new Login(driver);
		login.loginW3School("vltl", "12345");
		
		driver.navigate().to("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
		homePage.SingUpLink();
		login = new Login(driver);
		login.singUpW3School("abc", "abcd");
	}

	
	@After
	public void tearDown() throws Exception{
		driver.close();
	}
	
}
