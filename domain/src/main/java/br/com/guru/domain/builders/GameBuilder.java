package br.com.guru.domain.builders;

import br.com.guru.domain.Game;

public class GameBuilder {
    private int id;
    private Game.Type type;
    private String name;
    private double price;

    public GameBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public GameBuilder setType(Game.Type type) {
        this.type = type;
        return this;
    }

    public GameBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GameBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Game createGame() {
        return new Game(id, type, name, price);
    }
}