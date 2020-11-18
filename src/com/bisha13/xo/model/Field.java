package com.bisha13.xo.model;

public class Field {

    private final int size;

    private Figure[][] field;

    public Field(final int size) {
        this.size = size;
        field = new Figure[size][size];
    }

    public void setFigure(Point point, Figure figure) {
        field[point.getX()][point.getY()] = figure;
    }

    public Figure getFigure(Point point) {
        return field[point.getX()][point.getY()];
    }

    public int getSize() {
        return size;
    }

}