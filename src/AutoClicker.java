public class AutoClicker {

	AutoClickerMvp.Model model;
	AutoClickerMvp.View view;
	AutoClickerMvp.Presenter presenter;
	
	public AutoClicker() {
		initializeMvp();
	}
	
	private void initializeMvp() {
		model = new AutoClickerModel();
		view = new AutoClickerView();
		presenter = new AutoClickerPresenter();
		presenter.setModel(model);
		presenter.setView(view);
	}
	
	public static void main(String[] args) {
		new AutoClicker();
	}
	
}
