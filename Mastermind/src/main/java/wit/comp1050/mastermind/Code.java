package wit.comp1050.mastermind;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
//this was added to test the push
public class Code {

    Code(int codeSize){
        this.codeSize = codeSize;
        this.colorCombination = new PegColor[codeSize];
        this.positions = new int[codeSize];
        getCode();
    }

    public void getCode(){

        PegColor[] code = new PegColor[codeSize];

        for (int i = 0; i < codeSize; i++){

            int random_num = getRandom(0, PegColor.values().length-1);

            colorCombination[i] = PegColor.values()[random_num];

        }
    }

    private int getRandom(int min, int max){

        int range = max - min + 1;

        return (int)(Math.random() * range) + min;
    }

    public int[] getPositions(PegColor[] guess){
        //Setting holder for other methods
        this.guess = guess;

        if (guess.length == colorCombination.length){
            for (int i = 0; i < guess.length; i++) {
                if (guess[i] == colorCombination[i]){
                    positions[i] = 1;
                } else {
                    positions[i] = 0;
                }
            }
        }
        return positions;
    }

    public Color[] colorFromPositions(){

        ArrayList<Integer> checkIndexs = new ArrayList<>();

        Color[] hintPegs = new Color[codeSize];

        //Checks if the color is in the right Spot for a red peg
        for (int i = 0; i < positions.length; i++){
            if (positions[i] == 1){
                hintPegs[i] = Color.RED;
            }
            else if (positions[i] == 0){
                hintPegs[i] = Color.TRANSPARENT;
            }
            else if (positions[i] == 2){
                hintPegs[i] = Color.GRAY;
            }
        }

        //Check if the color is in the wrong spot
        //BLUE, GREEN, PURPLE, RED, YELLOW;
        for (int i = 0; i < positions.length; i++){
            if (positions[i] != 1 && positions[i] != 2){
                checkIndexs.add(i);
            }
        }

        //every user guess that didnt match
        for (int i = 0; i < checkIndexs.size(); i++){
            //checks matchs against unmatched colors
            for (int j = 0; j < checkIndexs.size(); j++){
                if (guess[checkIndexs.get(i)] == colorCombination[checkIndexs.get(j)]){
                    //checkIndexs.remove(i);
                    positions[checkIndexs.get(i)] = 2;
                }

            }
        }


        System.out.println(Arrays.toString(positions));

        return hintPegs;
    }

    public PegColor[] getColorCombination() {
        return colorCombination;
    }

    protected int[] used_Colors = new int[5];
    protected PegColor[] guess;
    protected int[] positions;
    public PegColor[] colorCombination;
    public int codeSize;


}
