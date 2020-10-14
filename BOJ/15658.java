import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static char[] sign=new char[10];
    static int k;
    static int[] array;
    static int[] operator=new int[4];
    static int min_value=1000000000;
    static int max_value=-1000000000;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        k=scan.nextInt();

        int total=0;

        array=new int[k];

       for(int i=0;i<k;i++)
           array[i]=scan.nextInt();

       for(int i=0;i<4;i++)
           operator[i]=scan.nextInt();

       find(1,array[0]);

        System.out.println(max_value);
        System.out.println(min_value);

        scan.close();
    }

    public static void find(int index,int sum){
        if(index==k){
            min_value=Math.min(sum,min_value);
            max_value=Math.max(sum,max_value);
            return ;
        }


        int base=array[index];


        for(int i=0;i<4;i++)
        {
            if(operator[i]<=0)
                continue;

            int temp_sum=sum;

            if(i==0)
                temp_sum+=base;
            else if(i==1)
                temp_sum-=base;
            else if(i==2)
                temp_sum*=base;
            else
                temp_sum/=base;

            operator[i]--;
            find(index+1,temp_sum);
            operator[i]++;

        }

        return;
    }

}
