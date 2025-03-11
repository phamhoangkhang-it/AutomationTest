package automation.pageLocaltor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Day16_CRMStart_QuanLyKVLV extends CommonBase {
	private WebDriver driver;

	public Day16_CRMStart_QuanLyKVLV(WebDriver commonBaseDriver) {
		this.driver = commonBaseDriver;
	}

	public void loginFunction(String username, String pass) {
		type(By.id("email"), username);
		type(By.id("password"), pass);
		click(By.name("signin"));
	}

	public void addKVLV(String maKLV, String tenKLV) {
		click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
		click(By.xpath("//button[text()= 'Thêm mới']"));
		type(By.name("work_areas_code"), maKLV);
		type(By.name("name"), tenKLV);
		click(By.xpath("//button[text()='Lưu']"));
		//click(By.xpath("//button[@class='btn btn-success']"));
	}

	public void delKVLV(String maKLV, String tenKLV) {
		
		type(By.xpath("//input[@class='form-control me-3']"),tenKLV);
		click(By.xpath("//button[@class='btn btn-outline-success']"));
		click(By.xpath("//td[text()='"+maKLV+"']/following-sibling::td/a[normalize-space()='Xóa']"));

	}

}
