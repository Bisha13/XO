package com.bisha13.xo.controller;

import com.bisha13.xo.model.Field;
import com.bisha13.xo.model.Figure;
import com.bisha13.xo.model.Point;
import com.bisha13.xo.model.exceptions.InvalidPointException;

public class CurrentMoveController {

    public Figure currentMove(Field field) throws InvalidPointException {
        int count = 0;
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                if (field.getFigure(new Point(x, y)) != null)
                    count++;
            }
        }
        return count % 2 == 0 ? Figure.X : Figure.O;
    }
}
