package pl.arek.lifegame.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.arek.lifegame.controller.BoardController;
import pl.arek.lifegame.model.Board;
import pl.arek.lifegame.model.util.BoardSize;
import pl.arek.lifegame.model.util.Position;

@Component
public class BoardPanel extends JPanel {
	private BoardSize boardSize;
	@Autowired
	private Board board;
	private final JButton[][] buttons;

	@Autowired
	BoardPanel(BoardSize boardSize, BoardController boardController) {
		this.buttons = new JButton[boardSize.getRows()][boardSize.getColumns()];
		setLayout(new GridLayout(boardSize.getRows(), boardSize.getColumns()));
		this.boardSize = boardSize;
		addButtons(boardController);
	}

	public void setBackgrounds() {
		for (int i = 0; i < boardSize.getRows(); i++) {
			for (int j = 0; j < boardSize.getColumns(); j++) {
				setButtonBackground(new Position(i, j));
			}
		}
	}

	public void setButtonBackground(Position position) {
		JButton button = buttons[position.getRow()][position.getColumn()];
		if (isCellAlive(position)) {
			button.setBackground(View.FILLED_COLOR);
		} else {
			button.setBackground(View.EMPTY_COLOR);
		}
	}

	private boolean isCellAlive(Position position) {
		return board.getCell(position);
	}

	private void addButtons(BoardController boardController) {
		for (int i = 0; i < boardSize.getRows(); i++) {
			for (int j = 0; j < boardSize.getColumns(); j++) {
				JButton button = new JButton();
				button.setPreferredSize(new java.awt.Dimension(13, 8));
				button.setBackground(View.EMPTY_COLOR);
				button.addActionListener(boardController.newMakeLifeListener(new Position(i, j)));
				buttons[i][j] = button;
				this.add(button);
			}
		}
	}
}
