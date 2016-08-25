package pl.arek.lifegame.model;

public class Cell {
	private boolean alive;

	Cell(boolean alive) {
		this.setAlive(alive);
	}

	Cell(Cell cell) {
		this(cell.isAlive());
	}

	boolean isAlive() {
		return alive;
	}

	void setAlive(boolean alive) {
		this.alive = alive;
	}

	void changeState(int neighboursCount) {
		if (isAlive()) {
			changeAliveState(neighboursCount);
		}
		changeDeadState(neighboursCount);
	}

	private void changeAliveState(int neighboursCount) {
		if ((neighboursCount < 2) || (neighboursCount > 3)) {
			alive = false;
		}
	}

	private void changeDeadState(int neighboursCount) {
		if (neighboursCount == 3) {
			alive = true;
		}
	}
}
