package com.company.Task4;

import com.company.Task1.Time;

public class BinarySearchTree {
    Time time = new Time();
    Node root;


    BinarySearchTree(int [] list)
    {
        root = null;
        time.setStart();
        for (int i = 0; i <list.length; i++) {

            insert(list[i]);
        }
        time.setEnd();
        long formattedTime= time.getExpiredTime();

        System.out.println("Size : "+ list.length + " & total time is " + time.stringFormat(formattedTime));

    }

    void insert(int key)
    {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key)
    {

        // If the tree is empty, return a new node
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // return the (unchanged) node pointer
        return root;
    }


}
