package entity.creature.animal;

public abstract class Animal extends Creature {
    private int speed;
    private double maxCountSaturation;

    protected Animal(double weight, int maxNumberOnLocation, int speed, double maxNumberSaturation) {
        super(weight, maxNumberOnLocation);
        this.maxCountSaturation = maxNumberSaturation;
        this.speed = speed;
    }

    @Override
    public abstract void reproduce();

    public abstract void eat();

    public int getSpeed() {
        return speed;
    }

    public double getMaxCountSaturation() {
        return maxCountSaturation;
    }
}
