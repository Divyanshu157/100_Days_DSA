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
//        root.left.left.left= new Node(8);


//        System.out.println(height(root));

//        According to edges
//        System.out.println("on basis of edges   "+(height(root)-1) );


//        System.out.println(count(root));
//        System.out.println(sum(root));
//        System.out.println(diameter(root));
        System.out.println(diameter2(root));


    }
}
