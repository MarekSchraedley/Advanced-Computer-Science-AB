package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Msoe2009_8 {
    public static String[][] adjacentFill(int x, int y, String[][] array, String replaceWith) {
        array[x][y] = replaceWith;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (array[x+i][y+j].equals("*")) {
                    array = adjacentFill(x+i, y+j, array, replaceWith);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/image1.txt"));
            int count = file.nextInt();
            int length = file.nextInt();
            String line = "";
            String[][] array = new String[count][length];
            file.nextLine();
            for (int i = 0; i < count; i++) {
                line = file.nextLine();
                for (int j = 0; j < length; j++) {
                    array[i][j] = line.substring(j, j+1);
                }
            }
            String[] chars = {"A", "B", "C", "D"};
            int charsCount = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (array[i][j].equals("*")) {
                        array = adjacentFill(i, j, array, chars[charsCount]);
                        charsCount++;
                    }
                }
            }

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }

            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*

  AA   AA  BBBB
   AA AA  B
   A A A   BBB
   A   A      B
  AA   AA BBBB

    CCC   DDDDD
   C   C  D
   C   C  DDD
   C   C  D
    CCC   DDDDD

 */