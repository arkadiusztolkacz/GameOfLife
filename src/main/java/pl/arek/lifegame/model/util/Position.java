package pl.arek.lifegame.model.util;

public class Position {
	private int row;
	private int column;

	public int getRow() {
		return row;
	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
