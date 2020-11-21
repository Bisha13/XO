package com.bisha13.xo.view;

import com.bisha13.xo.controller.*;
import com.bisha13.xo.model.*;
import com.bisha13.xo.model.exceptions.AlreadyOccupiedException;
import com.bisha13.xo.model.exceptions.InvalidPointException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    public final MoveController moveController = new MoveController();

    private final static String LINE_CHARACTER = "-";


    public void show(final Game game) {
        final Field field = game.getField();
        for (int i = 0; i < field.getSize(); i++) {
            printRow(field, i);
            if (i != field.getSize() -1 ) {
                printSeparator(field);
            }
        }
    }

    public boolean move(Game game) {
        Field field = game.getField();
        Figure figure = currentMoveController.currentMove(field);
        Figure winner = winnerController.getWinner(field);

        if (winner != null) {
            System.out.format("Победитель - %s\n", winner.toString());
            return false;
        } else if (figure == null) {
            System.out.println("Победителя нет");
            return false;
        }

        System.out.format("Ходит - %s\n", figure);
        Point point = askPlayer();
        try {
            moveController.applyFigure(field, point, figure);
        } catch (AlreadyOccupiedException e) {
            System.out.format("Клетка %d %d уже занята, попробуйте ещё раз\n", point.getX() -1, point.getY() - 1);
        } catch (InvalidPointException e) {
            System.out.format("Клетки %d %d не существует, попробуйте ещё раз\n", point.getX() - 1, point.getY() - 1);
        }
        return true;
    }

    private Point askPlayer() {
        System.out.println("Введите координаты x y:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        int y = 0;
        try {
            String s = reader.readLine();
            String[] coordinates = s.split(" ");
            x = Integer.parseInt(coordinates[0]);
            y = Integer.parseInt(coordinates[1]);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Вы ввели неправильные числа, попробуйте ещё раз");
            askPlayer();
        }
        return new Point(x - 1, y - 1);
    }

    private void printSeparator(final Field field) {
        final int fieldSize = field.getSize();
        System.out.println(LINE_CHARACTER.repeat(fieldSize * 3 + 2));
    }

    private void printRow(final Field field, final int row) {
        for (int y = 0; y < field.getSize(); y++) {
            final Point p = new Point(row, y);
            Figure figure;
            try {
                figure = field.getFigure(p);
            } catch (InvalidPointException e) {
                throw new RuntimeException(e);
            }

            System.out.print(" ");
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");

            if (y != field.getSize() - 1)
                System.out.print("|");
        }
        System.out.println();
    }


}
