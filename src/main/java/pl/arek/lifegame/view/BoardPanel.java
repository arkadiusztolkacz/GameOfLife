package pl.arek.lifegame.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.arek.lifegame.model.util.BoardSize;

@Component
public class BoardPanel extends JPanel {

	private final JButton[][] buttons;
	
	@Autowired
	BoardPanel(BoardSize boardSize) {
		this.buttons = new JButton[boardSize.getRows()][boardSize.getColumns()];
		setLayout(new GridLayout(boardSize.getRows(), boardSize.getColumns()));
		addButtons(boardSize);
	}

	private void addButtons(BoardSize boardSize) {
		for (int i = 0; i < boardSize.getRows(); i++) {
			for (int j = 0; j < boardSize.getColumns(); j++) {
				JButton button = new JButton(i + " " + j);
				button.setPreferredSize(new java.awt.Dimension(13, 8));
				button.setBackground(View.EMPTY_COLOR);
				buttons[i][j] = button;
				this.add(button);
			}
		}
	}
}
