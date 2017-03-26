package jazli;

public class SinglyLinkedList {
	
	public  Node rotateRight(Node head)
	{
        Node prev = null;
        Node current = head;
        while (current.next != null) 
          {
               prev = current;
               current = current.next;
          }
        current.next = head;//povrzuva so pocetoko
        head = current;
        prev.next = null;//pretvodniko e krajo
     return head;
	}
	public Node rotateLeft(Node head)
	{
		Node current = head;
        Node temp;
		while(current.next != null)
		{
			current = current.next;
		}
		temp = head;
		current.next = temp;
		head = head.next;
		temp.next = null;
		return head;		
		
	}
	public Node copyList(Node head)
	{
		Node copyHead = new Node();
		Node copyTail = new Node();
		for(Node n= head;n != null;n=n.next)
		{
			Node newNode = new Node(n.value);
			if(copyHead == null)
			{
				copyHead = newNode;
				copyTail = copyHead;
			}
			else
			{
				copyTail.next = newNode;
				copyTail = newNode;
			}
		}
		return copyHead;
	}
	public Node reverseNode(Node head)
	{
		Node prev = new Node();
		Node current = head;
		Node next = new Node();
		while (current != null)
		{
			
		    next = current.next;
			current.next = prev;//povrzuva
			prev = current;//prev e na mestoto na current
			current = next;//current se pomeste na next
		}		
		
		return prev;
			
	}
   
	public Node insertAtBegining(Node head,int value)
	{
		Node newNode = new Node(value);
		
		newNode.next = head;
		head = newNode;
		return head;
	
	}
	public Node insertAtEnd(Node head,int value)
	{
		Node newNode = new Node(value);
		if(head.next == null)
		{
			head.next = newNode;
			return head;
		}
		
		Node current = head;
		while(current.next != null)
			current=current.next;
		
		current.next = newNode;
		return head;
		
	}
	public Node insertAtPosition(Node head,int index,int value)
	{
		
		if(index < 0 || index > dolzinaLista(head))
			{
			  System.err.println("Invalid index");
			  return head;
			}
		
		Node newNode = new Node(value);
		if(index == 0)
		{
			newNode.next=head;
			head = newNode;
			return head;
		}
		if (index == 1)
		{
			head.next = newNode;
			return head;
		}
		else
		{
			Node prethodnik = head;
			int count=1;
			while(count < index-1)
			{
				prethodnik = prethodnik.next;
				count++;
			}
			newNode.next = prethodnik.next;
			prethodnik.next = newNode;
			return head;	
		}
	
	}
	public Node deleteNode(Node head,int index)
	{
		Node removedNode = null;
		if(index <0 || index > dolzinaLista(head))
		{
			System.err.println("Invalid index");
			return head;
		}
		if(index == 0)//za head
		{
			removedNode = head;
			head = head.next;
			removedNode.next = null;
			return head;
		}
		else
		{
			Node prethodnik = head;
			int count=1; 
			while(count < index-1 )
			{
				prethodnik = prethodnik.next;
				count++;
			}
			removedNode = prethodnik.next;
			prethodnik.next = removedNode.next;
			removedNode.next = null;
			return head;
			
		}
	}
	public int dolzinaLista(Node head)
	{
		if(head.next == null)
			return 0;
		int count=1;
		Node current = head;
		while(current.next != null)
		{
			current = current.next;
			count++;
		}
		return count;
			
	}
    public void print(Node head)
    {
    	if(head.next == null)
    		return;
    	
    	Node current = head;
    	
    	while(current != null)
    	{
    		System.out.print(current.value + " --> ");
    		current=current.next;
    	}
    	System.out.println(current);//null
    }
}
