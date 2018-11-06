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
		this.view.setPresenter(this);
	}
	
	@Override
	public void onStartButtonClicked() {
		model.setDelay(view.getDelay());
		model.startClicking(new SuccessCallback() {
			
			@Override
			public void onSuccess() {
				view.setStartButtonEnabled(false);
				view.setStopButtonEnabled(true);
				view.setDelayEnabled(false);
				view.setViewAlwaysOnTop(true);
			}
			
			@Override
			public void onFail() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void onStopButtonClicked() {
		model.stopClicking(new SuccessCallback() {
			
			@Override
			public void onSuccess() {
				view.setStopButtonEnabled(false);
				view.setStartButtonEnabled(true);
				view.setDelayEnabled(true);
				view.setViewAlwaysOnTop(false);
			}
			
			@Override
			public void onFail() {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
