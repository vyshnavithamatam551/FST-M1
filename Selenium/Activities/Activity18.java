import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("The title of the page is : "+driver.getTitle());
		
		driver.findElement(By.cssSelector("button#simple")).click();
		
		Alert simple=driver.switchTo().alert();
		
		System.out.println("The text in alert is : "+simple.getText());
		
		simple.accept();
		
		WebElement result = driver.findElement(By.cssSelector("p#result"));
		
		System.out.println("The result message is : "+result.getText());
		
		driver.quit();
		
		
		
		
	}

}
