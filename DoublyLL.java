import com.sun.security.jgss.GSSUtil;

public class DoublyLL {

    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
            this.prev=null;
        }



    }
    public static Node head;
    public static Node tail;
    public static int size;

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
        head.prev=newNode;
        head=newNode;

    }

    public void addLast(int data)
    {
        Node newNode =  new Node(data);
        size++;
        if(head==null)
        {
            head=tail=newNode;
            return;
        }
        Node temp;
        temp=head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=null;
        newNode.prev=temp;

    }
    public void print()
    {
        Node temp = head;
        while (temp!=null)
        {
            System.out.print(temp.data+"<->");
            temp=temp.next;

        }
        System.out.print("null\n");

    }

    public void addToIndex(int index,int data)
    {
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        while (index>0)
        {
            temp=temp.next;
            index--;
        }
        newNode.next=temp.next;
        newNode.prev=temp;
        temp.next=newNode;
        temp.next.prev=newNode;

    }

    public int removeLast()
    {
        if(head==null)
        {
            System.out.print("linked list is empty\n");
            return Integer.MIN_VALUE;

        }
        if(size==1)
        {
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node Last;
        Last =head;
        while (Last.next.next!=null)
        {
            Last=Last.next;

        }
        int val= Last.next.data;
        Last.next=null;
        size--;

        return val;

    }

    public int removeFirst()
    {
        if(head==null)
        {
            System.out.print("empty linked list\n");
            return Integer.MIN_VALUE;
        }
        if(size==1)
        {
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }

    public int removeIndex(int index)
    {
        if(head==null)
        {
            System.out.print("your doubly linke list is emopty\n");
            return  Integer.MIN_VALUE;

        }
        if(size==1)
        {
            removeFirst();

        }
        Node temp1=head;
        Node temp2=head.next;


        while (index>1)
        {
            temp1=temp1.next;
            temp2=temp2.next;
            index--;
        }
        int val=temp2.data;
        temp1.next=temp2.next;
        temp2.next.prev=temp1;
        size--;
        return val;


    }

    public static void main(String[] args) {
        DoublyLL dll=new DoublyLL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.print();
//        dll.removeFirst();
//        dll.removeFirst();
//        dll.removeFirst();
//        dll.removeFirst();
//        dll.removeFirst();
        dll.addLast(10);
        dll.addLast(11);
        dll.addToIndex(2,13);
        dll.removeFirst();
        dll.removeLast();
        dll.print();
        dll.removeIndex(2);
        dll.print();
//        System.out.println(size);
//        System.out.println(head);



    }
}
