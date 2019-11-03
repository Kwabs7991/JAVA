package com.company;

import java.util.Scanner;

public class Primenumbre {


    public Primenumbre(int no) {
    }


    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hey You! Yh You!");
        System.out.println("Enter any number you want mate : ");
        int no = scanner.nextInt();
        new Primenumbre(no);
    }



    static void primenumbre(int no) {

        int temp;
        boolean flag = true;

        for (int i = 2; i <= no / 2; i++) {
            temp = no % i;
            if (temp == 0) {
                flag = false;
            }
        }

        if (flag = true) {
            System.out.println("Your number is......a PRIME NUMBER");
        } else if(flag = false) {
            System.out.println("Yo Your number is NOT A PRIME, get that thing outta here!");
        }
    }



}
