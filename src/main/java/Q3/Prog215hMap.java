package Q3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Prog215hMap {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/Prog215h.txt"));

            for (int i = 1; i <= 3; i++) {
                var map = new HashMap<Integer, Double>();
                var tempCurrent = file.nextDouble();
                var tempMax = tempCurrent;
                int maxInd = 0;
                var tempMin = tempCurrent;
                int minInd = 0;
                map.put(0, tempCurrent);
                double average = tempCurrent;
                for (int j = 1; j < 8; j++) {
                    tempCurrent = file.nextDouble();
                    average += tempCurrent;
                    map.put(j, tempCurrent);
                    if (tempCurrent > tempMax) {
                        tempMax = tempCurrent;
                        maxInd = j;
                    }
                    if (tempCurrent < tempMin) {
                        tempMin = tempCurrent;
                        minInd = j;
                    }
                }
                average -= map.get(maxInd);
                average -= map.get(minInd);
                average /= 6;
                System.out.println("Contestant " + i);
                map.forEach((index, score) -> System.out.print(score + " "));
                System.out.println("=" + average);
                System.out.println();
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Contestant 1
8.4 9.1 8.5 8.4 9.1 8.7 8.8 9.1 =8.766666666666666

Contestant 2
7.0 7.0 7.0 7.0 7.0 7.0 7.0 7.0 =7.0

Contestant 3
8.0 7.9 8.0 8.0 8.0 8.0 8.0 8.1 =8.0
 */