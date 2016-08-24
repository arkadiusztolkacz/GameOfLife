package pl.arek.lifegame.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.arek.lifegame.controller.MenuController;

@Component
public class ButtonPanel extends JPanel {
	private final JButton startButton = new JButton("Start");
	private final JButton pauseButton = new JButton("Pause");
	private final JButton populateButton = new JButton("Populate");
	private final JButton randomButton = new JButton("Random");
	private final JButton endButton = new JButton("Close");

	@Autowired
	ButtonPanel(MenuController menuController) {
		pauseButton.setEnabled(false);

		startButton.addActionListener(menuController.newStartListener());
		pauseButton.addActionListener(menuController.newPauseListener());
		populateButton.addActionListener(menuController.newPopulateListener());
		randomButton.addActionListener(menuController.newRandomListener());
		endButton.addActionListener(menuController.newExitListener());

		this.add(startButton);
		this.add(pauseButton);
		this.add(populateButton);
		this.add(randomButton);
		this.add(endButton);
	}

	public void enableOrDisableStart(boolean enable) {
		startButton.setEnabled(enable);
	}

	public void enableOrDisablePause(boolean enable) {
		pauseButton.setEnabled(enable);
	}

	public void enableOrDisableButtons() {
		startButton.setEnabled(!startButton.isEnabled());
		pauseButton.setEnabled(!pauseButton.isEnabled());
	}
}
