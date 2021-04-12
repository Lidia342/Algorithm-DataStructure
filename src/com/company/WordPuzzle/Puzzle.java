package com.company.Task3;

import com.company.Task1.Time;

import java.util.Scanner;

public class Puzzle {

    public static void main(String[] args) {
        new Puzzle();

    }

    static final int ROWS = 4;
    static final int COLUMNS = 4;

    private Time time;
    // find in all 8 directions
    private int[] rowNumber = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private int[] columnNumber = { -1, 0, 1, -1, 1, -1, 0, 1 };
    private boolean found = false;

    public Puzzle(){
        time = new Time();
        char [] [] puzzle = {
                {'t','h','i','s'},
                {'w','a','t','s'},
                {'o','a','h','g'},
                {'f','g','d','f',}
        };

        for(int i = 0; i < ROWS; i++) {
            System.out.println();
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(puzzle[i][j] +"  ");
            }}
        System.out.println();
        System.out.println();

        System.out.println("Please Enter desired word for search");
        String word = new Scanner(System.in).next();
        boolean loop = false;
        do {
            time.setStart();
            findWord(word, puzzle);
            time.setEnd();
            long formattedTime = time.getExpiredTime();
            System.out.println("Searching time: " +  time.stringFormat(formattedTime) );
            System.out.println("Do you want to search again Y or N");
            String answer = new Scanner(System.in).next();
            if(answer.equalsIgnoreCase("y")){
                loop = false;
            }
            else{
                loop  = true;
            }
        }while(loop);

        //findWord("this",puzzle);
        //findWord("two",puzzle);
        //findWord("fat",puzzle);
        //findWord("that",puzzle);
    }

    // searches given words in a given matrix in all 8 directions
    public void findWord(String word,char[][] puzzle){
        found = false;
        // consider every point as starting point and search given word

        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {

                findWordUtil(puzzle,i,j,word);
            }
        }
        if(!found){
            System.out.println("The word \"" + word + "\" has not been found");
        }
    }

    public boolean isSafe(int i, int j) {

        if (i >= 0 && i <= (ROWS - 1) && j >= 0 && j <= COLUMNS - 1) {
            return true;
        }

        return false;
    }

    // this function searches in all 8 direction from point (row, col) in puzzle [] []

    public void findWordUtil(char[][] puzzle, int row, int col, String word) {

        //If the first character of word does not much with given starting point in puzzle
        if (puzzle[row][col] != word.charAt(0)) {
            return; }

        int len = word.length();

        // searching word in all 8 directions starting from that col, row

        for (int dir = 0; dir < 8; ++dir) {
            //initialize starting point for current direction
            int rd = row + rowNumber[dir];
            int cd = col + columnNumber[dir];
            int k;
            String path = word.charAt(0) + "(" + row + "," + col + ")";

            //first character is already checked match remaining characters

            for (k = 1; k <= len - 1; k++) {
                //if out of bound break
                if (!isSafe(rd, cd)) {
                    break;
                }

                // if not matched break
                if (!(puzzle[rd][cd] == word.charAt(k))) {
                    break;
                } else {
                    path = path.concat(puzzle[rd][cd] + "(" + rd + "," + cd + ")");
                }

                // moving in particular direction
                rd = rd + rowNumber[dir];
                cd = cd + columnNumber[dir];
            }

            //if all character matched then value must be equal to length of word

            if (k == len) {
                System.out.println("Found the word \"" +word+"\" At: position: " + path);
                found = true;
            }

        }

    }

}
