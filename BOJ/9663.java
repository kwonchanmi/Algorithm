import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static char[] sign=new char[10];
    static int k;
    static ArrayList<Integer> array=new ArrayList<Integer>();
    static boolean[] remain={false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    static int[] max_value=new int[10];
    static int[] min_value=new int[10];

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        k=scan.nextInt();

        int total=0;

       for(int i=1;i<=k;i++){
           array.add(i);
           remain[i]=true;
           total+=find(2);
           remain[i]=false;
           array.remove(0);
       }

        System.out.println(total);

        scan.close();
    }

    public static int find(int index){
        if(index>k)
            return 1;

        int sum=0;

        for(int i=1;i<=k;i++)
        {
            if(remain[i])
                continue;
            boolean result=possible(index,i);

            if(result){
                array.add(i);
                remain[i]=true;
                sum+=find(index+1);
                remain[i]=false;
                array.remove(index-1);
            }
        }


        return sum;
    }

    public static boolean possible(int index,int num){
        int x_base=index;
        int y_base=num;

        for(int i=0;i<index-1;i++)
        {
            int x=i+1;
            int y=array.get(i);


            if(Math.abs(x_base-x)==Math.abs(y_base-y))
                return false;
        }

        return true;
    }
}
