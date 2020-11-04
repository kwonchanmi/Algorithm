import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String[] friend_list=new String[51];
    public static int friend_num;
    public static int[][] floyd=new int[51][51];

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        friend_num=scan.nextInt();

        for(int x=0;x<friend_num;x++){
            friend_list[x]=scan.next();
        }

        System.out.println(floyd_base_list());


        scan.close();
    }

    public static int floyd_base_list(){

        for(int x=0;x<friend_num;x++){
            for(int y=0;y<friend_num;y++){

                // 자기 자신과의 거리는 9999로 설정한다.
                if(x==y){
                    floyd[x][y]=9999;
                    continue;
                }

                char temp=friend_list[x].charAt(y);

                // 둘이 친구일 경우 거리는 1, 아닐 경우 9999로 설정한다.
                if(temp=='Y')
                    floyd[x][y]=1;
                else
                    floyd[x][y]=9999;
            }
        }

        floyd_make();

        int max=floyd_num();

        return max;
    }

    public static void floyd_make(){

        // x: 기준 정점
        // y: 시작
        // z: 도착
        // y->z로 가는 경로보다 x->y->z로 가는 경로가 짧으면 값을 수정한다.
        for(int x=0;x<friend_num;x++){
            for(int y=0;y<friend_num;y++){
                for(int z=0;z<friend_num;z++){
                    if(x==y || z==x || z==y)
                        continue;

                    if(floyd[y][z]>floyd[y][x]+floyd[x][z])
                        floyd[y][z]=floyd[y][x]+floyd[x][z];
                }
            }
        }
    }

    public static int floyd_num(){
        int max=0;

        for(int x=0;x<friend_num;x++)
        {

            int sum=0;

            // 2-친구의 수를 구한다.
            for(int y=0;y<friend_num;y++){
                if(floyd[x][y]<=2)
                    sum++;
            }

            if(max<sum)
                max=sum;
        }

        return max;
    }





}
