package entity.creature.animal.herbivore;

import entity.creature.animal.Animal;

public class Herbivore extends Animal {
    protected Herbivore(double weight, int maxNumberOnLocation, int speed, double maxNumberSaturation) {
        super(weight, maxNumberOnLocation, speed, maxNumberSaturation);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void eat() {

    }
}
