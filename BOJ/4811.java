import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static long[][] cache;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int num;

        while((num=Integer.parseInt(br.readLine()))!=0){
            cache=new long[num+1][num+1];

            bw.write(String.valueOf(pill(num-1,1))+"\n");
            bw.flush();
        }

        br.close();
        bw.close();

    }

    public static long pill(int w_num,int h_num){
        if(w_num==0 && h_num==0)
            return 1;

        if(cache[w_num][h_num]!=0)
            return cache[w_num][h_num];

        long temp=0;

        if(w_num!=0)
            temp+=pill(w_num-1,h_num+1);

        if(h_num!=0)
            temp+=pill(w_num,h_num-1);

        cache[w_num][h_num]=temp;

        return temp;

    }





}
