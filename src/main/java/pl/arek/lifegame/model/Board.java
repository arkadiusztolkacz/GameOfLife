package pl.arek.lifegame.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.arek.lifegame.model.util.BoardSize;

@Service
public class Board {
	private Cell[][] cells;
	private final int columns;
	private final int rows;
	private final List<Dimension> changedFields;
	
	@Autowired
	Board(BoardSize boardSize) {
		this.columns = boardSize.getColumns();
		this.rows = boardSize.getRows();
		this.changedFields = new ArrayList<>();
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
	
	public String getState()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				sb.append(cells[i][j].isAlive() + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	/*
	public Cell getCell(int x, int y) {
		if (inBounds(x, y)) {
			return cells[x][y];
		}
		throw new IndexOutOfBoundsException();
	}

	private boolean inBounds(int x, int y) {
		return x >= 0 && y >= 0 && x < width && y < height;
	}

	public void nextCycle() {
		Cell[][] newBoard = copyBoard();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int neighboursCount = countAliveNeighbours(i, j);
				boolean hasChanged = newBoard[i][j].changeState(neighboursCount);
				if (hasChanged) {
					Dimension d = new Dimension(i, j);
					if (changedFields.contains(d)) {
						changedFields.remove(new Dimension(i, j));
					} else {
						changedFields.add(new Dimension(i, j));
					}
				}
			}
		}
		cells = newBoard;
	}

	public int countAliveNeighbours(int i, int j) {
		int startX = Math.max(i - 1, 0);
		int startY = Math.max(j - 1, 0);
		int endX = Math.min(i + 1, width - 1);
		int endY = Math.min(j + 1, height - 1);

		int aliveNeighbours = 0;
		for (int x = startX; x <= endX; x++) {
			for (int y = startY; y <= endY; y++) {
				if (cells[x][y].isAlive()) {
					aliveNeighbours++;
				}
			}
		}
		aliveNeighbours--;

		return aliveNeighbours;
	}

	public Cell[][] copyBoard() {
		Cell[][] newBoard = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newBoard[i][j] = new Cell(cells[i][j]);
            }
        }
		return newBoard;
	}

	public void removeField(int x, int y) {
		Dimension d = new Dimension(x, y);
		changedFields.remove(d);
	}

	public List<Dimension> getFields() {
		return changedFields;
	}
*/
}
