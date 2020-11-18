import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);


        int num=scan.nextInt();

        int[] array=new int[num];
        int[] dp=new int[num];
        int max=1;

        for(int x=0;x<num;x++)
            array[x]=scan.nextInt();

        dp[0]=1;

        for(int x=1;x<num;x++){

            dp[x]=1;

            for(int y=0;y<x;y++){
                if(array[x]<array[y] && dp[y]+1>dp[x]){
                    dp[x]=dp[y]+1;
                }
            }


            if(max<dp[x])
                max=dp[x];
        }

        System.out.println(max);




        scan.close();
    }





}
