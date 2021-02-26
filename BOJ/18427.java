import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int student_num,max_block_num,height;

        StringTokenizer num = new StringTokenizer(br.readLine());

        student_num = Integer.parseInt(num.nextToken());
        max_block_num = Integer.parseInt(num.nextToken());
        height = Integer.parseInt(num.nextToken());

        int[][] dp = new int[student_num + 1][height + 1];




        for (int x = 1; x <= student_num; x++) {

            StringTokenizer block = new StringTokenizer(br.readLine());

            dp[x - 1][0] = 1;

            int block_num = block.countTokens();

            for (int y = 0; y < block_num; y++) {

                int now = Integer.parseInt(block.nextToken());

                for (int z = now; z <= height; z++) {

                    dp[x][z] = (dp[x][z] + dp[x - 1][z - now]) % 10007;
                }

            }

            for (int k = 1; k <= height; k++) {
                dp[x][k] = (dp[x][k] + dp[x - 1][k]) % 10007;
            }

        }


        bw.write(String.valueOf(dp[student_num][height]));
        bw.close();
        br.close();


    }




}
