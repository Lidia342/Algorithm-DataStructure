package com.company.Task4;

import com.company.Task1.Time;


public class RedBlackTree {

    static class RedBlackNode{
        RedBlackNode left, right;
        int element;
        int color;

        public RedBlackNode(int theElement)
        {
            this( theElement, null, null );
        }

        public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
        {
            left = lt;
            right = rt;
            element = theElement;
            color = 1;
        }
    }

    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    private RedBlackNode header;
    private static RedBlackNode nullNode;
    Time time = new Time();
    // static initializer for nullNode
    static
    {
        nullNode = new RedBlackNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }

    static final int BLACK = 1;
    static final int RED   = 0;


    public RedBlackTree(int maxSize, int [] list)
    {
        header = new RedBlackNode(maxSize);
        header.left = nullNode;
        header.right = nullNode;

        time.setStart();
        for (int i = 0; i <list.length; i++) {

            insert(list[i]);
        }
        time.setEnd();
        long formattedTime = time.getExpiredTime();

        System.out.println("Size : "+ list.length + " & total time is " +  time.stringFormat(formattedTime));


    }


    public void insert(int item )
    {
        current = parent = grand = header;
        nullNode.element = item;
        while (current.element != item)
        {
            great = grand;
            grand = parent;
            parent = current;
            current = item < current.element ? current.left : current.right;
            // Check if two red children and fix if so
            if (current.left.color == RED && current.right.color == RED)
                handleReorient( item );
        }
        // Insertion fails if already present
        if (current != nullNode)
            return;
        current = new RedBlackNode(item, nullNode, nullNode);
        // Attach to parent
        if (item < parent.element)
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }
    private void handleReorient(int item)
    {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if (parent.color == RED)
        {
            // rotate
            grand.color = RED;
            if (item < grand.element != item < parent.element)
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate(item, great );
            current.color = BLACK;
        }
        // Make root black
        header.right.color = BLACK;
    }
    private RedBlackNode rotate(int item, RedBlackNode parent)
    {
        if(item < parent.element)
            return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;
        else
            return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
    }
    // Rotate binary tree node with left child
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
    {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    // Rotate binary tree node with right child
    private RedBlackNode rotateWithRightChild(RedBlackNode k1)
    {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
}

