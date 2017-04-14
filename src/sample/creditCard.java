package sample;

/**
 * Created by nickpaul on 4/10/17.
 */
public class creditCard {

    public Long ccNum;
    public Boolean valid;

    creditCard(Long num){
        this.ccNum = num;
        this.valid = isValid(this.ccNum);
    }


    /**
     * Return true if the card number is valid
     */
    private static boolean isValid(long number) {
        boolean state = false;
        int add = (sumOfDoubleEvenPlace(number)) + (sumOfOddPlace(number));

        if( prefixMatched(number, 0)){
            if (add % 10 == 0){
                state = true;
            }
        }
        return state;
    }
    /** Get the result from Step 2 */

    private static int sumOfDoubleEvenPlace(long number) {
        long ccNumer = number;

        int sumation = 0;
        while (ccNumer > 0) {
            ccNumer /= 10;
            int digit = getDigit((int) (ccNumer % 10) * 2);
            sumation += digit;
            ccNumer /= 10;
        }
        return sumation;
    }


    /**
     * Return this number if it is a single digit, otherwise, return the sum of
     * the two digits
     */
    private static int getDigit(int number) {
        if (number <= 9){return number;}

        else {
            int temp = number % 10;
            return 1 + temp;
        }
    }

    /**
     * Return sum of odd place digits in number
     */
    private static int sumOfOddPlace(long number) {
        long ccNumer = number;

        int sumation = 0;
        while (ccNumer > 0) {

            int digit = (int) (ccNumer % 10);
            digit = getDigit(digit);
            sumation += digit;
            ccNumer /= 100;
        }
        return sumation;
    }


    /**
     * Return true if the digit d is a prefix for number
     */
    private static boolean prefixMatched(long number, int d) {

        boolean state = false;
        long prefix = getPrefix(number, 0);

        if (prefix == 4 || prefix == 5 || prefix == 6){
            state = true;
        }
        else if (prefix == 3){
            prefix = getPrefix(number, 1);
            if (prefix == 37){
                state = true;
            }
        }
        return state;
    }

    /**
     * Return the number of digits in d
     */
    private static int getSize(long d) {
        int size;
        String length = Long.toString(d);
        size = length.length();
        return size;

    }

    /**
     * Return the first k number of digits from number. If the number of digits
     * in number is less than k, return number.
     */
    public static long getPrefix(long number, int k) {

        String converted = Long.toString(number);


        if (k == 0){
            String temp = converted.substring(0,1);
            long done =  Long.parseLong(temp);
            return done;
        }


        else {

            String temp = converted.substring(0,k);
            long done = Long.parseLong(temp);
            return done;

        }
    }

}
