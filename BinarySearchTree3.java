import java.util.ArrayList;

public class BinarySearchTree3 {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=this.right=null;

        }
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        Node temp;

        public Info(boolean isBST,int size ,int min , int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }

        public Info(boolean isBST,Node temp ,int min , int max){
            this.isBST=isBST;
            this.temp=temp;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE , Integer.MIN_VALUE );
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size+rightInfo.size+1;
        int min = Math.min(root.data ,Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));

        if(root.data<=leftInfo.max || root.data >= rightInfo.min){
            return new Info(false,size,min,max);
        }
        if (leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(size ,maxBST);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }

    public static void preOrder(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void inOrder(Node root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
//    problem ->  Find largest BST in binar treee
    static class BSTInfo{
        Node largestBSTroot ;
        int size ;
        public BSTInfo(Node root , int size){
            this.largestBSTroot=root;
            this.size=size;
        }

    }
    public static BSTInfo LargestBSTinBT(Node root){
        if (root==null){
            return new BSTInfo(null,0);

        }

        BSTInfo leftInfo = LargestBSTinBT(root.left);
        BSTInfo rightInfo = LargestBSTinBT(root.right);

        if(leftInfo.largestBSTroot==root.left && rightInfo.largestBSTroot==root.right &&(root.left==null || root.data >leftInfo.largestBSTroot.data) && (root.right==null || root.data<rightInfo.largestBSTroot.data)){
            int size = leftInfo.size+rightInfo.size+1;
            return new BSTInfo(root,size);

        }else {
            return leftInfo.size> rightInfo.size ? leftInfo : rightInfo;

        }
    }

//    Day34
//    Problem - >

    public static void getInorder( Node root, ArrayList<Integer> inorder){
        if(root==null){
            return;
        }
        getInorder(root.left , inorder);
        inorder.add(root.data);
        getInorder(root.right , inorder);
    }

    public static Node mergeBST(Node root1 , Node root2){
//        step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1 ,arr1);
//        step2

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2 ,arr2);

//        merge
        int i=0,j=0;
        ArrayList<Integer> finalArr  = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if (arr1.get(i)<=arr2.get(j)){
                finalArr.add(arr1.get(j));
                i++;

            }else {
                finalArr.add(arr2.get(j));
                j++;

            }
        }
        while (i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;

        }
        while (j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;

        }
         return buildBalancedTree(finalArr,0,finalArr.size()-1);


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

    public static void main(String[] args) {
        /*

                         50
                      /     \
                     30     60
                    / \     / \
                   5   20  45  70
                              /  \
                             65   80
         */


        Node root= new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right=new Node(20);

        root.right = new Node(60);
        root.right.left= new Node(45);
        root.right.right=new Node(70);
        root.right.right.left= new Node(65);
        root.right.right.right=new Node(80);

//        largestBST(root);
//        System.out.println(" " + maxBST);
//        inOrder(root);

        BSTInfo result= LargestBSTinBT(root);
        System.out.println(result.largestBSTroot.data);
        inOrder(result.largestBSTroot);



    }


}
