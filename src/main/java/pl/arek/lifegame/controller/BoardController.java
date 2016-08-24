package pl.arek.lifegame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.arek.lifegame.model.Board;
import pl.arek.lifegame.model.util.Position;
import pl.arek.lifegame.view.BoardPanel;

@Service
public class BoardController {
	@Autowired
	private Board board;
	@Autowired
	private BoardPanel boardPanel;
	private boolean rowSelected = false;
	private boolean columnSelected = false;

	public ActionListener newMakeLifeListener(Position position) {
		return new MakeLifeListener(position);
	}

	public ActionListener newSelectRowsListener() {
		return new SelectRowsListener();
	}

	public ActionListener newSelectColumnsListener() {
		return new SelectColumnsListener();
	}

	private class SelectRowsListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			rowSelected = !rowSelected;
		}
	}

	private class SelectColumnsListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			columnSelected = !columnSelected;
		}
	}

	private class MakeLifeListener implements ActionListener {
		Position position;

		private MakeLifeListener(final Position position) {
			this.position = position;
		}

		public void actionPerformed(ActionEvent arg0) {
			setSingleLife(position);
			if (isRowSelected()) {
				setLifeInRow(position);
			}
			if (isColumnSelected()) {
				setLifeInColumn(position);
			}
		}
	}

	private void setSingleLife(Position position) {
		board.setCell(position);
		boardPanel.setButtonBackground(position);
	}

	private void setLifeInRow(Position position) {
		board.setCellsInRow(position);
		boardPanel.setBackgrounds();
	}

	private void setLifeInColumn(Position position) {
		board.setCellsInColumn(position);
		boardPanel.setBackgrounds();
	}

	private boolean isRowSelected() {
		return rowSelected;
	}

	private boolean isColumnSelected() {
		return columnSelected;
	}
}
