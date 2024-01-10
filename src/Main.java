import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KioskApp kioskApp = new KioskApp();
        boolean operation = true;
        while(operation){
            operation = kioskApp.coreApp();
        }
    }
}