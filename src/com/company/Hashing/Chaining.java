package com.company.Task2;

// Reference: https://www.udemy.com/data-structures-and-algorithms-deep-dive-using-java/learn/v4/t/lecture/8435886?start=199

import com.company.Task1.FileReader;
import com.company.Task1.Heap;
import com.company.Task1.Time;
import java.util.LinkedList;
import java.util.ListIterator;

public class Chaining {

        private LinkedList<Item>[] hashTable ;
        private Time time;
        FileReader fileReader = new FileReader();

        public Chaining(int arraySize){
            hashTable = new LinkedList[arraySize];
            time = new Time();


            for (int i = 0; i < hashTable.length; i++){
                hashTable[i] = new LinkedList<Item>();
            }

            try {
                int[] list1 = fileReader.getInputFromFile(1000000);
                time.setStart();
                for(int i = 0; i <1000000;  i++) {
                    Item item1 = new Item(list1[i], list1[i]);
                    put(list1[i], item1);
                }
                time.setEnd();
                long formattedTime1 = time.getExpiredTime();

             /*   Item item1 = new Item(4371, 4371);
                Item item2 = new Item(1323, 1323);
                Item item3 = new Item(6173, 6173);
                Item item4 = new Item(4199, 4199);
                Item item5 = new Item(4344, 4344);
                Item item6 = new Item(9679, 9679);
                Item item7 = new Item(1989, 1989);




                put(4371, item1);
                put(1323, item2);
                put(6173, item3);
                put(4199, item4);
                put(4344, item5);
                put(9679, item6);
                put(1989, item7);

              */


                printHashTable();


                System.out.println("Running time: " + time.stringFormat(formattedTime1) + " nano seconds");
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Initialize array bigger than 5");
                e.printStackTrace();
            }


        }
        public void put(int rawKey, Item element){
            int hashedKey = hashFunction(rawKey);
            hashTable[hashedKey].add(element);

        }

        /*public Item getElement(int rawKey){
            int hashedKey = hashFunction(rawKey);
            // iterator to search linked List that matches the key
            ListIterator<Item> iterator = hashTable[hashedKey].listIterator();
            Item item = null;
            while (iterator.hasNext()) {
                item = iterator.next();

                if (item.getRawKey() == rawKey) {
                    return item;
                }
            }
            return null;
        }

        public Item removeElement(int rawKey){
            int hashedKey = hashFunction(rawKey);
            ListIterator<Item> iterator = hashTable[hashedKey].listIterator();
            Item item = null;
            //int index =-1;
            int index = 0;
            while (iterator.hasNext()) {
                item = iterator.next();
                index++;

                if (item.getRawKey() == rawKey) {
                    break;

                }
            }
            if (item == null || item.getRawKey() ==rawKey){
                return null;
            }
            else
            {

                hashTable[hashedKey].remove(index);
                return item;
            }

        }

         */

        private int hashFunction(int key){

            return key % 10;
        }
        public void printHashTable(){
            for( int i =0; i < hashTable.length; i++){
                if (hashTable[i].isEmpty()){
                    System.out.println("Hash table[" + i + "]:   -");
                }
                else
                {
                    System.out.print("Hash table[" + i + "]: ");
                    ListIterator<Item> iterator = hashTable[i].listIterator();
                    while (iterator.hasNext()){
                        System.out.print(iterator.next().getValue());
                        System.out.print(" -> ");
                    }
                    System.out.println("null");
                }
            }

        }
    }

