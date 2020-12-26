import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static char[][] box;

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num=scan.nextInt();

        box=new char[num][num];

        for(int x=0;x<num;x++){
            for(int y=0;y<num;y++)
                box[x][y]=' ';
        }

        box_make(num,0,0);

        for (int i = 0; i < num; i++) {
            bw.write(box[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();

        scan.close();
    }

    public static void box_make(int num,int x_index,int y_index){

        // num==3이면 base case
        if(num==3){
            for(int x=x_index;x<x_index+3;x++){
                for(int y=y_index;y<y_index+3;y++){
                    if(x!=x_index+1 || y!=y_index+1)
                        box[x][y]='*';
                }
            }

        }
        else{

            int blank=num/3;

            for(int x=x_index;x<x_index+num;x+=blank){
                for(int y=y_index;y<y_index+num;y+=blank){
                    //공백
                    if(x!=x_index+blank || y!=y_index+blank)
                        box_make(blank,x,y);
                }
            }


        }
    }

}
