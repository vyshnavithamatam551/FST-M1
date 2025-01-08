import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("The title of the page is : "+driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.xpath("//select[contains(@class,'h-10 w-64 rounded-lg border')]"));
		Select singleselect = new Select(dropdown);
		
		singleselect.selectByContainsVisibleText("Two");
		singleselect.selectByIndex(3);
		singleselect.selectByValue("four");
		
		List<WebElement> alloptions=singleselect.getOptions();
		
		System.out.println("The selected options are : ");
		for(WebElement i:alloptions) {
			System.out.println(i.getText());
			}
		
		driver.quit();

	}

}
