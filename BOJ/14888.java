import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static int [] temp_answer={1000000000,-1000000000};

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int num;

        num=scan.nextInt();

        ArrayList<Integer> num_list=new ArrayList<Integer>();
        int [] operator=new int[4];

        for(int i=0;i<num;i++)
            num_list.add(scan.nextInt());

        for(int i=0;i<4;i++)
            operator[i]=scan.nextInt();

        int sum=num_list.get(0);

        num_list.remove(0);

        sum_calculator(num_list,operator,sum);

        System.out.println(temp_answer[1]+"\n"+temp_answer[0]);

        scan.close();
    }

    public static void sum_calculator(ArrayList<Integer> num_list, int[] operator,int sum){

        if(num_list.size()==0){

            temp_answer[0]=Math.min(sum,temp_answer[0]);
            temp_answer[1]=Math.max(sum,temp_answer[1]);
            return;
        }

        int value=num_list.get(0);

        num_list.remove(0);


        for(int i=0;i<4;i++)
        {
            if(operator[i]!=0)
            {
                int temp_sum=sum;
                operator[i]--;

                if(i==0)
                    temp_sum+=value;
                else if(i==1)
                    temp_sum-=value;
                else if(i==2)
                    temp_sum*=value;
                else temp_sum/=value;



                sum_calculator(num_list,operator,temp_sum);

                operator[i]++;

            }
        }

        num_list.add(0,value);
        return;
    }
}
