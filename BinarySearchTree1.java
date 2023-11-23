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


    public static void main(String[] args) {
        int values[] ={ 8,5,3,1,4,6,10,11,14};
        Node root= null;

        for (int i=0;i<values.length;i++){
           root = insert(root ,values[i]);
        }
        delete(root,1);
        delete(root,10);

        inOrder(root);

//        System.out.println(search(root,5));




    }

}
