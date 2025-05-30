package Q2;
import java.math.*;
import DataStructures.BinarySearchTree;
import java.math.*;
public class BigTree {
    public static void main(String[] args) {
        var tree = new BinarySearchTree<Integer>();
        int temp = 0;
        int total = 0;
        for (int i = 0; i < 50; i++) {
            temp = (int)(Math.random()*100+1);
            total += temp;
            System.out.print(temp + " ");
            tree.insert(temp);
        }
        tree.printPreOrder();
        tree.printInOrder();
        tree.printPostOrder();
        System.out.println(total);
        System.out.println(tree.search(32));
        tree.insert(51);
        tree.insert(102);
        tree.printInOrder();
        int closest = 0;
        double distance = Integer.MAX_VALUE;
        for (int i = 1; i < 103; i++) {
            if (tree.search(i)) {
                if (Math.abs(((total/52)/2)-i) < distance) {
                    distance = Math.abs(((total/52)/2)-i);
                    closest = i;
                }
            }
        }
        System.out.println("removing " + closest);
        tree.delete(closest);
        System.out.println(tree.height());
        System.out.println(tree.width());
        tree.invert();
        tree.printInOrder();

    }
}
