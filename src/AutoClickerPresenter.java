import AutoClickerMvp.Model;
import AutoClickerMvp.View;

public class AutoClickerPresenter implements AutoClickerMvp.Presenter {

	private AutoClickerMvp.Model model;
	private AutoClickerMvp.View view;
	
	@Override
	public void setModel(AutoClickerMvp.Model model) {
		this.model = model;
	}

	@Override
	public void setView(AutoClickerMvp.View view) {
		this.view = view;
	}
	
	@Override
	public void onStartButtonClicked() {
		model.
	}

	@Override
	public void onStopButtonClicked() {
		
	}

}
