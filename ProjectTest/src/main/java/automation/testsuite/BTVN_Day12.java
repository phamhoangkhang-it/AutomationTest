package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVN_Day12 extends CommonBase {
	
	@BeforeMethod
	public void openBrowerTest() {
		driver = initBrowser(CT_PageURL.URL_GLOBALSQA);
	}
	
	@Test
	public void selectCountry()
	{
		Select dropdownCountry = new Select(driver.findElement(By.xpath("//select")));
		System.out.println("Số lựa chọn của dropdownlist là: " + dropdownCountry.getOptions().size());
		dropdownCountry.selectByContainsVisibleText("Angola");
		String textAfterSelect = dropdownCountry.getFirstSelectedOption().getText();
		System.out.println("Text is: "+textAfterSelect);
		
		System.out.println("Is multiple: " + dropdownCountry.isMultiple());
	}

}

