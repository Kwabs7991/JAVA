package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        double var1 = 20.00d;
        double var2 =  80.00d;

        double NumeroUno = var1 + var2;
        NumeroUno *= 100d ;
        System.out.println("After adding var 1 and 2 adn then multiply by hunna  :" + NumeroUno);
        NumeroUno = NumeroUno % 40.00d;
        System.out.println("After modulus, the remainder is: " + NumeroUno);

        boolean hablar1 = (NumeroUno == 0) ? true : false;
        System.out.println(hablar1);
        if (!hablar1){
            System.out.println("Got some remainder init.");
        }
    }
}
