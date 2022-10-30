/*Counting sort makes assumptions about the data
This algorithm does not use comparisons for sorting.
It count the number of occurences of each value.
Only works with non-negative discrete values. (can't work with floats, strings)
Values must be within a specific range */

/* Basically, counting sort algorithms sort the elements by counting the number
of occurence of each unique element in the array. The count is stored in another
array say, counting_array and the sorting is done by mapping the count as an index
of the counting_array */

/* This implementation is an unstable sort.
   It is not an in-place algorithm. */
    
package Sorting_Algorithms;

public class CountingSort{
    public static void main(String[] args) {
        
        int intArray [] = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };

        sort(intArray, 1, 10);

        for(int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i] + " ");
        }
    }

    public static void sort(int []input, int min, int max){

        int countArray[] = new int[(max-min)+1];

        //filling the counting array
        for(int i = 0; i < max;i++){ //this for loop is for traversing the elements of the input array one-by-one 
            countArray[input[i]-min]++ ;
        }

        //writing back to the original array 
        int j = 0;
        for(int i = min; i <= max; i++){ /* this for loop is looping on the basis that each element in 
            the countArray has a count(value)(here, that count has a min value=1 & max value=10) */
            while(countArray[i - min] > 0){
                input[j++] = i;
                countArray[i - min]--;
            }                            

        }

    }
}