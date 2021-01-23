import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static long[][] cache=new long[10][65];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(br.readLine());

        for(int x=0;x<10;x++)
            cache[x][0]=1;

        for(int y=1;y<=64;y++){
            long sum=0;

            for(int x=9;x>=0;x--){
                sum+=cache[x][y-1];
                cache[x][y]=sum;
            }
        }

        for(int x=0;x<test_case;x++){
            int n=Integer.parseInt(br.readLine());

            bw.write(String.valueOf(cache[0][n])+"\n");
            bw.flush();
        }

        br.close();
        bw.close();

    }

}
