
public interface AutoClickerMvp {

	interface Model {
		void setInterval(int interval);
		void startClicking();
		void stopClicking();
	}
	
	interface View {
		void setPresenter(AutoClickerMvp.Presenter presenter);
		int getInterval();
	}
	
	interface Presenter {
		void setModel(AutoClickerMvp.Model model);
		void setView(AutoClickerMvp.View view);
		void onStartButtonClicked();
		void onStopButtonClicked();
	}
}
