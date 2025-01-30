package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

	//Declare appium driver
	AppiumDriver driver;
	
	
	//Create setup function
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		//options.setApp("path of .apk");//if we don't have apk file we can use packkage and activity as below
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");
		options.noReset();
		
		//Server URL
		//URL url = new URL("http://localhost:4723");
		URL url = new URI("http://localhost:4723").toURL();
		
		//Initialize the driver
		driver=new AppiumDriver(url,options);
	}
	
	//Test
	@Test
	public void addTest() {
	    //find 5,tap it
		driver.findElement(AppiumBy.id("digit_5")).click();
		//find +,tap it
		//driver.findElement(AppiumBy.id("op_add")).click();
		driver.findElement(AppiumBy.accessibilityId("×")).click();
		//find 5,tap it
		driver.findElement(AppiumBy.id("digit_9")).click();
		//find = , tap it
		//driver.findElement(AppiumBy.id("eq")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("result")).getText();
		Assert.assertEquals(result, "45");		
		
	}
	
	//Tear down/ closing
	
	public void TearDown() {
		driver.close();
	}
	
}
