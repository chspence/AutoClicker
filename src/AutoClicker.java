import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.omg.CORBA.INITIALIZE;

public class AutoClicker {

	AutoClickerMvp.Model model;
	AutoClickerMvp.View view;
	AutoClickerMvp.Presenter presenter;
	
	public AutoClicker() {
		initializeMvp();
	}
	
	private void initializeMvp() {
		this.model = new AutoClickerModel();
		this.view = new AutoClickerView();
		this.presenter = new AutoClickerPresenter();
	}
	
	public static void main(String[] args) {
		
	}
	
}
