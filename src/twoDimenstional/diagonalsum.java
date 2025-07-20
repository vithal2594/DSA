package Prac.twoDimenstional;

import java.util.Scanner;

public class diagonalsum {
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

        int sumLeft = 0, sumRight = 0;

        for (int i = 0; i < n; i++) {
            sumLeft += matrix[i][i]; // main diagonal
            sumRight += matrix[i][n - 1 - i]; // anti-diagonal
        }

        System.out.println("Left/Main Diagonal Sum = " + sumLeft);
        System.out.println("Right/Anti Diagonal Sum = " + sumRight);
        sc.close();
    }
}
