package com.company.Task2;

import com.company.Task1.FileReader;
import com.company.Task1.Heap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loop = false;
        FileReader fileReader = new FileReader();

        do{
            System.out.println("Enter a number to run a task");
            System.out.println("1--> Chaining hash table");
            System.out.println("2--> linear probing");
            System.out.println("3--> quadratic probing");
            System.out.println("4--> second hash function h2(x) = 7 − (x mod 7)");
            System.out.println("5--> Rehashed table");
            System.out.println("6--> EXIT");

            int choice = input.nextInt();
            switch(choice){
                case 1:
                    new Chaining(10);

                    break;
                case 2:
                    new LinearProbing(1000001);
                    break;
                case 3:
                    new QuadraticProbing(100001);

                    break;
                case 4:
                    new LinearProbingOne(11);
                    break;
                case 5:
                    new Rehashed(11);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Please enter correct number:");


            }
            System.out.println("Do you want to continue on the same task Y or N?");
            String choice2 = input.next();
            if(choice2.equalsIgnoreCase("y")){
                loop = true;
            } else break;
        } while(loop);


    }
}
