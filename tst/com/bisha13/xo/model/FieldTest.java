package com.bisha13.xo.model;

import com.bisha13.xo.model.exceptions.AlreadyOccupiedException;
import com.bisha13.xo.model.exceptions.InvalidPointException;
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
        try {
            testField.setFigure(point, Figure.O);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        } catch (AlreadyOccupiedException e) {
            e.printStackTrace();
        }

        Figure actualFigure = null;
        try {
            actualFigure = testField.getFigure(point);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

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