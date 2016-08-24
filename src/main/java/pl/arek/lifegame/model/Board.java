package pl.arek.lifegame.model;

import java.util.ArrayList;
import java.util.List;

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
	private final List<Position> aliveFields;

	@Autowired
	Board(BoardSize boardSize) {
		this.columns = boardSize.getColumns();
		this.rows = boardSize.getRows();
		this.aliveFields = new ArrayList<>();
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
			aliveFields.remove(position);
		} else {
			cell.setAlive(true);
			aliveFields.add(position);
		}
		System.out.println(getState());
	}

	public boolean getCell(Position position) {
		return cells[position.getRow()][position.getColumn()].isAlive();
	}

	// TESTER METHOD - DELETE LATER
	public String getState() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sb.append(cells[i][j].isAlive() + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/*
	 * public Cell getCell(int x, int y) { if (inBounds(x, y)) { return
	 * cells[x][y]; } throw new IndexOutOfBoundsException(); }
	 * 
	 * private boolean inBounds(int x, int y) { return x >= 0 && y >= 0 && x <
	 * width && y < height; }
	 */
	public void nextCycle() {
		Cell[][] newBoard = copyBoard();
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				int neighboursCount = countAliveNeighbours(row, column);
				
				boolean hasChanged = newBoard[row][column].changeState(neighboursCount);
				
//				System.out.println("row: " + row + " column: " + column + " neighbours: " + neighboursCount
//						+ " hasChanged: " + hasChanged);
				
				/*if (hasChanged) {
					//Dimension d = new Dimension(i, j);
					Position p = new Position(row, column);
					if (aliveFields.contains(p)) {
						aliveFields.remove(p);
						
						System.out.println("Remove position " + row + " " + column);
						
					} else {
						aliveFields.add(p);
						
						System.out.println("Add position " + row + " " + column);
						
					}
				}*/
			}
		}
		cells = newBoard;
	}

	private int countAliveNeighbours(int i, int j) {
		int startX = Math.max(i - 1, 0);
		int startY = Math.max(j - 1, 0);
		int endX = Math.min(i + 1, rows - 1);
		int endY = Math.min(j + 1, columns - 1);
		
		
		//System.out.println("startX: " + startX + " endX: " + endX + " startY: " + startY + " endY: " + endY);
		
		int aliveNeighbours = 0;
		for (int x = startX; x <= endX; x++) {
			for (int y = startY; y <= endY; y++) {
				
				//System.out.println("x: " + x + " y: " + y);
				
				if (cells[x][y].isAlive()) {
					aliveNeighbours++;
				}
			}
		}
		if(cells[i][j].isAlive() && aliveNeighbours > 0){
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

//	public void removeField(int x, int y) {
//		Dimension d = new Dimension(x, y);
//		changedFields.remove(d);
//	}
	
	  public List<Position> getAliveFields() { return aliveFields; }
	 
}
