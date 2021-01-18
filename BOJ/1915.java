import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int n,m;


    public static int[][] cache=new int[1002][1002];

    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        int max=0;

        for (int x = 1; x <= n; x++) {
            String temp = br.readLine();

            for (int y = 1; y <= m; y ++) {
                cache[x][y] = temp.charAt(y-1)-'0';
            }
        }

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                if (cache[x][y] == 1) {
                    cache[x][y] = Math.min(Math.min(cache[x - 1][y - 1], cache[x - 1][y]), cache[x][y - 1]) + 1;

                    if (cache[x][y] > max) {
                        max = cache[x][y];
                    }
                }
            }
        }

        bw.write(String.valueOf(max*max));
        bw.flush();

        bw.close();
        br.close();



    }


}
