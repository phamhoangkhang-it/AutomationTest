package automation.pageLocaltor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Day16_CRMStart_QuanLyKVLV extends CommonBase {
	private WebDriver driver;

    public Day16_CRMStart_QuanLyKVLV (WebDriver driver) {
        this.driver = driver;
    }

    public void loginFunction(String username, String pass) {
        type(By.id("email"), username);
        type(By.id("password"), pass);
        click(By.name("signin"));
    }
    
    
}
