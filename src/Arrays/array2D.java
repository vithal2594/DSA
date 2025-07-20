import java.util.Scanner;

public class array2D {

    public static void printarray(int arr[][]){
         for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
               System.out.print(arr[i][j] + " ");
            }
            System.out.println();
         }
    }
    public static void takeinput(int arr[][]){
        int r=arr.length;
        int c=arr[0].length;
       System.out.println("Ente the size of elements "+ r*c +"elements"); 
       Scanner sc = new Scanner(System.in);
       for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            arr[i][j] = sc.nextInt();
        }
       }
    }

    public static void add2matrix(int arrA[][], int r1, int c1, int arrB[][], int r2, int c2 ){
        int sum[][]= new int[r1][c1];
        if(r1 != r2 || c1 != c2){
            System.out.println("Wrong input");
            return ;
        }
        for(int i=0; i<r1; i++){
            for(int j=0; j<c1; j++){
              sum[i][j] = arrA[i][j] + arrB[i][j];
            }
        }
        printarray(sum);
    }

    public static void multiple(int arrA[][], int r1, int c1, int arrB[][], int r2, int c2 ){
        int multi[][]= new int[r1][c2]; 
        if(c1 != r2){
            System.out.println("Wrong input");
            return ;
         }
        for(int i=0; i<r1; i++){
            for(int j=0; j<c2; j++){
                for(int k=0; k<c1; k++){
                  multi[i][j] += arrA[i][k] * arrB[k][j];
                }
            }
        }
        printarray(multi);
    }

   public static int[][] transpose(int arr[][], int r,int c){
      int ans[][] = new int[c][r];
      for(int i=0; i<c; i++){
        for(int j=0; j<r; j++){
            ans[i][j] = arr[j][i];
        }
      }
      return ans;
   } 

   public static void rotate90degree(int arr[][], int r1, int c1){
   
       int transposed[][] = transpose(arr, r1, c1);
       for(int i=0; i<transposed.length; i++){
          int left=0;
          int right =transposed[i].length-1;
          while(left < right){
            int temp = transposed[i][left];
            transposed[i][left] = transposed[i][right];
            transposed[i][right]=temp;
            left++;
            right--;
          }
       }
       System.out.println("Matrix afer 90 degree is: ");
       printarray(transposed);

   }

   public static void rotate180degree(int arr[][]) {
    int r = arr.length;
    int c = arr[0].length;
    
    // Reverse every row individually (left-right)
    for (int i = 0; i < r; i++) {
        int left = 0, right = c - 1;
        while (left < right) {
            int temp = arr[i][left];
            arr[i][left] = arr[i][right];
            arr[i][right] = temp;
            left++;
            right--;
        }
    }
    
    // Reverse the whole matrix (top-bottom)
    int top = 0, bottom = r - 1;
    while (top < bottom) {
        int[] temp = arr[top];
        arr[top] = arr[bottom];
        arr[bottom] = temp;
        top++;
        bottom--;
    }
    
    System.out.println("Matrix after 180 degree rotation:");
    printarray(arr);
}

public static void pascles(int n ){
    for(int line =0; line<n; line++){
        int num=1;
        for(int space =0; space<n-line-1; space++){
            System.out.print(" ");
        }
        for(int i=0; i<=line; i++){
            System.out.print(num+ " ");
            num=num*(line-i)/(i+1);
        }
        System.out.println();
    }
}

public static void spiralorder(int arr[][], int r, int c){
    int top=0;
    int bottom=r-1;
    int left=0;
    int right=c-1;

    while(top<= bottom && left<=right){
        for(int i=left; i<=right; i++){
            System.out.print(arr[top][i]+" ");
        }
        top++;
        for(int i=top; i<=bottom; i++){
            System.out.print(arr[i][right]+" ");
        }
        right--;
        if(top<=bottom){
            for(int i=right; i>=left; i--){
                System.out.print(arr[bottom][i]+" ");
            }
            bottom--;
        }
        if(left<=right){
            for(int i=bottom; i>=top;i--){
                System.out.print(arr[i][left]+ " ");
            }
            left++;
        }
    }
    System.out.println();
    // printarray(arr);
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int r1= sc.nextInt();
        System.out.println("enter the number of columns: ");
        int c1 = sc.nextInt();
        int arr[][]= new int[r1][c1];
        takeinput(arr);
        spiralorder(arr,r1,c1);
        // pascles(r1);
        // System.out.println("enter the number of columns: ");
        // int c1 = sc.nextInt();
        // int arr[][]= new int[r1][c1];
        // takeinput(arr);
        // System.out.println("Matrix 1 :" );
        // printarray(arr);
        // rotate180degree(arr);

        // rotate90degree(arr,r1,c1);  
        // arr=transpose(arr,r1,c1);
        // System.out.println("Transpose of matrix 1 :" );
        // printarray(arr);
        // System.out.println("Enter the number of rows: ");
        // int r2= sc.nextInt();
        // System.out.println("enter the number of columns: ");
        // int c2 = sc.nextInt();
        // int arr2[][]= new int[r2][c2];
        // takeinput(arr2);
        // System.out.print("Matrix 1 :" );
        // printarray(arr);
        // System.out.print("Matrix 2 :" );
        // printarray(arr2);
        // System.out.println("multiplication of Matrix 1 and matrix 2 is :" );
        // multiple(arr, r1, c1, arr2, r2, c2);

        // System.out.println("Sum of Matrix 1 and matrix 2 is :" );

        // add2matrix(arr, r1, c1, arr2, r2, c2);
     
        // int arr[][]= new int[2][3];
        // int arr2[][] ={
        //                 {1,5,6},
        //                 {7,9,11},
        //                 {8,1,1},
        //             };
        // takeinput(arr);
        // printarray(arr);
        sc.close();
    }
}
