package activities;

import io.appium.java_client.AppiumDriver;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

public class ActionsBase {

	static final PointerInput pointer = new PointerInput(Kind.TOUCH, "finger");
	//create the action function
	public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
		
		Sequence swipe = new Sequence(pointer, 1).
		       addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(),start.getY())).
		       addAction(pointer.createPointerDown(LEFT.asArg())).
		       addAction(pointer.createPointerMove(ofMillis(duration), viewport(), end.getX(),end.getY())).
		       addAction(pointer.createPointerUp(LEFT.asArg()));
		       
		//perform the actions
		driver.perform(Arrays.asList(swipe));
	}
	
}
