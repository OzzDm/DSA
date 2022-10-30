package Sorting_Algorithms;

public class MergeSort_Optimized {
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

        if(a[mid - 1] <= a[mid]){   //Optimization 1
            return;
        }
        /* Optimization 1: When we are calling merge method, the left and right partitions
        both are already sorted. And we know that, 'mid' is the index of 1st elements of 
        right array and 'mid-1' is the index of last element of the left array(partition). 
        Now, if the last element in the left partition is less than or equal to the 1st element 
        in the right partition, which means that all the elements in left partition are
        less than or equal to all the elements of the right partition; bocause both the left anf right 
        partitions are sorted. So, essentially, we have the situation here that if we were to go through 
        the merge process for these partitions, we would end up copying the entire left array to the 
        temp array & then we copy the entire right array to the temp array. But after that, we copy
        that merged temporary array back into the original array into the positions that are already
        occupied by those elements itself; so what that means is we are not gonna change the orginal array in
        any way as we're just gonna end up copying the elements back in the same order they are already in.*/

        int i = start;
        int j = mid;
        int tempIndex=0;
        int temp[] = new int[end-start];
        while(i < mid && j < end)
        {
            temp[tempIndex++] = a[i] <= a[j] ? a[i++] : a[j++]; //this equalsto(" = ") in >= makes the merge sort stable
        }
        
        System.arraycopy(a, i, a, start + tempIndex , mid - i);//Optimization 2
        /* Optimization 2: If we are having the elements remaining in the left partition we have to
        copy them into temp array. BUT, if we have elements remaining in the right partition we don't
        have to copy it into the temp array. REASON -->Consider following exaple of merging A & B
        A = { 32, 34} ; B = {33, 36}
        temp = { 32, 33, 34}  we don't take 36 in temp array bacause it is already in its correct position
        inside the original array. So adding it to temp array & then copying it back to original array adds
        unnecessary number of steps for processing of the program.
        
        A = { 32, 36} ; B = {33, 34} 
        temp = { 32, 33, 34, 36} But in this case when elemnts are remaing in left array,
        they are to added to temp array; as we can see in example the position of 36 in changed from index 2 to index 4(relative positions)
        and that change has to be reflected to the original array also. */
    
        System.arraycopy(temp, 0, a, start, tempIndex);
    }

    
}
