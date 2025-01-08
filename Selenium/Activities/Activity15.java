import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		System.out.println("The title of the page is : "+driver.getTitle());
		
		driver.findElement(By.xpath("//input[contains(@name, 'full-name')]")).sendKeys("Vyshnavi");
		driver.findElement(By.xpath("//input[contains(@name, '-email')]")).sendKeys("vyshnavi@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]")).sendKeys("2025-01-08");
		driver.findElement(By.xpath("//textarea[contains(@name, '-additional-details')]")).sendKeys("Full Stack Training");
		driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")))
                .getText();
        System.out.println("Success message: " + message);
        
        driver.quit();
	}

}
