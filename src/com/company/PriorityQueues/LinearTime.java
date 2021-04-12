package com.company.Task1;

public class LinearTime {

    private int[] heap;
    private int size;
    private int maxSize;
    Time time = new Time();

    public LinearTime(int maxSize, int[] list){
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];


        //System.out.println();
        time.setStart();
        for (int i = 0; i <list.length; i++) {
            insert(list[i]);
        }
        time.setEnd();
        long formattedTime = time.getExpiredTime();
        resetHeap();
        buildHeapLinearTime(list);
        printHeap();
       // System.out.println("Size : "+ list.length + " & total time is " + time.stringFormat(formattedTime));

        if (list.length == 15){
            System.out.println("Deleted min Heap(linear algorithm):");
            time.setStart();
            //deleteMin();
            time.setEnd();
            //printHeap();
            long formattedTime1 = time.getExpiredTime();
            //System.out.println();
            System.out.println("Total time  for deleting min heap is: " + time.stringFormat(formattedTime1));
        }


    }

    private int parent(int i){
        if(i <=0 || i >= this.size){
            return -1;
        }
        return (i-1)/2;
    }

    private int left(int i){
        int left = 2*i + 1;
        if(left >= this.size){
            return -1;
        }
        return left;
    }

    private int right(int i){

        int right = 2*i + 2;
        if(right >= this.size){
            return -1;
        }
        return right;
    }

    // A recursive method to heapify a subtree with root at given index
    // This method assumes that the subtrees are already heapified
    //time complexity -O(log n)- if given element is root, we need to percolate down to the height of the heap in worst case
    private void minHeapify(int i){
        int leftChild = left(i);
        int rightChild = right(i);
        int min;
        if(leftChild != -1 && this.heap[leftChild] < this.heap[i]){
            min = leftChild;
        }
        else {
            min = i;
        }
        if(rightChild != -1 && this.heap[rightChild] < this.heap[min]){
            min = rightChild;
        }
        if(min != i){
            swap(this.heap,i,min);
            minHeapify(min);
        }
    }

    private void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void printHeap(){
        for(int i = 0; i<this.size; i++){
            System.out.print(this.heap[i] + " ");
        }
    }

    /*
    increase the heap size
    keep the new element at end of the heap
    heapify the element from bottom to top(percolate up)
    Time complexity - log(n)
     */
    public void insert(int data){
        if(this.size == this.maxSize){
            resizeHeap();
        }
        this.size++;
        int i = this.size-1;
        this.heap[i] = data;
        while (i >=0 && parent(i) >=0 && this.heap[parent(i)] > this.heap[i]){
            swap(heap,i,parent(i));
            i = parent(i);
        }
    }

    private void resizeHeap(){
        int[] oldArr = new int[this.maxSize];
        System.arraycopy(this.heap,0,oldArr,0,this.size-1);
        this.heap = new int[this.maxSize *2];
        for(int i =0; i< oldArr.length ; i++){
            this.heap[i] = oldArr[i];
        }
        this.maxSize *=2;
        oldArr = null;
    }


    public void buildHeapLinearTime(int[] arr){
        while (arr.length > this.maxSize - this.size){
            resizeHeap();
        }
        for(int i=0 ;i < arr.length; i++){
            this.heap[i] = arr[i];
            this.size++;
        }
        int firstNonLeaf = (this.size - 1)/2;
        for(int i = firstNonLeaf; i >=0; i--){
            minHeapify(i);
        }
    }

    private void resetHeap(){
        this.size = 0;
        this.heap = new int[this.maxSize];
    }
    public int deleteMin(){
        if (this.size == 1)
        {
            this.size--;
            return this.heap[0];
        }

        // Store the minimum value, and remove it from heap
        int root = this.heap[0];
        this.heap[0] = this.heap[this.size-1];
        this.size--;
        minHeapify(0);
        return root;
    }

}
