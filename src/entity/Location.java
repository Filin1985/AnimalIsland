package entity;

import entity.creature.animal.Creature;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int row;
    private int column;
    private List<Creature> creatures;
    public Location(int posX, int posY) {
        this.row = posX;
        this.column = posY;
        this.creatures = new ArrayList<>();
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public List<Creature> getAnimals() {
        return creatures;
    }
}
