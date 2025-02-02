package util;

import entity.creature.animal.Creature;
import entity.creature.animal.herbivore.*;
import entity.creature.animal.preditor.*;
import entity.creature.plant.Plant;

public class AnimalFactory {
    public Creature createAnimal(AnimalType type) {
        return switch(type) {
            case WOLF -> new Wolf();
            case BOA -> new Boa();
            case FOX -> new Fox();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case DEER -> new Deer();
            case RABBIT -> new Rabbit();
            case MOUSE -> new Mouse();
            case GOAT -> new Goat();
            case BUFFALO -> new Buffalo();
            case DUCK -> new Duck();
            case HOG -> new Hog();
            case SHEEP -> new Sheep();
            case CATERPILLAR -> new Caterpillar();
            case PLANT -> new Plant();
        };
    };
}
