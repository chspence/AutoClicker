
public interface AutoClickerMvp {

	interface Model {
		void setDelay(int delay);
		void startClicking(SuccessCallback callback);
		void stopClicking(SuccessCallback callback);
	}
	
	interface View {
		void setPresenter(AutoClickerMvp.Presenter presenter);
		int getDelay();
		void setDelayEnabled(boolean enabled);
		void setStartButtonEnabled(boolean enabled);
		void setStopButtonEnabled(boolean enabled);
		void setViewAlwaysOnTop(boolean alwaysOnTop);
	}
	
	interface Presenter {
		void setModel(AutoClickerMvp.Model model);
		void setView(AutoClickerMvp.View view);
		void onStartButtonClicked();
		void onStopButtonClicked();
	}
}
