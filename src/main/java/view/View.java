package view;

import config.CreatureConfig;
import config.IslandConstants;
import model.Island.Cell;
import model.Island.Island;
import model.animal.Creature;
import model.plant.Grass;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class View {

    CreatureConfig creatureConfig = new CreatureConfig();
    int generationNumber;

    public synchronized void printIsland(Island island, String taskName) {

            System.out.println(IslandConstants.NEXT_GEN + ++generationNumber + " *********************************");
            System.out.println(taskName);
            for (int i = 0; i < island.getX(); i++) {
                for (int j = 0; j < island.getY(); j++) {
                    out.print("cell " + (i) + "/" + (j) + "    ");
                    print(island.getIsland().get(i).get(j));
                }

        }
//        island.getIsland().stream().flatMap(Collection::stream).forEach(this::print);
    }

    public void print(Cell cell) {
        Grass grass = new Grass();
        int count;
        for (Class<? extends Creature> creatureClass : creatureConfig.creatureClassList) {
            count = cell.getAnimals().stream()
                    .mapToInt(value -> value.getClass().equals(creatureClass) ? 1 : 0)
                    .sum();
            try {
                cellMap.put(creatureClass.getConstructor().newInstance().getSymbol(), count);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        cellMap.put(grass.getSymbol(), cell.getPlants().size());
        System.out.println(cellMap);
    }

    Map<String, Integer> cellMap = new HashMap<>() {
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> pair : cellMap.entrySet()) {
                stringBuilder.append(String.format("%s%d  ", pair.getKey(), pair.getValue()));
            }
            return stringBuilder.toString();
        }
    };
}
