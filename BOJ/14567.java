import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int subject_num, condition_num;

        StringTokenizer num=new StringTokenizer(br.readLine());

        subject_num = Integer.parseInt(num.nextToken());
        condition_num = Integer.parseInt(num.nextToken());


        int[] dp = new int[subject_num + 1];
        boolean[][] list = new boolean[subject_num + 1][subject_num + 1];


        for(int x=0;x<condition_num;x++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            list[one][two]=true;
        }


        for (int x = 1; x <= subject_num; x++) {

            dp[x]=1;

            for (int y = 1; y < x; y++) {
                if (list[y][x]) {
                    dp[x] = Math.max(dp[x], dp[y] + 1);
                }
            }
        }

        for (int x = 1; x <= subject_num; x++) {
            bw.write(dp[x] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }




}
