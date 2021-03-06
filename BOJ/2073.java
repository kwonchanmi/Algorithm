import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int distance, town;
        int MAX = 33554432;

        StringTokenizer input = new StringTokenizer(br.readLine());

        distance = Integer.parseInt(input.nextToken());
        town = Integer.parseInt(input.nextToken());

        int[] dp = new int[distance + 1];

        dp[0] = MAX;

        for (int x = 0; x < town; x++) {
            int length, capacity;

            StringTokenizer pipe = new StringTokenizer(br.readLine());

            length = Integer.parseInt(pipe.nextToken());
            capacity = Integer.parseInt(pipe.nextToken());

            for (int y = distance; y >= length; y--) {
                dp[y] = Math.max(dp[y], Math.min(capacity, dp[y - length]));
            }

        }

        bw.write(String.valueOf(dp[distance]) + "\n");
        bw.flush();
        bw.close();
        br.close();

    }







}
