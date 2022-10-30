/* It is an in-place algorithm.*/

/* In insertion sort, we assume that the element at position 0 is in a sorted partition.
In this implementation of insertion sort we will be growing the sorted partition from left
to right. So, the unsorted partition would start from index 1 of the array. In each iteration
we will taking the first element of the unsorted partition and we insert it into the sorted
partition. While inserting the elements into the sorted partition, we compare the value we're
inserting with the values in the sorted partition. We traverse the sorted partition from right
to left, and we try to look for a value that is less than or equal to the one we're trying to
insert; because once we find that value we can stop looking. Thus, we get the new insertion
position for the element we're trying to insert in the sorted partition.*/

/*It is a stable sorting algorithm.(Relative positions of duplicate elemnts remains preserved) */
package Sorting_Algorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int intArray[] ={20, 35, -15, 7, 55, 1, -22};
        /*We are starting the loop from firstUnsortedIndex= 1, because we assume that the first 
        element is in the sorted partition */
        for(int firstUnsortedIndex=1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++)
        {
            int newElement=intArray[firstUnsortedIndex];
            int i;
            for(i=firstUnsortedIndex; i>0 && intArray[i-1] > newElement; i--)
            {
                intArray[i] = intArray[i-1];
            }
            intArray[i]=newElement;
            for (int k : intArray) {
                System.out.print(k+" ");
            }
            System.out.println();
        }
        System.out.println("Sorted array is-->");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+" ");
        }
    }
}
