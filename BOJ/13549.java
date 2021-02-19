import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        int N=scan.nextInt();
        int K=scan.nextInt();
        boolean flag=true;




        if(N>=K)
            System.out.println(N-K);
        else{

            Queue<Integer> location=new LinkedList<>();

            location.add(N);

            int dp[]=new int[K*2+1];
            boolean visited[]=new boolean[K*2+1];

            visited[N]=true;


            while(!location.isEmpty()) {

                int now = location.poll();

                if(now==K)
                    break;

                if (now - 1 >= 0) {
                    if (dp[now - 1] > dp[now] + 1 || !visited[now - 1]) {
                        visited[now - 1] = true;
                        dp[now - 1] = dp[now] + 1;
                        location.add(now - 1);
                    }
                }

                if (now + 1 <= K) {
                    if (dp[now + 1] > dp[now] + 1 || !visited[now + 1]) {
                        visited[now + 1] = true;
                        dp[now + 1] = dp[now] + 1;
                        location.add(now + 1);
                    }
                }

                if (now * 2 < K * 2) {
                    if (dp[now * 2] > dp[now] || !visited[now * 2]) {
                        visited[now * 2] = true;
                        dp[now * 2] = dp[now];
                        location.add(now * 2);
                    }
                }


            }

            System.out.println(dp[K]);
        }



    }





}
