package singlyWclassSTudent;

public class Node 
{
   public Student info;
   public Node next;
   public Node(){ next = null;}

	public Node(Student info)//constructor
	{
		this.info = info;
		this.next=null;
	}
}
