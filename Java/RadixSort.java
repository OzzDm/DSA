/* Radix sort makes assumption about the data.
The Data must have same radix (e.g. decimal nos. have base 10 so radix=10) and width
It is a sort based on individual digit or letter position. It starts with the rightmost
position. It must use stable sort algorithm at each stage.(mostly stable counting sort
is used.*/
/*  It is a stable sort.
    In-place --> depends on which sort algorithm you use. */ 
package Sorting_Algorithms;

public class RadixSort {
    public static void main(String[] args) {
        int radixArray[] = { 4725, 4586, 1330, 8792, 1594, 5729 };

        radixSort(radixArray, 10, 4);

        for(int i = 0;i < radixArray.length; i++){
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(int input[], int radix, int width){
        for(int i=0; i < width; i++){
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int input[], int position, int radix){
        int countArray[] = new int[radix];
        int numlen = input.length;

        //creating the counting array
        for(int value : input){
            countArray[getDigit(value, position, radix)]++;
        }

        //adjusting the counting array
        for(int j = 1; j < radix; j++){
            countArray[j] += countArray[j-1];
        }

        int tmp[] = new int[numlen];
        for(int tempIndex = numlen - 1; tempIndex >= 0; tempIndex--){
            tmp[--countArray[getDigit(input[tempIndex], position, radix)]] = input[tempIndex];
        }

        System.arraycopy(tmp, 0, input, 0, numlen);
    }

    public static int getDigit(int value, int position, int radix){
        return value/ (int)Math.pow(radix, position) % radix;
    }
}
