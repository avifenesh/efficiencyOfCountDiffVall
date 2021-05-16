/*
create by Avi Fenesh
this program check how much actions we do while using Red-Black tree for algorithm who check how much different values there in array
the idea is to insert all the array into RED-BLACK tree while every time we find that the same value is already exist we return, and if not we add it and count
we check how much insert action, placement action and compare action we do while working with the algorithm
 */
public class SeventhAlgo {

    SeventhAlgo leftChild, rightChild;
    int element;
    int color;

    //constructor to set the value of a node having no left and right child
    public SeventhAlgo(int element)
    {
        this( element, null, null );
    }

    //constructor to set value of element, leftChild, rightChild and color
    public SeventhAlgo(int element, SeventhAlgo leftChild, SeventhAlgo rightChild)
    {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        color = 1;
    }
}

//create class CreateRedBlackTree for creating red-black tree
class CreateRedBlackTree
{
    static int insertCounter = 0;// count the insert actions
    static int placementCounter = 0;// count the placements actions
    static int compareCounter = 0;// count the placement actions
    static int result = 0;//count the different value in the array

    private static SeventhAlgo nullNode;   //define null node
    private SeventhAlgo current;   //define current node
    private SeventhAlgo parent;    //define parent node
    private SeventhAlgo header;   // define header node
    private SeventhAlgo grand; //define grand node
    private SeventhAlgo great; //define great node

    //create two variables, i.e., RED and Black for color and the values of these variables are 0 and 1 respectively.
    static final int RED   = 0;
    static final int BLACK = 1;

    // using static initializer for initializing null Node
    static
    {
        insertCounter ++;//for insertion of first node
        placementCounter += 2;//for placement of childes
        nullNode = new SeventhAlgo(0);
        nullNode.leftChild = nullNode;
        nullNode.rightChild = nullNode;
    }


    // Constructor for creating header node
    public CreateRedBlackTree(int header)
    {
        placementCounter += 3;//for head and childes placements
        this.header = new SeventhAlgo(header);
        this.header.leftChild = nullNode;
        this.header.rightChild = nullNode;
    }

    // create removeAll() for making the tree logically empty
    public void removeAll()
    {
        placementCounter++;//for placement as a null
        header.rightChild = nullNode;
    }

    //create method checkEmpty() to check whether the tree is empty or not
    public boolean checkEmpty()
    {
        compareCounter ++;//for check if empty
        return header.rightChild == nullNode;
    }

    //create insertNewNode() method for adding a new node in the red black tree
    public void insertNewNode(int newElement )
    {
        placementCounter += 4;//for all of the placements down here
        current = parent = grand = header;      //set header value to current, parent, and grand node
        nullNode.element = newElement;          //set newElement to the element of the null node

        //repeat statements until the element of the current node will not equal to the value of the newElement
        compareCounter++;//for last compare in the while loop
        while (current.element != newElement)
        {
            compareCounter++;//for every while question
            placementCounter += 4;//for all of the placements down here
            great = grand;
            grand = parent;
            parent = current;

            //if the value of the newElement is lesser than the current node element, the current node will point to the current left child else point to the current right child.
            current = newElement < current.element ? current.leftChild : current.rightChild;

            // Check whether both the children are RED or NOT. If both the children are RED change them by using handleColors() method
            compareCounter ++;//for if
            if (current.leftChild.color == RED && current.rightChild.color == RED)
                handleColors( newElement );
        }

        // insertion of the new node will be fail if will already present in the tree
        compareCounter ++;//for if
        if (current != nullNode)
            return;

        //create a node having no left and right child and pass it to the current node
        insertCounter ++;//for the insertion of new element
        result ++;// we insert nwe node, that mean this value did not exist in the previous values at the array
        current = new SeventhAlgo(newElement, nullNode, nullNode);

        //connect the current node with the parent
        compareCounter ++;//for if
        placementCounter ++;//for the placement that we do after if
        if (newElement < parent.element)
            parent.leftChild = current;
        else
            parent.rightChild = current;
        handleColors( newElement );
    }

    //create handleColors() method to maintain the colors of Red-black tree nodes
    private void handleColors(int newElement)
    {
        placementCounter+=3;//for all of the placements down here
        // flip the colors of the node
        current.color = RED;    //make current node RED
        current.leftChild.color = BLACK;    //make leftChild BLACK
        current.rightChild.color = BLACK;   //make rightChild BLACK

        //check the color of the parent node
        compareCounter++;//for if
        if (parent.color == RED)
        {
            // perform rotation in case when the color of parent node is RED
            placementCounter++;////for the placements down here
            grand.color = RED;

            compareCounter +=3;//for 3 question at the if
            if (newElement < grand.element && grand.element != newElement && newElement < parent.element)
                placementCounter ++;//for all of the placements down here
                parent = performRotation( newElement, grand );  // Start dbl rotate
            placementCounter += 2;//for all of the placements down here
            current = performRotation(newElement, great );
            current.color = BLACK;
        }

        // change the color of the root node with BLACK
        placementCounter ++;
        header.rightChild.color = BLACK;
    }

    //create performRotation() method to perform dbl rotation
    private SeventhAlgo performRotation(int newElement, SeventhAlgo parent)
    {
        //check whether the value of the newElement is lesser than the element of the parent node or not
        compareCounter ++;//for if
        placementCounter ++;//for the option that made
        if(newElement < parent.element)
            //if true, perform the rotation with the left child and right child based on condition and set return value to the left child of the parent node
            return parent.leftChild = newElement < parent.leftChild.element ? rotationWithLeftChild(parent.leftChild) : rotationWithRightChild(parent.leftChild) ;
        else
            //if false, perform the rotation with the left child and right child based on condition and set return value to the right child of the parent node
            return parent.rightChild = newElement < parent.rightChild.element ? rotationWithLeftChild(parent.rightChild) : rotationWithRightChild(parent.rightChild);
    }

    //create rotationWithLeftChild() method  for rotating binary tree node with left child
    private SeventhAlgo rotationWithLeftChild(SeventhAlgo node2)
    {
        placementCounter +=3;//for all of the placements down here
        SeventhAlgo node1 = node2.leftChild;
        node2.leftChild = node1.rightChild;
        node1.rightChild = node2;
        return node1;
    }

    // create rotationWithRightChild() method for rotating binary tree node with right child
    private SeventhAlgo rotationWithRightChild(SeventhAlgo node1)
    {
        placementCounter += 3;//for all of the placements down here
        SeventhAlgo node2 = node1.rightChild;
        node1.rightChild = node2.leftChild;
        node2.leftChild = node1.leftChild;
        return node2;
    }

    public static int[] seventhGetDiff(int[] A){
        int [] vals = new int[3];
        //construct the tree
        CreateRedBlackTree tree = new CreateRedBlackTree(Integer.MIN_VALUE);
        //insert all the array to the tree
        for (int i = 0; i<A.length; i++){
            tree.insertNewNode(A[i]);
        }
        //return the actions been made values
        vals[0] = insertCounter;
        vals[1] = compareCounter;
        vals[2] = placementCounter;
        return vals;

    }
}
