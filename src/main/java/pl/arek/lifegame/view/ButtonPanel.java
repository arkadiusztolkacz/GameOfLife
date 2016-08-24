package pl.arek.lifegame.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.arek.lifegame.controller.BoardController;
import pl.arek.lifegame.controller.MenuController;

@Component
public class ButtonPanel extends JPanel {
	private final JCheckBox rowCheckBox = new JCheckBox("row");
	private final JCheckBox columnCheckBox = new JCheckBox("column");
	private final JButton startButton = new JButton("Start");
	private final JButton pauseButton = new JButton("Pause");
	private final JButton clearButton = new JButton("Clear");
	private final JButton populateButton = new JButton("Populate");
	private final JButton randomButton = new JButton("Random");
	private final JButton endButton = new JButton("Close");

	@Autowired
	ButtonPanel(MenuController menuController, BoardController boardController) {
		pauseButton.setEnabled(false);

		rowCheckBox.addActionListener(boardController.newSelectRowsListener());
		columnCheckBox.addActionListener(boardController.newSelectColumnsListener());

		startButton.addActionListener(menuController.newStartListener());
		pauseButton.addActionListener(menuController.newPauseListener());
		clearButton.addActionListener(menuController.newClearListener());
		populateButton.addActionListener(menuController.newPopulateListener());
		randomButton.addActionListener(menuController.newRandomListener());
		endButton.addActionListener(menuController.newExitListener());

		this.add(rowCheckBox);
		this.add(columnCheckBox);
		this.add(startButton);
		this.add(pauseButton);
		this.add(clearButton);
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

	public boolean isRowSelected() {
		return rowCheckBox.isSelected();
	}

	public boolean isColumnSelected() {
		return columnCheckBox.isSelected();
	}
}
