import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create a driver
		WebDriver driver=new FirefoxDriver();
		
		//Open webpage in browser 
		driver.get("https://training-support.net");
		
		//perform operations
		System.out.println("The title of page is : "+driver.getTitle());
		
		WebElement about_us=driver.findElement(By.linkText("About Us"));
		
		about_us.click();
		
		System.out.println("The title of next page is : "+driver.getTitle());
		
		//close browser
		driver.quit();
	}

}
