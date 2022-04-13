package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	private WebDriver driver;
	By username = By.id("modalusername");
	By password = By.id("current-password");
	By password1 = By.id("new-password");
	By loginButton = By.xpath("//div[@class='_20LW8']//button[1]");
	By singUpLink = By.xpath("//span[text()=' Sign up']");
	By singUpForFree = By.xpath("//span[text()='Sign up for free']");
	
	public Login(WebDriver driver) {
		this.driver= driver;
	}
	public void setUsername(String username) {
		driver.findElement(this.username).sendKeys(username);
	}
	public void setPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	public void setPassword1(String password1) {
		driver.findElement(this.password1).sendKeys(password1);
	}
	public void LoginButton() {
		driver.findElement(this.loginButton).click();
	}
	
	public void SingUpButton() {
		driver.findElement(this.singUpForFree).click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void singUpW3School(String username, String password1) {
		this.setUsername(username);
		this.setPassword1(password1);
		this.SingUpButton();
	}
	public void loginW3School(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.LoginButton();
	}
}

