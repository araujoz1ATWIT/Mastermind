package wit.comp1050.mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static int CODE_SIZE = 4;
    public static boolean SOUNDS_VALUE = false; //Change configurations here
    public static boolean DUPLICATES_ALLOWED_IN_CODE = false; //Change configurations here

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Code code = new Code(CODE_SIZE);

        code.getCode();
        System.out.println(Arrays.toString(code.getColorCombination()));

        PegColor[] user_guess = new PegColor[code.getColorCombination().length];

        for (int i = 0; i < code.getColorCombination().length; i++){

            System.out.printf("Enter your %d row guess, with code size of %d\n", i+1, code.getColorCombination().length);

            for (int j = 0; j < code.codeSize; j++){
                System.out.printf("Enter peg %d: ", j+1);
                user_guess[j] = PegColor.valueOf(input.next());
            }

            System.out.println(Arrays.toString(user_guess));
            System.out.println(Arrays.toString(code.getPositions(user_guess)));
            System.out.println(Arrays.toString(code.colorFromPositions()));
        }




    }
}
