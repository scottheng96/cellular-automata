package model;

import java.util.Set;

public class Cell {
    int state;
    Set<Cell> neighbours;
    int life;

    //for WarTor static variables
    public final int reproductionLife = 10;
    public final int food = 5;

    public Cell() {};

    public Cell(int state) {
        this.state = state;
    }

    public Cell(int state, int life) {
        this.state = state;
        this.life = life;
    }

    // getters
    public int getState() {
        return this.state;
    }

    public Set<Cell> getNeighbours() {
        return this.neighbours;
    }

    public int getLife() {
        return this.life;
    }

    public int getFood() {return this.food; }

    public boolean canReproduce() {
        return (life >= reproductionLife);
    }

    // setters
    public void setState(int state) {
        this.state = state;
    }

    public void setNeighbours(Set<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
