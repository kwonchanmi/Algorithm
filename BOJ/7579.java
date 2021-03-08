import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int app_num, memory_target, answer = 10001;

        StringTokenizer input = new StringTokenizer(br.readLine());

        app_num = Integer.parseInt(input.nextToken());
        memory_target = Integer.parseInt(input.nextToken());

        int[] dp = new int[10001];

        //[][0] -> 바이트 [][1] -> 비용
        int[][] app = new int[app_num][2];


        for (int x = 0; x < 2; x++) {

            StringTokenizer list = new StringTokenizer(br.readLine());

            for (int y = 0; y < app_num; y++) {
                app[y][x] = Integer.parseInt(list.nextToken());
            }
        }

        for (int x = 0; x < app_num; x++) {
            for (int y = 10000; y >= app[x][1]; y--) {
                dp[y] = Math.max(dp[y], dp[y - app[x][1]] + app[x][0]);

            }
        }


        for (int x = 0; x <= 10000; x++) {
            if(dp[x]>=memory_target && x<answer)
                answer = x;
        }

        System.out.println(answer);

        br.close();

    }





}


