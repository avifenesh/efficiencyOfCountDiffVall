/*
created by Avi Fenesh
this program find how much actions we do while we use quick sort for find how much different
object there is in the given array
the algorithm use quick sort and after using quick sort go throw the array and find how much objects
in the array are different then the next object after them in the array
 */

public class thirdAlgo {
    static int compareCounter = 0;// count the compare actions
    static int placementCounter = 0;// count the placement actions

    public static int[] thirdGetDiff(int[] A){
        int result = 0;
        int[] vals = new int[2];
        quickSort(A,0 ,A.length-1);
        for(int i = 1; i< A.length; i++){//check how much different objects in the sorted array
            if(A[i-1] != A[i]){
                result ++;
                compareCounter ++;
            }
        }
        vals[0] = placementCounter;
        vals[1] = compareCounter;
        return vals;
    }
    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        placementCounter += 3;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
        placementCounter += 2;
        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            compareCounter ++;
            if (arr[j] < pivot)
            {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        compareCounter ++;
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
            placementCounter ++;
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
