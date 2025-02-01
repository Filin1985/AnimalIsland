package entity.creature.animal.herbivore;

public class Horse extends Herbivore{
    protected Horse(double weight, int maxNumberOnLocation, int speed, double maxNumberSaturation) {
        super(400, 20, 4, 60);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void eat() {

    }
}
