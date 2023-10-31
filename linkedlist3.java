public class linkedlist3 {

    public static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;

        }

    }
    public static Node head;
    public static Node tail;

    public static Boolean isCycle()
    {
        Node slow =head;
        Node fast =head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
            {
                return true;
            }
        }
        return  false;

    }
// to remove Cycle from a linked list ->  this is not valid for corner case eg..   if last node is connected to head node
// then this will not remove Cycle from linked list

//    Steps
//    1.Detct the cycle
//    2.detect the meeting points
//    3.assign null value to prev Node
    public static void removeCycle()
    {
    //Detcting if  cycle exits
        Node slow =head;
        Node fast =head;
        Boolean cycle = false;

        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
            {
                cycle=true;
                break;
            }
        }
        if(cycle=false)
        {
            return;
        }
    // detecting meeting points

        slow=head;
        Node prev= null;
        while (slow!=fast)
        {
            prev=fast;
            slow=slow.next;

            fast=fast.next;

        }

//        assign last  node to null
        prev.next=null;

    }

    public static void main(String[] args) {
        head=new Node(1);
        Node temp =new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;

//        1->2->3->2

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());

    }
}
