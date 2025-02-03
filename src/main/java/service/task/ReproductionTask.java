package service.task;

import config.CreatureConfig;
import model.Island.Cell;
import model.animal.Animal;
import model.animal.Creature;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
public class ReproductionTask {
    private final CreatureConfig creatureConfig = new CreatureConfig();
    public void animalReproduction(Cell cell) {
        for (Class<? extends Creature> animalClass : creatureConfig.creatureClassList) {
            for (int i = 0; i < cell.getAnimals().size(); i++) {
                int countEqualsObjects = i;
                if (cell.getAnimals().stream().filter(s -> Objects.equals(cell.getAnimals().get(countEqualsObjects).getName(), s.getName())).count() <  0.98 * creatureConfig.maxNumberOnCellMap.get(cell.getAnimals().get(i).getClass())) {
                   // boolean isReproduction = ThreadLocalRandom.current().nextBoolean();
                    boolean isReproduction = Math.random() < 0.5;

                    if (animalClass.equals(cell.getAnimals().get(i).getClass()) && isReproduction) {
                        try {
                            cell.getAnimals().add((Animal) animalClass.getConstructor().newInstance());
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                                 NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }
    }
}


