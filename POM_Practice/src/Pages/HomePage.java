package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	By button = By.cssSelector("a#w3loginbtn");
	By singUpLink = By.xpath("//span[text()=' Sign up']");
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	public void ClickButton() {
		driver.findElement(this.button).click();
	}
	public void SingUpLink() {
		driver.findElement(this.singUpLink).click();
	}
}

