package automation.testsuite;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

//import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocaltor.LoginPage;
//import automation.common.CommonBase;
//import automation.constant.CT_PageURL;

public class Alada_LoginTest extends CommonBase {

	@BeforeMethod
	public void openBrowerTest() {
		driver = initBrowser(CT_PageURL.URL_ALADA);

	}

	@Test(priority=1)
	public void loginSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("demoemail@gmail.com", "123456");
		// Assert Dashboard display
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']"))
				.isDisplayed());

	}

	@Test(priority=2)
	public void loginFail_IncorrectPass() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("demoemail@gmail.com", "123456_incorrect");
		assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());

	}
	
	@Test(priority=3)
	public void loginFail_IncorrectEmail() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("dem2email@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());

	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
