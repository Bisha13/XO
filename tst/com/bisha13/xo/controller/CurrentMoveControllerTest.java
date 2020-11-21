package com.bisha13.xo.controller;

import com.bisha13.xo.model.Field;
import com.bisha13.xo.model.Figure;
import com.bisha13.xo.model.Point;
import com.bisha13.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testZeroFigures() throws InvalidPointException {
        int fieldSize = 3;
        Field field = new Field(fieldSize);
        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure expectedFigure = Figure.X;
        Figure actualFigure = currentMoveController.currentMove(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testOddFigures() throws InvalidPointException {
        int fieldSize = 3;
        Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 0), Figure.X);

        CurrentMoveController currentMoveController = new CurrentMoveController();

        Figure expectedFigure = Figure.O;
        Figure actualFigure = currentMoveController.currentMove(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testEvenFigures() throws InvalidPointException {
        int fieldSize = 3;
        Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);

        CurrentMoveController currentMoveController = new CurrentMoveController();

        Figure expectedFigure = Figure.X;
        Figure actualFigure = currentMoveController.currentMove(field);

        assertEquals(expectedFigure, actualFigure);

    }

    @Test
    public void testFieldIsFull() throws InvalidPointException {
        int fieldSize = 3;
        Field field = new Field(fieldSize);
        for (int i = 0; i < fieldSize; i++) {
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.O);
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure actualFigure = currentMoveController.currentMove(field);

        assertNull(actualFigure);

    }

}