/*
 created by Avi Fenesh
 this is the main program that execute all the algorithms and return the values of the
 actions that been made in each one
 algorithm been checks:
 1. special algorithm made for this task only
 2. algorithm that use insertion sort
 3. algorithm that use quick sort
 4. algorithm that use counting sort
 5. algorithm that use hash-table
 6. algorithm that use binary tree search
 7. algorithm that use red-black tree
*/

import java.util.Scanner;
import java.util.Random;

public class mainProg {
    public static void main(String [] args){
        System.out.println("please enter the size of array you want to check algorithms performance on, for exit please enter 0: ");
        Scanner scan = new Scanner (System.in);
        int n = scan.nextInt();// scan the wanted length for the array
        int [] A = new int[n];// create the array
        Random rn = new Random();
        for (int i = 0;i < n; i++){
            A[i] = rn.nextInt(100);
        }// randomise the values in the array
        int algCompare;//the compare actions at the algorithm
        int algPlace;// the placements action at the algorithm
        int algIncrease;//the increase action at the algorithm
        int algChecks;// the checks action at the algorithm
        int algHashes;// the hashes action at the algorithm
        int algInsert;// the hashes action at the algorithm
        int [] vals;// for get few values from the algorithm

        while(n!=0) {

            int[] a = A.clone();// we dont want to change the original array, so we use copy

            vals = FirstAlgo.firstGetDiff(a);// runs the first algorithm
            algPlace = vals[0];
            algCompare = vals[1];
            System.out.println("The number of actions been made for array in " + n + " size, with the first algorithm is " +
                    algCompare + " compares and " + algPlace + " placements");


            int[] b = A.clone();// we dont want to change the original array, so we use copy

            vals = SecondAlgo.secondGetDiff(b);
            algPlace = vals[0];
            algCompare = vals[1];
            System.out.println("The number of actions been made for array in " + n + " size, with the second algorithm," +
                    " using insertion sort is " + algCompare + " compares and " + algPlace + " placements");


            int[] c = A.clone();// we dont want to change the original array, so we use copy

            vals = thirdAlgo.thirdGetDiff(c);
            algPlace = vals[0];
            algCompare = vals[1];
            System.out.println("The number of actions been made for array in " + n + " size, with the third algorithm," +
                    " using quick sort is " + algCompare + " compares and " + algPlace + " placements");

            int[] d = A.clone();// we dont want to change the original array, so we use copy

            vals = FourthAlgo.fourthGetDiff(d);
            algPlace = vals[0];
            algChecks = vals[1];
            algIncrease = vals[2];
            System.out.println("The number of actions been made for array in " + n + " size, with the fourth algorithm," +
                    " using insertion sort is " + algPlace + " placements, " + algChecks + " checks and " + algIncrease + " increases");

            int[] e = A.clone();// we dont want to change the original array, so we use copy

            vals = FifthAlgo.fifthGetDiff(e);
            algChecks = vals[0];
            algHashes = vals[1];
            algPlace = vals[2];
            algCompare = vals[3];

            System.out.println("The number of actions been made for array in " + n + " size, with the fifth algorithm," +
                    " using hash table is " + algPlace + " placements, " + algChecks + " checks," + algCompare + " compares and " + algHashes + " hashes");

            int[] f = A.clone();// we dont want to change the original array, so we use copy

            vals = SixthAlgo.sixthGetDiff(f);
            algInsert = vals[0];
            algCompare = vals[1];
            algPlace = vals[2];
            System.out.println("The number of actions been made for array in " + n + " size, with the sixth algorithm," +
                    " using BTS is " + algInsert + " insertion, " + algCompare + " compares and " + algPlace + " placements");

            int[] g = A.clone();// we dont want to change the original array, so we use copy

            vals = SixthAlgo.sixthGetDiff(g);
            algInsert = vals[0];
            algCompare = vals[1];
            algPlace = vals[2];
            System.out.println("The number of actions been made for array in " + n + " size, with the seventh algorithm," +
                    " using RED-BLACK tree is " + algInsert + " insertion, " + algCompare + " compares and " + algPlace + " placements");

            System.out.println("please enter the size of array you want to check algorithms performance on, for exit please enter 0: ");
            n = scan.nextInt();// scan the wanted length for the array
            A = new int[n];// create the array
            rn = new Random();
            for (int i = 0;i < n; i++){
                A[i] = rn.nextInt(100);
            }// randomise the values in the array
        }//end of while

        System.out.println("Thank you for using our program, hope to see you soon again!");

    }//end of main
}// end of program