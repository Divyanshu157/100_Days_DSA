public class Linklist2 {

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

    public static int size;
//    Adding element to first
    public void addFirst(int data)
    {
        Node newNode= new Node(data);
        size++;

        if(head==null)
        {
            head=tail=newNode;
            return;

        }
        newNode.next=head;
        head=newNode;
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head=tail=newNode;
            return;
        }
        tail.next= newNode;
        newNode=tail;

    }

    public void print()
    {
        Node temp= head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
//day 7 task  to check if list is palindrome steps are :--
//    1.find Mid Node of linked list
//    2.reverse the second half of linked list
//    3.check value of first half and second half

//    Find Mid of linkedlist

    public Node midNode(Node head)
    {
        Node mid;
        Node slow =head;
        Node fast =head;
        while(fast!=null&& fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;


    }

//

    public Boolean checkPalindrome()
    {
        if(head==null || head.next==null)
        {
            return true;
        }
//        find mid node of linked list
        Node mid = midNode(head);
//        reverse 2nd half of linked list

        Node prev= null;
        Node curr = mid;
        Node next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        Node right=prev;
        Node left=head;
//        check if equal
        while (right!=null)
        {
            if(left.data!=right.data)
            {
                return false;

            }
            left=left.next;
            right=right.next;

        }
        return true;


    }

    public static void main(String[] args) {
        Linklist2 ll = new Linklist2();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(1);
        ll.addFirst(0);
//        ll.addLast(12);
        ll.print();
        System.out.println();

        System.out.println(ll.checkPalindrome());





    }
}

