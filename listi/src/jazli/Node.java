package jazli;

public class Node
{
	public int value;
	public Node next;
	public Node()
	{
	    value=0;
		next=null;
	}
	public Node(int value)//constructor
	{
		this.value=value;
		this.next=null;
	}
public static void main(String [] args)
{
	Node head=new Node(10);
	Node second=new Node(15);
	Node third=new Node(25);
	
	head.next=second;
	second.next=third;
	
	
	SinglyLinkedList list= new  SinglyLinkedList();
	list.print(head);
    
    Node newHead = list.insertAtBegining(head, 5);
    list.print(newHead);
    
    list.insertAtEnd(newHead,30);
    list.print(newHead);
			
     newHead = list.insertAtPosition(newHead,4, 20);
     list.print(newHead);
    
     newHead = list.deleteNode(newHead,4);
     list.print(newHead);
     
      //newHead =  list.deleteNode(newHead, 0);
      //list.print(newHead);
      
     newHead = list.reverseNode(newHead);
     //list.print(newHead);
     
    // newHead =  list.rotateLeft(newHead);
     list.print(newHead);
     
}
}
