import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] array=new int[9];
    public static int[] list=new int[9];
    public static boolean[] flag=new boolean[9];
    public static int num;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        num=scan.nextInt();

        for(int i=0;i<num;i++)
            array[i]=scan.nextInt();

        int sum=0;
        int max=0;

        for(int i=0;i<num;i++){
            list[0]=array[i];
            flag[i]=true;
            sum=make_list(1);
            flag[i]=false;

            if(sum>max)
                max=sum;
        }

        System.out.println(max);


        scan.close();
    }

    public static int make_list(int index){

        if(index==num){
            int sum=0;

            for(int i=0;i<num-1;i++)
                sum+=Math.abs(list[i]-list[i+1]);


            return sum;
        }

        int max=0;

        for(int i=0;i<num;i++){
            if(!flag[i]){
                list[index]=array[i];
                flag[i]=true;
                int temp=make_list(index+1);
                flag[i]=false;

                if(temp>max)
                    max=temp;
            }
        }

        return max;
    }




}
