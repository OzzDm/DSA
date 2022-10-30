// 1. Merge sort is a divide and conquer algorithm.
// 2. It's a recursive algorithm.
// 3. It involves two phases:  (i) Splitting (ii) Merging
/* i) Splitting phase:
        --> It starts with an unsorted array.
        --> Divide array into 2 unsorted arrays.
        --> Keep splitting the arrays until all the arrays have
            only 1 element each - these arrays are sorted.
    ii) Merge phase:
        --> Merges every left/ right pair of sibling arrays into a sorted array
        --> After 1st merge, we'll have a bunch of 2-element sorted arrays
        --> Then merge those sorted arrays (left/ right siblings) to end up with a
            bunch of 4-element sorted arrays.
        --> Repeat until you have a single sorted array. 
*/
/* 4. Merging Process:
        --> we merge sibling left and right arrays.
        --> We create a temporary array large enough to hold the elemnts in the
            array we're merging.
        --> We set 'i' to the first index of left array and 'j' to the first index of right array.
        --> We compare left[i] with right[j]. If left is smaller, we copy it to the temp array &
            increment i by 1. If right is smaller, we copy it to temp array & increment j by 1.
        --> We repeat this until all elements in left & right arrays have been processed.
        --> At this point, the temporary array contais the merged valuesin sorted order.
        --> We then copy this temporary array to the original array at correct positions.
        --> If left array is at position 'x' to 'y' & right array at position 'y+1' to'z'
            then after the copy, the positions 'x' to 'z' will be sorted in the original array.
        -->So, we overwrite what's there in the original array with the sorted array.        
    */
/* 
Splitting leads to faster sorting during merging
Splitting is logical. We don't create new arrays
It is not an in-place algorithm as it uses tempory array.
It is a stable algorithm. 
*/

package Sorting_Algorithms;

public class MergeSort {
    public static void main(String[] args) {
        int intArray[]={ 20, 35, -15, 7, 55, 1, -22 };

        sort(intArray, 0, intArray.length);

        for(int i=0; i< intArray.length; i++){
            System.out.println(intArray[i]+ " ");
        }
    }

    public static void sort(int a[], int start, int end){
        if(end - start < 2){
            return;
        }
        int mid = (start + end)/2;
        sort(a, start, mid);
        sort(a, mid, end);
        merge(a, start, mid, end);
    } 
    
    public static void merge(int a[], int start, int mid, int end){
        int i = start;
        int j = mid;
        int k=0;
        int temp[] = new int[end-start];
        while(i < mid && j < end)
        {
            temp[k++] = a[i] <= a[j] ? a[i++] : a[j++]; //this equalsto(" = ") in >= makes the merge sort stable
        }
        while(i < mid){
            temp[k++] = a[i++];
        }
        while(j < end){
            temp[k++] = a[j++];
        }

        for(int l=start, m=0; l < end; l++){
            a[l] = temp[m++];
        }

        // Instead of using loop we can use arraycopy function
        //Syntax ---> System.arraycopy(src, srcPos, dest, destPos, length);
        // System.arraycopy(temp, 0, a, start, temp.length);
    }
    
    
}
