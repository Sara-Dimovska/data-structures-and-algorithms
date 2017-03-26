package nanizano;

public class TreeN {

    public Node v;
public TreeN(){}
public TreeN (int niza[],int n)//constructor
{
	Node p,x,root = null,vodac;
	p = new Node();
	p.lbit = p.rbit = 1;
	p.left = p.right = p;	
	vodac = p;
	for(int i=0; i<n;i++)
	{
		if(root == null) //p i vodac se na root(prvio element)
		{
			p = new Node(niza[0]);
			p.lbit = p.rbit = 0;
			p.left = p.right = vodac;
			vodac.right = vodac.left = p;
			root = p;				
		}
		else
		{
			p = new Node(niza[i]);
			x = root;//za parent
			while((x.lbit == 1) || (x.rbit == 1))//traze parrent(se dodeka ima vrski)
			{
				if(p.data < x.data ) //novio clen e pomal od x/root
				{
					if(x.lbit == 1)// ako ima vrski na levo
						x =x.left; //izmini gi levo				
				}
				
				else if(p.data > x.data)//novio clen e pogolem od x
				{
					if(x.rbit == 1) //ako vrski na desno
						x =x.right; //izmini gi desno
				}
			}
			if(p.data < x.data)//ako treba da dodade levo dete
			{
				x.lbit = 1; //parent kje ima vrska na levo
				p.left = x.left; //nishkata na novio = prethodniko
				x.left = p; //povrzi so novio clen
				p.lbit = p.rbit = 0;//deka nema vrski novio
				p.right = x;//nishka na sledbeniko 
				
			}
			if(p.data > x.data)
			{
				x.rbit = 1;
				p.right = x.right;
				x.right = p;
				p.lbit = p.rbit = 0;
				p.left = x; //nishka
			}
		}v = vodac;
	}
	
	
}
public void preorderOnInorder()
{
	Node p = v.right; //root
	while(p.lbit  == 1)//dodeka ima vrski na levo 
		p = p.left;
	System.out.print(p.data + " ");
	
	while(p.right != v)
	{
		p = sled(p);
		System.out.print(p.data + " ");
	}
}

public Node sled(Node p)
{
	if(p.rbit == 0)//vrati nishkata na desno
		return p.right;
	
	//else ako ima na desno vrska
	p = p.right;
	
	while(p.lbit == 1)//ako desnata vrska ima levo podsteblo
		p = p.left;
	
	return p;
}

public Node prev(Node p)
{
	if(p.lbit == 0) //vrati nishkata na levo
		return p.left;
	
	//else ako ima na levo vrska
	p = p.left;

	while(p.rbit == 1)//levata vrska ima desno podsteblo
         p = p.right;
	
	return p;
}
public void insertRight(Node parent,Node child)
{
	Node temp =  null; 
	
	child.right = parent.right;
	parent.rbit = 1;
	parent.right = child;
	child.rbit = parent.rbit;
	child.left = parent;
	child.lbit = 0;
	
	if (child.rbit == 1) //ako ima  desno podsteblo
	{        
		temp = child.right; 
		while (temp.lbit == 1) 
		    temp = temp.left; 
		
		temp.left = child; //treba najlevoto ->child
	}
	
}
public  int brojListovi(Node v)
{ 
   if (v.left == v) 
	   return 0; 
   
   int count = 0;
   Node p = v.left; 
   
   while (p.lbit == 1) //dodeka ima vrski na levo
    p = p.left;           //odi na sledniot
   
    while(p != v) 
    {
      //se dodeka ne go izmineme celoto steblo
       if (p.lbit == 0)    //ako najdeme niska
    	   count++; 		      //se broi jazelot kako list
      p = sled(p);     //funkcija naslednik vo inorder 
    }
return count; 
} 


public static void main(String [] args)
{
	int niza[] = {15,2,4,3,5};
	TreeN tree = new TreeN(niza,4);
	tree.preorderOnInorder();
	System.out.println("");
    
	
	
	//Node newNode = new Node(18);
	/*
	Node a = new Node(19);
	Node b = new Node(17);
	a.lbit = b.lbit = 0;
	a.rbit = b.rbit = 0;
	newNode.right = a;
	newNode.rbit = 1;
	newNode.left = b;
	newNode.lbit = 1;
	*/
	
	//tree.insertRight(tree.v.right,newNode);
	//tree.preorderOnInorder();
	
    Node n = tree.prev(tree.v.right.left.right);
   System.out.println(n.data);
	
   Node sled = tree.sled(tree.v.right.left.right);
    System.out.println(sled.data);
	
	//int broj = tree.brojListovi(tree.v);
	//System.out.println(broj);
	
	
}


}



