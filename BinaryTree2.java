import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree2 {


    static  class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right= null;


        }
    }



    public static int height(Node root){

//        calculate on basis of Nodes , If you want to calcuate by edges decrease by one
        if(root==null){
            return 0;
        }
        int lh= height(root.left);
        int rh= height(root.right);
        return Math.max(lh,rh) +1;


    }

    public static int count(Node root){
        if(root==null){
            return 0;

        }
        int lcount= count(root.left);
        int rcount = count(root.right);
        return lcount+rcount+1;

    }


    public static int sum(Node root){
        if(root==null){
            return 0;

        }
        int lSum=  sum(root.left);
        int rSum= sum(root.right);
        return  lSum+rSum+root.data;

    }

    public static int diameter(Node root){
        if(root==null){
            return 0;

        }
        int ldia = diameter(root.left);
        int rdia= diameter(root.right);
        int lh=  height(root.left);
        int rh= height(root.right);

        int self =  lh+rh+1;
        return Math.max(Math.max(ldia,rdia),self);

    }

    static class Info{
        int dia;
        int ht;

        public Info(int dia,int ht){
            this.dia= dia;
            this.ht=ht;

        }

    }
    public static Info diameter2(Node root){
        if(root==null){
            return new Info(0,0);

        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam= Math.max(Math.max(leftInfo.dia,rightInfo.dia),leftInfo.ht+rightInfo.ht+1);
        int ht  =Math.max(leftInfo.ht , rightInfo.ht);


        return new Info(diam,ht);



    }

    public static Boolean isSubtree(Node root ,Node subTree){
        if(root==null){
            return false;
        }
        if(root.data==subTree.data){
            if(isIdentical(root,subTree)) {
                return true;
            }
        }
        return isSubtree(root.left , subTree) || isSubtree(root.right,subTree);
    }
    public static Boolean isIdentical(Node node , Node subTree){
        if(node==null && subTree==null){
            return true;
        }else if(node ==null || subTree==null || node.data != subTree.data){
            return false;
        }
        if(!isIdentical(node.left , subTree.left)){
            return false;
        }
        if (!isIdentical(node.right , subTree.right)){
            return false;
        }
        return true;
    }

    public static void kLevel(Node root , int level ,int k){
        if(root==null){
            return;

        }
        if (level==k){
            System.out.print(root.data+" ");
            return;
        }
        kLevel(root.left,level+1,k);
        kLevel(root.right,level+1,k);

    }

//    day  27
//    problem 7  -> lowest common ancestor
    public static Node lca(Node root ,int n1 ,int n2){
        ArrayList<Node>  path1 = new ArrayList<>();
        ArrayList<Node>  path2  = new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if (path1.get(i) != path2.get(i)){
                break;
            }
        }

        return path1.get(i-1);
    }
    public static boolean getPath(Node root ,int n , ArrayList<Node> path){

        if(root==null){
            return false;
        }
        path.add(root);

        if(root.data == n){
            return true;
        }
        boolean foundLeft = getPath(root.left , n,path);
        boolean foundRight = getPath(root.right,n ,path);
        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

//    problem 8 -> lowest common ancestor
//    now this is solved with even better spacec complexity

    public static Node lca2(Node root ,int n1,int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;

        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;

        }
        return root;
    }

//    day28
//    Problem  9  ->  Minimum distance between two nodes
    public static int minDistance(Node root , int n1 ,int n2){

        Node lca = lca2(root,n1,n2);
        int dis1=distance(lca,n1);
        int dis2=distance(lca,n2);

        return  dis1+dis2;
    }
    public static int distance(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int ld= distance(root.left,n);
        int rd= distance(root.right,n);
        if(ld==-1 && rd==-1){
            return -1;
        }else if(ld==-1){
            return rd+1;
        }else {
            return ld+1;
        }

    }

//    problrm 10  ->  Kth ancestor of a node
    public static int kthAncestor(Node root, int n , int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDis = kthAncestor(root.left,n ,k);
        int rightDis= kthAncestor(root.right,n,k);

        if(leftDis ==-1 && rightDis==-1){
            return -1;

        }
        int max = Math.max(leftDis,rightDis);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transform(Node root ){
        if(root==null){
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChid = transform(root.right);
        int data = root.data;

        int newLeft  = root.left ==null ?0:root.left.data;
        int newRight = root.right ==null ? 0:root.right.data;

        root.data = newLeft+leftChild+newRight+rightChid;
        return data;
    }

    public static void preOrder(Node root ){
        if (root == null) {

            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {


        /*            1
                    /   \
                   2     3
                  / \   / \
                4    5 6   7

         */

        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
//        root.right.right.left=new Node(8);
//        root.right.right.right=new Node(9);


//        Node subTree = new Node(2);
//        subTree.left= new Node(4);
//        subTree.right= new Node(5);

//        root.left.left.left= new Node(8);


//        System.out.println(height(root));

//        According to edges
//        System.out.println("on basis of edges   "+(height(root)-1) );


//        System.out.println(count(root));
//        System.out.println(sum(root));
//        System.out.println(diameter(root));
//        System.out.println(diameter2(root));
//        System.out.println(isSubtree(root,subTree));
//        kLevel(root,1,3);
//        System.out.println(lca(root , 2,5).data);
//        System.out.println(lca(root,4,5).data);
//        System.out.println(lca2(root,6,7).data);
//        System.out.println(minDistance(root,4,9));
//        System.out.println(root.right.right.right.data);
//        kthAncestor(root,9,1);

        transform(root);
        preOrder(root);

    }
}
