import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);

        int num=scan.nextInt();

        ArrayList<Integer> list=new ArrayList<Integer>(num);

        for(int i=1;i<=num;i++)
            list.add(i);

        make_list(list,"");

    }

    public static void make_list(ArrayList<Integer> list,String answer){
        if(list.isEmpty()){
            System.out.println(answer);
        }else{
            for(int i=0;i<list.size();i++){
                int temp=list.get(i);
                String temp_answer=answer+temp+" ";
                list.remove(i);
                make_list(list,temp_answer);
                list.add(i,temp);

            }

        }
    }






}
