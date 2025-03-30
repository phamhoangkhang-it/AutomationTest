package automation.pageLocaltor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import automation.common.CommonBase;

public class ProjectFinal_QLND extends CommonBase {
	private WebDriver driver;

	public ProjectFinal_QLND(WebDriver commonBaseDriver) {
		this.driver = commonBaseDriver;
	}

	public void loginFunction(String username, String pass) {
		type(By.id("email"), username);
		type(By.id("password"), pass);
		click(By.name("signin"));
	}

	public void Add(String name, String email, String phone, String PB, String CD, String KVLV, String ID) {
		ProjectFinal_QLND call = new ProjectFinal_QLND(driver);
		
		click(By.xpath("//button[text()='Thêm mới' and @class='btn btn-success']"));

		type(By.name("username"), name);

		type(By.name("email"), email);

		type(By.name("phone_number"), phone);

		call.SelectDepartment(PB);
		call.SelectRole(CD);
		call.SelectWorkarea(KVLV);

		Select dropdownWorkarea = new Select(driver.findElement(By.id("select_workarea_id")));
		dropdownWorkarea.selectByContainsVisibleText(KVLV);

		type(By.name("code_user"), ID);

		click(By.xpath("//button[text()='Lưu' and @class='btn btn-outline-success']"));
		
		click(By.xpath("//button[text()='Thêm' and @class='btn btn-success']"));

	}
	
	public void Search(String name) {
		type(By.name("query"), name);
		click(By.xpath("//button[text()='Tìm kiếm' and @class='btn btn-outline-success']"));
	}
	
	public void SelectDepartment(String name) {
		Select dropdownDepartment = new Select(driver.findElement(By.id("select_department_id")));
		dropdownDepartment.selectByContainsVisibleText(name);
	}
	
	public void SelectRole(String name) {
		Select dropdownRole = new Select(driver.findElement(By.id("select_role_id")));
		dropdownRole.selectByContainsVisibleText(name);
	}
	
	public void SelectWorkarea(String name) {
		Select dropdownWorkarea = new Select(driver.findElement(By.id("select_workarea_id")));
		dropdownWorkarea.selectByContainsVisibleText(name);
	}

}
