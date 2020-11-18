package com.bisha13.xo.model;

import com.bisha13.xo.model.exceptions.AlreadyOccupiedException;
import com.bisha13.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void setFigure() throws Exception {

        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;
        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(0, 0);

        testField.setFigure(point, Figure.O);


        Figure actualFigure = testField.getFigure(point);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testSetFigureWhenAlreadyOccupied() throws Exception {

        final Figure inputFigure = Figure.O;
        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(0, 0);

        testField.setFigure(point, inputFigure);

        try {
            testField.setFigure(point, inputFigure);
            fail();
        } catch (final AlreadyOccupiedException e) {}
    }

    @Test
    public void getSize() {

        final int inputSize = 3;

        final int expectedSize = inputSize;

        final Field field = new Field(inputSize);

        final int actualSize = field.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testGetFigureWhenFigureNotSet() throws Exception {

        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(0, 0);

        Figure actualFigure = testField.getFigure(point);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXLessThanZero() {

        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(-1, 0);

        try {
            Figure actualFigure = testField.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureWhenYLessThanZero() {

        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(0, -1);

        try {
            Figure actualFigure = testField.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureWhenBothLessThanZero() {

        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(-1, -1);

        try {
            Figure actualFigure = testField.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureWhenXMoreThanZero() {

        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(testField.getSize() + 1, 0);

        try {
            Figure actualFigure = testField.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureWhenYMoreThanZero() {

        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(0, testField.getSize() + 1);

        try {
            Figure actualFigure = testField.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureWhenBothMoreThanZero() {

        final int fieldSize = 3;

        final Field testField = new Field(fieldSize);
        final Point point = new Point(testField.getSize() + 1, testField.getSize() + 1);

        try {
            Figure actualFigure = testField.getFigure(point);
            fail();
        } catch (final InvalidPointException e) {
        }

    }


}