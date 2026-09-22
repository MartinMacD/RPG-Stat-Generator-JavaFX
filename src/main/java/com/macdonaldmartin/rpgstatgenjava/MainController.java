package com.macdonaldmartin.rpgstatgenjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Arrays;

public class MainController {
    @FXML private ImageView die1ImageView;
    @FXML private ImageView die2ImageView;
    @FXML private ImageView die3ImageView;
    @FXML private ImageView die4ImageView;
    @FXML private Button btnStr;
    @FXML private Button btnDex;
    @FXML private Button btnCon;
    @FXML private Button btnInt;
    @FXML private Button btnWis;
    @FXML private Button btnCha;
    @FXML private Label lblTotal;

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
    private void onRollClick(){
        int[] dice = character.rollStat();
        total = sum3Dice(dice);
        ImageView[] dieViews = { die1ImageView, die2ImageView, die3ImageView, die4ImageView };

        //For each dice, change the ImageView to match the image of the dice corresponding to its location in the array.
        for (int i = 0; i < dice.length; i++) {
            String imagePath = "images/" + FACE_IMAGES[dice[i]];
            Image faceImage = new Image(getClass().getResourceAsStream(imagePath));
            dieViews[i].setImage(faceImage);
        }
        lblTotal.setText("Total: " + total);
        setBtnStatus(false);
    }

    @FXML private void onStrClick() { applyStat(btnStr); }
    @FXML private void onDexClick() { applyStat(btnDex); }
    @FXML private void onConClick() { applyStat(btnCon); }
    @FXML private void onIntClick() { applyStat(btnInt); }
    @FXML private void onWisClick() { applyStat(btnWis); }
    @FXML private void onChaClick() { applyStat(btnCha); }

    @FXML
    public void onResetClick() {
        character.reset();
    }

    private void applyStat(Button statButton){
        statButton.setText(String.valueOf(total));
        setBtnStatus(true);
        total = 0;
    }

    //Sort the dice in ascending order, then return the highest three dice.
    private int sum3Dice(int[] dice){
        int[] sortedDice = dice.clone();
        Arrays.sort(sortedDice);
        return sortedDice[1] + sortedDice[2] + sortedDice[3];
    }

    private void setBtnStatus(boolean status){
        btnStr.setDisable(status);
        btnDex.setDisable(status);
        btnCon.setDisable(status);
        btnInt.setDisable(status);
        btnWis.setDisable(status);
        btnCha.setDisable(status);
    }


}
