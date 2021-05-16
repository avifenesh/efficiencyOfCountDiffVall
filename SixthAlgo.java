/*
create by Avi Fenesh
this program check how much actions we do while using BTS for algorithm who check how much different values there in array
the idea is to insert all the array into BTS' while every time we find that the same value is already exist we return, and if not we add it and count
we check how much insert action, placement action and compare action we do while working with the algorithm
 */

public class SixthAlgo {

    static int insertCounter = 0;// count the insert actions
    static int placementCounter = 0;// count the placements actions
    static int compareCounter = 0;// count the placement actions
    static int result = 0;//count the different value in the array

    /* Class containing left
       and right child of current node
     * and key value*/
    class Node
    {
        int key;
        SixthAlgo.Node left, right;

        public Node(int item)
        {
            placementCounter ++;
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    SixthAlgo.Node root;

    // Constructor
    SixthAlgo()
    {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to
       insert a new key in BST */
    SixthAlgo.Node insertRec(SixthAlgo.Node root, int key)
    {

        /* If the tree is empty,
           return a new node */
        compareCounter ++;
        if (root == null)
        {
            insertCounter ++;
            result ++;
            root = new SixthAlgo.Node(key);
            return root;
        }
        // if equal value - we dont add to the BTS
        compareCounter ++;
        if (key == root.key){
            return root;
        }

        /* Otherwise, recur down the tree */
        compareCounter ++;
        if (key < root.key){
            root.left = insertRec(root.left, key);
            compareCounter ++;}
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }
    public static int[] sixthGetDiff(int[] A){
        int [] vals = new int[3];
        //construct the tree
        SixthAlgo tree = new SixthAlgo();
        //insert all the array to the tree
        for (int i = 0; i<A.length; i++){
            tree.insert(A[i]);
        }
        //return the actions been made values
        vals[0] = insertCounter;
        vals[1] = compareCounter;
        vals[2] = placementCounter;
        return vals;

    }
}
