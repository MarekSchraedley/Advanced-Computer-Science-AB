package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog408aMatrix {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prg408a.dat"));
            var matrix = new int[21][2];
            for (int i = 0; i < 21; i++) {
                matrix[i][0] = file.nextInt();
                matrix[i][1] = file.nextInt();
            }
            file.close();

            System.out.println("ID\tScore");
            for (int[] row : matrix)
                System.out.println(row[0] + "\t" + row[1]);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void bubbleSortMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length-i-1; j++) {
                if (mat[j][i] < mat[j+1][1]) {
                    int[] temp = mat[j];
                    mat[j] = mat[j+1];
                    mat[j+1] = temp;
                }
            }
        }
    }
}
