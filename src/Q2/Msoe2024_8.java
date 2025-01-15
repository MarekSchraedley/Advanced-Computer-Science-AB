package Q2;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Msoe2024_8 {
    public static int embeddingLength(String target, String word) {
        int largestEmbed = 0;
        for (int lcv = 0; lcv < target.length(); lcv++) { //focus letter of target
            int tempCount = 0;
            int currTargIndex = lcv;
            int startLetterIndex = 0;
            for (int i = lcv; i < target.length(); i++) {
                for (int lcv2 = startLetterIndex; lcv2 < word.length(); lcv2++) { //search for letter
                    if (word.substring(lcv2, lcv2+1).equals(target.substring(currTargIndex, currTargIndex+1))) {
                        startLetterIndex = lcv2;
                        tempCount++;
                        currTargIndex++;
                        break;
                    }
                }
            }
            if (tempCount > largestEmbed) {
                largestEmbed = tempCount;
                if (tempCount == 4) {
                    //System.out.println(lcv);
                    //System.out.println();
                }
            }

        }
        return largestEmbed;
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/MSOE2024_8.dat"));
            ArrayList<String> wordList = new ArrayList<>();
            String word = file.next();
            while (file.hasNext()) {
                wordList.add(file.next());
            }
            for (int lcv = 0; lcv < wordList.size(); lcv++) {
                if (wordList.get(lcv).length() <= 1) {
                    wordList.remove(lcv);
                    lcv--;
                }
            }
            ArrayList<Integer> sizes = new ArrayList<>();
            for (int lcv = 0; lcv < wordList.size(); lcv++) {
                sizes.add(embeddingLength(word, wordList.get(lcv)));
            }
            int longestEmbed = 0;
            for (int lcv = 0; lcv < sizes.size(); lcv++) {
                if (sizes.get(lcv) != word.length() && sizes.get(lcv) > longestEmbed) {
                    longestEmbed = sizes.get(lcv);
                }
            }
            ArrayList<String> output = new ArrayList<>();
            for (int lcv = 0; lcv < sizes.size(); lcv++) {
                if (sizes.get(lcv) == longestEmbed) {
                    output.add(wordList.get(lcv));
                }
            }
            Boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int lcv = 0; lcv < output.size()-1; lcv++) {
                    if (output.get(lcv).compareTo(output.get(lcv+1)) > 0) {
                        String temp = output.get(lcv);
                        output.set(lcv, output.get(lcv+1));
                        output.set(lcv+1, temp);
                        sorted = false;
                    }
                }
            }

            for (int lcv = 0; lcv < output.size(); lcv++) {
                System.out.println(output.get(lcv));
            }

            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
bandersnatch
branch
great
hand
 */