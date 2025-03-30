package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVN_Day17 extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_MEDIAMART);
	}

	private boolean checkAlertPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Test
	public void clickZalo() throws InterruptedException {
		if (checkAlertPresent() == true) {
			driver.switchTo().alert().accept();
		}

		Thread.sleep(3000);

		driver.switchTo().frame(getElementPresentDOM(By.xpath("//iframe[contains(@src, 'page.widget.zalo.me')]")));
		// driver.switchTo().frame(0); // Dòng này được comment

		click(By.xpath("//div[@class='za-chat_head-box']"));

		if (checkAlertPresent() == true) {
			driver.switchTo().alert().accept();
		}

		assertTrue(isElementDisplay(By.xpath("//h1[text()='Xin chào!']")));

	}

}
