package com.macdonaldmartin.rpgstatgenjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Arrays;

public class MainController {
    private Image placeholderDie;
    @FXML private ImageView die1ImageView, die2ImageView, die3ImageView, die4ImageView;
    @FXML private Button btnRoll, btnStr, btnDex, btnCon, btnInt, btnWis, btnCha;
    @FXML private Label lblStrVal, lblDexVal, lblConVal, lblIntVal, lblWisVal, lblChaVal, lblTotal;

    private final Character character = new Character();
    private int total;
    private static final String[] FACE_IMAGES = {
            null,
            "DieOne.png",
            "DieTwo.png",
            "DieThree.png",
            "DieFour.png",
            "DieFive.png",
            "DieSix.png"
    };

    @FXML
    public void initialize() {
        placeholderDie = new Image(getClass().getResourceAsStream("images/DieQ.png"));
        setBtnStatus(true);
    }

    @FXML
    private void onRollClick(){
        int[] dice = character.rollStat();
        total = sum3Dice(dice);
        ImageView[] dieViews = { die1ImageView, die2ImageView, die3ImageView, die4ImageView };

        // Find the index of the lowest roll
        int lowestIndex = 0;
        for (int i = 1; i < dice.length; i++) {
            if (dice[i] < dice[lowestIndex]) {
                lowestIndex = i;
            }
        }

        //For each dice, change the ImageView to match the image of the dice corresponding to its location in the array.
        for (int i = 0; i < dice.length; i++) {
            String imagePath = "images/" + FACE_IMAGES[dice[i]];
            Image faceImage = new Image(getClass().getResourceAsStream(imagePath));
            dieViews[i].setImage(faceImage);
            dieViews[i].setOpacity(i == lowestIndex ? 0.4 : 1.0);
        }
        lblTotal.setText("Total: " + total);
        setBtnStatus(false);
        btnRoll.setDisable(true);
    }

    @FXML private void onStrClick() { applyStat(btnStr, lblStrVal, "strength"); }
    @FXML private void onDexClick() { applyStat(btnDex, lblDexVal, "dexterity"); }
    @FXML private void onConClick() { applyStat(btnCon, lblConVal, "constitution"); }
    @FXML private void onIntClick() { applyStat(btnInt, lblIntVal, "intelligence"); }
    @FXML private void onWisClick() { applyStat(btnWis, lblWisVal, "wisdom"); }
    @FXML private void onChaClick() { applyStat(btnCha, lblChaVal, "charisma"); }

    //Reset the program back to initial values.
    @FXML
    public void onResetClick() {
        character.reset();

        lblStrVal.setText("00");
        lblDexVal.setText("00");
        lblConVal.setText("00");
        lblIntVal.setText("00");
        lblWisVal.setText("00");
        lblChaVal.setText("00");
        lblTotal.setText("Total: 00");

        die1ImageView.setImage(placeholderDie);
        die2ImageView.setImage(placeholderDie);
        die3ImageView.setImage(placeholderDie);
        die4ImageView.setImage(placeholderDie);

        die1ImageView.setOpacity(1.0);
        die2ImageView.setOpacity(1.0);
        die3ImageView.setOpacity(1.0);
        die4ImageView.setOpacity(1.0);

        setBtnStatus(true);
        btnRoll.setDisable(false);
    }

    private void applyStat(Button statBtn, Label statLbl, String statName){
        character.setStat(statName, total);
        statLbl.setText(String.format("%02d", total));
        statBtn.setDisable(true);
        setBtnStatus(true);
        btnRoll.setDisable(false);
        total = 0;
    }

    //Sort the dice in ascending order, then return the highest three dice.
    private int sum3Dice(int[] dice){
        int[] sortedDice = dice.clone();
        Arrays.sort(sortedDice);
        return sortedDice[1] + sortedDice[2] + sortedDice[3];
    }

    //Set button on or off depending on whether it has a value that's not 00.
    private void setBtnStatus(boolean status) {
        if (!hasValue(lblStrVal)) btnStr.setDisable(status);
        if (!hasValue(lblDexVal)) btnDex.setDisable(status);
        if (!hasValue(lblConVal)) btnCon.setDisable(status);
        if (!hasValue(lblIntVal)) btnInt.setDisable(status);
        if (!hasValue(lblWisVal)) btnWis.setDisable(status);
        if (!hasValue(lblChaVal)) btnCha.setDisable(status);
    }

    private boolean hasValue(Label valueLbl) {
        return Integer.parseInt(valueLbl.getText()) != 00;
    }

}
