package Q3;

import DataStructures.Set;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog595r {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/dale-chall-word-list.txt"));
            var easyWordList = new Set<String>();
            while (file.hasNext()) {
                easyWordList.insert(file.next());
            }
            var scanner = new Scanner(System.in);
            System.out.println("Input a sentence: ");
            String scentence = scanner.nextLine();
            double scentenceCount = scentence.split("[.?!]").length;
            var wordsList = scentence.split("\\s+");
            double wordCount = wordsList.length;
            for (int i = 0; i < wordsList.length; i++) {
                wordsList[i] = wordsList[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
            }
            double difficultWords = 0.0;
            for (int i = 0; i < wordsList.length; i++) {
                if (!easyWordList.contains(wordsList[i])) {
                    difficultWords++;
                }
            }
            double rawScore = 0.1579*(difficultWords/wordCount * 100) + 0.0496*(wordCount/scentenceCount);
            if (difficultWords/wordCount > 0.05) {
                rawScore += 3.6365;
            }
            System.out.println("Readability Score: " + rawScore);
            System.out.print("Grade Level: ");
            if (rawScore >= 0 && rawScore < 5) {
                System.out.println("K-4");
            } else if (rawScore >= 5 && rawScore < 6) {
                System.out.println("5-6");
            } else if (rawScore >= 6 && rawScore < 7) {
                System.out.println("7-8");
            } else if (rawScore >= 7 && rawScore < 8) {
                System.out.println("9-10");
            } else if (rawScore >= 8 && rawScore < 9) {
                System.out.println("11-12");
            } else if (rawScore >= 9 && rawScore < 10) {
                System.out.println("13-15 (College)");
            } else if (rawScore >= 10) {
                System.out.println("16 and above (College Graduate)");
            }

            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Input a sentence:
The quick brown fox jumps over the lazy dog. Many installations require thorough understanding.
Readability Score: 9.622985714285715
Grade Level: 13-15 (College)
 */