package com.bisha13.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getPlayers() {
        final Player player1 = new Player("Bisha", Figure.O);
        final Player player2 = new Player("Dasha", Figure.X);

        final Player[] expectedPlayers = new Player[2];
        expectedPlayers[0] = player1;
        expectedPlayers[1] = player2;

        final Game game = new Game.Builder()
                .players(player1, player2)
                .build();
        final Player[] actualPlayers = game.getPlayers();

        assertArrayEquals(expectedPlayers, actualPlayers);

    }

    @Test
    public void getField() {

        final int fieldSize = 3;
        final Field inputField = new Field(fieldSize);
        final Field expectedField = inputField;

        final Game game = new Game.Builder()
                .field(inputField)
                .build();

        final Field actualField = game.getField();

        assertEquals(expectedField, actualField);

    }

    @Test
    public void getName() {

        final String inputName = "Bisha";
        final String expectedName = inputName;

        final Game game = new Game.Builder()
                .name(inputName)
                .build();

        final String actualField = game.getName();

        assertEquals(expectedName, actualField);
    }


}