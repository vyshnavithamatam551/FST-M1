import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("The title of the page is : "+driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.cssSelector("select.h-80"));
		
		Select multiselect = new Select(dropdown);
		
		multiselect.selectByContainsVisibleText("HTML");
		multiselect.selectByIndex(4);
		multiselect.selectByIndex(5);
		multiselect.selectByIndex(6);
		multiselect.selectByValue("nodejs");
		multiselect.deselectByIndex(5);
		
		List<WebElement> allselected = multiselect.getAllSelectedOptions();
		System.out.println("All selected options are: ");
		for(WebElement i:allselected) {
			System.out.println(i.getText());
		}
		driver.quit();		
	}

}
