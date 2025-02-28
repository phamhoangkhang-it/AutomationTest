package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocaltor.BTVN_Day14;

public class BTVN_Day14_Alada extends CommonBase {
	@BeforeMethod
	public void openBrowerTest() {
		driver = initFireFoxDriver(CT_PageURL.URL_ALADA_HOME);

	}

	@Test
	public void createAccount() {
		BTVN_Day14 logup = new BTVN_Day14(driver);
		logup.LogupFlow("Hoàng Khang", "hoangkhang98@gmail.com", "12345678", "0817509945");
		assertTrue(driver.findElement(By.xpath("//div[@class='avatar2']")).isDisplayed());

	}

	@Test
	public void ChangePassword() {
		BTVN_Day14 changepassword = new BTVN_Day14(driver);
		changepassword.ChangePasswordFlow("hoangkhang98@gmail.com", "abc123", "abc1234");
		assertTrue(driver.findElement(By.xpath("//div[@class='avatar2']")).isDisplayed());
	}
	
	@Test
	public void FullFlow() {
		BTVN_Day14 fullflow = new BTVN_Day14(driver);
		fullflow.FullFlow("Jason","jasonpham98@gmail.com", "abc123","0901239414" , "abc1234");
		assertTrue(driver.findElement(By.xpath("//div[@class='avatar2']")).isDisplayed());
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
