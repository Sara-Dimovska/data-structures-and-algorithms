package pretstaviPolinom;

public class test 
{
	public  static Node pretstavi(int [] niza,int n)
	{
		Node p = new Node(niza[0]);
		Node tail;
		Node front = tail = p; 
		
		for(int i = 1;i<n;i++)
		{
			p = new Node(niza[i]);
			tail.next = p;
			tail = p;
		}
		return front;
	}
    public static void print(Node head)
    {
    	Node curr = head;
    	while(curr != null)
    	{
    		System.out.print(curr.val + " ");
    		curr = curr.next;
    	}
    }
	public static void main(String [] as)
	{
		int  []p = {4,7,4,5,6,2,4,0,1};
		Node list = pretstavi(p,9);
		print(list);
	}
}
