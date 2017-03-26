package gueue;

public class Gueue {
	
	private int qMaxSize;// max queue size
	   private int front = 0;  // front pointer
	   private int rear = 0;  // rear pointer
	   private int sizeQ = 0;  // size of queue
	   private char[] queue;    // actual queue

	   public Gueue(int size) {
	      qMaxSize = size;
	      front = 0;
	      rear = 0;
	      sizeQ = 0;
	      queue = new char[qMaxSize];
	   }
	   public boolean empty() {
		      return sizeQ == 0;
		   }

		   public boolean full() 
		   {
		      return sizeQ == qMaxSize;
		   }
		   
		   
		   public void insert(char ch)
		   {
			      if (!full())
			      {
			         sizeQ++;
			         rear = (rear + 1)%qMaxSize;
			         queue[rear] = ch;
			      }
			      else
			         System.err.println("Overflow\n");
			   }   
	   public char delete() 
	   {
		      if (!empty())
		      {
		         sizeQ--;
		         front = (front + 1) % qMaxSize;
		         return queue[front];
		      }
		      else {
		         System.err.println("Underflow");
		         return '?';
		      }
		   }
	
			   public void print() 
			   {
			      System.out.print("Size: " + sizeQ +
			         ", front: " + front + ", rear: " + rear + ", queue: ");
			      for (int i = 0; i < qMaxSize; i++)
			         System.out.print("queue[" + i + "]=" 
			            + queue[i] + "; ");
			      System.out.println();
			   }
			   public static void main(String[] args)
			   {
				   Gueue q=new Gueue(3);
				   q.insert('a');
				   q.insert('b');
				   //q.insert('c');

				   
				   q.delete();
				   q.delete();
				   q.print();
			   }
		
}
