import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        int N=scan.nextInt();
        int K=scan.nextInt();



        if(N>=K)
            System.out.println(N-K);
        else{

            Queue<Integer> location=new LinkedList<>();

            location.add(N);

            int dp[]=new int[K*2+1];

            while(!location.isEmpty()) {

                int now = location.poll();

                if(now==K)
                    break;

                if (now - 1 >= 0 && dp[now - 1] == 0) {
                    dp[now - 1] = dp[now] + 1;
                    location.add(now - 1);
                }

                if (now + 1 <= K && dp[now + 1] == 0) {
                    dp[now + 1] = dp[now] + 1;
                    location.add(now + 1);
                }

                if (now * 2 < K * 2 && dp[now * 2] == 0) {
                    dp[now * 2] = dp[now] + 1;
                    location.add(now * 2);
                }
            }

            System.out.println(dp[K]);
        }



    }





}
