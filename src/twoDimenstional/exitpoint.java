package twoDimenstional;

public class exitpoint {
    public static void findExitPoint(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0, j = 0;
        int dir = 0; // 0: right, 1: down, 2: left, 3: up

        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (matrix[i][j] == 1) {
                matrix[i][j] = 0;  // Flip 1 to 0
                dir = (dir + 1) % 4;
            }

            // Move in current direction
            if (dir == 0) j++;        // right
            else if (dir == 1) i++;   // down
            else if (dir == 2) j--;   // left
            else if (dir == 3) i--;   // up
        }

        // Roll back one step
        if (dir == 0) j--;
        else if (dir == 1) i--;
        else if (dir == 2) j++;
        else if (dir == 3) i++;

        System.out.println("Exit Point: (" + i + ", " + j + ")");
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1},
                {1, 0, 0},
                {1, 1, 0}
        };

        findExitPoint(matrix);  // Output: (2, 2)
    }
}
