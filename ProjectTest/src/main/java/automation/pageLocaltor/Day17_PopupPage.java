package automation.pageLocaltor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

import static org.testng.Assert.assertTrue;

import java.util.*;


public class Day17_PopupPage extends CommonBase {

	private WebDriver diver;

	public Day17_PopupPage(WebDriver commonBaseDriver) {
		this.driver = commonBaseDriver;
	}
	
	public void handleChildWindow() {
		click(By.xpath("//a[text()='Click Here']"));
		// Lãy main window
		String mainWindow = driver.getWindowHandle();
		// Lấy tập hợp các windows
		Set<String> windows = driver.getWindowHandles();
		for(String childWindow: windows)
		{
			if(!childWindow.equals(mainWindow))
			{
				driver.switchTo().window(childWindow);
				type (By.name ("emailid"),"testEmail@gmail.com");
				click (By.name ("btnLogin"));
				assertTrue(isElementDisplay(By.xpath("//h2[text()='Access details to demo site.']")));
				driver.close();
				
			}
		}
		driver.switchTo().window(mainWindow);
		System.out.println("driver has been switched to main window'");
	}
	

	
}
