package com.macdonaldmartin.rpgstatgenjava;

import java.util.Arrays;

public class Character {

    //Stats
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private final Dice die = new Dice();

    //Rolls four dice and outputs an array of them.
    public int[] rollStat(){
        return new int[]{die.getRandomRoll(), die.getRandomRoll(), die.getRandomRoll(), die.getRandomRoll()};
    }

    //Getters.
    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }
}
