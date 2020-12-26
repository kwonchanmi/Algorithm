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

        int N=scan.nextInt();
        int K=scan.nextInt();
        int index=K-1;

        ArrayList<Integer> list=new ArrayList<>();

        for(int i=1;i<=N;i++)
            list.add(i);

        System.out.print("<"+K);
        list.remove(K-1);

        for(int i=0;i<N-1;i++){
            index=(index+K-1)%(list.size());

            System.out.print(", "+list.get(index));
            list.remove(index);
        }

        System.out.print(">");

        scan.close();
    }



}
