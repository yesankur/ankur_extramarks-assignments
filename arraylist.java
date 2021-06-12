import java.io.*;
import java.util.*;

public class arraylist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int d,q,x,y;
    ArrayList[] t = new ArrayList[num];
    for(int i=0;i<num;i++){
        d = sc.nextInt();
        t[i] = new ArrayList();
        for(int j=0;j<d;j++){  
            t[i].add(sc.nextInt());                
        }
    }
    q=sc.nextInt();
    for(int i=0;i<q;i++){
        x=sc.nextInt();
        y=sc.nextInt();
        try{
            System.out.println(t[x-1].get(y-1));
        } catch(Exception e){
            System.out.println("ERROR!");
        }
    }
    }
}