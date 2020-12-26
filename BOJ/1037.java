import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);

        int num=scan.nextInt();

        int[] list=new int[num];

        for(int x=0;x<num;x++)
            list[x]=scan.nextInt();

        Arrays.sort(list);

        System.out.println(list[0]*list[num-1]);

        scan.close();
    }



}
