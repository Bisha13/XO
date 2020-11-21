package com.bisha13.xo.model;

public class Game {

    private final Player[] players;

    private final Field field;

    private final String name;

    private Game(Builder builder) {
        this.players = builder.getPlayers();
        this.field = builder.getField();
        this.name = builder.getName();
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }


    public static class Builder {

        private Player[] players;

        private Field field;

        private String name;

        public Builder players(Player... players) {
            this.players = players;
            return this;
        }

        public Builder field(Field field) {
            this.field = field;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Game build() {
            return new Game(this);
        }

        public Player[] getPlayers() {
            return players;
        }

        public Field getField() {
            return field;
        }

        public String getName() {
            return name;
        }
    }
}