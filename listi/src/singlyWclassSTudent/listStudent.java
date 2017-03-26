package singlyWclassSTudent;

public class listStudent 
{
	
	public static void main(String [] sd)
	{
		Student s1 = new Student("Sara","Kostovska",9);
		Student s2 = new Student("ivana","cebova",9.8);
		Student s3 = new Student("marija","ljubenovska",9.8);
		Student s4 = new Student("marija","krsteva",8);
		
		Node n1 = new Node(s1);
		Node n2 = new Node(s2);
		Node n3 = new Node(s3);
		Node n4 = new Node(s4);
		
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		print(n1);
		
		System.out.println("");
		n1 = nad9(n1);
		print(n1);
	}
	public  static void print(Node head)
	{
		Node curr = head;
		while(curr != null)
		{
			System.out.print(curr.info.prosek + " ");
			curr = curr.next;
			
		}
	}
	public static Node nad9(Node head)
	{
		Node curr = head;
		Node newlist = null;
        Node copyHead = null,copyTail = null;
		while( curr.next != null)
		{
			if(curr.info.prosek >= 9)
			{
				newlist = new Node(curr.info);	
				
			  if(copyHead == null)
				   {
					 copyHead = newlist;
					 copyTail = newlist;
				   }
				else
				{ 
				  copyTail.next = newlist;
				  copyTail = newlist;
				}
			}
			curr = curr.next;
		}
		return copyHead;
	}

}
