package automation.testsuite;

//import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Dropdownlist extends CommonBase {
	
	@BeforeMethod
	public void openBrowerTest() {
		driver = initBrowser(CT_PageURL.URL_CORESTAR);
	}
	
	@Test
	public void chooseAWSOption()
	{
		Select dropdownCourse = new Select(driver.findElement(By.id("product_categories_filter")));
		System.out.println("Số lựa chọn của dropdownlist là: " + dropdownCourse.getOptions().size());
		dropdownCourse.selectByContainsVisibleText("AWS");
		String textAfterSelect = dropdownCourse.getFirstSelectedOption().getText();
		System.out.println("Text is: "+textAfterSelect);
		
		System.out.println("Is multiple: " + dropdownCourse.isMultiple());
	}

}
