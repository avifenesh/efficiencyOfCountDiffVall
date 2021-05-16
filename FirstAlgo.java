/*
 * created by Avi Fenesh
 * this is the first algorithm that we got in maman 11
 * the algorithm go throw the array and check how much different objects in it
 * for every action the program made we increase the counter by 1, at the end we want to know how much action has been
 * made for checking the efficiency of the algorithm
 * in this one we expecting for n^2 action in the worst case, n representing the size of the array
 */
public class FirstAlgo {
    public static int[] firstGetDiff(int[] A){
        int [] vals = new int[2];
        int compareCounter = 0;// count the compare actions
        int placementCounter = 0;// count the placement actions
        int U_size = 0;// count the differences object, also using for know when to stop the j loop
        placementCounter ++;// for placement
        boolean U;// if the object we check is unique in the array, u is true, else, if we found another object equal to the one we check, u is false
        for(int i = 1; i < A.length; i++){
            U = true;
            placementCounter ++;// for placement
            for (int j = 0;j <= U_size; j++){
                compareCounter ++;// for if
                if(A[i] == A[j]){// check if there is another equal object
                    U = false;
                    j = U_size;
                    placementCounter += 2;// for placement
                }//if
            }// j for loop
            compareCounter ++;// for if
            if(U){// check if we found unique object
              U_size ++;
              A[U_size] = A[i];// cause we want to compare the next object with the new unique we found also
                placementCounter += 2;// for placement
            }// if
        }// i for loop
        vals[0] = placementCounter;
        vals[1] = compareCounter;
        return vals;
    }// end of method
}// end of program