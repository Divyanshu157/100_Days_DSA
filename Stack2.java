public class Stack2 {

//    Implementation of stack using Linked list

      public static class Node {
         int data;
         Node next;

         Node(int data) {
             this.data = data;
             this.next = null;
         }
     }

         static class Stack{
             static Node head=null;

             public static boolean isEmpty()
             {
                 return head==null;
             }
//             push
             public static void push(int data)
             {
                 Node newNode= new Node(data);
                 if(isEmpty())
                 {
                     head=newNode;
                     return;
                 }


                 newNode.next=head;
                 head=newNode;

             }
             public static int pop()
             {
                 if(head==null)
                 {
                     System.out.print("stack is empty\n");
                     return -1;
                 }
                 int top = head.data;
                 head=head.next;
                 return top;
             }
             public static int peek()
             {
                 if(isEmpty())
                 {
                     System.out.println("empty hai");
                     return -1;
                 }
                 int top= head.data;
                 return top;
             }

         }

    public static void main(String[] args) {

          Stack s = new Stack();
          s.push(1);
          s.push(2);
          s.push(3);

//          while(!s.isEmpty())
//          {
//              System.out.println(s.peek());
//              s.pop();
//          }
//          s.peek();

          Stack s2= new Stack();
          s2.push(4);
          s2.push(5);
          s2.push(6);
          while(!s.isEmpty())
          {
              System.out.println(s.peek());
              s.pop();
          }









    }
}
