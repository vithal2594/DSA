package twoDimenstional;

import java.util.Scanner;

public class rotateby180 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns:");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotate180(matrix);

        System.out.println("Matrix after 180 degree rotation:");
        printMatrix(matrix);

        sc.close();
    }

    public static void rotate180(int[][] matrix) {
        int rows = matrix.length;
        // int cols = matrix[0].length;

        // Step 1: Reverse every row
        for (int i = 0; i < rows; i++) {
            reverseArray(matrix[i]);
        }

        // Step 2: Reverse the order of rows
        int top = 0, bottom = rows - 1;
        while (top < bottom) {
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
            top++;
            bottom--;
        }
    }

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
