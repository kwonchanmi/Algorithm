import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] movie_list=new int[5];

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        for(int i=0;i<5;i++)
            movie_list[i]=scan.nextInt();

        System.out.println(make());


        scan.close();
    }

    public static int make(){
        int MAX=950600;
        int index=4;

        for(;index<=MAX;index++){

            int count=0;

            for(int y=0;y<5;y++){
                if(index%movie_list[y]==0)
                    count++;
            }

            if(count>=3)
                break;
        }

        return index;
    }





}
