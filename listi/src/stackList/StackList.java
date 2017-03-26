package stackList;

public class StackList implements Stack{
	
	private Node top;
	
	public StackList()//contructor
	{
		top = null;
	}
	public boolean isEmpty()
	{
		return top == null;
	}
public void push(int value) //PUSH
{
	Node node = new Node(value);
	node.next = top;
	top = node;
}
public int pop() //POP
{
	if(top == null)
		{ System.err.println("No elements");
	      return 0;
		}
		int temp = top.value;
		top = top.next; 	
		return temp;
}
public void display()
{
	if(top == null)
		System.err.println("Empty stack");
	Node current = top;
	while(current != null)
	{
		System.out.println(current.value  + " ");
		current = current.next;
	}

}
public static void main(String [] args)
{
	StackList list = new StackList();
	//list.display();
	//list.pop();
	
	list.push(1);
	list.push(2);
	list.push(3);
	list.push(4);
	
	int deleted = list.pop();
	//list.pop();
	System.out.println("Deleted:" + deleted);
	 list.display();
		
}
}






