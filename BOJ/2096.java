import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;

    public static int INF=999999;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        int[][] min=new int[N][3];
        int[][] max=new int[N][3];


        for(int x=0;x<N;x++) {


            StringTokenizer st = new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());

            if (x == 0) {
                min[0][0] = max[0][0] = one;
                min[0][1] = max[0][1] = two;
                min[0][2] = max[0][2] = three;
            } else {
                min[x][0] = Math.min(min[x - 1][0], min[x - 1][1]) + one;
                max[x][0] = Math.max(max[x - 1][0], max[x - 1][1]) + one;

                min[x][1] = Math.min(Math.min(min[x - 1][0], min[x - 1][1]), min[x - 1][2]) + two;
                max[x][1] = Math.max(Math.max(max[x - 1][0], max[x - 1][1]), max[x - 1][2]) + two;

                min[x][2] = Math.min(min[x - 1][1], min[x - 1][2]) + three;
                max[x][2] = Math.max(max[x - 1][1], max[x - 1][2]) + three;
            }
        }


        int answer_min=Math.min(Math.min(min[N-1][0],min[N-1][1]),min[N-1][2]);
        int answer_max=Math.max(Math.max(max[N-1][0],max[N-1][1]),max[N-1][2]);

        System.out.println(answer_max + " " + answer_min);





    }




}
