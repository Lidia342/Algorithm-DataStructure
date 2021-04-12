package com.company.Task2;

import com.company.Task1.Time;

public class Rehashed {
    private Item [] hashTable;
    private Time time;
    public Rehashed (int ArraySize){
        hashTable = new Item[ArraySize];
        time = new Time();
        try {
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




            //printHashTable();
            //getElement(4371);
           //removeElement(4371);
            printHashTable();
            System.out.println("Running time: " + time.stringFormat(formattedTime1) + " nano seconds" );
        }catch (ArrayIndexOutOfBoundsException  e){
            System.out.println("Initialize array ArraySize bigger than 5");
            e.printStackTrace();
        }


    }

    private int hashFunction(int rawKey){

        return 7 - (rawKey % 7);
    }

    public void put(int rawKey, Item item){
        int hashedKey = hashFunction(rawKey);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == hashTable.length -1){
                hashedKey = 0;
            }
            else{
                hashedKey++;
            }
            while(occupied(hashedKey) && hashedKey !=stopIndex){
                hashedKey = (hashedKey +1) % hashTable.length;
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
        System.out.println("Element with rawKey " + rawKey + " have been removed");
        // store the current table
        Item[] oldHashTable = hashTable;
        hashTable = new Item[oldHashTable.length * 2 +1 ]; //I have added +1 so that i get 23 a prime number
        //hash all the values in old hashtable n put them into the new hashtable
        for (int i = 0; i < oldHashTable.length; i++){
            if(oldHashTable[i] != null){
                put(oldHashTable[i].getRawKey(),oldHashTable[i]);
            }
        }
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

