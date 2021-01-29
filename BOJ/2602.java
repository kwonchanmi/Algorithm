import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String magic=br.readLine();


        String devil=br.readLine();
        String angel=br.readLine();

        int magic_size=magic.length();
        int str_size=devil.length();

        int[][][] dp = new int[2][magic_size][str_size];

        if(magic.charAt(0)==devil.charAt(0))
            dp[0][0][0]=1;
        if(magic.charAt(0)==angel.charAt(0))
            dp[1][0][0]=1;

        for(int x=1;x<str_size;x++){


            char devil_temp=devil.charAt(x);
            char angel_temp=angel.charAt(x);

            dp[0][0][x]=dp[0][0][x-1];
            dp[1][0][x]=dp[1][0][x-1];
            
            if(devil_temp==magic.charAt(0))
                dp[0][0][x]+=1;
            if(angel_temp==magic.charAt(0))
                dp[1][0][x]+=1;
            
            for(int y=1;y<magic_size;y++){

                dp[0][y][x] += dp[0][y][x - 1];
                dp[1][y][x] += dp[1][y][x - 1];

                if(devil_temp==magic.charAt(y))
                    dp[0][y][x]+=dp[1][y-1][x-1];
                if(angel_temp==magic.charAt(y))
                    dp[1][y][x]+=dp[0][y-1][x-1];
                
            }


        }


        bw.write(String.valueOf(dp[0][magic_size - 1][str_size-1] + dp[1][magic_size - 1][str_size-1]));

        bw.flush();
        bw.close();
        br.close();


    }



}
