import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int total,kim,han;
        int round=1;

        total=scan.nextInt();
        kim=scan.nextInt();
        han=scan.nextInt();

        int kim_round=kim/2+kim%2;
        int han_round=han/2+han%2;



        while(kim_round!=han_round){
            kim_round=kim_round%2+kim_round/2;
            han_round=han_round%2+han_round/2;
            round++;
        }

        System.out.println(round);


        scan.close();

    }





}
