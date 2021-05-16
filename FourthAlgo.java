/*
create by Avi Fenesh
this program check how much actions we do while using counting sort for check how much different values there is in a given array
the values are between 0-101
in the checks algorithm we dont go all the way with counting sort, cause we dont need to get a sorted array,
we stop after filling the C array, that represent the number of objects of any values that in the array we check
we use counter to check how much checks, increase and placements we do while sorting an counting
 */

public class FourthAlgo {
    public static int[] fourthGetDiff(int[] A) {
        int [] vals = new int[3];
        int checksCounter = 0;// count the checks actions
        int increaseCounter = 0;// count the increase actions
        int placementCounter = 0;// count the placements actions
        int[] C = new int[101];// represent the 101 optional values at the array
        int result = 0;//count the different values
        int i;// index for for-loops
        for (i = 0; i < C.length; i++) {//set the C array to 0
            C[i] = 0;
            placementCounter ++;// for every zero setting
        }
        // going throw A array, checks the values in every cell and increase the cell in the C array with this values as index
        for (i = 0; i < A.length; i++) {
            C[A[i]]++;
            checksCounter++;//for value check hide in putting A[i] directly
            increaseCounter++;//for increase C cells
        }
        for (i = 0; i < C.length; i++) {//count the number of different values
            checksCounter++;//for any if question
            if (C[i] != 0) {
                result++;
                increaseCounter ++;//for every increase action
            }
        }
        vals[0] = placementCounter;
        vals[1] = checksCounter;
        vals[2] = increaseCounter;
        return vals;//return the action that been made;
    }
}
