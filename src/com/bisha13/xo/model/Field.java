package com.bisha13.xo.model;

import com.bisha13.xo.model.exceptions.InvalidPointException;

public class Field {

    private final int SIZE;

    private final int MIN_SIZE = 0;

    private Figure[][] field;

    public Field(final int size) {
        this.SIZE = size;
        field = new Figure[size][size];
    }

    public void setFigure(Point point, Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.getX()][point.getY()] = figure;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.getX()][point.getY()];
    }

    public int getSize() {
        return SIZE;
    }

    private boolean checkPoint(Point point) {
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());
    }

    private boolean checkCoordinate(int x) {
        return ((x >= MIN_SIZE) && (x < SIZE));
    }

}