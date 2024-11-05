package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Msoe2007_8 {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/problem8.dat"));
            int row = file.nextInt();
            int col = file.nextInt();
            int[][] myList = new int[row][col];
            for (int lcv = 0; lcv < row; lcv++) {
                for (int lcv2 = 0; lcv2 < col; lcv2++) {
                    myList[lcv][lcv2] = file.nextInt();
                }
            }
            file.close();
            boolean highpoint = true;
            System.out.println("High points: ");
            for (int lcv = 1; lcv < row-1; lcv++) {
                for (int lcv2 = 1; lcv2 < col-1; lcv2++) {
                    //
                    highpoint = true;
                    for (int i = lcv-1; i <= lcv+1; i++) {
                        for (int j = lcv2-1; j <= lcv2+1; j++) {
                            if (myList[i][j] > myList[lcv][lcv2]) {
                                highpoint = false;
                            }
                        }
                    }
                    if (highpoint) {
                        System.out.println(myList[lcv][lcv2] + " ");
                    }
                    //
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
