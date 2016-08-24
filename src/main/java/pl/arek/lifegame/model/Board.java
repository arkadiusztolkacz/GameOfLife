package pl.arek.lifegame.model;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.arek.lifegame.model.util.BoardSize;
import pl.arek.lifegame.model.util.Position;

@Service
public class Board {
	private Cell[][] cells;
	private final int columns;
	private final int rows;

	@Autowired
	Board(BoardSize boardSize) {
		this.columns = boardSize.getColumns();
		this.rows = boardSize.getRows();
	}

	@PostConstruct
	private void initializeCells() {
		cells = new Cell[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Cell(false);
			}
		}
	}

	public void setCell(Position position) {
		Cell cell = cells[position.getRow()][position.getColumn()];
		if (cell.isAlive()) {
			cell.setAlive(false);
		} else {
			cell.setAlive(true);
		}
	}

	public boolean getCell(Position position) {
		return cells[position.getRow()][position.getColumn()].isAlive();
	}

	public void nextCycle() {
		Cell[][] newBoard = copyBoard();

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				int neighboursCount = countAliveNeighbours(row, column);
				newBoard[row][column].changeState(neighboursCount);
			}
		}
		cells = newBoard;
	}

	private int countAliveNeighbours(int i, int j) {
		int startX = Math.max(i - 1, 0);
		int startY = Math.max(j - 1, 0);
		int endX = Math.min(i + 1, rows - 1);
		int endY = Math.min(j + 1, columns - 1);

		int aliveNeighbours = 0;
		for (int x = startX; x <= endX; x++) {
			for (int y = startY; y <= endY; y++) {
				if (cells[x][y].isAlive()) {
					aliveNeighbours++;
				}
			}
		}
		if (cells[i][j].isAlive() && aliveNeighbours > 0) {
			aliveNeighbours--;
		}
		return aliveNeighbours;
	}

	private Cell[][] copyBoard() {
		Cell[][] newBoard = new Cell[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				newBoard[i][j] = new Cell(cells[i][j]);
			}
		}
		return newBoard;
	}
}
