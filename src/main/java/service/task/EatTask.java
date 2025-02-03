package service.task;

import config.CreatureConfig;
import model.Island.Cell;
import model.animal.Animal;
import model.animal.Creature;
import model.plant.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EatTask {
    private Cell cell;
    private final CreatureConfig creatureConfig = new CreatureConfig();

    public void animalEat(Cell cell) {
        this.cell = cell;
        for (int i = 0; i < cell.getAnimals().size(); i++) {
            getAnimalEat(cell.getAnimals().get(i));
        }
    }

    private void getAnimalEat(Animal hunter) {
        Map<Class<? extends Creature>, Integer> victimMap =
                creatureConfig.fightProbabilityMap.get(hunter.getClass());
        for (Map.Entry<Class<? extends Creature>, Integer> victimEntry : victimMap.entrySet()) {
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
            int randomProbability = threadLocalRandom.nextInt(100);
            if (victimEntry.getValue() != 0 && randomProbability >= victimEntry.getValue()
                    || victimEntry.getValue() == 100) {
                try {
                    removeAnimal(victimEntry.getKey().getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void removeAnimal(Creature creature) {
        if (creature instanceof Animal) {
            for (Animal animal : cell.getAnimals()) {
                if (animal.getClass().equals(creature.getClass())) {
                    cell.getAnimals().remove(animal);
                    break;
                }
            }
        } else {
            for (Plant plant : cell.getPlants()) {
                if (plant.getClass().equals(creature.getClass())) {
                    cell.getPlants().remove(plant);
                    break;
                }
            }
        }
    }
}