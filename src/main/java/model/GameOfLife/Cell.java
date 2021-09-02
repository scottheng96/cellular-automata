package model.GameOfLife;

import java.util.Set;

public class Cell {

    public enum State {
        LIVE,
        DEAD
    }

    State state;
    Set<Cell> neighbours;

    public Cell(State state) {
        this.state = state;
    }

    public void setNeighbors(Set<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<Cell> getNeighbours() {
        return this.neighbours;
    }

    public State getState() {
        return this.state;
    }
}
