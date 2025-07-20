import java.util.Scanner;

public class allow2d {
    public static void main(String[] args) {
        System.out.println("Enter the size of arrays column");
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();

        System.out.println("Enter the size of arrays row");
        int row = sc.nextInt();
        int twoDarray[][] = new int[row][column];

        for(int i=0; i<row; i++){
            for(int j=0; j<column;j++){
                System.out.println("Enter element of row + "+i + "and column" + j);
                 twoDarray[i][j]=sc.nextInt();
            }
        }

        System.out.println("2D array:");
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print(twoDarray[i][j]+ " ");
            }
        }

        System.out.println("Enter the rows positions");
        int r=sc.nextInt();
    
        System.out.println("Enter the rows positions");
        int c=sc.nextInt();

        if(r>=0 && r<row && c>=0 && c<column){
            System.out.println(twoDarray[r][c]);
        }else{
            System.out.println("Invalid position");
        }

           sc.close();
    }
}
