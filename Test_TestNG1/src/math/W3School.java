package math;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class W3School {
	private WebDriver driver;
	
	@Test(priority = 1, groups = {"basic"})
	public void Login() {
		driver.get("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
		driver.findElement(By.id("modalusername")).click();
		driver.findElement(By.id("modalusername")).sendKeys("abcd");
		driver.findElement(By.id("current-password")).click();
		driver.findElement(By.id("current-password")).sendKeys("123456");
		driver.findElement(By.xpath("//div[@class='_20LW8']//button[1]")).click();
	}
	@Test(priority = 2, groups = {"basic"})
	public void SingUp() {
		driver.get("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
		driver.findElement(By.xpath("//span[text()=' Sign up']")).click();		
		driver.findElement(By.id("modalusername")).click();
		driver.findElement(By.id("modalusername")).sendKeys("vtdl");
		driver.findElement(By.xpath("//input[@type='password']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("10071999");
		driver.findElement(By.xpath("//span[text()='Sign up for free']")).click();
	}
	
	@Test(priority = 3, groups = {"advance"})
	public void FotgotPass() {
		driver.get("https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com");
		driver.findElement(By.xpath("//div[@class='_Sg7KA']//a[1]")).click();		
		driver.findElement(By.xpath("(//div[@class='_3L6qc ']//input)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='_3L6qc ']//input)[2]")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//span[text()='Reset password']")).click();
	}
	
	@BeforeClass(groups = {"basic", "advance"})
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\HCL\\Technical\\XPath\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

	}

	@AfterClass(groups = {"basic", "advance"})
	public void afterClass() {
		driver.quit();
	}

}
