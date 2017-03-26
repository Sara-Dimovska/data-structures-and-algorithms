package doubleLinked;

public class Node 
{
   public int value;
   public Node prev;
   public Node next;
   
   public Node(){}
   public Node(int value)
   {
	   prev = null;
	   this.value = value;
	   next = null;
   }
   public Node (Node prev,int value,Node next)
   {
	   this.prev = prev;
	   this.value = value;
	   this.next = next;
   }
	
}
