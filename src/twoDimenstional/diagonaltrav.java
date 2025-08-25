package twoDimenstional;

public class diagonaltrav {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Diagonal Traversal:");
        printDiagonals(matrix);
    }
    public static void printDiagonals(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int d = 0; d <= rows + cols - 2; d++) {
            for (int i = 0; i <= d; i++) {
                int row = i;
                int col = d - i;

                if (row < rows && col < cols) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println(); // Move to next diagonal
        }
    }
}
