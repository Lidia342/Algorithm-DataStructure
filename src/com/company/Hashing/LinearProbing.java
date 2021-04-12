package com.company.Task2;

// Reference: https://www.udemy.com/data-structures-and-algorithms-deep-dive-using-java/learn/v4/t/lecture/8435876?start=1275

import com.company.Task1.FileReader;
import com.company.Task1.Time;

public class LinearProbing {
    private Item [] hashTable;
    private Time time;

    public LinearProbing(int arraySize){
        FileReader fileReader = new FileReader();
        hashTable = new Item[arraySize];
        time = new Time();
        try {
            int[] list1 = fileReader.getInputFromFile(1000000);
            time.setStart();
            for(int i = 0; i <1000000;  i++) {
                Item item1 = new Item(list1[i], list1[i]);
                put(list1[i], item1);
            }
            time.setEnd();
            long formattedTime1 = time.getExpiredTime();
            /*
            Item item1 = new Item(4371, 4371);
            Item item2 = new Item(1323, 1323);
            Item item3 = new Item(6173, 6173);
            Item item4 = new Item(4199, 4199);
            Item item5 = new Item(4344, 4344);
            Item item6 = new Item(9679, 9679);
            Item item7 = new Item(1989, 1989);

            time.setStart();
            put(4371, item1);
            put(1323, item2);
            put(6173, item3);
            put(4199, item4);
            put(4344, item5);
            put(9679, item6);
            put(1989, item7);
            time.setEnd();
            long formattedTime1 = time.getExpiredTime();


             */

            printHashTable();
            //getElement(4371);
            //removeElement(4371);
            //printHashTable();

            System.out.println("Running time: " + time.stringFormat(formattedTime1) + " nano seconds");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Initialize array bigger than 5");
            e.printStackTrace();
        }
    }

    private int hashFunction(int rawKey){

        return rawKey % 10;
    }

    public void put(int rawKey, Item item){
        // hash the key value
        int hashedKey = hashFunction(rawKey);
        // check if the hashed value pos in the array is already occupied
        if(occupied(hashedKey)){
            // if it is occupied we do linear probing
            // set stop index (to know that we have already looked the entire array)
            int stopIndex = hashedKey;
            // check if this the last index
            if(hashedKey == hashTable.length -1){
                // sets the probe position
                hashedKey = 0;
            }
            else{
                hashedKey++;
            }
            // wraps hashed key to z beginning of the array
            while(occupied(hashedKey) && hashedKey !=stopIndex){
                // sets the next probe
                hashedKey = (hashedKey +1) % hashTable.length;
            }
        }
        // if the array is full
        if(occupied(hashedKey)){
            System.out.println("Hash Table["+ hashedKey + "]= occupied");
        }
        // if not we add it
        else{
            hashTable[hashedKey]= item;
        }
    }

    public void getElement(int rawKey){
        int hashedKey = findKey(rawKey);
        if(hashedKey == -1){

        }
        System.out.println("Retrieved element with raw key" +  rawKey);
        System.out.println("Hash table[" + hashedKey +"]= "+  hashTable[hashedKey].getValue());
    }

    // to check the given pos if it is already occupied or not
    private boolean occupied(int index){

        return hashTable[index] != null;
    }


    private int findKey(int rawKey){
        int hashedKey = hashFunction(rawKey);
        if(hashTable[hashedKey] != null && hashTable[hashedKey].getRawKey() == rawKey){
            return hashedKey;
        }
        // the position we are looking is not the item
        // that was added with the key that we are interested in
        int stopIndex = hashedKey;
        if(hashedKey == hashTable.length -1){
            hashedKey = 0;
        }
        else{

            hashedKey++;
        }
        while(hashedKey != stopIndex &&
                hashTable[hashedKey] != null &&
                hashTable[hashedKey].getRawKey() == rawKey){
            hashedKey = (hashedKey +1) % hashTable.length;
        }
        if(hashTable[hashedKey] != null &&
                hashTable[hashedKey].getRawKey() == rawKey){
            return hashedKey;
        }
        else{
            return -1;
        }
    }

    public void removeElement(int rawKey){
        int hashedKey = findKey(rawKey);
        if(hashedKey == -1){
            System.out.println("Element not present in the hash table");
        }
        hashTable[hashedKey] = null;
        System.out.println("element with rawKey " + rawKey + " have been removed");
    }

    public void printHashTable(){
        System.out.println();
        for(int i = 0; i < hashTable.length; i++){
            if(hashTable[i] == null){
                System.out.println("Hash table[" + i +"]= -");
            }
            else{
                System.out.println("Hash table[" + i +"]= "+  hashTable[i].getValue());
            }
        }
    }
}
