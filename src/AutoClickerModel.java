import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoClickerModel implements AutoClickerMvp.Model {

	private Thread currentClickingThread;
	private Robot robot;
	private int delay;
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
	public void setDelay(int delay) {
		//Disallow interacting with current clicking instance
		if(isClicking) return;
		
		this.delay = delay;
	}

	@Override
	public void startClicking(SuccessCallback callback) {
		//Validate single clicking instance enforced
		if(isClicking) return;
		isClicking = true;
		
		//Successful Start callback
		callback.onSuccess();
		
		currentClickingThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(isClicking) {
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(delay);
//					try {
//						Thread.sleep(delay);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			}
		});
		currentClickingThread.start();
			
	}

	@Override
	public void stopClicking(SuccessCallback callback) {
		//Validate single clicking instance enforced
		if(!isClicking) return;
		isClicking = false;
		
		//Wait for currentClickingThread to end
		try {
			currentClickingThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Successful Stop callback
		callback.onSuccess();
	}
}
