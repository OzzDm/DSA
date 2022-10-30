/*Bubble sort is a classic sort algorithm. It is the least efficient algorithm of all the sorting algorithms*/

/* In Bubble sort, the array is "logically" partitioned
into an unsorted and a sorted array. Initially the whole
array is considered to be unsorted. We begin with comparing
adjacent elements of the array from the start index and go on 
till the lastIndex of the unsorted partition. We swap the elements
if element at index i > element at index i+1 in case of ascending
order. So what happens is that we basically place the largest element
in its correct position in each(i iteration, here) iteration; according
to my implementation. */

/* Bubble sort is a stable sorting algorithm*/ 

package Sorting_Algorithms;

public class BubbleSort {
    public static void main(String[] args) {
        // int intArray[] ={20, 35, -15, 7, 55, 1, -22};
        int intArray[] ={55, 35, 20, 7, 1, -15, -22};

        for(int i=0; i<intArray.length-1; i++){
            for(int j=0; j<intArray.length-i-1; j++){
                if(intArray[j]>intArray[j+1]){
                    swap(intArray, j, j+1);
                }
            } 
            for (int k = 0; k < intArray.length; k++) {
                System.out.print(intArray[k]+" ");
            }
            System.out.println("\n");       
        }
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+" ");
        }
    }
    public static void swap(int[] a, int i, int j){
        if(i==j){
            return;
        }
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
        
    }
}
