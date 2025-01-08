import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println("The title of the page is : "+driver.getTitle());
		
		driver.findElement(By.cssSelector("button#prompt")).click();
		
		Alert prompt=driver.switchTo().alert();
		
		System.out.println("The text in alert is : "+prompt.getText());
		
		prompt.sendKeys("Awesome!");
		
		prompt.accept();
		
		System.out.println("The result message is : "+driver.findElement(By.id("result")).getText());
		
		driver.quit();
		
	}

}
