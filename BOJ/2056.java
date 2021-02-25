import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int process_num = Integer.parseInt(br.readLine());
        int answer=0;

        int[] dp = new int[process_num + 1];

        for (int x = 1; x <= process_num; x++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int time,num;

            time = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());

            dp[x] = time;

            for (int y = 0; y < num; y++) {
                int temp = Integer.parseInt(st.nextToken());

                dp[x] = Math.max(dp[x], dp[temp] + time);
            }

            if(answer<dp[x])
                answer = dp[x];

        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();


    }




}
