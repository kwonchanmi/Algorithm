import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int height,width;
    public static int target;

    public static int[][] list=new int[501][501];

    public static int[][] cache=new int[501][501];

    public static int[][] plus={{0,1},{0,-1},{1,0},{-1,0}};


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        height=scan.nextInt();
        width=scan.nextInt();

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                list[x][y] = scan.nextInt();
                cache[x][y] = -1;
            }
        }

        System.out.println(make_route(0,0));



        scan.close();


    }

    public static int make_route(int now_x,int now_y){

        if (now_x == height - 1 && now_y == width - 1) {
            return 1;
        }

        if(cache[now_x][now_y]!=-1)
            return cache[now_x][now_y];

        int ret=0;

        for(int index=0;index<4;index++){

            int next_x=plus[index][0]+now_x;
            int next_y=plus[index][1]+now_y;
            if (isRange(next_x, next_y) && list[next_x][next_y] < list[now_x][now_y]) {
                ret+=make_route(next_x,next_y);
            }
        }

        cache[now_x][now_y]=ret;

        return ret;

    }

    public static boolean isRange(int x,int y){
        if(x>=height || y>=width || x<0 || y<0)
            return false;
        return true;
    }

}
