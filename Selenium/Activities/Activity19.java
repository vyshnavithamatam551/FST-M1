import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("The title of the page is : "+driver.getTitle());
		
		driver.findElement(By.cssSelector("button#confirmation")).click();
		
		Alert confirm=driver.switchTo().alert();
		
		System.out.println("The text in alert is : "+confirm.getText());
		
		confirm.accept();
		
		WebElement result = driver.findElement(By.cssSelector("p#result"));
		
		System.out.println(result.getText());
		
		
	}

}
