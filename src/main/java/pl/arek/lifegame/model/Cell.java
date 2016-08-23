package pl.arek.lifegame.model;

public class Cell {
    private boolean alive;

    Cell(boolean alive) {
        this.setAlive(alive);
    }

//    Cell(Cell cell) {
//        this(cell.isAlive());
//    }

    boolean isAlive() {
        return alive;
    }

    void setAlive(boolean alive) {
        this.alive = alive;
    }
    
 /*
    boolean changeState(int neighboursCount) {
        if (isAlive()) {
            return changeAliveState(neighboursCount);
        }
        return changeDeadState(neighboursCount);
    }

    private boolean changeAliveState(int neighboursCount) {
        if ((neighboursCount < 2) || (neighboursCount > 3) ) {
            alive = false;
            return true;
        }
        return false;
    }

    private boolean changeDeadState(int neighboursCount) {
        if (neighboursCount == 3) {
            alive = true;
            return true;
        }
        return false;
    }
    */
}
