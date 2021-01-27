import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;

    public static int[][] forest=new int[500][500];

    public static int[][] cache = new int[500][500];

    public static int[][] plus = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());


        for (int x = 0; x < N; x++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());

            for(int y=0;y<N;y++){
                forest[x][y] = Integer.parseInt(temp.nextToken());
            }
        }

        int answer=0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                answer = Math.max(answer, dp_make(x, y));
            }
        }

        System.out.println(answer);

    }

    public static int dp_make(int x,int y){
        if(cache[x][y]!=0)
            return cache[x][y];


        for (int index = 0; index < 4; index++) {
            int temp_x=x+plus[index][0];
            int temp_y=y+plus[index][1];

            if(!isRange(temp_x,temp_y) || forest[x][y] >=forest[temp_x][temp_y])
                continue;

            cache[x][y] = Math.max(cache[x][y], dp_make(temp_x, temp_y));

        }

        cache[x][y]=cache[x][y]+1;

        return cache[x][y];

    }

    public static boolean isRange(int x, int y){
        if(0>x || x>=N || 0>y || y>=N)
            return false;

        return true;
    }





}
