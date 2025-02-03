package config;

import model.animal.*;
import model.plant.Grass;
import util.PropertiesReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CreatureConfig {
    private static final String numberOnCell = "numberOnCell";
    public final List<Class<? extends Creature>> creatureClassList = List.of(Boar.class,
            Buffalo.class, Caterpillar.class, Deer.class, Duck.class, Goat.class, Horse.class, Mouse.class, Rabbit.class
            , Sheep.class, Bear.class, Eagle.class, Fox.class, Boa.class, Wolf.class, Grass.class);

    public final Map<Class<? extends Creature>, Map<Class<? extends Creature>, Integer>> fightProbabilityMap =
            new HashMap<>();

    public final Map<Class<? extends Creature>, Integer> maxNumberOnCellMap =
            new HashMap<>();

    {
        fillFightProbability();
        fillMaxNumberOnCellMap();
    }

    private void fillFightProbability() {
        for (Class<? extends Creature> cretureClass : creatureClassList) {
            fightProbabilityMap.put(cretureClass, getCreatureConfig(cretureClass));
        }
    }
    private void fillMaxNumberOnCellMap() {
        for (Class<? extends Creature> cretureClass : creatureClassList) {
            Properties maxNumberOnCellProps = PropertiesReader.loadProperties(cretureClass.getSimpleName().toLowerCase()
                    , IslandConstants.INHABITANT_PROPS_FOLDER);
            Integer maxNumberOnCell = Integer.valueOf(maxNumberOnCellProps.getProperty(numberOnCell));
            maxNumberOnCellMap.put(cretureClass, maxNumberOnCell);
        }
    }
    private Map<Class<? extends Creature>, Integer> getCreatureConfig(Class<? extends Creature> hunterClass) {
        Map<Class<? extends Creature>, Integer> victimMap = new HashMap<>();
        String hunter = hunterClass.getSimpleName().toLowerCase();
        Properties victimProbability = PropertiesReader.loadProperties(hunter
                , IslandConstants.INHABITANT_PROPS_FOLDER);
        for (Class<? extends Creature> victimClass : creatureClassList) {
            String name = victimClass.getSimpleName();
            Integer probability = Integer.valueOf(victimProbability.getProperty(name.toLowerCase()));
            victimMap.put(victimClass, probability);
        }
        return victimMap;
    }
}
