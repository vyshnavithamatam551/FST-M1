package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectKeepAppReminderActivity3 {

	AppiumDriver driver;
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");//this line is to connect to the mob
		options.setAutomationName("UiAutomator2"); // this line is to connect to the mob
		options.setAppPackage("com.google.android.apps.tasks"); // this line is for specific application(here it is a calculator)
		options.setAppActivity(".ui.TaskListsActivity");// this line is for specific application (class name) we can get through from inspector ->command tab -> AppManagement
		//options.setApp(".ipa");/// this is for Iphone
		
		//options.setApp("pathto .apk"); // if our system doesnt have the calculator.apk file but emulator have the apk file so we useing AppPackage and AppActivity
		options.noReset();
		
		//SErver URL
		
		URL serverURL = new URI("http://127.0.0.1:4723/").toURL();
		
		
		//Initialize the driver
		
		driver = new AppiumDriver(serverURL, options);
	}
	//test function
	@Test
	public void addGoogleKeepNote() {
		
		//click on add button
		driver.findElement(AppiumBy.accessibilityId("Create a note")).click();
		//add text
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();				
		//add title
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/editable_title\"]")).sendKeys("My first note");
		//add desc
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/edit_note_text\"]")).sendKeys("This is for year 2025 from jan 31");
		
		//add reminder
		driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
		
		//reminder for tomorrow morning
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Tomorrow morning\"]")).click();
		//click on back button
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		
		
		
		
		
		//assertions
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.google.android.keep:id/browse_note_interior_content\"]")).isDisplayed());
		
	


	}
	//tearDown function
			@AfterClass
			
			public void closeDriver() {
				
				driver.quit();
				
			}
	
}
	
	
