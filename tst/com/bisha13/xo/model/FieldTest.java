package com.bisha13.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void setFigure() {

        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;
        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(0, 0);
        testField.setFigure(point, Figure.O);

        final Figure actualFigure = testField.getFigure(point);

        assertEquals(expectedFigure, actualFigure);


    }

    @Test
    public void getSize() {

        final int inputSize = 3;

        final int expectedSize = inputSize;

        final Field field = new Field(inputSize);

        final int actualSize = field.getSize();

        assertEquals(expectedSize, actualSize);
    }
}