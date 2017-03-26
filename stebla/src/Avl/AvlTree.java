package Avl;



public class AvlTree {
    
	public int vis(Node p)  
	{
	       if (p == null)
	             return -1;
	       else
	             return p.visina;
    }    
	public int maks(int a, int b) 
    {
        if (a > b) return a;
        else return b;
    }
	public Node ClockWise(Node k2)//desno
    {
     Node k1;
     k1=k2.left;
     k2.left=k1.right;
     k1.right=k2;
     k2.visina=maks(vis(k2.left), vis(k2.right))+1;
     k1.visina=maks(vis(k1.left), k2.visina)+1;
     return k1;   
    }
	public Node CounterClockWise(Node k1)//levo
    {
     Node k2;
     k2=k1.right;
     k1.right=k2.left;
     k2.left=k1;
     k1.visina=maks(vis(k1.left), vis(k1.right))+1;
     k2.visina=maks(vis(k2.right), k1.visina)+1;
     return k2;   
     }
	public Node CCWiseClockWise(Node k3)//levo pa desno
    {
     
     k3.left = CounterClockWise( k3.left );
     
     return ClockWise( k3 );
    }
	public Node ClockWiseCCWise(Node k3 )//desno pa levo
    {
     
     k3.right = ClockWise( k3.right );
    
     return CounterClockWise( k3 );
    }
	public Node insert(int x, Node t)
    {
     if( t == null )
           {
            /* Kreiraj I vrati steblo so eden jazel */
            t = new Node() ;
            t.info = x;
            t.visina = 0;
            t.left = t.right = null;
            }
    else
            if( x < t.info )
            {
                t.left = insert( x, t.left );//rekurzivno dodava vo levata strana
                
                 if (( vis( t.left ) - vis( t.right )) == 2 )
                          if( x < t.left.info )
                                     t = ClockWise( t );
                          else//ako 4 > 3
                                     t= CCWiseClockWise( t ); 
             }
             else
                      if ( x > t.info ) 
                  {
                            t.right = insert( x, t.right );
                      if( vis( t.right ) - vis( t.left ) == 2 ) 
                                if( x > t.right.info )
                                      t = CounterClockWise( t );
                                else
                                      t =ClockWiseCCWise( t ); 
                  }
   
    t.visina = maks(vis(t.left),vis(t.right))+1; 
   
    return t;
    }
	
	public Node contains( int x, Node t )
    {
        while( t != null )
        {
            
            if( x < t.info )
             return  contains(x,t.left);
           // t = t.left;
            else if( x > t.info )
              return   contains(x,t.right);
            //t = t.right;
            else
                return t;    // Match
        }

      return null;   // No match
    }
	public  int nodes(Node head)
	{
		int count = 1; //one for root
		Node curr = head;
		
	  if(curr == null)
		   return 0;
	   
	   count += nodes(curr.left);
	   count += nodes(curr.right);
	   return count;
	   
	}
    public void inorder(Node r)
    {
     if (r!=null)
     {
           inorder(r.left);
	       System.out.print(r.info+" ");
	       inorder(r.right);
     }
    }
    public static void main(String[] args) 
    {
     Node p=null;
     
     AvlTree t= new AvlTree();
   
     p=t.insert(15,p);
     
     p=t.insert(6,p);
     p=t.insert(18,p);
  
     p=t.insert(3,p);
     p=t.insert(2,p);
    
     p=t.insert(4,p);
      p=t.insert(7,p);
     p=t.insert(13,p);
     p=t.insert(9,p);
     p=t.insert(17,p);
     p=t.insert(20,p);

    t.inorder(p);
    
    Node n = t.contains(3, p); 
    System.out.println("contains:" + n.info);
    System.out.println("");
    System.out.println(t.nodes(p));
    

    }

}
