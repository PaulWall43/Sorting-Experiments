import java.util.Arrays;

public class Sort{
    //assumes correct upper bound (length - 1)
    public void quickSort(int[] array, int lower, int higher){
        //get the middle element of the array
        int pivot = array[((lower + higher)/2)];
        //Swap the pivot with the left most 
        Sort.swap(array,lower,((lower + higher)/2));
        int lastSeen = lower + 1; 
        for(int i = lower; i <= higher; i++){
            if(array[i] < pivot){
                Sort.swap(array, i, lastSeen);
                lastSeen++; 
            }
        }
        Sort.swap(array, lower, --lastSeen);
        if((lastSeen - 1) - 1 > lower){
            quickSort(array, lower, (lastSeen - 1));
        }
        if(higher - 1 > ++lastSeen){
            quickSort(array, lastSeen, higher);
        }
    }

    //assumes correct upper bound (length - 1)
    public void mergeSort(int[] array, int lower, int higher){
        //Mine is inclusive on higher so check if lower and higher are equal 
        if(higher == lower){
            //This means we're down to a single element
            return;
        }
        // Divide the array into two haves
        int midIndex = (lower + higher) / 2;  // Overflow may be a problem 
        mergeSort(array, 0, midIndex); 
        mergeSort(array, (midIndex + 1), higher); 
        merge(array, lower, midIndex, higher);

    }

    //Assume mid is always lower mid, inclusive 
    public void merge(int[] array, int lower, int mid, int higher){
        //compare bottom and top array until done
        int[] lowerArr = Arrays.copyOfRange(array, lower, ++mid); //Java does exclusive
        int[] higherArr = Arrays.copyOfRange(array, mid, (higher + 1)); //Java does exclusive
        int maxBound = (higher - lower) + 1;  //The number of swaps that should be made (+ 1 b/c length)
        int lowerCount = 0;
        int higherCount = 0;
        int realCount = lower; //lower is inclusive index of array
        boolean bottomFinished = false;
        boolean topFinished = false;
        for(int i = 0; i < maxBound; i++, realCount++){
            if(!bottomFinished && !topFinished){
                if(lowerArr[lowerCount] <= higherArr[higherCount]){
                    array[realCount] = lowerArr[lowerCount];
                    lowerCount++;
                } else {
                    array[realCount] = higherArr[higherCount];
                    higherCount++;
                } 
                if(lowerCount == lowerArr.length)
                    bottomFinished = true;
                else if(higherCount == higherArr.length)
                    topFinished = true;
            } else {
                if(bottomFinished){
                    array[realCount] = higherArr[higherCount];
                    higherCount++;
                } else {
                    array[realCount] = lowerArr[lowerCount];
                    higherCount++;
                }
            }
        } 

    }


    //i and j are indices 
    private static void swap(int[] array, int i, int j){
        //System.out.println(i + " " + j);
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        //int[] arr = {13,7,6,5,4,3,2,1,12,11};
        int[] arr = {24,2,45,20,56,75,2,56,99,53,12, 100, 123, 123, 234, 52, 45, 74, 23 ,64, 53};
        //int[] arr = {5,4,3,2,1};
        Sort mine = new Sort();
        //mine.quickSort(arr, 0, arr.length - 1);
        mine.mergeSort(arr, 0, arr.length - 1);
        for(int i : arr){
            System.out.print( i + " ");
        }
        System.out.println();
    }
}