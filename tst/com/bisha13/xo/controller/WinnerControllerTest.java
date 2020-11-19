package com.bisha13.xo.controller;

import com.bisha13.xo.model.Field;
import com.bisha13.xo.model.Figure;
import com.bisha13.xo.model.Point;
import com.bisha13.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void checkWinnerRow1() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.O);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = Figure.O;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void checkWinnerRow2() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(1, 0), Figure.O);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(1, 2), Figure.O);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = Figure.O;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void checkWinnerRow3() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = Figure.X;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void checkWinnerColumn1() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = Figure.X;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void checkWinnerColumn2() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 1), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = Figure.X;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void checkWinnerColumn3() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 2), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = Figure.X;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void checkWinnerDiagonal1() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = Figure.O;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void checkWinnerDiagonal2() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 2), Figure.O);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.O);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = Figure.O;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

}