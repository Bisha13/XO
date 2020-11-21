package com.bisha13.xo;

import com.bisha13.xo.model.Field;
import com.bisha13.xo.model.Figure;
import com.bisha13.xo.model.Game;
import com.bisha13.xo.model.Player;
import com.bisha13.xo.view.ConsoleView;

public class MainXO {

    public static void main(String[] args){
        Player player1 = new Player("Bisha", Figure.X);
        Player player2 = new Player("Grisha", Figure.O);
        Field field = new Field(3);
        String name = "XO";
        Game game = new Game.Builder()
                .players(player1, player2)
                .field(field)
                .name(name)
                .build();

        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.move(game)) {
            consoleView.show(game);
        }
    }
}
