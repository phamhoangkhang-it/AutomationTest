package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class BaitapBuoi8 extends CommonBase {
	@BeforeMethod
	public void openBrowerTest() {
		driver = initBrowser("https://automationfc.github.io/basic-form/index.html");
	}

	@Test
	public void locateById() {
		WebElement textboxName = driver.findElement(By.id("name"));
		System.out.println("Textbox Name by ID " + textboxName);

		WebElement textboxAdress = driver.findElement(By.id("address"));
		System.out.println("Textbox Address by ID " + textboxAdress);

		WebElement textboxEmail = driver.findElement(By.id("email"));
		System.out.println("Textbox Address by ID " + textboxEmail);

		WebElement textboxPassword = driver.findElement(By.id("password"));
		System.out.println("Textbox Address by ID " + textboxPassword);
	}

	@Test
	public void locateByName() {
		WebElement textboxName = driver.findElement(By.name("name"));
		System.out.println("Textbox Name by NAME " + textboxName);

		WebElement textboxAdress = driver.findElement(By.name("address"));
		System.out.println("Textbox Address by NAME " + textboxAdress);

		WebElement textboxEmail = driver.findElement(By.name("email"));
		System.out.println("Textbox Address by NAME " + textboxEmail);

		WebElement textboxPassword = driver.findElement(By.name("password"));
		System.out.println("Textbox Address by NAME " + textboxPassword);
	}

	@Test
	public void locateByClassName() {
		WebElement Form = driver.findElement(By.className("large-12 columns"));
		System.out.println("Submit and Reset form element is: " + Form);

	}

	@Test
	public void locateByLink() {
		WebElement Tooltips = driver.findElement(By.linkText("Hover over me"));
		System.out.println("Link Tooltips: " + Tooltips);
	}

}