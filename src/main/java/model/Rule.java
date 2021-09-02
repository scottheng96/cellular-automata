package model;

import model.GameOfLife.Cell;

public interface Rule {
    void validate(Cell cell);
}
