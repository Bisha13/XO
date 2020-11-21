package com.bisha13.xo.controller;

import com.bisha13.xo.model.Field;
import com.bisha13.xo.model.Figure;
import com.bisha13.xo.model.Point;
import com.bisha13.xo.model.exceptions.InvalidPointException;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int count = 0;
        for (int x = 0; x < field.getSize(); x++) {
            count += countFigureInRow(field, x);
        }

        if (count == field.getSize() * field.getSize())
            return null;

        return count % 2 == 0 ? Figure.X : Figure.O;
    }

    private int countFigureInRow(final Field field, final int row) {
        int count = 0;
        for (int y = 0; y < field.getSize(); y++) {
            try {
                if (field.getFigure(new Point(row, y)) != null)
                    count++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
