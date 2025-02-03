package model.plant;

import model.animal.Creature;

public abstract class Plant extends Creature {
    public Plant(String name, String symbol, float weight) {
        super(name, symbol, weight);
    }
}
