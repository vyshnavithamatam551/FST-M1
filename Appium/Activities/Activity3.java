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

public class Activity3 {

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
	
	@Test
    public void additionTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        
        System.out.println("The result for addition is: "+result);
 
        // Assertion
        Assert.assertEquals(result, "14");
    }
 
    // Test method
    @Test
    public void subtractTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        
        System.out.println("The result for subtraction is: "+result);
 
        // Assertion
        Assert.assertEquals(result, "5");
    }
 
    // Test method
    @Test
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("×")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
 
        System.out.println("The result for multiplication is: "+result);
        // Assertion
        Assert.assertEquals(result, "500");
    }
 
    // Test method
    @Test
    public void divideTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
 
        System.out.println("The result for division is: "+result);
        // Assertion
        Assert.assertEquals(result, "25");
		
	}
	
	//Tear down/ closing
	
	public void TearDown() {
		driver.close();
	}
	
}
