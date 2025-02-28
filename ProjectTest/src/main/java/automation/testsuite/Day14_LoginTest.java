package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocaltor.Day14_LoginPageFacetorry;

public class Day14_LoginTest extends CommonBase {

	@BeforeMethod
	public void OpenBrowser() {
		driver = initBrowser(CT_PageURL.URL_ALADA);
	}

	@Test(priority = 1)
	public void LoginSuccessfully() {
		Day14_LoginPageFacetorry login = new Day14_LoginPageFacetorry(driver);
		login.LoginFunction("demoemail@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']"))
				.isDisplayed());
	}

	@Test(priority = 2)
	public void LoginFail_IncorrectPass() {
		Day14_LoginPageFacetorry login = new Day14_LoginPageFacetorry(driver);
		login.LoginFunction("demoemail@gmail.com", "123456_incorrcect");
		assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
	}

	@Test(priority = 3)
	public void loginFail_IncorrectEmail() {
		Day14_LoginPageFacetorry login = new Day14_LoginPageFacetorry(driver);
		login.LoginFunction("dem2email@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
	}
	
	@Test(priority = 4)
	public void Logout() {
		Day14_LoginPageFacetorry login = new Day14_LoginPageFacetorry(driver);
		login.LoginFunction("demoemail@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//div[@class='login']/child::a[text()='Khóa học của tôi']"))
				.isDisplayed());
		login.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//a[text()='Đăng Nhập']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
}
