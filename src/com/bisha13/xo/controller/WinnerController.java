package com.bisha13.xo.controller;

import com.bisha13.xo.model.Field;
import com.bisha13.xo.model.Figure;
import com.bisha13.xo.model.Point;
import com.bisha13.xo.model.exceptions.InvalidPointException;

public class WinnerController {

    public Figure getWinner(Field field) {
        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (checkPoints(field, new Point(i, 0), p -> new Point(p.getX(), p.getY() + 1)))
                    return field.getFigure(new Point(i, 0));
                if (checkPoints(field, new Point(0, i), p -> new Point(p.getX() + 1, p.getY())))
                    return field.getFigure(new Point(0, i));
            }
            if (checkPoints(field, new Point(0, 0),
                    p -> new Point(p.getX() + 1, p.getY() + 1)))
                return field.getFigure(new Point(0, 0));

            if (checkPoints(field, new Point(0, field.getSize() - 1),
                    p -> new Point(p.getX() + 1, p.getY() - 1)))
                return field.getFigure(new Point(0, field.getSize() - 1));
        } catch (InvalidPointException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private boolean checkPoints(final Field field,
                                final Point currentPoint,
                                final IPointGenerator pointGenerator) {

        Figure currentFigure;
        Figure nextFigure;
        Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;
        if (currentFigure != nextFigure)
            return false;

        return checkPoints(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator  {
        Point next(final Point point);
    }

}
