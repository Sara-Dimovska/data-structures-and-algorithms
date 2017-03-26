package doubleLinked;

public class DoubleLinkedList 
{
	public Node prv; 
	//public Node last;
	   public DoubleLinkedList(){ prv = null; }
	   public Node vodac(){ return prv; } 
	   
	   public void kreiraj(int niza[], int n)     
	     {
		   Node front, last, curr;
	           front = curr = new Node(niza[0]);//prv element 15   
	           
	           for (int i=1; i < n; i++) 
	           {
	                     last = new Node(niza[i]);
	                     curr.next = last;
	                     last.prev = curr;
	                     curr = last; 
	           }
	           curr.next = front;//kruzna
	           front.prev = curr;
	          prv = front; //vodic   
	      }
	   public void duplicate()
	   {
		   Node p1 = prv,p2 =  prv.next,p = null;
		  
		   
		   do
		   {
			  p = new Node(p1.value);
				
			   p.next = p2;
			   p.prev = p1;
			   p1.next = p;
			   p2.prev = p;
				   
			 p1 = p2;
			 p2 = p2.next;
			
			   
		   }while(p1 != prv);
	
	   }
	   public void removeDuplicates()
	   {
		   
		       
		       /* Node current = prv;
		 
		        
		        Node duplicate;
		 
		       
		        if (prv == null)    
		            return;
		 
		      
		       do
		        {
		 
		            
		            if (current.value == current.next.value)
		            {
		                duplicate = current.next;
		                current.next = duplicate.next;
		                duplicate.next.prev = current;
		                
		            }
		            else
		               current = current.next;
		            
		        }while(current != prv);
		    }
		   */
		   Node p1 = prv,p2 = prv.next,duplicate;
		   do
		   {
			   if(p1.value == p2.value)
			   {
				   duplicate = p1.next;
				   p1.next = duplicate.next;
				   duplicate.next.prev = p1;
				   
			   }
			   p1 = p2;
			   p2 = p2.next;
			   
		   }while(p1 != prv);
	   }
	   
	   public void insertAf(int n, int k)
	   {
		   Node newnode = new Node(k);
		   Node curr = prv;
		   
		   do
		   {
			   if(curr.value == n)
			   {
				   newnode.prev = curr;
				   newnode.next = curr.next;
				   curr.next = newnode;
				   newnode.next.prev = newnode;
				   return;
			   }
			   curr = curr.next;
			   
		   }while(curr != prv);
		   
	   }
	   public void insertBf(int n,int k)
	   {
		   Node newnode = new Node(k);
		   Node curr = prv;
		   do
		   {
			    if(curr.value == n)
			    { 	
			    	
				   newnode.next = curr;
				   newnode.prev = curr.prev;
				   curr.prev = newnode;
				   newnode.prev.next = newnode; 
				   
				   if (curr == prv)
					   prv = newnode;
				   
				   return;
			    }
			   curr = curr.next;
			   
		   }while(curr != prv);
	   }
	   public void insert(int k)//dodaj na kraj od listata
	   {
		   Node newnode = new Node(k);
		   Node curr = prv;
		   
		   if(curr == null)//ako e prazna listata
		   {
			   prv = newnode;
		   }
		   
		   
		   newnode.next = curr;
		   newnode.prev = curr.prev;
		   curr.prev = newnode;
		   newnode.prev.next = newnode; 
	   }
	   public void remove(int n)
	   {
		   Node curr = prv;
		   do
		   {
			   if(curr.value == n)
			   {
				   curr.prev.next = curr.next;
				   curr.next.prev = curr.prev;
				   if(curr == prv)
					   prv = curr.next;
				   return;
			   }
			   curr = curr.next;
			   
		   }while(curr != prv);
	   }
	public void pecatiLista()
	      {    
		       Node  curr = prv;
	           
	           do
	           {
	        	   System.out.print(curr.value + " ");
	        	   curr = curr.next;
	           }while(curr != prv);
	        	   
             System.out.println("");
	      } 

	public Node find_max() 
	{
	   Node curr, temp; //front = prv;
	   int max;
	   max=prv.value; 
	   temp = prv;  
	   curr = temp.next; 
	   
	   while(curr != prv) 
	   {
	     if (max < curr.value) 
	      {
	         temp = curr;
	         max = curr.value; 
	      }  
	      curr = curr.next;
	   }
	   return temp;
	}  
	public Node find_first(int broj)
	{
	  Node curr,temp;
	   temp = prv;
	   curr = temp.next;
	   while(curr != prv)
	   {
		 // if(temp.value == broj)
			 // return temp;
		  
		 if(curr.value == broj)
	         {
	            temp = curr;
	            break;
	         }
	      curr = curr.next;
	   }
	   return curr;
	}

	public void sosed_swap(Node a)
	{
		Node b = a.next;

	   a.prev.next = b;
	   b.prev = a.prev;
	   a.next=b.next;
	   b.next.prev = a;
	   b.next=a;
	   a.prev=b;
	}  
	public void swap(Node p, Node q)
	{
	  Node t;
	   if(p.next == q)
	      sosed_swap(p);
	   
	   else if(p.prev == q)
	      sosed_swap(q);
	   
	   else
	   {
	      p.next.prev = p.prev.next = q;
	      q.next.prev = q.prev.next = p;
	      
	      t = p.next;
	      p.next = q.next;
	      q.next = t;
	      
	      t = p.prev;
	      p.prev = q.prev;
	      q.prev = t;
	   }

	}  

	public static void main(String[] args) 
    {
        
     int n = 11;
     int[] niza={6,6,18,3,2,4,7,13,20,9,17};
    
    
     DoubleLinkedList t = new DoubleLinkedList();
     t.kreiraj(niza, n);
     //make a list with the array
     t.pecatiLista();
     //t.insertAf(15,14);
     t.insertBf(6, 14);
     t.pecatiLista();
     
     t.remove(14);

     t.pecatiLista();
   
     
     Node najgolem = new Node();
     najgolem = t.find_max();
     System.out.println(najgolem.value);
     
     Node najmal = new Node();
     najmal = t.find_first(6);
     
     
     
     t.swap(najgolem, najmal);
     t.insert(22);
    // t.insert(22);
     //t.pecatiLista(); 
     t.duplicate();
     t.pecatiLista();
     
     t.removeDuplicates();
     t.insert(22);
     t.removeDuplicates();
     t.pecatiLista();
     
    // t.removeDuplicates();
     //t.pecatiLista();
     }
} 
