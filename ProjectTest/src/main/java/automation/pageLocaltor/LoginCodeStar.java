package automation.pageLocaltor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginCodeStar {
	private WebDriver driver;
	@FindBy(xpath ="//button[text()='Thêm mới']") WebElement buttonThemMoi;
	@FindBy(id="select_department_id") WebElement dropDownDepartment;
	@FindBy(id="select_role_id") WebElement dropDownRole;
	@FindBy(id="select_workarea_id") WebElement dropDownWorkArea;
	
	public LoginCodeStar(WebDriver _driver) {
		this.driver = _driver;
		
		PageFactory.initElements(driver, this);
	}

	public void Login(String email, String password) {
		WebElement emailTextbox = driver.findElement(By.id("email"));

		emailTextbox.sendKeys(email);

		WebElement passwordText = driver.findElement(By.id("password"));

		passwordText.sendKeys(password);

		// Click button Signin
		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
		btnSignin.click();

	}
	public void chucNangThemNhanVien(String phongBan, String role, String KVLV) throws InterruptedException {
		
		buttonThemMoi.click();
		Select selectPhongBan = new Select(dropDownDepartment) ;
		selectPhongBan.selectByContainsVisibleText(phongBan);
		Thread.sleep(3000);
		Select selectChucDanh = new Select(dropDownRole);
		selectChucDanh.selectByValue(role);	
		Thread.sleep(3000);
		Select selectKVLV = new Select(dropDownWorkArea);
		selectKVLV.selectByValue(KVLV);
	}
	
	
	public void Logout() throws InterruptedException {
		// Dừng màn hình 10 giây
		Thread.sleep(10000);

		// Click button Signin
		WebElement btnAdmin = driver.findElement(By.id("dropdownMenuLink"));
		btnAdmin.click();
		
		WebElement dropdownSignout = driver.findElement(By.xpath("//button[text()='Đăng xuất'and @class='dropdown-item']"));
		dropdownSignout.click();
		
		WebElement btnSignout = driver.findElement(By.xpath("//button[text()='Đăng xuất'and @class='btn btn-success']"));
		btnSignout.click();
	}
	
	
	

}
