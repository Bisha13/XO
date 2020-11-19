package com.bisha13.xo.controller;

import com.bisha13.xo.model.Field;
import com.bisha13.xo.model.Figure;
import com.bisha13.xo.model.Point;
import com.bisha13.xo.model.exceptions.AlreadyOccupiedException;
import com.bisha13.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveControllerTest {

    @Test
    public void testAlreadyOccupyedException() throws InvalidPointException {
        final int fieldSize = 3;
        final Field field = new Field(fieldSize);

        Point point = new Point(0, 0);
        field.setFigure(point, Figure.X);
        MoveController moveController = new MoveController();

        try {
            moveController.applyFigure(field, point, Figure.X);
            fail();
        } catch (AlreadyOccupiedException e) {}
    }
}