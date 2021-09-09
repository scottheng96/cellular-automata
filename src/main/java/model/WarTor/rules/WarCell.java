package model.WarTor.rules;


import java.util.Set;

public class WarCell {
    public enum State {
        FISH,
        SHARK,
        WATER
    }

    State state;
    Set<WarCell> neighbours;
    int lifeStatus;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void setNeighbours(Set<WarCell> neighbours) {
        this.neighbours = neighbours;
    }

    public Set<WarCell> getNeighbours() {
        return this.neighbours;
    }

    public void setLifeStatus(int x) {
        lifeStatus = x;
    }

    public int getLifeStatus() {
        return lifeStatus;
    }
}
