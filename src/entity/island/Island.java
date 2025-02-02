package entity.island;

import entity.Location;
import entity.creature.animal.Animal;
import entity.creature.animal.Creature;
import util.AnimalFactory;
import util.AnimalType;
import util.Direction;

import java.util.concurrent.ThreadLocalRandom;

public class Island {
    private int length;
    private int width;
    private Location[][] locations;
    private AnimalFactory factory;

    public Island(int length, int width) {
        this.length = length;
        this.width = width;
        this.locations = new Location[getLength()][getWidth()];
        this.factory = new AnimalFactory();
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void createIsland() {
        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                locations[i][j] = new Location(i, j);
            }
        }
    }

    public void fillIsland() {
        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                String str = "";
                for(AnimalType types: AnimalType.values()) {
                    int random = ThreadLocalRandom.current().nextInt(1, factory.createAnimal(types).getMaxNumberOnLocation());
                    Creature creature = factory.createAnimal(types);
                    int count = 0;
                    for (int num = 0; num < random; num++) {
                        locations[i][j].getAnimals().add(creature);
                        count++;
                    }
                    str = creature.getClass().getSimpleName() + " --> " + count + ";";
                }
                System.out.print("[ " + str + " ]");
            }
            System.out.println();
        }
    }

    private void move(Animal animal, Location location) {
        int stepsNumber = ThreadLocalRandom.current().nextInt(0, animal.getSpeed());

        while (stepsNumber > 0) {
            Direction direction = Direction.values()[ThreadLocalRandom.current().nextInt(Direction.values().length)];

            switch (direction) {
                case UP -> location = up(animal, location);
                case DOWN -> location = down(animal, location);
                case LEFT -> location = left(animal, location);
                case RIGHT -> location = right(animal, location);
            }
        }
    }

    private Location up(Animal animal, Location location) {
        //TODO;
        return location;
    }

    private Location right(Animal animal, Location location) {
        //TODO;
        return location;
    }

    private Location down(Animal animal, Location location) {
        //TODO;
        return location;
    }

    private Location left(Animal animal, Location location) {
        //TODO;
        return location;
    }
}
