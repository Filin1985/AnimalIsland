package entity.creature.animal;

public abstract class Creature {
    private double weight;
    private int maxNumberOnLocation;

    protected Creature(double weight, int maxNumberOnLocation) {
        this.weight = weight;
        this.maxNumberOnLocation = maxNumberOnLocation;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxNumberOnLocation() {
        return maxNumberOnLocation;
    }

    public abstract void reproduce();
}
