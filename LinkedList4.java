public class LinkedList4 {
    public static class Node{
        int data;
        Node next;
        public  Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;


    public  void addFirst(int data)
    {
//        Create the node
        Node newNode = new Node(data);
        size++;
        if(head==null)
        {
            head=tail=newNode;

            return;
        }
//        assign head as next of new node
        newNode.next= head;
//       new node is the head
        head=newNode;
    }
//Merge Sort in linked list O(nlogn)   ->cm-plexcity

    private Node getMid(Node head)
    {
       Node slow = head;
        Node fast= head.next;

        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }
    private Node merge(Node head1, Node head2)
    {
        Node mergedll = new Node(-1);
        Node temp = mergedll;

        while (head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;


            }
            else
            {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;

            }

        }
        while (head1!=null)
        {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;

        }
        while (head2!=null)
        {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;

        }
        return mergedll.next;

    }


    public  void zigZag()
    {
//        find mid of linked list
        Node slow = head;
        Node fast= head.next;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }
        Node mid = slow;




//        reverse the 2nd half of linked lst

        Node curr = mid.next;
        mid.next=null;
        Node prev= null;
        Node next;
        while (curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev= curr;
            curr=next;

        }

        Node left=head;
        Node right=prev;
        Node nextL , nextR;

//        alt merge - zig zag merge
        while (left!=null && right!=null)
        {
            nextL=left.next;
            left.next= right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;

        }



    }


    public Node mergeSort(Node head)
    {
        if(head==null ||head.next==null)
        {
            return head;
        }
//      get middle of linked list
        Node mid= getMid(head);

//        divide linked list in left and right half
        Node righthead = mid.next;
        mid.next=null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(righthead);
//        merge
        return merge(newLeft,newRight);

    }

    public static void print()
    {
        Node temp= head;
        while(temp!=null)

        {
            System.out.print(temp.data+"->");
            temp=temp.next;

        }
        System.out.print("null");
        System.out.println();

    }
    public static void main(String[] args) {

        LinkedList4 ll = new LinkedList4();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(7);
        ll.print();

//        head=ll.mergeSort(head);
//        ll.zigZag();
//        ll.print();
        ll.zigZag();
        ll.print();





    }
}
