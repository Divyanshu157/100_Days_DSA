import java.util.ArrayList;

public class BinarySearchTree1 {

//    what is BST?
//    ->  It is also a  Binary Tree
//    -> Left Subtree Nodes < Root
//    -> Right subtree Nodes >root
//    -> left subtree and right subtree  are also BST with no duplicates.
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return root =new Node(data);
        }
        if(root.data>data){
            root.left=insert(root.left, data);

        }else {
            root.right=insert(root.right,data);

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

    public static boolean search(Node root , int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        } else if (root.data>key)
        {
           return search(root.left,key);

        }else {
            return search(root.right,key);
        }
    }

    public static Node delete(Node root , int key){
        if(root.data<key){
            root.right= delete(root.right,key);
        }else if(root.data>key){
            root.left=delete(root.left,key);
        }
        else {
//            case 1 leaf node delete
            if (root.right == null && root.left == null) {
                return null;
            }
//            case 2 node with single child
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;

            }

            Node IS = findInorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
    return root;
    }
    public static Node findInorderSuccesor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;

    }


//    Day 31 Problems of BST
    public static void printRange(Node root , int k1 , int k2){
        if (root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printRange(root.right,k1,k2);
        }else if (root.data<k1){
            printRange(root.left,k1,k2);
        }else {
            printRange(root.right,k1,k2);
        }

    }

//    problem 7

    public static void printRootToLeaf(Node root, ArrayList<Integer> path ){

        if (root==null){
            return;
        }
        path.add(root.data);

        if (root.left==null && root.right==null){
            printPath(path);

        }
        printRootToLeaf(root.left,path);
        printRootToLeaf(root.right,path);
        path.remove(path.size()-1);

    }
    public static void printPath(ArrayList<Integer> path){
        for (int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.print("Null");
        System.out.println();
    }
//
//problem 8

    public static boolean isValidBST(Node root, Node min , Node max){
        if (root == null) {

            return true;
        }
        if (min!=null && root.data<=min.data){
            return false;
        } else if (max!=null && root.data>=max.data){
            return false;
        }
        return isValidBST(root.left , min,root) && isValidBST(root.right ,root,max);


    }
    public static void main(String[] args) {
        int values[] ={ 8,5,3,1,4,6,10,11,14};
        Node root= null;

        for (int i=0;i<values.length;i++){
           root = insert(root ,values[i]);
        }
//        delete(root,1);
//        delete(root,10);

        inOrder(root);
        System.out.println();
//        printRange(root,5,12);

//        System.out.println(search(root,5));
//        printRootToLeaf(root,new ArrayList<>());

        System.out.println(isValidBST(root,null,null));

    }

}
