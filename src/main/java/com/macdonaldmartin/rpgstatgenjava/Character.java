package com.macdonaldmartin.rpgstatgenjava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Character {

    private final Map<String, Integer> stats = new HashMap<>();

    private final Dice die = new Dice();

    //Rolls four dice and outputs an array of them.
    public int[] rollStat(){
        return new int[]{die.getRandomRoll(), die.getRandomRoll(), die.getRandomRoll(), die.getRandomRoll()};
    }

    public void setStat(String statName, int value) {
        stats.put(statName, value);
    }

    public int getStat(String statName) {
        return stats.getOrDefault(statName, 0);
    }

    public void reset() {
        stats.clear();
    }
}
