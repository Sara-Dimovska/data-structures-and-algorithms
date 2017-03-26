package construct;



public class Stack 
{
	private int size;
    private int emptyStack;
    private int top;
    private Node[] items;
    
    public Stack(int size)//constructor
    {
    	this.size = size;
    	emptyStack=-1;
    	top = emptyStack;
        items = new Node[size];
     }
   public boolean empty()  
   {
       return top == emptyStack;
   }
   public boolean full()
   {
	   return top == size;
   }
   public Node top()
   {
	   return items[top];
   }
   public void push(Node node)
   {
      items[++top] = node;
   }
   public Node pop()
   {  
   		return items[top--];
   }

}