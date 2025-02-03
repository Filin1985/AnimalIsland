package service.task;

import config.CreatureConfig;
import model.Island.Cell;
import model.plant.Grass;

import java.util.concurrent.ThreadLocalRandom;

public class PlantsIncreaseTask {
    private final CreatureConfig creatureConfig = new CreatureConfig();

    public void grassGrow(Cell cell) {
        Grass grass = new Grass();
        int grassMaxNumber = creatureConfig.maxNumberOnCellMap.get(grass.getClass());
        int randomNumber = ThreadLocalRandom.current().nextInt(grassMaxNumber);
        for (int i = 0; i < randomNumber; i++) {
            cell.getPlants().add(new Grass());
        }
    }
}
