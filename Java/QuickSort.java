/* Quick sort is a divide and conquer algorithm 
    It is an in-place algorithm.
    It is an unstable sorting algorithm. */
package Sorting_Algorithms;

public class QuickSort {
    public static void main(String[] args) {
        int intArray[]={ 20, 35, -15, 7, 55, 1, -22 };
    
        sort(intArray, 0, intArray.length - 1);
    
        for(int i=0; i< intArray.length; i++){
            System.out.println(intArray[i]+ " ");
        }
        
    }

    public static void sort(int a[], int start, int end){
        if(end < start){
            return;
        }

        int partitionIndex = partition(a, start, end);
        sort(a, start, partitionIndex-1);
        sort(a, partitionIndex+1, end);

    }

    public static int partition(int a[], int start, int end){
        int i = start, j = end;
        int pivot = i;
        
        while(i < j)
        {
            while( i<j && a[i] <= a[pivot])
            {   i++;    }
            while( a[j] > a[pivot])
            {   j--;    }
            if(i<j)
            {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        int tmp = a[j];
        a[j] = a[pivot];
        a[pivot] = tmp;
        
        return j;
    }
    
}
