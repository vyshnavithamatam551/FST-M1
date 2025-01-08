import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/target-practice");
		System.out.println("The title of the page is : " +driver.getTitle());
		
		WebElement third_header= driver.findElement(By.xpath("//h3[contains(text(), '#3')]"));
		System.out.println("Third Header text is : "+third_header.getText());
		
		WebElement fifth_header= driver.findElement(By.xpath("//h5[contains(text(), '#5')]"));
		System.out.println("Fifth Header color is : "+fifth_header.getCssValue("color"));
		
		String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
        System.out.println("Purple button's classes are: "+purpleButtonClass);
        
        String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
        System.out.println("Text in slate button is: "+slateButtonText);
		
		driver.close();
	}
}
