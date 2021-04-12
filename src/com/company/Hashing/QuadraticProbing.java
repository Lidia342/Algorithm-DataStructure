package com.company.Task2;

import com.company.Task1.FileReader;
import com.company.Task1.Time;

public class QuadraticProbing{
    private Item [] hashTable;
    private Time time;
    public QuadraticProbing(int ArraySize){
        hashTable = new Item[ArraySize];
        time = new Time();
        FileReader fileReader = new FileReader();
        try {
            int[] list1 = fileReader.getInputFromFile(1000000);
            time.setStart();
            for(int i = 0; i <100000;  i++) {
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
            System.out.println("Running time: " + time.stringFormat(formattedTime1) + " nano seconds" );
        }catch (ArrayIndexOutOfBoundsException  e){
            System.out.println("Initialize array ArraySize bigger than 5");
            e.printStackTrace();
        }


    }

    private int hashFunction(int key){
        return key % 10;
    }


    public void put(int rawKey, Item item){
        int multiplier = 0;

        int hashedKey = hashFunction(rawKey);
        if(occupied(hashedKey)){
            multiplier++;

            int stopIndex = hashedKey;
            if(hashedKey == hashTable.length -1){
                hashedKey = 0;
            } else{
                hashedKey = hashedKey + multiplier * multiplier;
            }
            while(occupied(hashedKey) && hashedKey !=stopIndex){

                hashedKey = (hashedKey +1) % hashTable.length ;

            }

        }

        if(occupied(hashedKey)){
            System.out.println("Hash Table["+ hashedKey + "]= occupied");
        }
        else{
            hashTable[hashedKey]= item;
        }
    }

    public void getElement(int rawKey){
        int hashedKey = findKey(rawKey);
        if(hashedKey == -1){

        }
        System.out.println("Retrieved element with raw key " + rawKey);
        System.out.println("Hash table[" + hashedKey +"]= "+  hashTable[hashedKey].getValue());
    }

    private boolean occupied(int index){

        return hashTable[index] != null;
    }

    private int findKey(int rawKey){
        int hashedKey = hashFunction(rawKey);
        if(hashTable[hashedKey] != null && hashTable[hashedKey].getRawKey() == rawKey){
            return hashedKey;
        }
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
