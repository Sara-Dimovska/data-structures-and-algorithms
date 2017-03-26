package stebla;

public class Stack 
{
	private int size;
    private int emptyStack;
    private int top;
    private TNode[] items;
    
    public Stack(int size)//constructor
    {
    	this.size = size;
    	emptyStack=-1;
    	top = emptyStack;
        items = new TNode[size];
     }
   public boolean empty()  
   {
       return top == emptyStack;
   }
   public boolean full()
   {
	   return top == size;
   }
   public TNode top()
   {
	   return items[top];
   }
   public void push(TNode node)
   {
      items[++top] = node;
   }
   public TNode pop()
   {  
   		return items[top--];
   }

}
