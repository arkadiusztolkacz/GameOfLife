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
	
	public ActionListener newMakeLifeListener(Position position){
		return new MakeLifeListener(position);
	}

	private class MakeLifeListener implements ActionListener {
		
		Position position;
		
		private MakeLifeListener(final Position position){
			this.position = position;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println("row: " + position.getRow() + " column: " + position.getColumn());
			board.setCell(position);
			//boardPanel.changeColor(position);
			boardPanel.setButtonBackground(position);
		}
	}
}
