package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Msoe2009_9 {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/separation1.txt"));
            int tempLength = file.nextInt();
            int[][] array = new int[tempLength][tempLength];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = 9999;
                }
            }
            while (file.hasNext()) {
                int a = file.nextInt();
                int b = file.nextInt();
                array[Math.min(a, b)][Math.max(a, b)] = 1;
            }
            Boolean foundShorter = true;
            while (foundShorter) {
                foundShorter = false;
                for (int a = 0; a < array.length; a++) {
                    for (int b = a; b < array[0].length; b++) {
                        if (a == b) {
                            array[a][b] = 0;
                        } else {
                            for (int c = 0; c < array.length; c++) {
                                int aToc = array[Math.min(a, c)][Math.max(a, c)];
                                int bToc = array[Math.min(b, c)][Math.max(b, c)];
                                if (aToc + bToc < array[a][b]) {
                                    array[a][b] = aToc + bToc;
                                    foundShorter = true;
                                }
                            }
                        }
                    }
                }
            }
            file.close();
            file = new Scanner(System.in);
            System.out.println("Input two friend digits: ");
            int a = file.nextInt();
            int b = file.nextInt();
            System.out.println("Their connection is: " + array[Math.min(a, b)][Math.max(a, b)]);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Input two friend digits:
2
4
Their connection is: 3
 */