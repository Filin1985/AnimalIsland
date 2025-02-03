package service;

import config.CreatureConfig;
import model.Island.Cell;
import model.animal.Animal;
import model.animal.Creature;
import model.plant.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class CellFactory {
    private final CreatureConfig creatureConfig = new CreatureConfig();

    public Cell createCell() {
        Cell cell = new Cell();
        int number;
        int maxNumberOnCell = 0;
        for (Class<? extends Creature> creatureClass : creatureConfig.creatureClassList) {
            Creature creature;
            try {
                creature = creatureClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }

                for (Map.Entry<Class<? extends Creature>                       // Присвоение максимума животных на одной клетке при создании ячеек при инициализации острова. Перетаскиваем значения из одной мапы в другую
                        , Integer> maxNumberOnCellEntry : creatureConfig.maxNumberOnCellMap.entrySet()) {
                    if (creatureClass.equals(maxNumberOnCellEntry.getKey())) {
                        maxNumberOnCell = maxNumberOnCellEntry.getValue();
                        break;
                    }
                }

                number = (ThreadLocalRandom.current().nextInt(100) * maxNumberOnCell)/100;// задание количества животных на клетке при инициализации клетки острова


            for (int i = 0; i <= number; i++) {
                try {
                    if (creature instanceof Animal) {
                        cell.getAnimals().add((Animal) creature.clone());
                    } else {
                        cell.getPlants().add((Plant) creature.clone());
                    }
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return cell;
    }
}