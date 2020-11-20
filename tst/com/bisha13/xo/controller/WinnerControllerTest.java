package com.bisha13.xo.controller;

import com.bisha13.xo.model.Field;
import com.bisha13.xo.model.Figure;
import com.bisha13.xo.model.Point;
import com.bisha13.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void checkWinnerRow() throws InvalidPointException {
        final int fieldSize = 3;
        WinnerController winnerController = new WinnerController();

        for (int i = 0; i < fieldSize; i++) {
            final Field field = new Field(fieldSize);
            field.setFigure(new Point(0, 0), Figure.O);
            field.setFigure(new Point(0, 1), Figure.O);
            field.setFigure(new Point(0, 2), Figure.O);

            Figure expectedFigure = Figure.O;
            Figure actualFigure = winnerController.getWinner(field);

            assertEquals(expectedFigure, actualFigure);
        }
    }

    @Test
    public void checkWinnerRowWhenNoWinner() throws InvalidPointException {
        final int fieldSize = 3;
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i <fieldSize ; i++) {

            final Field field = new Field(fieldSize);
            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);

            Figure expectedFigure = null;
            Figure actualFigure = winnerController.getWinner(field);

            assertEquals(expectedFigure, actualFigure);
        }

    }

    @Test
    public void checkWinnerColumn() throws InvalidPointException {
        final int fieldSize = 3;
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i <fieldSize ; i++) {

            final Field field = new Field(fieldSize);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);

            Figure expectedFigure = Figure.X;
            Figure actualFigure = winnerController.getWinner(field);

            assertEquals(expectedFigure, actualFigure);
        }
    }

    @Test
    public void checkWinnerWhenNoWinnerColumn() throws InvalidPointException {
        final int fieldSize = 3;
        WinnerController winnerController = new WinnerController();
        for (int i = 0; i <fieldSize ; i++) {

            final Field field = new Field(fieldSize);
            field.setFigure(new Point(0, i), Figure.O);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.X);

            Figure expectedFigure = null;
            Figure actualFigure = winnerController.getWinner(field);

            assertEquals(expectedFigure, actualFigure);
        }
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
    public void checkWinnerWhenNOWinnerDiagonal1() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = null;
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

    @Test
    public void checkWinnerWhenNoWinnerDiagonal2() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.O);

        WinnerController winnerController = new WinnerController();
        Figure expectedFigure = null;
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

}