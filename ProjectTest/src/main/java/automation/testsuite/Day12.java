package automation.testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12 extends CommonBase {
	@BeforeMethod
	public void openBrowerTest() {
		driver = initBrowser(CT_PageURL.URL_DEMOQA);
	}

	@Test
	public void clickOnCheckBox() {
		WebElement checkboxSport = driver.findElement(By.id("hobbies-checkbox-1"));
		if (checkboxSport.isSelected() == false) {

			driver.findElement(By.xpath("//label[text()='Sports']")).click();
			System.out.println("Checkbox sprorts has clicked!");
		}

		WebElement checkboxReading = driver.findElement(By.id("hobbies-checkbox-2"));
		if (checkboxReading.isSelected() == false) {
			driver.findElement(By.xpath("//label[text()='Reading']")).click();
			System.out.println("Checkbox reading has clicked!");
		}
	}

	@Test
	public void clickMutiple() {

		List<WebElement> listCheckbox = driver
				.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
		for (WebElement checkbox : listCheckbox) {
			if (checkbox.isSelected() == false) {
				checkbox.click();
			}
		}
	}
	@Test
	public void clickRadioButton() {
		WebElement radioMale = driver.findElement(By.xpath("//label[text()='Male']"));
		// 1. Kiểm tra giá trị mặc định
		boolean isClickMale = radioMale.isSelected();
		System.out.println("Radio male is clicked: "+ isClickMale);
		// 2.  Kiểm tra radio male enable thì click:
		if(radioMale.isEnabled()==true) {
			radioMale.click();
		}
		}

//	@AfterMethod
//	public void closeBrowerTest() {
//		driver.close();
//	}

}
