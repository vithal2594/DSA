package twoDimenstional;

import java.util.Scanner;

public class SwapDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of square matrix:");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Swap diagonals
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][i];
            matrix[i][i] = matrix[i][n - 1 - i];
            matrix[i][n - 1 - i] = temp;
        }

        System.out.println("Matrix after swapping diagonals:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
