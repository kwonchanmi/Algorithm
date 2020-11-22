import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);

        int box_num=scan.nextInt();

        int[] box=new int[box_num];
        int[] dp=new int[box_num];

        int max_num=0;

        for(int x=0;x<box_num;x++){
            box[x]=scan.nextInt();
            dp[x]=1;

            for(int y=0;y<x;y++){
                if(box[x]>box[y] && dp[x]<dp[y]+1){
                    dp[x]=dp[y]+1;
                }
            }

            if(max_num<dp[x])
                max_num=dp[x];
        }

        System.out.println(max_num);
    }
}
