package bag;

public class Main {

    public static void main(String[] args) {

        int myValue = 10000;
        int myMinIntVALUE  = Integer.MIN_VALUE;
        int myMaxIntVALUE  = Integer.MAX_VALUE;

        System.out.println("Integer Minimum Value = " + myMinIntVALUE);
        System.out.println("Integer Maximum Value = " + myMaxIntVALUE);
        /*Here I am using the MIN_VALUE & MAX_VALUE to get Java to tell is the minimum
         *and maximum ranges of numbers that can be stored*/

        System.out.println("Busted MAX Value = " + (myMaxIntVALUE + 1)); //Underflow in the case of the minimum.
        System.out.println("Busted MIN Value = " + (myMinIntVALUE - 1)); //Overflow in the case of the Maximum.

        /*When attempting to put a value larger than the maximum value known in Java, or vice versa in terms of smaller
        * then what will returnm is an overflow (max value) or underflow (min value).
        *
        * What happens is that the compiler (the computer simply speaking)
        * skips back to the min or max number (depending on situation of course).
        * This is not ideal in most cases and should be avoided.*/
    }
}
