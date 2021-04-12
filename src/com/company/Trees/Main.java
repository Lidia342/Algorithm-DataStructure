package com.company.Task4;

import com.company.Task1.FileReader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        boolean loop = false;
        do{
            Scanner input = new Scanner(System.in);
            System.out.println("1. Binary search Tree");
            System.out.println("2. AVL");
            System.out.println("3. Red-Black Tree");

            int choice = input.nextInt();


            switch (choice) {
                case 1:
                    for (int i = 100; i < 1000001; i = i * 10) {
                        int[] fileNumbers = fileReader.getInputFromFile(i);      //From the file
                        new BinarySearchTree(fileNumbers);
                    }
                    break;
            }
            switch (choice) {
                case 2:
                    for (int i = 100; i < 1000001; i = i * 10) {
                        int[] fileNumbers = fileReader.getInputFromFile(i);      //From the file
                        new AvlTree(fileNumbers);
                    }
                    break;
            }
            switch (choice) {
                case 3:
                    for (int i = 100; i < 1000001; i = i * 10) {
                        int[] fileNumbers = fileReader.getInputFromFile(i);      //From the file
                        new RedBlackTree(fileNumbers.length, fileNumbers);
                    }
                default:
            }

            System.out.println(" \n Do you want to continue on the same task Y or N?");
            String choice2 = input.next();
            if(choice2.equalsIgnoreCase("y")){
                loop = true;
            }
            else
                loop = false;
        }while(loop);

    }
}
