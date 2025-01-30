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

public class Activity2 {

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
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
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
	   driver.get("https://training-support.net");	
	   
	   System.out.println("The Heading of the page is : "+driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Training Support\"]")).getText());
	   driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")).click();
	   System.out.println("The About page title is : "+driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")).getText());
	}
	
	//Tear down/ closing
	
	public void TearDown() {
		driver.close();
	}
	
}
