import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int k;
    public static int mod=1000000000;


    public static int[][] cache=new int[202][202];

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        k = scan.nextInt();


        for (int x = 0; x <= 200; x++)
            for (int y = 0; y <= 200; y++) {
                cache[x][y] = 0;
            }


        cache[0][0]=1;

        for(int x=0;x<=n;x++){
            for(int y=1;y<=k;y++){
                for(int z=0;z<=x;z++)
                    cache[x][y]=(cache[x][y]+cache[x-z][y-1])%mod;
            }

        }
        System.out.println(cache[n][k]);

        scan.close();


    }

}
