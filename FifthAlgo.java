/*
created by Avi Fenesh
this program checks how much actions we do while using hash table for finding how much different values there is in a given array
the idea of the hash algorithm is to go throw the given array, send every object to the hash function
then go to the table and check if the fitting cell is empty,
if empty, increase the counter, else check if the object at the cell is equal to the one we have,
if equal we move to the next one, else we hashing it another time and do everything again atc.
we use counter to check how much hashing action we do, how much empty checks we do, how much compare we do and how much placements we do
 */
public class FifthAlgo {

    static int checksCounter = 0;// count the checks actions
    static int hashCounter = 0;// count the hash actions
    static int placementCounter = 0;// count the placements actions
    static int compareCounter = 0;// count the placement actions

    public static int[] fifthGetDiff(int[] A) {
        int i;//index for for-loops
        int [] hash_table = new int[2*A.length];//hash-table
        int [] vals = new int[4];
        int counter = 0;// count the different values

        for(i = 0; i<hash_table.length; i++){//the values we expect are positive so -1 is a sign of empty cell
            hash_table[i] = -1;
        }

        for (i = 0; i < A.length; i++){//counting the different values by using the result of the hash method
            counter += hash(A[i], hash_table, 1);
        }

        vals[0] = checksCounter;
        vals[1] = hashCounter;
        vals[2] = placementCounter;
        vals[3] = compareCounter;
        return vals;//return the actions counters
    }//end of main func

    /*
    the hash method use recursion, every time we hash again we increase k by one and checks the suitable cell
    k represent the hash iteration, i represent the value of the checked object
    the hash methode is (i + k) mod hash-table length
    */
    public static int hash(int i, int[] hash_table, int k){
        compareCounter ++;
        if (k>hash_table.length) {
            System.out.println("tha hash table full, please try with suitable hash-table");
            return 0;
        }
        int j = ((i+k)%hash_table.length);//hash method
        hashCounter ++;//for using hash method
        checksCounter ++;//for if
        if (hash_table[j]==-1){//if the cell is empty
            placementCounter++;//for placement of new cell
            hash_table[j] = i;
            return 1;
        }
        else{
            compareCounter++;//for if
            if (hash_table[j]==i)//if the value in the hash-table equal to the one we check
                return 0;
            else return hash(i, hash_table, ++k);//if not equal and not empty' hash again
        }
    }//end of hash
}//end of program
