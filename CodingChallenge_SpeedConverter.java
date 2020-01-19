public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour) {

        if (kilometersPerHour < 0) {
            return -1;
        }
        //below can be seen/acts as an "else if" code block
        //System.out.println("Miles Used: " + Math.round(kilometersPerHour * 1.60934));
        long mile = Math.round(kilometersPerHour / 1.60934) ;
        return mile;
    }


    public static void printConversion(double kilometersPerHour){

        if (kilometersPerHour < 0){
            System.out.println("Invalid Value");
        }else{
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            //System.out.println(milesPerHour);
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////

public class main {
    public static void main(String[] args) {
        //SpeedConverter.toMilesPerHour(10.5);
        SpeedConverter.printConversion(97.75);
    }

}
