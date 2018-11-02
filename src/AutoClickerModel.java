import java.awt.AWTException;
import java.awt.Robot;

public class AutoClickerModel implements AutoClickerMvp.Model {

	private Robot robot;
	private int interval;
	private boolean isClicking;
		
	public AutoClickerModel() {
		initializeRobot();
	}
	
	private void initializeRobot() {
		
		Robot robot = null;
		
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		this.robot = robot;
	}

	@Override
	public void setInterval(int interval) {
		this.interval = interval;
	}

	@Override
	public void startClicking() {
		
		if(isClicking) return;
		
		while(isClicking) {
			robot.dela //robot is sleeping bt main thread isnt -> backlog of calls this has to be synced up
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		}
	}

	@Override
	public void stopClicking() {
		// TODO Auto-generated method stub
		
	}
	
	
	//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	
}
