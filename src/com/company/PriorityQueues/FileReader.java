package com.company.Task1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {


    private Scanner scanner;


    public int[] getInputFromFile(int arraysize) {



        try {

            File file = new File("C:\\Users\\Lili\\Desktop\\Algorithm & Data Structure\\Seminar3\\src\\com\\company\\Seminar 1 - File with random numbers.txt");
            scanner = new Scanner(file);

        } catch (IOException e) {
            System.out.println("file not found");
        }


        int[] array = new int[arraysize];
        int i = 0;
        while (scanner.hasNextInt() && i < arraysize) {
            array[i++] = scanner.nextInt();

        }
        return array;


    }
}

