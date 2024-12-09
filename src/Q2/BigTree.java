package Q2;

import DataStructures.BinarySearchTree;
import java.math.*;
public class BigTree {
    public static void main(String[] args) {
        var tree = new BinarySearchTree<Integer>();
        int temp = 0;
        for (int i = 0; i < 50; i++) {
            temp = (int)(Math.random()*100+1);
            System.out.print(temp + " ");
            tree.insert(temp);
        }
        tree.printInOrder();
    }
}
