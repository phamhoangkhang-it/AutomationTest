package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocaltor.LoginCodeStar;

public class BTVN_Day13 extends CommonBase {
	@BeforeMethod
	public void openBrowerTest() {
		driver = initFireFoxDriver(CT_PageURL.URL_CODESTAR);

	}

	@Test
	public void loginSuccessfully() {
		LoginCodeStar login = new LoginCodeStar(driver);
		login.Login("admin@gmail.com", "12345678");
		// Assert Dashboard display
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());

	}

	@Test
	public void loginFail_IncorrectPass() {
		LoginCodeStar login = new LoginCodeStar(driver);
		login.Login("admin@gmail.com", "123456");
		// Chờ tối đa 10 giây để thông báo xuất hiện
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")));

		assertTrue(errorMessage.isDisplayed(), "Thông báo lỗi không xuất hiện!");
	}

	@Test
	public void loginFail_IncorrectEmail() {
		LoginCodeStar login = new LoginCodeStar(driver);
		login.Login("dem2email@gmail.com", "12345678");
		// Chờ tối đa 10 giây để thông báo xuất hiện
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")));

		assertTrue(errorMessage.isDisplayed(), "Thông báo lỗi không xuất hiện!");

	}

	@Test
	public void loginFail_IncorrectEmailandPass() {
		LoginCodeStar login = new LoginCodeStar(driver);
		login.Login("dem2email@gmail.com", "abc123456");
		// Chờ tối đa 10 giây để thông báo xuất hiện
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")));

		assertTrue(errorMessage.isDisplayed(), "Thông báo lỗi không xuất hiện!");
	}

	@Test
	public void logoutSuccessfully() throws InterruptedException {
		LoginCodeStar login = new LoginCodeStar(driver);
		login.Login("admin@gmail.com", "12345678");
		login.Logout();
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập' and @class='title my-3']")).isDisplayed());

	}

	@Test
	public void themNhanVien() throws InterruptedException {
		LoginCodeStar login = new LoginCodeStar(driver);
		login.Login("admin@gmail.com", "12345678");
		// Assert Dashboard display
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());

		login.chucNangThemNhanVien("Quản Lý", "2", "1");

	}
}
