
public class MegaBytesConv {
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {

        if (kiloBytes < 0){
            System.out.println("Invalid Value");

        }else{
            int megabytes = kiloBytes / 1024;
            int remainsKB = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " +  megabytes + " MB and " + remainsKB + " KB");
        }
    }
}

/******************************************************************************************************/
/******************************************************************************************************/

public class mainClass {
    public static void main(String[] args) {
        MegaBytesConv.printMegaBytesAndKiloBytes(-1054);
        MegaBytesConv.printMegaBytesAndKiloBytes(2500);
    }
}
