import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoClicker {

	public static void main(String[] args) {
		try {
			Robot robot = new Robot();
			robot.delay(3000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
