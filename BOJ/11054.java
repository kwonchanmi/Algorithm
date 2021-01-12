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
        int[] dp_right=new int[num];
        int[] dp_left=new int[num];

        int answer=0;

        dp_right[0]=dp_left[num-1]=1;

        for(int x=0;x<num;x++){
            list[x]=scan.nextInt();

            dp_right[x]=1;

            for(int y=0;y<x;y++){
                if(list[x]>list[y] && dp_right[x]<dp_right[y]+1)
                    dp_right[x]=dp_right[y]+1;
            }
        }

        for(int x=num-1;x>=0;x--){

            dp_left[x]=1;

            for(int y=num-1;y>x;y--){
                if(list[x]>list[y] && dp_left[x]<dp_left[y]+1)
                    dp_left[x]=dp_left[y]+1;
            }

            if(answer<dp_left[x]+dp_right[x])
                answer=dp_left[x]+dp_right[x];
        }

        System.out.println(answer-1);

        scan.close();


    }





}
