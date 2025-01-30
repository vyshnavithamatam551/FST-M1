package activities;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class Activity5 {

	//Declare appium driver
	AndroidDriver driver;
	WebDriverWait wait;
	
	
	//Create setup function
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		//options.setApp("path of .apk");//if we don't have apk file we can use packkage and activity as below
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity(".ui.ConversationListActivity");
		options.noReset();
		
		//Server URL
		//URL url = new URL("http://localhost:4723");
		URL url = new URI("http://localhost:4723").toURL();
		
		//Initialize the driver
		driver=new AndroidDriver(url,options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
    public void smsTest() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
 
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("recipient_text_view")
        ));
 
        // Find the element to add recipient
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("18282832912");
        // Press ENTER
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
 
        // Wait for textbox to appear
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
 
        // Enter text to send
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        // Press Send
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
 
        // Assertion
        String messageTextSent = driver.findElement(AppiumBy.id("message_text")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
    }
 
	//Tear down/ closing
	
	public void TearDown() {
		driver.close();
	}
	
}
