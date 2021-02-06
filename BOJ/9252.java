
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String one=br.readLine();
        String two=br.readLine();

        int one_size=one.length();
        int two_size=two.length();

        int[][] dp=new int[one_size+1][two_size+1];

        for(int x=1;x<=one_size;x++){
            for(int y=1;y<=two_size;y++){
                if(one.charAt(x-1)!=two.charAt(y-1))
                    dp[x][y]=Math.max(dp[x-1][y],dp[x][y-1]);
                else
                    dp[x][y]=dp[x-1][y-1]+1;
            }
        }

        int answer=dp[one_size][two_size];

        bw.write(String.valueOf(answer)+"\n");

        Stack<Character> st=new Stack<>();


        int one_index=one_size;
        int two_index=two_size;

        while(dp[one_index][two_index]>0){
            if(dp[one_index][two_index]==dp[one_index-1][two_index])
                one_index--;
            else if(dp[one_index][two_index]==dp[one_index][two_index-1])
                two_index--;
            else{
                st.add(one.charAt(one_index-1));
                one_index--;
                two_index--;
            }
        }


        int size=st.size();

        for(int index=0;index<size;index++){
            bw.write(st.pop());
        }




        bw.flush();
        bw.close();
        br.close();



    }


}
