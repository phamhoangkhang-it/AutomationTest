package automation.pageLocaltor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVN_Day14 {
	private WebDriver driver;

	@FindBy(xpath = "//a[text()='Đăng Ký']")
	WebElement buttonLogup;
	@FindBy(xpath = "//a[text()='Đăng Nhập']")
	WebElement buttonLogin;
	@FindBy(id = "txtLoginUsername")
	WebElement inputLoginemail;
	@FindBy(id = "txtLoginPassword")
	WebElement inputLoginPassword;
	@FindBy(xpath = "//button[text()='ĐĂNG NHẬP' and @type='submit']")
	WebElement buttonDangNhap;

	@FindBy(id = "txtFirstname")
	WebElement inputFirstname;
	@FindBy(id = "txtEmail")
	WebElement inputEmail1;
	@FindBy(id = "txtCEmail")
	WebElement inputEmail2;
	@FindBy(id = "txtPassword")
	WebElement inputPassword1;
	@FindBy(id = "txtCPassword")
	WebElement inputPassword2;
	@FindBy(id = "txtPhone")
	WebElement inputPhonenumber;
	@FindBy(xpath = "//button[text()='ĐĂNG KÝ' and @class='btn_pink_sm fs16']")
	WebElement buttonDangKy;

	@FindBy(xpath = "//div[@class='avatar2']")
	WebElement buttonAvatar;
	@FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']")
	WebElement buttonSuaThongTin;
	@FindBy(xpath = "//a[text()='Thoát']")
	WebElement buttonSignOut;

	@FindBy(id = "txtpassword")
	WebElement inputOldPassword;
	@FindBy(id = "txtnewpass")
	WebElement inputNewPassword1;
	@FindBy(id = "txtrenewpass")
	WebElement inputNewPassword2;
	@FindBy(xpath = "//button[text()='Lưu mật khẩu mới']")
	WebElement buttonSavePassword;

	public BTVN_Day14(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void LogupFlow(String firstname, String email, String password, String phonenumber) {
		// Click Đăng ký ở homepage
		buttonLogup.click();
		// Điền form đăng ký
		inputFirstname.sendKeys(firstname);
		inputEmail1.sendKeys(email);
		inputEmail2.sendKeys(email);
		inputPassword1.sendKeys(password);
		inputPassword2.sendKeys(password);
		inputPhonenumber.sendKeys(phonenumber);
		// Click Đăng ký ở form đăng ký
		buttonDangKy.click();

	}

	public void ChangePasswordFlow(String email, String password_old, String password_new) {
		// Đăng nhập
		buttonLogin.click();
		inputLoginemail.sendKeys(email);
		inputLoginPassword.sendKeys(password_old);
		buttonDangNhap.click();

		// Click Avatar > Sửa thông tin
		buttonAvatar.click();
		buttonSuaThongTin.click();

		// Cuộn xuống phía dưới màn hình
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// Cập nhật Password mới
		inputOldPassword.sendKeys(password_old);
		inputNewPassword1.sendKeys(password_new);
		inputNewPassword2.sendKeys(password_new);
		buttonSavePassword.click();

		// Xử lý alert nếu có
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert xuất hiện: " + alert.getText());
			alert.accept(); // Chấp nhận thông báo
		} catch (NoAlertPresentException e) {
			System.out.println("Không có alert nào xuất hiện.");
		}

		// Quay lại trang trước
		driver.navigate().back();

		// Đăng xuất
		buttonAvatar.click();
		buttonSignOut.click();

		// Đăng nhập với Password mới
		buttonLogin.click();
		inputLoginemail.sendKeys(email);
		inputLoginPassword.sendKeys(password_new);
		buttonDangNhap.click();

	}

	public void FullFlow(String firstname, String email, String password, String phonenumber, String new_password) {
		// Click Đăng ký ở homepage
		buttonLogup.click();
		// Điền form đăng ký
		inputFirstname.sendKeys(firstname);
		inputEmail1.sendKeys(email);
		inputEmail2.sendKeys(email);
		inputPassword1.sendKeys(password);
		inputPassword2.sendKeys(password);
		inputPhonenumber.sendKeys(phonenumber);
		// Click Đăng ký ở form đăng ký
		buttonDangKy.click();

		// Đăng nhập
		buttonLogin.click();
		inputLoginemail.sendKeys(email);
		inputLoginPassword.sendKeys(password);
		buttonDangNhap.click();

		// Click Avatar > Sửa thông tin
		buttonAvatar.click();
		buttonSuaThongTin.click();

		// Cuộn xuống phía dưới màn hình
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// Cập nhật Password mới
		inputOldPassword.sendKeys(password);
		inputNewPassword1.sendKeys(new_password);
		inputNewPassword2.sendKeys(new_password);
		buttonSavePassword.click();

		// Xử lý alert nếu có
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert xuất hiện: " + alert.getText());
			alert.accept(); // Chấp nhận thông báo
		} catch (NoAlertPresentException e) {
			System.out.println("Không có alert nào xuất hiện.");
		}

		// Quay lại trang trước
		driver.navigate().back();

		// Đăng xuất
		buttonAvatar.click();
		buttonSignOut.click();

		// Đăng nhập với Password mới
		buttonLogin.click();
		inputLoginemail.sendKeys(email);
		inputLoginPassword.sendKeys(new_password);
		buttonDangNhap.click();

	}

}
