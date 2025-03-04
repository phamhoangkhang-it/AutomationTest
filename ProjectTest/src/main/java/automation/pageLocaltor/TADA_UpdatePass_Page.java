package automation.pageLocaltor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TADA_UpdatePass_Page {
	private WebDriver driver;

	@FindBy(id = "UserName")
	WebElement textUsername;
	@FindBy(id = "Password")
	WebElement textPassword;
	@FindBy(xpath = "//button[text()='Đăng nhập']")
	WebElement btnLogin;
	@FindBy(id = "onesignal-slidedown-cancel-button")
	WebElement buttonCancelPopup;
	@FindBy(id = "my_account")
	WebElement btnMyAccount;
	@FindBy(xpath = "//a[@title='Đổi mật khẩu']")
	WebElement btnChangePass;
	@FindBy(id = "OldPassword")
	WebElement textOldPassword;
	@FindBy(id = "NewPassword")
	WebElement textNewPassword;
	@FindBy(id = "ConfirmNewPassword")
	WebElement textConfirmPass;
	@FindBy(xpath = "//input[@value='Cập nhật']")
	WebElement btnUpdatePass;

	@FindBy(xpath = "//input[@class='autosearch-input form-control']")
	WebElement inputSearch;
	@FindBy(xpath = "//button[@class='button-search btn btn-primary']")
	WebElement btnSearch;

	public TADA_UpdatePass_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginFunction(String username, String password) throws InterruptedException {
		textUsername.sendKeys(username);
		Thread.sleep(2000);
		textPassword.sendKeys(password);
		Thread.sleep(2000);
		btnLogin.click();
	}

	public void updatePass(String oldPass, String newPass) throws InterruptedException {
		buttonCancelPopup.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnMyAccount);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", btnChangePass);
		Thread.sleep(2000);
		textOldPassword.sendKeys(oldPass);
		Thread.sleep(2000);
		textNewPassword.sendKeys(newPass);
		Thread.sleep(2000);
		textConfirmPass.sendKeys(newPass);
		Thread.sleep(2000);
		btnUpdatePass.click();
	}

	public void searchKhoaHoc(String khoahoc) {
		buttonCancelPopup.click();

		inputSearch.sendKeys(khoahoc);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnSearch);

	}

}
