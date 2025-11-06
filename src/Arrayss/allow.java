package Arrayss;

import java.util.Scanner;

public class allow {
    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        
        int array[] = new int[5];
        for(int i=0; i<n;i++){
            array[i]=sc.nextInt();
        }

        for(int i=0; i<n;i++){
            System.out.println(array[i]);
        }
        System.out.println("Array at position");
        int pos = sc.nextInt();

        if(pos>=0 && pos< n){
            System.out.println(array[pos]);
        }else{
            System.out.println("Invalid position");
        }
        sc.close();
    }
}
