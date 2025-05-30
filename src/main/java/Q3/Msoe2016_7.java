package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Msoe2016_7 {
    public static class Clues {
        private int myDirection;
        private int myRowCol;
        private int myBuildings;
        public Clues(int direction, int rowCol, int buildings) {
            myDirection = direction;
            myRowCol = rowCol;
            myBuildings = buildings;
        }

        public int getMyDirection() {return myDirection;}
        public int getMyRowCol() {return myRowCol;}
        public int getMyBuildings() {return myBuildings;}
    }

    public static int findErrors(int[][] puzzle, ArrayList<Clues> clues) {
        //same num
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                for (int k = j+1; k < puzzle.length; k++) {
                    if (puzzle[i][j] == puzzle[i][k]) {
                        return 1;
                    }
                    if (puzzle[j][i] == puzzle[k][i]) {
                        return 1;
                    }
                }
            }
        }
        //cannot be filled
        int[] numlist = new int[puzzle.length];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                numlist = new int[puzzle.length+1];
                if (puzzle[i][j] == 0) {
                    for (int k = 0; k < puzzle.length; k++) {
                        if (k != j) {
                            numlist[puzzle[i][k]]++;

                        }
                        if (k != i) {
                            numlist[puzzle[k][j]]++;
                        }
                    }
                    for (int k = 1; k < numlist.length; k++) {
                        if (numlist[k] == 0) {
                            return 2;
                        }
                    }
                }
            }
        }
        //completely filled
        for (int i = 0; i < clues.size(); i++) {
            var current = clues.get(i);
            var rowCol = current.getMyRowCol();
            int incCount = 0;
            int largest = 0;
            if (current.getMyDirection() == 0) {
                for (int j = 0; j < puzzle.length; j++) {
                    if (puzzle[j][rowCol] > largest) {
                        incCount++;
                        largest = puzzle[j][rowCol];
                    }
                }
            } else if (current.getMyDirection() == 1) {
                for (int j = 0; j < puzzle.length; j++) {
                    if (puzzle[rowCol][j] > largest) {
                        incCount++;
                        largest = puzzle[rowCol][j];
                    }
                }
            } else if (current.getMyDirection() == 2) {
                for (int j = puzzle.length-1; j >= 0; j--) {
                    if (puzzle[j][rowCol] > largest) {
                        incCount++;
                        largest = puzzle[j][rowCol];
                    }
                }
            } else if (current.getMyDirection() == 3) {
                for (int j = puzzle.length-1; j >= 0; j--) {
                    if (puzzle[rowCol][j] > largest) {
                        incCount++;
                        largest = puzzle[rowCol][j];
                    }
                }
            }
            if (incCount != current.getMyBuildings()) {
                return 3;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/MSOE2016_7.txt"));
            int puzzleSize = file.nextInt();
            int Clues = file.nextInt();
            var list = new ArrayList<Clues>();
            for (int i = 0; i < Clues; i++) {
                list.add(new Clues(file.nextInt(), file.nextInt(), file.nextInt()));
            }
            var puzzleArray = new int[puzzleSize][puzzleSize];
            for (int i = 0; i < puzzleSize; i++) {
                for (int j = 0; j < puzzleSize; j++) {
                    puzzleArray[i][j] = file.nextInt();
                }
            }
            file.close();
            int result = findErrors(puzzleArray, list);
            if (result == 0) {
                System.out.println("No errors");
            }
            if (result == 1) {
                System.out.println("Number appears more than once in a row or column");
            }
            if (result == 2) {
                System.out.println("Empty area cannot be filled");
            }
            if (result == 3) {
                System.out.println("Completely filled row or column that does mot present the amount of faces");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
