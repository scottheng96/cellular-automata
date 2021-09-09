package model.GameOfLife;

import java.util.Random;
import java.util.Set;

public class Cell{
    public enum State {
        LIVE,
        DEAD
    }

    State state;
    Set<Cell> neighbours;

    public Cell() {
        // default state is DEAD
        Random rd = new Random();
        float prob = rd.nextFloat();
        if (prob < 0.8) this.state = State.DEAD;
        else this.state = State.LIVE;

    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void setNeighbours(Set<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public Set<Cell> getNeighbours() {
        return this.neighbours;
    }

}

