import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);


        int num=scan.nextInt();

        int[] list=new int[num];
        int[] dp=new int[num];
        int max=0;


        for(int i=0;i<num;i++){
            list[i]=scan.nextInt();

            int temp_index=-1;
            for(int x=0;x<i;x++){
                if(list[x]<list[i] && (temp_index==-1 || dp[temp_index]<dp[x])){
                    temp_index = x;
                }
            }

            if(temp_index!=-1)
                dp[i]=dp[temp_index]+list[i];
            else
                dp[i]=list[i];

            if(dp[i]>max)
                max=dp[i];
        }

        System.out.println(max);


        scan.close();


    }



}
