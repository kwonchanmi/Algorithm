import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N,M,test_num;

        StringTokenizer size = new StringTokenizer(br.readLine());

        N = Integer.parseInt(size.nextToken());
        M = Integer.parseInt(size.nextToken());

        int[][] dp = new int[N + 1][M + 1];

        for (int x = 1; x <= N; x++) {

            StringTokenizer temp = new StringTokenizer(br.readLine());

            for (int y = 1; y <= M; y++) {

                int input = Integer.parseInt(temp.nextToken());

                dp[x][y] = dp[x - 1][y] + dp[x][y - 1] + input - dp[x - 1][y - 1];
            }
        }

        test_num = Integer.parseInt(br.readLine());

        for (int t = 0; t < test_num; t++) {

            StringTokenizer location = new StringTokenizer(br.readLine());

            int x1,x2,y1,y2;

            x1 = Integer.parseInt(location.nextToken());
            y1 = Integer.parseInt(location.nextToken());
            x2 = Integer.parseInt(location.nextToken());
            y2 = Integer.parseInt(location.nextToken());

            bw.write(String.valueOf(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }






}
