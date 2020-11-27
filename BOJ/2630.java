import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int [][] paper=new int[128][128];
    public static int[] number=new int[2];

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);


        int num=scan.nextInt();

        for(int x=0;x<num;x++){
            for(int y=0;y<num;y++)
                paper[x][y]=scan.nextInt();
        }

        paper_check(num,0,0);

        System.out.println(number[0]+"\n"+number[1]);

        scan.close();
    }


    public static void paper_check(int num,int x_index,int y_index){

        boolean flag=true;
        int base=paper[x_index][y_index];

        for(int x=x_index;x<x_index+num;x++){
            for(int y=y_index;y<y_index+num;y++){
                if(base!=paper[x][y]){
                    flag=false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            number[base]++;
        }else{
            int divide=num/2;

            paper_check(divide,x_index,y_index);
            paper_check(divide,x_index+divide,y_index);
            paper_check(divide,x_index,y_index+divide);
            paper_check(divide,x_index+divide,y_index+divide);
        }
    }

}
