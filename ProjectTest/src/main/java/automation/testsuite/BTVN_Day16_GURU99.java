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

public class BTVN_Day16_GURU99 extends CommonBase {

	@BeforeMethod
	public void OpenBrowser() {
		driver = initBrowser(CT_PageURL.URL_GURU99_V2);
	}

	@Test
	public void deleteCustomer() {

		type(By.xpath("//input[@type='text']"), "admin123");
		click(By.xpath("//input[@type='submit']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		// Kiem tra message cua Alert 1 hien thi dung
		String actualMessage1 = driver.switchTo().alert().getText();
		String expectedMessage1 = "Do you really want to delete this Customer?";
		assertEquals(actualMessage1, expectedMessage1);

		// Bấm OK trên alert
		driver.switchTo().alert().accept();
		
		
		// Kiem tra message cua Alert 2 hien thi dung
		String actualMessage2 = driver.switchTo().alert().getText();
		String expectedMessage2 = "Customer Successfully Delete!";
		assertEquals(actualMessage2, expectedMessage2);
	}

}
