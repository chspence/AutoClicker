import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import sun.misc.JavaxCryptoSealedObjectAccess;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class AutoClickerView extends JFrame implements AutoClickerMvp.View {

	private AutoClickerMvp.Presenter presenter;
	
	private JFormattedTextField interval;
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
	public int getInterval() {
		return (int) interval.getValue();
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
		
		JLabel lblInterval = new JLabel("Interval (ms)");
		GridBagConstraints gbc_lblInterval = new GridBagConstraints();
		gbc_lblInterval.fill = GridBagConstraints.VERTICAL;
		gbc_lblInterval.insets = new Insets(0, 0, 5, 0);
		gbc_lblInterval.gridx = 0;
		gbc_lblInterval.gridy = 0;
		panel.add(lblInterval, gbc_lblInterval);
		
		JFormattedTextField interval = new JFormattedTextField(NumberFormat.getIntegerInstance());
		GridBagConstraints gbc_interval = new GridBagConstraints();
		gbc_interval.insets = new Insets(0, 0, 5, 0);
		gbc_interval.fill = GridBagConstraints.BOTH;
		gbc_interval.gridx = 0;
		gbc_interval.gridy = 1;
		panel.add(interval, gbc_interval);
		this.interval = interval;
		
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
		
		setVisible(true);
	}
	
}
