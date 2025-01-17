package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	
	
	@BeforeClass

		
		public void start() {
			driver = new FirefoxDriver();
			Wait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			driver.get("https://alchemy.hguy.co/jobs/");
			System.out.println("The title of the page is : "+driver.getTitle());
			
			
		}
		@Test
		public void postjob() throws InterruptedException {
			WebElement postjobs=driver.findElement(By.linkText("Post a Job"));
			postjobs.click();
			driver.findElement(By.id("create_account_email")).sendKeys("demo5@gmail.com");
			driver.findElement(By.id("job_title")).sendKeys("Full Stack Tester");
			driver.findElement(By.id("job_location")).sendKeys("Bangalore");
			
			WebElement dropdown=driver.findElement(By.id("job_type"));
			Select select=new Select(dropdown);
			select.selectByIndex(2);
			
			WebElement description=driver.findElement(By.cssSelector(".mce-i-bullist"));
			description.click();
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter an email address')]")).sendKeys("demo5@gmail.com");
			driver.findElement(By.xpath("//input[contains(@placeholder,'Enter the name of the company')]")).sendKeys("IBM");
			driver.findElement(By.xpath("//input[contains(@name,'submit_job')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[contains(@name,'continue')]")).click();
			
			driver.findElement(By.linkText("Jobs")).click();
			driver.findElement(By.xpath("//input[contains(@id,'job_type_freelance')]")).click();
			Thread.sleep(1000);
			WebElement element= driver.findElement(By.xpath("//h3[contains(text(),'Full Stack Tester')]"));	
			if(element.isDisplayed()) {
				System.out.println("The new job got posted");
			}
			else {
				System.out.println("There is an issue");
			}
						
		}
		 
		@AfterClass
		public void end() {
			driver.quit();
		}

}
