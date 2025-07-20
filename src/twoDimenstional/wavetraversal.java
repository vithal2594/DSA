package Prac.twoDimenstional;

import java.util.Scanner;

public class wavetraversal {
   public static void main(String[] args) {
      Scanner sc=  new Scanner(System.in);
      System.out.println("Enter the number of rows");
      int rows=sc.nextInt();
      System.out.println("Enter the number of columns");
      int col=sc.nextInt();
      
      int arr[][] = new int[rows][col];
      System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    
      System.out.println("Original Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    System.out.println("Wave Traversal Output:");
      for(int j=0; j<col; j++){
        if(j %2 ==0){
            for(int i=0; i<rows; i++){
            System.out.print(arr[i][j] + " ");
            }
        }else{
            for(int i=rows-1; i>=0; i--){
                System.out.print(arr[i][j] + " ");
                }
        }
      }
      System.out.println();
      System.out.println("Wave Traversal Output from top only:");
      for(int j=0; j<col; j++){
        if(j %2 ==0){
            for(int i=0; i<rows; i++){
            System.out.print(arr[i][j] + " ");
            }
        }else{
            for(int i=0; i<rows; i++){
                System.out.print(arr[i][j] + " ");
                }
        }
      }
      sc.close();
   } 
}
