package twoDimenstional;

import java.util.Scanner;

public class rotateby90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns");
        int col = sc.nextInt();

        int arr[][] = new int[rows][col];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original Matrix:");
        printMatrix(arr);

        System.out.println("After Transpose:");
        int[][] transposed = transpose(arr, rows, col);
        printMatrix(transposed);

        System.out.println("After 90 Degree Rotation:");
        int[][] rotated = rotate90degree1(transposed);
        printMatrix(rotated);

        sc.close();
    }

    public static int[][] transpose(int[][] arr, int r, int c) {
        int[][] ans = new int[c][r]; 
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[j][i] = arr[i][j];
            }
        }
        return ans;
    }

    public static int[][] rotate90degree1(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = 0;
            int right = arr[i].length - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
        return arr;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
