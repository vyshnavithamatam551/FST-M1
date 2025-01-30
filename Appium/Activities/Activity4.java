package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {

	//Declare appium driver
	AppiumDriver driver;
	WebDriverWait wait;
	
	
	//Create setup function
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		//options.setApp("path of .apk");//if we don't have apk file we can use packkage and activity as below
		options.setAppPackage("com.android.contacts");
		options.setAppActivity(".activities.PeopleActivity");
		options.noReset();
		
		//Server URL
		//URL url = new URL("http://localhost:4723");
		URL url = new URI("http://localhost:4723").toURL();
		
		//Initialize the driver
		driver=new AppiumDriver(url,options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
    public void contactsTest() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
 
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@text='First name']")
        ));
 
        // Enter the details
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='First name']"
        )).sendKeys("Aaditya");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Last name']"
        )).sendKeys("Varma");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Phone']"
        )).sendKeys("999148292");
        // Click Save
        driver.findElement(AppiumBy.id("editor_menu_save_button")).click();
 
        // Wait for contact to save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
 
        // Assertion
        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }
	
	//Tear down/ closing
	
	public void TearDown() {
		driver.close();
	}
	
}
