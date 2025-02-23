package automation.pageLocaltor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void LoginFunction(String email, String password) {
		WebElement emailTextbox = driver.findElement(By.id("txtLoginUsername"));
		// Xóa giá trị mặc định trong textbox email
		if (emailTextbox.isDisplayed()) {
			emailTextbox.clear();

			// Nhap admin@demo.com CharSequence.keysToSeng
			emailTextbox.sendKeys(email);
		}

		WebElement passwordText = driver.findElement(By.id("txtLoginPassword"));
		if (passwordText.isDisplayed()) {
			passwordText.clear();
			passwordText.sendKeys(password);
		}

		// Click button Signin
		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='ĐĂNG NHẬP' and @type='submit']"));
		btnSignin.click();

	}
	
}