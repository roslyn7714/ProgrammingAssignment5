import java.util.*; 
import java.io.*;
public class TestBinarySearchTree {
   public static void main(String[] args) {
       Integer[] num = { 67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81,
               66, 40, 53, 84, 77 };
       BinarySearchTree tree = new BinarySearchTree();
       
       for (int i = 0; i < num.length; i++) {
           tree.insert(num[i]);
       }
       tree.inorder(tree.root);
       Scanner input = new Scanner(System.in);
       System.out.println("\nEnter an element to search");
       int n = input.nextInt();
       if (tree.search(n))
           System.out.println("Element is present in tree");
       else
           System.out.println("Element is not present in tree");

       System.out.println("Enter an element to delete");
       n = input.nextInt();
       tree.delete(n);
       System.out.println("Enter an element to insert");
       n = input.nextInt();
       tree.insert(n);
       System.out.println("in order: ");
       tree.inorder(tree.root);
       System.out.println("\npre order: ");
       tree.inorder(tree.root);
       System.out.println("\npost order: ");
       tree.inorder(tree.root);
System.out.println("\nHow many leaves does the tree have? "+ tree.getNumberOfLeaves());
System.out.println("\nWhat element are you looking for?");
 int j = input.nextInt();
System.out.println(tree.leftSubTree(j));
System.out.println("\nWhat element are you looking for?");
 int k = input.nextInt();
System.out.println(tree.rightSubTree(k));
System.out.println("\nWhat element do you want the path from?");
int y = input.nextInt();
System.out.println(tree.path(y));
        



   }
}
/*
run:
34 39 40 43 48 53 55 59 66 67 73 77 81 84 87 91 92 95 
Enter an element to search
39
Element is present in tree
Enter an element to delete
40
Enter an element to insert
15
in order: 
15 34 39 43 48 53 55 59 66 67 73 77 81 84 87 91 92 95 
pre order: 
15 34 39 43 48 53 55 59 66 67 73 77 81 84 87 91 92 95 
post order: 
15 34 39 43 48 53 55 59 66 67 73 77 81 84 87 91 92 95 
How many leaves does the tree have? 18

What element are you looking for?
55
[15, 34, 39, 43, 48, 53]

What element are you looking for?
59
[66]

What element do you want the path from?
55
[]
BUILD SUCCESSFUL (total time: 37 seconds) 
*/