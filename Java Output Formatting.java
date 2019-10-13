/*This code does the following:

    - Each String is left-justified with trailing whitespace through the first 15 characters. 
    - The leading digit of the integer is the 16th character, and each integer that was less than 3 digits now has leading zeroes.


    Output should be as follows:

        ================================
        java           100 
        cpp            065 
        python         050 
        ================================


In a formatter, % introduces a format sequence. The - means that the string will be left-justified (spaces will be added on the right of the string). The 15 means the resulting string will be 15 characters long. The s is the character string format code, and ends the format sequence
 */


import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");

            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();

                String sents = String.format("%-15s", s1);

                if (x>0 && x<=99){
                    int x1 = x;
                    System.out.println(sents + "0" + x1);
                }else if(x==0){
                    int x2 = x;
                    System.out.println(sents + "00" + x2);
                }else if (x>99){
                   
                    System.out.println(sents + x);
                }
            }
            System.out.println("================================");

    }
}



