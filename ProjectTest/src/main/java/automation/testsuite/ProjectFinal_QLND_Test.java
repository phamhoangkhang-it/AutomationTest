package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocaltor.ProjectFinal_QLND;

public class ProjectFinal_QLND_Test extends CommonBase {

	@BeforeMethod
	public void initBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_CODESTAR);
	}

	@Test(priority = 1)
	public void Logintest() {
	
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
	}

	@Test(priority = 2)
	public void Search() {

		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//td[text()='HoangKhang' and @class='fullname']")).isDisplayed());
	}

	@Test(priority = 3)
	public void Add() {
	
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Add("JasonPham", "jasonpham@gmail.com", "817509988", "Công Nghệ", "Nhân viên nhập hàng", "KVLV271",
				"9988");
		flow.Search("JasonPham");

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//td[text()='HoangKhang' and @class='fullname']")).isDisplayed());
	}

	@Test(priority = 4)
	public void Edit_Name() {
		
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		type(By.name("username"), "PhamHoangKhang");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());

		flow.Search("PhamHoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		type(By.name("username"), "HoangKhang");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));
		
		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
	}

	@Test(priority = 5)
	public void Edit_PhoneNumber() {
	
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		type(By.name("phone_number"), "817509999");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());

		flow.Search("PhamHoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		type(By.name("phone_number"), "817509944");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));
		
		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
	}

	@Test(priority = 6)
	public void Edit_Departments() {
	
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		flow.SelectDepartment("Phòng quản lý sản phẩm");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
		
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		flow.SelectDepartment("Công Nghệ");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));
		
		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
	}

	@Test(priority = 7)
	public void Edit_Role() {
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		flow.SelectRole("Nhân viên đóng hàng");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
		
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		flow.SelectRole("Nhân viên nhập hàng");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));
		
		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
	}

	@Test(priority = 8)
	public void Edit_WorkArea() {
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		flow.SelectWorkarea("KV0057");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
		
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		flow.SelectWorkarea("KVLV271");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));
		
		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());

	}

	@Test(priority = 9)
	public void Edit_UserID() {
		
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		type(By.name("code_user"), "686868");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());

		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'modify/156478798771')]"));
		type(By.name("code_user"), "9945");
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Chỉnh sửa']"));
		
		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
	}

	@Test(priority = 10)
	public void View() {
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'detail/156478798771')]"));

		AssertJUnit.assertTrue(driver.findElement(By.xpath("//label[text()='HoangKhang']")).isDisplayed());
	}

	@Test(priority = 11)
	public void Activate_Lock() {
		// Login
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'active/156478798771')]"));

		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Bạn có thực sự muốn thay đổi trạng thái cuả người dùng này";
		assertEquals(actualMessage, expectedMessage);
		driver.switchTo().alert().accept();

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//p[text()='Quản lý người dùng' and @class='text']")).isDisplayed());
	}

	@Test(priority = 12)
	public void Change_Pass() {
		// Login
		ProjectFinal_QLND flow = new ProjectFinal_QLND(driver);
		flow.loginFunction("admin@gmail.com", "12345678");
		flow.Search("HoangKhang");
		click(By.xpath("//a[contains(@href, 'reset_pw/156478798771')]"));

		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Bạn có thực sực muốn làm mới mật khẩu của người dùng này";
		assertEquals(actualMessage, expectedMessage);
		driver.switchTo().alert().accept();

		AssertJUnit.assertTrue(
				driver.findElement(By.xpath("//td[text()='HoangKhang' and @class='fullname']")).isDisplayed());
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
