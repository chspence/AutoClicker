import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AutoClickerView extends JFrame implements AutoClickerMvp.View {

	private AutoClickerMvp.Presenter presenter;
	
	private JFormattedTextField delay;
	private JButton btnStart;
	private JButton btnStop;
	
	public AutoClickerView() {
		initializeView();
	}

	@Override 
	public void setPresenter(AutoClickerMvp.Presenter presenter) {
		this.presenter = presenter;
	}
	
	@Override
	public int getDelay() {
		return (Integer)delay.getValue();
	}
	
	@Override
	public void setDelayEnabled(boolean enabled) {
		delay.setEnabled(enabled);
	}
	
	@Override
	public void setStartButtonEnabled(boolean enabled) {
		btnStart.setEnabled(enabled);
	}

	@Override
	public void setStopButtonEnabled(boolean enabled) {
		btnStop.setEnabled(enabled);
	}

	@Override
	public void setViewAlwaysOnTop(boolean alwaysOnTop) {
		this.setAlwaysOnTop(alwaysOnTop);
	}
	
	private void initializeView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 0};
		gbl_panel.rowHeights = new int[]{30, 30, 30, 0, 30};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDelay = new JLabel("Delay (ms)");
		GridBagConstraints gbc_lblDelay = new GridBagConstraints();
		gbc_lblDelay.fill = GridBagConstraints.VERTICAL;
		gbc_lblDelay.insets = new Insets(0, 0, 5, 0);
		gbc_lblDelay.gridx = 0;
		gbc_lblDelay.gridy = 0;
		panel.add(lblDelay, gbc_lblDelay);
		
		NumberFormatter delayFormatter = new NumberFormatter();
		delayFormatter.setValueClass(Integer.class);
		delayFormatter.setAllowsInvalid(false);
		delayFormatter.setMinimum(new Integer(0));
		delayFormatter.setMaximum(new Integer(100000));
		JFormattedTextField delay = new JFormattedTextField(delayFormatter);
		delay.setValue(1000);
		GridBagConstraints gbc_delay = new GridBagConstraints();
		gbc_delay.insets = new Insets(0, 0, 5, 0);
		gbc_delay.fill = GridBagConstraints.BOTH;
		gbc_delay.gridx = 0;
		gbc_delay.gridy = 1;
		panel.add(delay, gbc_delay);
		this.delay = delay;
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.onStartButtonClicked();
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.fill = GridBagConstraints.BOTH;
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 2;
		panel.add(btnStart, gbc_btnStart);
		this.btnStart = btnStart;
		
		JButton btnStop = new JButton("Stop");
		btnStop.setEnabled(false);
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.onStopButtonClicked();
			}
		});
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.fill = GridBagConstraints.BOTH;
		gbc_btnStop.gridx = 0;
		gbc_btnStop.gridy = 3;
		panel.add(btnStop, gbc_btnStop);
		this.btnStop = btnStop;
		
		this.setContentPane(panel);
		this.pack();
		setVisible(true);
	}

}
