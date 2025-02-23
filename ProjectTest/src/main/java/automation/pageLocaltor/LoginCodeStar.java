package automation.pageLocaltor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginCodeStar {
	private WebDriver driver;

	public LoginCodeStar(WebDriver _driver) {
		this.driver = _driver;
	}

	public void Login(String email, String password) {
		WebElement emailTextbox = driver.findElement(By.id("email"));

		emailTextbox.sendKeys(email);

		WebElement passwordText = driver.findElement(By.id("password"));

		passwordText.sendKeys(password);

		// Click button Signin
		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
		btnSignin.click();

	}

	public void Logout() throws InterruptedException {
		// Dừng màn hình 10 giây
		Thread.sleep(10000);

		// Click button Signin
		WebElement btnAdmin = driver.findElement(By.id("dropdownMenuLink"));
		btnAdmin.click();
		
		WebElement dropdownSignout = driver.findElement(By.xpath("//button[text()='Đăng xuất'and @class='dropdown-item']"));
		dropdownSignout.click();
		
		WebElement btnSignout = driver.findElement(By.xpath("//button[text()='Đăng xuất'and @class='btn btn-success']"));
		btnSignout.click();
	}

}
