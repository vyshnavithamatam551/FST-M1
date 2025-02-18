package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectChromeToDoListActivity4 extends ActionBaseScroll{
	
	AppiumDriver driver;
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");//this line is to connect to the mob
		options.setAutomationName("UiAutomator2"); // this line is to connect to the mob
		options.setAppPackage("com.android.chromes"); // this line is for specific application(here it is a calculator)
		options.setAppActivity("com.google.android.apps.chrome.Main");// this line is for specific application (class name) we can get through from inspector ->command tab -> AppManagement
		//options.setApp(".ipa");/// this is for Iphone
		
		//options.setApp("pathto .apk"); // if our system doesnt have the calculator.apk file but emulator have the apk file so we useing AppPackage and AppActivity
		options.noReset();
		
		//SErver URL
		
		URL serverURL = new URI("http://127.0.0.1:4723/").toURL();
		
		
		//Initialize the driver
		
		driver = new AppiumDriver(serverURL, options);
		
		driver.get("https://v1.training-support.net/selenium");
	
	}
	
	//test function
		@Test
		public void scrollToDoList() {
			
			/**String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
			
			//wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
			
			driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
			
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Tab opener']")).click();**/
			
			Dimension dims = driver.manage().window().getSize();
			
			Point start = new Point((int) (dims.getWidth() * .46), (int) (dims.getHeight() * .92));
			Point end = new Point((int) (dims.getWidth() * .49), (int) (dims.getHeight() * .14));
			
			doScroll(driver, start, end, 2000);
			
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Tab opener']")).click();
			
			
			
			
			
			
		}
		
		//tearDown function
				@AfterClass
				
				public void closeDriver() {
					
					driver.quit();
					
				}

}
