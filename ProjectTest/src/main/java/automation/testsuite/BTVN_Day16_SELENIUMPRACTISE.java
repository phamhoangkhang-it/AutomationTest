package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVN_Day16_SELENIUMPRACTISE extends CommonBase {

	@BeforeMethod
	public void OpenBrowser() {
		driver = initBrowser(CT_PageURL.URL_SELENIUMPRACTISE);
	}

	@Test
	public void pressTryIt() {
		click(By.xpath("//button[text()='Try it']"));

		// Chờ tối đa 10 giây để alert xuất hiện
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		// Kiem tra message cua Alert hien thi dung
		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Welcome to Selenium WebDriver Tutorials";
		assertEquals(actualMessage, expectedMessage);
		
		// Bấm OK trên alert
		//alert.accept();

	}

}
