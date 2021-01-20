import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int n;

    public static int[] list=new int[1001];
    public static int[] dp=new int[1001];
    public static int[] cache=new int[1001];

    public static void main(String[] args) throws IOException {

        Scanner scan=new Scanner(System.in);

        n=scan.nextInt();

        int max=0;
        int max_index=0;

        for(int x=0;x<n;x++){
            list[x]=scan.nextInt();
            dp[x]=1;

            for(int y=0;y<x;y++){
                if(list[y]<list[x] && dp[y]+1>dp[x]){
                    dp[x]=dp[y]+1;
                    cache[x]=y;
                }
            }

            if(dp[x]>max){
                max=dp[x];
                max_index=x;
            }
        }

        int [] answer=new int[max];
        int index=max_index;

        for(int x=max-1;x>=0;x--){
            answer[x]=list[index];
            index=cache[index];
        }

        System.out.println(max);
        for(int x=0;x<max;x++)
            System.out.print(answer[x]+" ");


    }




}
