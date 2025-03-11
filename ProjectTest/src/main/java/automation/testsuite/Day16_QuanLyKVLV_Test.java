package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocaltor.Day16_CRMStart_QuanLyKVLV;

public class Day16_QuanLyKVLV_Test extends CommonBase {
	String tenKLV = "Tien Giang";
	String maKLV = "0063";

	@BeforeMethod
	public void OpenBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_CODESTAR);
	}

	@Test(priority = 1)
	public void quanLyKhuVucLamViec() {
		// Login
		Day16_CRMStart_QuanLyKVLV flow = new Day16_CRMStart_QuanLyKVLV(driver);
		flow.loginFunction("admin@gmail.com", "12345678");

		// Thêm khu vực làm việc
		flow.addKVLV(maKLV, tenKLV);
		// nhấn Ok trên popup
		click(By.xpath("//button[@class='btn btn-success']"));

		// Xóa khu vực làm việc
		flow.delKVLV(maKLV, tenKLV);

		// Assert display
		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Bạn có thực sự muốn xóa khu vực này";
		assertEquals(actualMessage, expectedMessage);
		// Bấm OK trên alert
		driver.switchTo().alert().accept();

		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý khu làm việc' and @class='text']")).isDisplayed());

	}

	@Test(priority = 2)
	public void themKVLV_SaiDinhDang_MaKLV() {
		Day16_CRMStart_QuanLyKVLV addfail01 = new Day16_CRMStart_QuanLyKVLV(driver);
		addfail01.loginFunction("admin@gmail.com", "12345678");
		addfail01.addKVLV("0063 6300", tenKLV);
		assertTrue(driver
				.findElement(By.xpath("//div[text()='Dữ liệu nhập vào sai định dạng' and @id='workarea_validate']"))
				.isDisplayed());
	}
	
	@Test(priority = 3)
	public void themKVLV_SaiDinhDang_TenKLV() {
		Day16_CRMStart_QuanLyKVLV addfail02 = new Day16_CRMStart_QuanLyKVLV(driver);
		addfail02.loginFunction("admin@gmail.com", "12345678");
		addfail02.addKVLV(maKLV, "Tiền Giang");
		assertTrue(driver
				.findElement(By.xpath("//div[text()='Dữ liệu nhập vào sai định dạng' and @id='name_validate']"))
				.isDisplayed());
	}

}
