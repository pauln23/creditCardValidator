package sample;

import java.util.Scanner;

/**
 * Created by nickpaul on 4/10/17.
 */
public class testclass {


    public static void main(String[] args) {


        Scanner input = new Scanner (System.in);
        System.out.println("Enter number: ");


        creditCard card = new creditCard(5105105105105100L);

        System.out.println(card.valid);

    }
}
