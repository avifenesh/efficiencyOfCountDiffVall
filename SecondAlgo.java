/*
created by Avi Fenesh
this program is find how much actions we do while we use insertion sort for find how much different
object there is in the given array
the algorithm use insertion sort and after using insertion sort go throw the array and find how much objects
in the array are different then the next object after them in the array
 */
public class SecondAlgo {
    public static int[] secondGetDiff(int[] A) {
        int n = A.length;
        int[] vals = new int[2];
        int compareCounter = 0;// count the compare actions
        int placementCounter = 0;// count the placement actions
        int result = 0;
        for (int i = 1; i < n; ++i) {// insertion sort
            int key = A[i];
            int j = i - 1;
            placementCounter ++;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j = j - 1;
                placementCounter ++;
                compareCounter += 2;
            }
            compareCounter += 2; // for the last while compare in any iteration
            A[j + 1] = key;
            placementCounter ++;
        }
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
}
