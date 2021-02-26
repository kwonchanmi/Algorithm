import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rice_num = Integer.parseInt(br.readLine());
        int[][] dp = new int[rice_num + 1][rice_num + 1];
        int[] rice_plant = new int[rice_num + 1];

        for (int x = 1; x <= rice_num; x++) {
            rice_plant[x] = Integer.parseInt(br.readLine());

            dp[x][x] = rice_plant[x] * rice_num;

            for (int y = x - 1; y > 0; y--) {
                dp[y][x] = Math.max(dp[y + 1][x] + rice_plant[y] * (rice_num - x + y), dp[y][x - 1] + rice_plant[x] * (rice_num - x + y));
            }
        }



        bw.write(String.valueOf(dp[1][rice_num]));
        bw.flush();
        bw.close();
        br.close();

    }






}
