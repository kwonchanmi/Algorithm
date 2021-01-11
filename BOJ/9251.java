import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[][] cache=new int[1001][1001];
    public static String input_str_1="";
    public static String input_str_2="";

    public static int input_str_1_size=0;
    public static int input_str_2_size=0;

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);

        input_str_1=scan.next();
        input_str_2=scan.next();

        input_str_1_size=input_str_1.length();
        input_str_2_size=input_str_2.length();

//        long start=System.currentTimeMillis();

        // 배열 값 초기화
        for(int x=0;x<=1000;x++){
            for(int y=0;y<=1000;y++)
                cache[x][y]=-1;
        }

        System.out.println(dp(0,0));

//        long end=System.currentTimeMillis();
//
//        System.out.println(end-start);

        scan.close();


    }

    public static int dp(int one,int two){

        if(one>=input_str_1_size || two>=input_str_2_size)
            return 0;


        if(cache[one][two]!=-1)
            return cache[one][two];

        char base=input_str_1.charAt(one);

        int max_value=0;

        int temp_value=0;

        if(base==input_str_2.charAt(two))
            temp_value = dp(one + 1, two + 1) + 1;
        else
            temp_value = Math.max(dp(one + 1, two),dp(one,two+1));

        if (max_value < temp_value)
            max_value = temp_value;

        cache[one][two]=max_value;

        return max_value;
    }



}
