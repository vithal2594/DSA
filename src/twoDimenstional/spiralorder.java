package twoDimenstional;

import java.util.Scanner;

public class spiralorder {
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
        System.out.println("Spiral Traversal:");
        spiralorder1(arr,rows,col);
        sc.close();
       
    }

    public static void spiralorder1(int arr[][],int rows,int cols){
       int top=0;
       int bottom=rows-1;
       int left=0;
       int right=cols-1;

       while(top<=bottom && left <= right){
          for(int i=left; i<=right; i++){
            System.out.print(arr[top][i]+ " ");
          }
          top++;

          for(int i=top; i<=bottom; i++){
            System.out.print(arr[i][right]+ " ");
          }
          right--;

          if(top<=bottom){
            for(int i=right; i>=left; i--){
                System.out.print(arr[bottom][i]+ " ");
            }
            bottom--;
          }
          if(left<=right){
            for(int i=bottom; i>=top; i--){
                System.out.print(arr[i][left]+ " ");
            }
            left++;
          }
          
       }  
    }
}
