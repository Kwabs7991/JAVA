

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



