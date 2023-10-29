

public class LinkedList {

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

    public  void addLast(int data)
    {
        Node newNode =  new Node(data);
        size++;
        while (head==null)
        {
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void addToIndex(int idx,int data)
    {
        if(idx==0)
        {
            addFirst(data);
            return;
        }
        Node newNode= new Node(data);
        size++;

        Node temp = head;

        int i=0;
        while(i<idx-1)
        {

            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;


    }

    public  void taceList()
    {
       if(head==null)
       {
           System.out.println("Empty list is there\n");
       }
       Node temp=head;
       while(temp!=null)
       {
           System.out.print(temp.data + " ");
           temp = temp.next;
       }
        System.out.println();
    }


    public int removeFirst()
    {
        if (size==0)
        {
            System.out.println("Empty llist\n");
            return Integer.MIN_VALUE;

        } else if (size==1) {
            int val=head.data;
            head=tail=null;
            size=0;
            return val;

        }
        int val= head.data;
        head=head.next;
        size--;

        return val;

    }
    public int removeLast()
    {
        if(size==0)
        {
            System.out.println("empty list\n");
            return Integer.MIN_VALUE;

        }
        else if (size==1) {
            head = tail = null;
            size=0;
            return head.data;

        }
        Node prev = head;
        for(int i=0;i<size-2;i++)
        {
            prev=prev.next;

        }
        int val=prev.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;

    }

    public  int search(int key)
    {
        Node temp=head;
        int i=0;
        while (temp!=null)
        {
            if(temp.data==key)
            {
                return i;
            }
            i++;
            temp=temp.next;
        }
        return -1;
    }

    public int helper(Node head,int key)
    {
        if(head==null)
        {
            return -1;
        }
        if(head.data==key)
        {
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1)
        {
            return -1;
        }
        return idx+1;
    }

    public void reverse()
    {
        Node prev =null;
        Node curr =tail=head;
        Node next;

        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public int recSearch(int key)

    {
        return helper(head,key);
    }

    public void removeToIdx(int n)
    {
        int sz=0;
        Node temp = head;
        while(temp!=null)
        {
            temp=temp.next;
            sz++;

        }
        if(sz==n)
        {
            head=head.next;
            return;
        }
        int i=1;
        int idx = size-n;
        Node prev = head;

        while(i<idx)
        {
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }


    public static void main(String [] args)
    {
//        LinkedList ll = new LinkedList();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addFirst(3);
//        ll.addLast(4);
//        ll.taceList();

        LinkedList ll2= new LinkedList();
        ll2.addLast(4);
        ll2.taceList();
        ll2.addLast(3);
        ll2.taceList();
        ll2.addLast(2);
        ll2.taceList();
        ll2.addLast(1);
        ll2.taceList();
        ll2.addToIndex(1,10);
        ll2.taceList();
        ll2.removeFirst();
        ll2.taceList();
        ll2.removeLast();
        ll2.taceList();

//        System.out.println(size);
//        System.out.println(ll2.search(10));
//        System.out.println(ll2.recSearch(2));
//        ll2.reverse();
        ll2.removeToIdx(3);
        ll2.taceList();


    }
}
