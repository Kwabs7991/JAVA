public class BarkingDog {
 public static boolean shouldWakeUp(boolean barking,int hourOfDay){

        if (barking && (hourOfDay < 0 || hourOfDay > 23)){
            System.out.println("false");
            return false;
        }else if (barking && (hourOfDay < 8 || hourOfDay > 22)){
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    }
}


/****************************************************************************/
/****************************************************************************/


public class mainClass {

    public static void main(String[] args) {
BarkingDog.shouldWakeUp(false,10); //false
BarkingDog.shouldWakeUp(true, 1); //true
BarkingDog.shouldWakeUp(true, -1); //false
BarkingDog.shouldWakeUp(true, 8);  //false
BarkingDog.shouldWakeUp(false, 2);//false
    }
}
