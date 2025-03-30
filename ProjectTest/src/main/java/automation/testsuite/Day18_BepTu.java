package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day18_BepTu extends CommonBase{
	@BeforeMethod
	public void openBrowerTest() {
		driver = initBrowser(CT_PageURL.URL_BEPANTOAN);
	}
	
	@Test
	public void researchBOSS() {
		click(By.xpath("//div[@class='flex-1 truncate max-w-[170px] text-clip overflow-hidden']"));
		click(By.xpath("(//a[contains(@href, 'bep-tu/bosch')]) [1]"));
		
		if (isElementDisplay(By.xpath("//div[contains(@class, 'product-list')]/a//h4")) == true) {
	        List<WebElement> listProduct = driver.findElements(By.xpath("//div[contains(@class, 'product-list')]/a//h4"));
	        for (WebElement product : listProduct) {
	            String actualProductName = product.getText().toUpperCase();
	            System.out.println("Tên sản phẩm trên màn hình: " + actualProductName);
	            assertTrue(actualProductName.contains("BOSCH"));
	        }
	    } else {
	        System.out.println("Fail Test");
	        assertTrue(isElementDisplay(By.xpath("//div[contains(@class, 'product-list')]/a//h4")));
	    }
		
		
	}

}
