package com.company.Task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean loop = false;
        FileReader fileReader = new FileReader();


        do{
            System.out.println("Enter a number for the task you want to run");
            System.out.println("1--> Algorithm  one");
            System.out.println("2--> Algorithm two (Linear time)");
            System.out.println("3. Traverse Algorithm  one");
            System.out.println("4. Traverse Algorithm two (Linear time)");

            System.out.println("5--> EXIT");

            int choice = input.nextInt();
            switch(choice){
                case 1:
                    int [] list = {10 , 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2 };

                    new Heap(list.length,list);
                    /*
                   for(int i = 100; i <=1000000; i = i *10) {
                        int[] list1 = fileReader.getInputFromFile(i);
                        new Heap(list1.length, list1);
                     }

                     */

                   break;
                case 2:
                    int [] list2 = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};
                    new LinearTime(list2.length, list2);

                    /*for(int i = 100; i <=1000000; i = i *10) {
                        int[] arr = fileReader.getInputFromFile(i);
                        new LinearTime(arr.length, arr);
                        }
                     */
                    break;
                case 3:
                    BinaryTree tree1 = new BinaryTree();

                    tree1.root = new Node(1);
                    tree1.root.left = new Node(3);
                    tree1.root.right = new Node(2);
                    tree1.root.left.left = new Node(6);
                    tree1.root.left.right = new Node(7);
                    tree1.root.left.left.left = new Node(15);
                    tree1.root.left.left.right = new Node(14);
                    tree1.root.left.right.left = new Node(12);
                    tree1.root.left.right.right = new Node(9);
                    tree1.root.right.left = new Node(5);
                    tree1.root.right.right = new Node(4);
                    tree1.root.right.right.left = new Node(13);
                    tree1.root.right.right.right = new Node(8);
                    tree1.root.right.left.left = new Node(10);
                    tree1.root.right.left.right = new Node(11);

                    System.out.println("Preorder traversal of binary tree is : ");
                    tree1.printPreorder();

                    System.out.println();
                    System.out.println(" Inorder traversal of binary tree is : ");
                    tree1.printInorder();

                    System.out.println();
                    System.out.println(" Postorder traversal of binary tree is : ");
                    tree1.printPostorder();

                    System.out.println();
                    System.out.println(" levelOrder traversal of binary tree is : ");
                    tree1.levelOrder();
                    break;
                case 4:
                    BinaryTree tree = new BinaryTree();
                    tree.root = new Node(1);
                    tree.root.left = new Node(3);
                    tree.root.right = new Node(2);
                    tree.root.left.left = new Node(12);
                    tree.root.left.right = new Node(6);
                    tree.root.left.left.left = new Node(15);
                    tree.root.left.left.right = new Node(14);
                    tree.root.left.right.left = new Node(9);
                    tree.root.left.right.right = new Node(7);
                    tree.root.right.left = new Node(4);
                    tree.root.right.right = new Node(8);
                    tree.root.right.right.left = new Node(13);
                    tree.root.right.right.right = new Node(10);
                    tree.root.right.left.left = new Node(5);
                    tree.root.right.left.right = new Node(11);


                    System.out.println("Preorder traversal of binary tree is : ");
                    tree.printPreorder();

                    System.out.println();
                    System.out.println(" Inorder traversal of binary tree is : ");
                    tree.printInorder();

                    System.out.println();
                    System.out.println(" Postorder traversal of binary tree is : ");
                    tree.printPostorder();

                    System.out.println();
                    System.out.println(" levelOrder traversal of binary tree is : ");
                    tree.levelOrder();

                default:



            }
            System.out.println(" \n Do you want to continue on the same task Y or N?");
            String choice2 = input.next();
            if(choice2.equalsIgnoreCase("y")){
                loop = true;
            }
            else
                loop = false;
        } while(loop);




    }
}
