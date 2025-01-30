package activities;

import static activities.ActionsBase.doSwipe;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {

	WebDriverWait wait;
	AppiumDriver driver;
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://training-support.net/webelements/sliders");
	}
	@Test
	public void volume75Test() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
		
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);
		
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .65));
		Point end = new Point((int) (dims.getWidth() * .67), (int) (dims.getHeight() * .65));
		
		doSwipe(driver, start, end, 2000);
		
//		String volumeText = driver.findElement(AppiumBy.xpath("//android.view.View/adroid.widget.TextView[contains(@text,'%')]")).getText();
//		
//		//assertTrue(volumeText.contains("75%"));
//		assertTrue(volumeText.contains("50%"));
		
	}
	@Test
    public void volume25Test() {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
		
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims);
		
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .65));
		Point end = new Point((int) (dims.getWidth() * .33), (int) (dims.getHeight() * .65));
		
		doSwipe(driver, start, end, 2000);
		
//		String volumeText = driver.findElement(AppiumBy.xpath("//android.view.View/adroid.widget.TextView[contains(@text,'%')]")).getText();
//		
//		//assertTrue(volumeText.contains("25%"));
//		assertTrue(volumeText.contains("50%"));
		
	}
    @AfterClass
    public void TearDown() {
	driver.quit();
     }
}
