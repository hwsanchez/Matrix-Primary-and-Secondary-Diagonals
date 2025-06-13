import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Problem Statement:
        // Given a square matrix 'mat', return the sum of the matrix diagonals.
        // Only include the sum of all the elements on the primary diagonal and
        // all the elements on the secondary diagonal that are not part of the primary diagonal.

        // Read the size of the matrix:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the matrix: ");
        int n = scanner.nextInt();

        //declare and intialize the matrix:
        int[][] mat = new int[n][n];
        int e = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = e++;
            }
        }

        System.out.println("The matrix: ");
        int[] primaryDiagonal;
        primaryDiagonal = new int[n];
        int primaryIndex = 0;
        int[] secondaryDiagonal;
        secondaryDiagonal = (n % 2 == 1) ? new int[n - 1] : new int[n];
        int secondaryIndex = 0;


        //displaying the matrix and colecting the diagonals:
        for (int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                //Printing the number:
                int num = mat[row][col];
                int digits = num/10;
                if(digits < 1) {
                    System.out.print(num + "   ");
                } else if(digits < 10) {
                    System.out.print(num + "  ");
                } else {
                    System.out.print(num + " ");
                }
                //Primary and secondary Diagonal:
                if(col == row) {
                    primaryDiagonal[primaryIndex] = num;
                    primaryIndex++;
                } else if((row + col) == (n - 1)) {
                    if(n % 2 == 1 && row == col) {
                        continue;
                    }
                    secondaryDiagonal[secondaryIndex] = num;
                    secondaryIndex++;
                }

            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Primary Diagonal: " + Arrays.toString(primaryDiagonal));
        System.out.println("Secondary Diagonal: " + Arrays.toString(secondaryDiagonal));
        scanner.close();
    }
}
