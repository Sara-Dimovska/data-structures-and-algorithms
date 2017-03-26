package queueList;

public class QueueList implements Queue
{

	Node first;
	Node last;
	
	public QueueList(){first = null;} //constructor
	public boolean isEmpty()
	{
		return first == null;
	}
	public void set(int value) 
	{
	 Node node = new Node(value);	
	 if(first == null)
	   {   first = node;
	       last = node;
	       return;
	   }
	  last.next = node;
	  last = node;
	}
	public int delete()
	{
        if(first == null)
            System.err.println("Empty queue");
        
        int temp = first.value;
        first = first.next;
        return temp;

	}
	public void displayList() 
	{  
		if(first == null)
			System.err.println("Empty queue");
		
        Node current = first;
        while (current != null) 
        {
        	System.out.print(current.value  + " ");
            current = current.next;
        }
    }
	public static void main(String [] args)
	{
		QueueList list = new QueueList();
		list.set(1);
		list.set(2);
		list.set(3);
		list.set(4);
		
		int delete = list.delete();
		System.out.println("Deleted:" + delete);
	
		list.displayList();
		
	}
}
