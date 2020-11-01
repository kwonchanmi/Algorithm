import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int material_num=scan.nextInt();
        int material_need=scan.nextInt();

        int[] material_list=new int[material_num];

        int sum=0;

        if(material_need>200000){
            System.out.println("0");
            scan.close();
            return;
        }

        for(int i=0;i<material_num;i++)
            material_list[i]=scan.nextInt();


        Arrays.sort(material_list);


        int start=0,end=material_num-1;

        while(start<end){

            int temp=material_list[start]+material_list[end];
            if(temp==material_need){
                sum++;
                start++;
                end--;
            }else if(temp<material_need){
                start++;
            }else{
                end--;
            }
        }

        System.out.println(sum);

        scan.close();
    }


}
