package com.macdonaldmartin.rpgstatgenjava;

public class Dice {

    public int getRandomRoll(){
        return (int) (Math.random() * 6) + 1;
    }
}
