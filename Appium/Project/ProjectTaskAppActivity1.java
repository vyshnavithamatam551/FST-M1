package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectTaskAppActivity1 {
	
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
		public void addGoogleTask() {
			
			//click on add task
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			//add title
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")).sendKeys("Complete Activity with Google Tasks");
			//save first task
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]")).click();
			
			
			//click on add task
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			//add title
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")).sendKeys("Complete Activity with Google Keep");
			//save second task
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]")).click();
			
			//click on add task
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			//add title
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")).sendKeys("Complete Second Activity with Google Keep");
			//save second task
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.apps.tasks:id/add_task_done\"]")).click();
			
			
			
			
			//assertions
			String task2 = driver.findElement(AppiumBy.xpath("//*[@text='Complete Activity with Google Tasks']")).getText();
			System.out.println(task2);		
			assertEquals(task2,"Complete Activity with Google Tasks"); 
			
			
			//assertions
			String task1 = driver.findElement(AppiumBy.xpath("//*[@text='Complete Activity with Google Keep']")).getText();
			assertEquals(task1,"Complete Activity with Google Keep"); 			
			
			
			
			//assertions
			String task3 = driver.findElement(AppiumBy.xpath("//*[@text='Complete Second Activity with Google Keep']")).getText();
			assertEquals(task3,"Complete Second Activity with Google Keep"); 
		
			
			
			
			
		}

		//tearDown function
		@AfterClass
		
		public void closeDriver() {
			
			driver.quit();
			
		}
}
