import java.io.*;
import java.util.*;

public class Main {

    public static int[][][] dp=new int[21][21][21];


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int a,b,c;


        while(true){

            StringTokenizer st=new StringTokenizer(br.readLine());

            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1)
                break;

            bw.write("w("+String.valueOf(a)+", "+String.valueOf(b)+", "+String.valueOf(c)+") = "+String.valueOf(W_make(a,b,c))+"\n");


        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static int W_make(int a,int b,int c){

        if(a<=0 || b<=0 || c<=0)
            return 1;

        if(a>20 || b>20 || c>20)
            return W_make(20,20,20);

        if(dp[a][b][c]!=0)
            return dp[a][b][c];


        if(a<b && b<c)
            dp[a][b][c]=W_make(a,b,c-1)+W_make(a,b-1,c-1)-W_make(a,b-1,c);
        else
            dp[a][b][c]=W_make(a-1,b,c)+W_make(a-1,b-1,c)+W_make(a-1,b,c-1)-W_make(a-1,b-1,c-1);

        return dp[a][b][c];
    }



}
