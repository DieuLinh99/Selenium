package math;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestQLDT {
	private WebDriver driver;

	@Test
	public void Login() {
		driver.get("http://qldt.hanu.vn/");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtTaiKhoa")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtTaiKhoa")).sendKeys("1701040099");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtMatKhau")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_txtMatKhau")).sendKeys("12345");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ucDangNhap_btnDangNhap")).click();
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
