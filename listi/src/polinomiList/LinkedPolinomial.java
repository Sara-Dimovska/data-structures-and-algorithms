package polinomiList;

public class LinkedPolinomial 
{
	
	private static class Node
    {
        public int coef;
        public int exp;
        Node next;
        
        Node(int coef, int exp) 
        {
            this.coef = coef;
            this.exp  = exp;
        }

    }
	
	       private Node first = new Node(0,0);  //jazel cuvar
		   private Node last  = first;

		    
		    private LinkedPolinomial(){ }
		  
		        
		     public LinkedPolinomial(int coef, int exp) // a * x^b
		     {
		            last.next = new Node(coef, exp); //povrze
		            last = last.next; //last e novovnesenio
		        }
		  
		        // return c = a + b se povikuva so a.plus(b)

		        public LinkedPolinomial plus(LinkedPolinomial b) 
			    {
		        	LinkedPolinomial a = this; //taj so povikuva
		        	LinkedPolinomial c = new LinkedPolinomial(); //rezultato kje smeste
			        Node x = a.first.next; //kje izminuva a
			        Node y = b.first.next; //kje izminuva b
			        
			        while (x != null || y != null) 
			        {
			            Node t = null;
			            
			            if (x == null) //ako prvata e prazna  
			            {
			              t = new Node(y.coef, y.exp); //kopira od vtorata
			              y = y.next; //y = null
			            }
			            
			            else if (y == null)  //vtorata e prazna 
			            { 
			              t = new Node(x.coef, x.exp); //kopira od prvata
			              x = x.next;
			            }
			          
			            else if (x.exp > y.exp) //tuka e ispolnet uslovo
			            {
			            	t = new Node(x.coef, x.exp);
			            	x = x.next; //x = null;
			            	
			            }
			            
			            else if (x.exp < y.exp)
			            { 
			            	t = new Node(y.coef, y.exp); 
			            	y = y.next; 
			            } 

			            else //ako eksponentite se isti
			            {
			                int coef = x.coef + y.coef;
			                int exp  = x.exp;
			                x = x.next;
			                y = y.next;
			                
			                if (coef == 0) continue;
			                
			                t = new Node(coef, exp);			             
			            }
			            
			            System.out.println(t.coef + " "  + t.exp);
			            // 4  3 (od prvio jazel)
			             //3  2 (od vtorio jazel)
			            
			          c.last.next = t;//povrze so t    
			          c.last = c.last.next; // last e t
			        }
			        
			        return c;      
			       
			    }
		     // return c = a * b se povikuva so c=а.times(b);

		        public LinkedPolinomial times(LinkedPolinomial b)
			    {
		        	LinkedPolinomial a = this;
		        	LinkedPolinomial c = new LinkedPolinomial();
		        	
			        for (Node x = a.first.next; x!= null; x = x.next) 
			        {
			        	LinkedPolinomial temp = new LinkedPolinomial();
			        	
			            for (Node y = b.first.next; y!= null; y = y.next)
			            {
			                temp.last.next = new Node(x.coef * y.coef, x.exp + y.exp);
			                temp.last = temp.last.next;
			            }
			            c = c.plus(temp);
			        }
			        return c;
			    }
		        public String toString() 
		        {
		            String s = "";
		            for (Node n = first.next; n != null; n = n.next) 
		            {
		                if      (n.coef > 0)
		                s = s + " + " +   n.coef  + "x^" + n.exp;
		                
		                else if (n.coef < 0)
		                s = s + " - " + (-n.coef) + "x^" + n.exp;
		            }
		            return s;
		        }

	public static void main(String[] args)
	{
		//LinkedPolinomial zero = new LinkedPolinomial(0, 0);
	
		LinkedPolinomial p1   = new LinkedPolinomial(4, 3);
		LinkedPolinomial p2   = new LinkedPolinomial(3, 2);
		//LinkedPolinomial p3   = new LinkedPolinomial(1, 0);
		//LinkedPolinomial p4   = new LinkedPolinomial(2, 1);
		LinkedPolinomial p    = p1.plus(p2);
				//plus(p3).plus(p4); // 4x^3 + 3x^2 + 1 + 2x
		
	/*	LinkedPolinomial q1   = new LinkedPolinomial(3, 2);
		LinkedPolinomial q2   = new LinkedPolinomial(5, 0);
		LinkedPolinomial q    = q1.plus(q2); // 3x^2 + 5
		
		LinkedPolinomial r    = p.plus(q);
		LinkedPolinomial s    = p.times(q);
		*/
		       // System.out.println("zero(x) =     " + zero);
		        System.out.println("p(x) =" + p);
		       // System.out.println("q(x) =" + q);
		        
		      // System.out.println("p(x) + q(x) = " + r);
		       //System.out.println("p(x) * q(x) = " + s);
       
		

	}

	}
