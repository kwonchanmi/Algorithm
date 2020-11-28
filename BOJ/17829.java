import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int [][] paper=new int[1025][1025];
    public static int[][] plus={{1,0},{1,1}};

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);


        int num=scan.nextInt();

        for(int x=0;x<num;x++){
            for(int y=0;y<num;y++)
                paper[x][y]=scan.nextInt();
        }

        make(num);

        System.out.println(paper[0][0]);

        scan.close();
    }

    public static void make(int num){
        if(num==1)
            return;


        for(int x=0;x<num;x+=2){
            for(int y=0;y<num;y+=2){

                int[] temp={paper[x][y],paper[x][y+1],paper[x+1][y],paper[x+1][y+1]};

                Arrays.sort(temp);

                paper[x/2][y/2]=temp[2];

            }
        }

        make(num/2);

    }










}
