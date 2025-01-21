package Q2;

import DataStructures.BinarySearchTree;
import DataStructures.Deque;
import DataStructures.DoublyLinkedList;
import DataStructures.Queue;
import DataStructures.Stack;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog1999s {
    public static class Recipe {
        String myName;
        ArrayList<ingredientItem> myIngredients;
        public Recipe(String name, ArrayList<ingredientItem> ingredients) {
            myName = name;
            myIngredients = ingredients;
        }

        public String getMyName() {return myName;}
        public ArrayList<ingredientItem> getIngredientList() {return myIngredients;}
        public ingredientItem getMyIngredients(int x) {return  myIngredients.get(x);}

    }

    public static class ingredientItem {
        String myName;
        int myQuantity;
        public ingredientItem(String name, int quantity) {
            myName = name;
            myQuantity = quantity;
        }
        public String getMyName() {return myName;}
        public int getMyQuantity() {return myQuantity;}
        public void changeMyQuantity(int x) {myQuantity = x;}
    }

    public static class Order {
        String myName;
        int myQuantity;
        public Order(String name, int quantity) {
            myName = name;
            myQuantity = quantity;
        }
        public String getMyName() {return myName;}
        public int getMyQuantity() {return myQuantity;}
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog1999s.dat"));
            int fileCount = 0;
            fileCount = file.nextInt();
            BinarySearchTree<String> BST = new BinarySearchTree<>(); // BST
            ArrayList<Recipe> myRecipes = new ArrayList<>();
            for (int i = 0; i < fileCount; i++) {
                String tempName = file.next();
                ArrayList<ingredientItem> tempIngredients = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    String tempString = file.next();
                    int colonIndex = tempString.indexOf(":");
                    tempIngredients.add( new ingredientItem( tempString.substring(0, colonIndex), Integer.parseInt(tempString.substring(colonIndex+1))));
                }
                myRecipes.add(new Recipe(tempName, tempIngredients));
            }
            for (int lcv = 0; lcv < myRecipes.size(); lcv++) {
                BST.insert(myRecipes.get(lcv).getMyName());
            }

            ArrayList<ingredientItem> inventory = new ArrayList<>(); //array
            fileCount = file.nextInt();
            for (int i = 0; i < fileCount; i++) {
                inventory.add(new ingredientItem(file.next(), file.nextInt()));
            }

            DoublyLinkedList<String> buffer = new DoublyLinkedList<>(); //DLL
            fileCount = file.nextInt();
            for (int i = 0; i < fileCount; i++) {
                for (int lcv = 0; lcv < 3; lcv++) {
                    buffer.add(file.next());
                }
            }
            for (int lcv = 0; lcv < buffer.size(); lcv++) {
                int colonIndex = buffer.get(lcv).indexOf(":");
                String name = buffer.get(lcv).substring(0, colonIndex);
                int quantity = Integer.parseInt(buffer.get(lcv).substring(colonIndex+1));
                Boolean found = false;
                for (int lcv2 = 0; lcv2 < inventory.size(); lcv2++) {
                    if (inventory.get(lcv2).getMyName().equals(name)) {
                        found = true;
                        inventory.get(lcv2).changeMyQuantity(inventory.get(lcv2).getMyQuantity() + quantity);
                        break;
                    }
                }
                if (found == false) {
                    inventory.add(new ingredientItem(name, quantity));
                }

            }
            fileCount = file.nextInt();
            DataStructures.Queue<String> orders = new Queue<>();
            for (int lcv = 0; lcv < fileCount; lcv++) {
                String tempName = file.next();
                int iterations = file.nextInt();
                for (int i = 0; i < iterations; i++) {
                    orders.enqueue(tempName);
                }
            }

            while (orders.size() != 0) {
                for (int lcv = 0; lcv < myRecipes.size(); lcv++) {
                    if (orders.peek().equals(myRecipes.get(lcv).getMyName())) {
                        for (int lcv2 = 0; lcv2 < myRecipes.get(lcv).getIngredientList().size(); lcv2++) { //all ingredients
                            for (int lcv3 = 0; lcv3 < inventory.size(); lcv3++) { //going through inventory
                                if (myRecipes.get(lcv).getMyIngredients(lcv2).getMyName().equals(inventory.get(lcv3).getMyName())) { // if name of ingredient is name of inventory item
                                    inventory.get(lcv3).changeMyQuantity(inventory.get(lcv3).getMyQuantity() - myRecipes.get(lcv).getMyIngredients(lcv2).getMyQuantity());
                                }
                            }
                        }
                        break;
                    }
                }
                orders.dequeue();
            }
            fileCount = file.nextInt();
            Deque<String> featured = new Deque<>();
            for (int lcv = 0; lcv < fileCount; lcv++) {
                String tempString = file.next();
                if (tempString.equals("ADD_FRONT")) {
                    featured.enqueueFront(file.next());
                } else if (tempString.equals("ADD_BACK")) {
                    featured.enqueueRear(file.next());
                } else if (tempString.equals("REMOVE_FRONT")) {
                    featured.dequeueFront();
                } else if (tempString.equals("REMOVE_BACK")) {
                    featured.dequeueRear();
                }
            }

            fileCount = file.nextInt();
            Stack<String> recentlyViewed = new Stack<>();
            for (int lcv = 0; lcv < fileCount; lcv++) {
                file.next();
                recentlyViewed.push(file.next());
            }

            file.close();
            System.out.println("Final Inventory");
            for (int lcv = 0; lcv < inventory.size(); lcv++) {
                System.out.println(inventory.get(lcv).getMyName() + " " + inventory.get(lcv).getMyQuantity());
            }
            System.out.println("\nFeatured Meals");
            int tempSize = featured.size();
            for (int lcv = 0; lcv < tempSize; lcv++) {
                System.out.println(featured.peekFront());
                featured.dequeueFront();
            }

            System.out.println("\nTop of Recently Viewed");
            System.out.println(recentlyViewed.peek());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
Final Inventory
Pasta 6
Sauce 2
Cheese 1
Quinoa 2
Chickpeas 2
Herbs 4
Spinach 3
Lemons 4
Tortillas 4
Beans 4
Salsa 2

Featured Meals
VeganBowl
SpicyTacos

Top of Recently Viewed
GrilledSalmon

 */