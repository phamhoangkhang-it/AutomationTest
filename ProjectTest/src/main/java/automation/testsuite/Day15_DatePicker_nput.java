package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day15_DatePicker_nput extends CommonBase {

	@BeforeMethod
	public void OpenBrowser() {
		driver = initBrowser(CT_PageURL.URL_GURU99);
	}

	@Test
	public void typeToDatePicker() {
		WebElement datePickerBDay = driver.findElement(By.name("bdaytime"));

		// Remove thuộc tính ReadyOnly nếu có trong the input
		// js.executeScript("arguments[0].removeAttribute('readonly', 'readonly');",
		// datePickerBDay);

		datePickerBDay.sendKeys("12022020");
		datePickerBDay.sendKeys(Keys.TAB);

		datePickerBDay.sendKeys("0110AM");
		datePickerBDay.sendKeys(Keys.TAB);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		assertTrue(driver.findElement(By.xpath("//div[text()='Your Birth Date is 2020-12-02']")).isDisplayed());
	}
}
