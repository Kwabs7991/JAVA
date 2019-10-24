package com.company;

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

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Min.Value over here: " + myMinByteValue);
        System.out.println("Byte Max.Value over here: " + myMaxByteValue);


        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short Min.Value over here: " + myMinShortValue);
        System.out.println("Short Max.Value over here: " + myMaxShortValue);
        /*A byte is 8 bits, so we can say that a byte has a width of 8
        * A short has larger range in number and occupies 16 bits, therefore it has a width of 16.
        * An int has an even larger range of numbers and occupies 32 bits, therefore it has a width of 32.
        * A long has a width of 64. This means it has 64 bits. This would then be 8 bytes,
        * if we were looking in terms of bytes.*/
        
        
        long myLongValue = 100L;//We use the upper case L as it tells the compiler that this will be a Long number.
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long Min.Value over here: " + myMinLongValue);
        System.out.println("Long Max.Value over here: " + myMaxLongValue);
        long bigLongLiteralValue = 2_147_483_647_234L;
        System.out.println(bigLongLiteralValue);
    }
}
