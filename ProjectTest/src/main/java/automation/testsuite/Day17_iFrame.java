package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_iFrame extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_CODESTAR_V2);
	}

	@Test
	public void dangKyNhanTuVan_KhongThanhCong() {
		scrollToElement(By.xpath("//h2[contains(text(), 'Đăng kí nhận tư vấn lộ trình')]"));
		driver.switchTo().frame(getElementPresentDOM(By.xpath("(//iframe[@title= 'Khách hàng']) [1]")));
		type(By.id("name"), "Auto test name");
		type(By.id("phone_number"), "0988777666");
		click(By.xpath("//button[normalize-space()='Gửi ngay']"));
		assertTrue(isElementDisplay(By.xpath("//button[normalize-space()='Gửi ngay']")));
	}

	@Test
	public void findIndexIframe() {
		// Tìm tổng số tất cả các iframe
		int soIframe = driver.findElements(By.tagName("iframe")).size();
		System.out.println("so iFrame la: "+soIframe);
		for (int i = 0; i < soIframe; i++) {
			driver.switchTo().frame(i);
			if (driver.findElements(By.id("name")).size() > 0) {
				System.out.println("Frame chứa thẻ Họ và tên ở vị trí thứ: " + i);
			}
			driver.switchTo().defaultContent();
		}
	}
}
