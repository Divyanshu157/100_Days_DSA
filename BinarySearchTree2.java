import java.util.ArrayList;

public class BinarySearchTree2 {


//    Day 32
    static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;

    }
}
        public static Node buildBST(int data,Node root){
            if(root==null){
                return new Node(data);
            }
            if(root.data>data){
                root.left = buildBST(data,root.left);
            }else {
                root.right = buildBST(data,root.right);
            }
            return root;
        }

        public static void inOrder(Node root){
            if(root==null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

    public static Node mirrorBST(Node root){
        if (root==null){
            return null;
        }
        Node leftS = mirrorBST(root.left);
        Node rightS = mirrorBST(root.right);

        root.left = rightS;
        root.right=leftS;

        return root;
    }

//    problem second of day32  creating BST with minimum possible height

    public static Node buildBSTSortedCollection(int arr[] , int start , int end){
        if(start>end)
        {
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = buildBSTSortedCollection(arr , start,mid-1);
        root.right = buildBSTSortedCollection(arr,mid+1,end);
        return root;

    }
//    problem  -> calculate height of binary tree
    public static int  height(Node root){

        if(root == null ){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;


    }

//    problem -> transform a tree into balanced tree
    public static Node balancedTree(Node root){

//        Step 1 store inorder of BST  in ArrayList

        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root , inorder);
//        Step 2

        root=  buildBalancedTree(inorder,0,inorder.size()-1);
        return root;

    }
    public static Node buildBalancedTree(ArrayList<Integer> inorder , int start , int end){
        if(start>end) {
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left= buildBalancedTree(inorder , start,mid-1);
        root.right=buildBalancedTree(inorder,mid+1,end);
        return root;
    }
    public static void getInorder(Node root,ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        getInorder(root.left , inorder);
        inorder.add(root.data);
        getInorder(root.right , inorder);
    }


//    preOrder
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

        public static void main(String args[]){

//            int values[] ={ 8,5,3,1,4,6,10,11,14};
//            Node root = null;
//            for (int i=0;i<values.length;i++){
//                root = buildBST(values[i] ,root);
//            }

//          mirrorBST(root);
//            inOrder(root);
//
//            int arr[] ={ 1,2,3,4,5,6,7,8};
//            buildBSTSortedCollection(arr , 0,arr.length-1);
//
//            inOrder(root);
//            System.out.println();
//            printRootToLeaf(root,new ArrayList<>());
//            System.out.println(height(root));


//            problem to transform unbalanced binary tree to balnced tree
//            ------------------------X------------------------

            Node root = new Node(8);
            root.left = new Node(7);
            root.left.left = new Node(6);
            root.left.left.left = new Node(5);
            root.right = new Node(9);
            root.right.right = new Node(10);
            root.right.right.right = new Node(11);
            preOrder(root);
//                          8
//                        /   \
//                       7     9
//                     /        \
//                    6           10
//                   /             \
//                  5               11


            root=balancedTree(root);
            System.out.println();
            preOrder(root);
//            -------------------------------------X------------------------------

        }
}
