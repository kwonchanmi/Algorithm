import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int num, sum;

        StringTokenizer st=new StringTokenizer(br.readLine());

        num=Integer.parseInt(st.nextToken());
        sum=Integer.parseInt(st.nextToken());

        int[] dp=new int[sum+1];


        dp[0]=1;

        for(int x=0;x<num;x++){

            int base=Integer.parseInt(br.readLine());

            for(int y=base;y<=sum;y++){
                dp[y]+=dp[y-base];
            }
        }


        bw.write(String.valueOf(dp[sum]));
        bw.flush();
        bw.close();
        br.close();



    }







}
