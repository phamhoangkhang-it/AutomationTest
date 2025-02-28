package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Rise_LoginTest  extends CommonBase{
	@BeforeMethod
	public void OpenBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_RISE_DEMO);
	}
	
	@Test
	public void loginSuccessfully()
	{
		WebElement emailTextbox = driver.findElement(By.id("email"));
		//Xóa giá trị mặc định trong textbox email
		emailTextbox.clear();
		// Nhập admin@demo.com
		emailTextbox.sendKeys("admin@demo.com");
		
		WebElement passwordTextbox = driver.findElement(By.id("password"));
		passwordTextbox.clear();
		passwordTextbox.sendKeys("riseDemo");
		
		//Click button Signin
		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='Sign in']"));
	}
}
