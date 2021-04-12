package com.company.Task1;

/**
 Inspirations:
 * https://www.youtube.com/watch?v=W81Qzuz4qH0
 * https://www.udemy.com/data-structures-and-algorithms-deep-dive-using-java/learn/v4/t/lecture/8435944?start=0
 */

public class Heap {
    private int [] heap;
    private int size;
    private Time time;
    private static final int FRONT = 1;

    // create and initialize the array
    // the caller decides the capacity of the heap
    public Heap(int capacity, int[] list){

        heap = new int[capacity + 1];
        time = new Time();

        //System.out.println();
        time.setStart();
        for (int i = 0; i < list.length; i++){
            insert(list[i]);
        }
        time.setEnd();
        long formattedTime = time.getExpiredTime();
        //System.out.println("Size : "+ list.length + " & total time is " + time.stringFormat(formattedTime));

        if (list.length == 1000000){
            System.out.println();
            System.out.print("Deleting min heap");
            time.setStart();
            //remove();
            for(int i = 1; i <= size; i++){

            System.out.print(heap[i] +"  ");
        }

            time.setEnd();
            long formattedTime1 = time.getExpiredTime();
            //System.out.println();
            System.out.println("Total time  is " + time.stringFormat(formattedTime1));
        }

        printHeapLevelOrder();


    }

    // when insert a node check to see if it is full
    public boolean isFull(){
        return size ==heap.length;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    // getting the parent of the element in array
    public int getParent(int index){
        return (index -1) / 2;
    }

    public int getChild(int index ,boolean left){
        return 2 * index + (left? 1 : 2);

    }
    public void insert(int value){
        if(isFull()){
            throw  new IndexOutOfBoundsException("Heap is full");
        }
        // if it is not full size will be incremented to z next available position
        heap[size] = value;
        fixHeapUp(size);
        size++;
    }
/*
    public void delete(int index){
        if (isEmpty()){
            throw  new IndexOutOfBoundsException("heap is empty");
        }
        int parent = getParent(index);
        int deletedValue = heap[index];
        heap[index] = heap[size - 1];
        if(index == 0 || heap[index] > heap[parent]){
            percolateDown(index,size -1);
        }
        else{
            fixHeapUp(index);
        }
        size--;
        System.out.println("deleted value is " + deletedValue + " at index " + index);
    }

 */
   public int remove(){
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        fixHeapUp(FRONT);
        System.out.println();

        return popped;
    }



    // check if the value we inserted is greater than parent and repeat
    // until the value is not greater than its parent or
    // if it hit the root then the value has become the root

    public void fixHeapUp(int index){
        int newValue = heap [index];

        // swapping until we find its right position
        while(index > 0 && newValue < heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        // assign the new value after its found its right position
        heap[index] = newValue;

    }
/*
    public void percolateDown(int index, int lastHeapIndex){
        int childToSwap;
        while(index <= lastHeapIndex){
            int leftChild = getChild(index,true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastHeapIndex){
                if(rightChild > lastHeapIndex){
                    childToSwap = leftChild;
                }
                else{
                    childToSwap = (heap[leftChild] < heap[rightChild]? leftChild : rightChild);
                }

                if(heap[index] > heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }
                else { break;}
                index = childToSwap;

            }
            else {
                break;
            }
        }

    }

 */


    public void printHeapLevelOrder(){
        for(int i = 0; i < size; i++){

            System.out.print(heap[i] +"  ");

        }


    }


}

