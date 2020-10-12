import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static char[] sign=new char[10];
    static int k;
    static boolean[] remain={false,false,false,false,false,false,false,false,false,false};
    static int[] max_value=new int[10];
    static int[] min_value=new int[10];

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        k=scan.nextInt();


        for(int i=0;i<k;i++)
            sign[i]=scan.next().charAt(0);


        max_find(0,k);
        min_find(0,k);

        for(int i=0;i<=k;i++)
            System.out.print(max_value[i]);

        System.out.println();

        for(int i=0;i<=k;i++)
            System.out.print(min_value[i]);

        scan.close();
    }

    // 순서대로 가장 큰 수부터 재귀하여 끝나게 되면 true 반환.
    public static boolean max_find(int index,int k){

        boolean result=false;

        if(index>k)
            return true;

        if(index==0){
            for(int i=9;i>=0;i--){

                if(result)
                    break;
                remain[i]=true;
                max_value[0]=i;
                result=max_find(index+1,k);
                remain[i]=false;
            }
        }else{

            int last_index=max_value[index-1];
            if(sign[index-1]=='<') {
                // last_index보다 큰 수가 없으면 false

                for(int i=9;i>last_index;i--){
                    if(result)
                        break;

                    if(!remain[i]){
                        remain[i]=true;
                        max_value[index]=i;
                        result=max_find(index+1,k);
                        remain[i]=false;
                    }
                }

            }else{

                //last_index 보다 작은 수가 없으면 false

                for(int i=last_index-1;i>=0;i--){
                    if(result)
                        break;

                    if(!remain[i]){
                        remain[i]=true;
                        max_value[index]=i;
                        result=max_find(index+1,k);
                        remain[i]=false;
                    }
                }


            }

        }
        return result;
    }

    // 순서대로 가장 작은 수부터 재귀하여 끝나게 되면 true 반환.
    public static boolean min_find(int index,int k){

        boolean result=false;

        if(index>k)
            return true;

        if(index==0){
            for(int i=0;i<=9;i++){

                if(result)
                    break;
                remain[i]=true;
                min_value[0]=i;
                result=min_find(index+1,k);
                remain[i]=false;
            }
        }else{

            int last_index=min_value[index-1];
            if(sign[index-1]=='<') {
                // last_index보다 큰 수가 없으면 false

                for(int i=last_index+1;i<=9;i++){
                    if(result)
                        break;

                    if(!remain[i]){
                        remain[i]=true;
                        min_value[index]=i;
                        result=min_find(index+1,k);


                        remain[i]=false;
                    }
                }

            }else{

                //last_index 보다 작은 수가 없으면 false

                for(int i=0;i<last_index;i++){
                    if(result)
                        break;

                    if(!remain[i]){
                        remain[i]=true;
                        min_value[index]=i;
                        result=min_find(index+1,k);

                        remain[i]=false;
                    }
                }


            }

        }
        return result;
    }

}
