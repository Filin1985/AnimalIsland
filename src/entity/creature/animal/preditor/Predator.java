package entity.creature.animal.preditor;

import entity.creature.animal.Animal;

public abstract class Predator extends Animal {

    protected Predator(double weight, int maxNumberOnLocation, int speed, double maxNumberSaturation) {
        super(weight, maxNumberOnLocation, speed, maxNumberSaturation);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void eat() {

    }
}
