package model.GameOfLife;

import model.RuleSet;

import java.util.Set;

public class Cell {
    public enum State {
        LIVE,
        DEAD
    }

    State state;
    Set<Cell> neighbours;

    public Cell() {
        // default state is DEAD
        this.state = State.DEAD;
    }

    public Cell(State state) {
        this.state = state;
    }

    public void setNeighbours(Set<Cell> neighbours) {
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

    public void updateCell(RuleSet rules) {

    }
}
