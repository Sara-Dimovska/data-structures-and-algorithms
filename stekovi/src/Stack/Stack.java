package Stack;

import java.io.*;

public class Stack 
{
	private int size;
    private int emptyStack;
    private int top;
    private char[] items;
    
    public Stack(int size)//constructor
    {
    	this.size = size;
    	emptyStack=-1;
    	top = emptyStack;
        items = new char[size];
     }
    public boolean full()  
     {
        return top + 1 == size;
     }
  
    public boolean empty()  
    {
        return top == emptyStack;
    }

    public void push(char ch) //vnes
    {
    	if(full())
    	   System.out.println("Stekot e poln");
    	else
    	         items[++top] = ch;
    }
    	 
   public void pop()
    {
    	 if(empty())
    	     System.out.println("Stekot e prazen");
    	else
    		 System.out.print(items[top--]);
     
    }

	public static void main(String[] args) 
	    
		throws IOException 
	       {
	           Stack s = new Stack(10); // 10 chars
	           char ch;
	           while ((ch = (char)System.in.read())!= '\n')
	              if (!s.full()) 
	            	s.push(ch);
	           
	           while (!s.empty())
	              s.pop();
	           
	           System.out.println();
	        }
	}

  
