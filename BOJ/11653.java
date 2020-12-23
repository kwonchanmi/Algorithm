import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);


        int num=scan.nextInt();
        int start=2;

        while(num!=1){
            if(num%start==0){
                System.out.println(start);
                num/=start;
            }else
                start++;
        }

        scan.close();
    }







}
