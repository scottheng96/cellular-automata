package model;

import model.GameOfLife.Cell;

import java.util.Set;

public abstract class AbstractCell {
    Set<AbstractCell> neighbours;

    public void setNeighbours(Set<AbstractCell> neighbours) {
        this.neighbours = neighbours;
    }

    public Set<AbstractCell> getNeighbours() {
        return this.neighbours;
    }

    public abstract States getState();

    public abstract void setState(States state);
}
