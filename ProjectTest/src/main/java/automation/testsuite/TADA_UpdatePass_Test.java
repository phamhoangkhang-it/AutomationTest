package automation.testsuite;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocaltor.TADA_UpdatePass_Page;

public class TADA_UpdatePass_Test extends CommonBase {
	String password="admin@123" ;
	
	@BeforeMethod
	public void OpenFirefox() {
		driver = initFireFoxDriver(CT_PageURL.URL_TADA);
	}

	@Test
	public void loginSuccessfully() throws InterruptedException
	{
		TADA_UpdatePass_Page tada = new TADA_UpdatePass_Page(driver);
		tada.loginFunction("khangpham98@gmail.com", password);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
	}
	
	@Test(priority = 1)
    public void updatePassSuccessfully() throws InterruptedException {
        loginSuccessfully();
        Thread.sleep(3000);
        TADA_UpdatePass_Page tada = new TADA_UpdatePass_Page(driver);
        tada.updatePass("admin@123", "admin@123_new");
        password = "admin@123_new";
        assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Đổi mật khẩu thành công')]")).isDisplayed());
    }

    @Test(priority = 2)
    public void updatePassSuccessfullyBack() throws InterruptedException {
        loginSuccessfully();
        Thread.sleep(3000);
        TADA_UpdatePass_Page tada = new TADA_UpdatePass_Page(driver);
        tada.updatePass("admin@123_new", "admin@123");
        password = "admin@123" ;
        assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Đổi mật khẩu thành công')]")).isDisplayed());
    }
    
    @Test(priority = 3)
    public void search() throws InterruptedException {
        loginSuccessfully();
        Thread.sleep(3000);
        TADA_UpdatePass_Page timkiem = new TADA_UpdatePass_Page(driver);
        timkiem.searchKhoaHoc("ASP Net");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//a[text()='Bài 52: Gửi phản hồi và gửi mail trong ASP NET sử dụng SMTP']")).isDisplayed());

    }
}
