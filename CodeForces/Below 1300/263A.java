import java.util.*;
import java.io.*;

public class test{
    public static void main(String[] args) {
        int x=0,y=0;
        Scanner scn = new Scanner(System.in);

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int a = scn.nextInt();
                if(a!=0){
                    x=i;
                    y=j;
                    break;
                }
            }
        }

        System.out.println(Math.abs(x-2)+Math.abs(y-2));

    }
}