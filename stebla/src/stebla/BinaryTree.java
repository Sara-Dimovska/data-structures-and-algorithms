package stebla;


public class BinaryTree
{
	public TNode root;
	public BinaryTree(){}
	
	public  TNode kreiraj(int [] niza,int n)
	{
		TNode p,root = null,x,y;
		int i;
		for( i = 0;i < n;i++)
		{
			if(root == null)
			{
				p = new TNode(niza[i]);
			    root = p; //root->prvio clen
			}
				p = new TNode(niza[i]);
				x = root;
				y = null;
				while(x != null)//za da znae na koj roditel da dodele dete
				{
					y = x;//za da se zacuva roditelo
					if(p.value < x.value)
						x = x.left;//ode na levo
					else if(p.value > x.value)
						x = x.right; //ode na desno
					
					else break;//ista
				}				
				if(p.value < y.value)//levo dete
				{
					y.left = p;
					p.left = p.right = null;
				}
				else if(p.value > y.value)//desno dete
				{
					y.right = p;
					p.left = p.right = null;
				}
		}
		return root;
	}
	
	public void addNode(int value)
	{
		TNode newNode = new TNode(value);
		if(root == null)
		{
			root = newNode;
			return;
		}
		TNode x = root;
		TNode y = null;
		while(x != null)
		{
			y = x;
			if(value < x.value)
				x = x.left;
				
			else if(value > y.value)
				 x = x.right;
			
			else break;
		}
		if( value < y.value)
			y.left = newNode;
		
		else if(value > y.value)
		    y.right = newNode;	
		
	}

	public void preorder(TNode root) 
	{ 
		TNode temp = root;
		Stack s = new Stack(maxDepth(root));
		s.push(root);
		
		while(!s.empty())//dodeka ne stane prazen
		{
			temp = s.pop();
			System.out.print(temp.value + " ");
			if(temp.right != null)
				s.push(temp.right);
			if(temp.left != null)
				s.push(temp.left);
			
		}
		
	}
	public void postorder(TNode node) 
	{
		if (node != null) 
		{		
		 postorder(node.left);
		 postorder(node.right);
		 System.out.print(node.value + " ");
		}
	}

public int maxDepth(TNode root)
	{
	    if(root==null)
	        return 0;
	 
	    int leftDepth = maxDepth(root.left);
	    int rightDepth = maxDepth(root.right);
	 
	    int bigger = Math.max(leftDepth, rightDepth);
	 
	    return bigger + 1;
	}
public TNode najgolem(TNode root)
{
	//TNode x = root,y = null;
	//while(x.right != null)
	//{
		//y = x;
		//x = x.right;
	//}
	//return y;	   
	 
	if(root.right.right == null)
		return root;
	else
		return najgolem(root.right);
}
	
public TNode search(TNode root,int value)
{
	TNode pointer = root;
	while(pointer != null)
	{
		if(value == pointer.value)
			return pointer;
		
		if(value < pointer.value)
			return search(pointer.left , value);
			//pointer = pointer.left;
		else
			return search(pointer.right,value);			
			//pointer = pointer.right;
	}
  return null;
}	
public static TNode deleteNode(TNode root, int value)
{  
	  if (root == null)  
	       return null;  	  
	  if (value < root.value) //pomala
	  {  
	    root.left = deleteNode(root.left, value); //baraj levo
	  }
	  else if (value > root.value) //pogolema
	  {  
	    root.right = deleteNode(root.right, value);  //baraj desno	  
	  } 	  
	  else //I found you and get ready for deletion
	  {  
		  if(root.left == null && root.right == null)//No child
		   {
			  root = null;
		   }
		  else if(root.left == null)// Only right child
		  {			 
			 root = root.right;
		  }
		  else if(root.right == null) //Only left child
		  {			 
			  root = root.left;
		  }
		  else // 2 kids
		  {
			  TNode temp = min(root.right);
			  root.value = temp.value;
			  root.right = deleteNode(root.right,temp.value);
			  //treba da ga izbrise taj cija vrednost  kopirana
		  }		  		  
	  }
	  return root;
 } 
public int leaves(TNode t)
{
	  if (t!=null)
	     if ((t.left == null)&&( t.right == null) &&( t.value % 2 == 0))
	      return 1;
	    	 
	  else  
	       return(leaves(t.left)+leaves(t.right));
	  
  return 0;
}
public int getMax(TNode root) 
{ //check if root is null
	   if(root.right == null) 
		   return root.value; 
	   
	    else 
	       return getMax(root.right);
	}
public static TNode min(TNode root)
{ 
	if(root.left == null)
		return root;
	else 
		return min(root.left);
}
public void inorder(TNode curr)
{
  if (curr == null) return;
   
   	inorder(curr.left);
   	System.out.print(curr.value + " "); 
   	inorder(curr.right);
   
}
public static int brojVoOpseg(TNode root,int fromKey,int toKey)
{
	
	 // Base case
    if (root == null) return 0;
 
    // Special case 
     if (root.value == toKey && root.value == fromKey)
        return 1;
 
    //pripagja vo opseg
    if (fromKey <= root.value && toKey >= root.value)
         return 1 + brojVoOpseg(root.left, fromKey, toKey) +
        		 brojVoOpseg(root.right, fromKey, toKey);
 
    
    //ako vrednosta na jazelot e pomala od dolnata granica dvizi se desno
    else if (toKey > root.value)
         return brojVoOpseg(root.right, fromKey, toKey);
 
    //ako vrednosta na jazelot e pogolema od gornata granica idi na levo
    
    else //( fromKey < root.value )
    	return brojVoOpseg(root.left, fromKey, toKey);
	 
	
}
public static void pecatiVoOpseg(TNode root,int fromKey,int toKey)
{
	if (root == null) return;

	if ( fromKey < root.value )
		pecatiVoOpseg(root.left, fromKey, toKey);
	 
	   
	 if ( fromKey <= root.value && toKey >= root.value )
	    System.out.print(root.value + " ");//pripaga vo opsegot
	 
	  
	 if ( toKey > root.value)
		   pecatiVoOpseg(root.right, fromKey, toKey);
	
}
public static void insertLeft(TNode root,int parrentKey,int childKey)
{
	TNode curr = root;
	while(curr.value != parrentKey)
	{
		if(parrentKey < curr.value)
				curr = curr.left;
		
		else if(parrentKey > curr.value)
			     curr = curr.right;

	}
	TNode newchild  = new TNode(childKey);
	newchild.left = curr.left;//ako ima podsteblo
	newchild.right = null;
	curr.left = newchild;	
	
	System.out.println("vmetnavte "+childKey+" levo od "+parrentKey);
}
public  int nodes(TNode head)
{
	int count = 1; //one for root
	TNode curr = head;
	
  if(curr == null)
	   return 0;
   
   count += nodes(curr.left);//7
   count += nodes(curr.right);////3
   return count;
   
}
public  int suma(TNode root)
{
	if(root == null)
		return 0;
	
	return (suma(root.left) + suma(root.right) + root.value);
	
}

	public static void main(String[] args) 
	{
		 BinaryTree tree = new BinaryTree();
		  tree.addNode(15);
		   tree.addNode(6);
		   tree.addNode(18);
		   tree.addNode(7);
		   tree.addNode(3); 
		   tree.addNode(2);
		   tree.addNode(4); 
		   tree.addNode(9);
		   tree.addNode(13);
		   tree.addNode(17);
		   tree.addNode(20);
		   
		   
		   
		   tree.inorder(tree.root);
		   System.out.println("");
		   tree.postorder(tree.root);
		   System.out.println("");
		   tree.preorder(tree.root);
		   
		   int suma = tree.suma(tree.root);
		   System.out.println("");
		   System.out.println("Suma:" + suma);		
		   System.out.println("Sredna vrednost:"+ suma/(tree.nodes(tree.root)));
		   
		   System.out.println("");
		   System.out.println("leaves:" + tree.leaves(tree.root));
		   System.out.println("depth:" + tree.maxDepth(tree.root));
		   TNode max = tree.najgolem(tree.root);
		   System.out.println("Vnatresen max:" + max.value);
		   
		   
		   //System.out.print("Preorder:"); 
		   //tree.preorder(tree.root);
		  // System.out.println("");

		   deleteNode(tree.root, 15);
		   System.out.println("");
		   tree.inorder(tree.root);
		   System.out.println("nodes:" + tree.nodes(tree.root));
		  
		   insertLeft(tree.root,6,5);
		   pecatiVoOpseg(tree.root,3,9);
		   System.out.println("");
		  int count = brojVoOpseg(tree.root,3,9);
		  System.out.println(count);
		  
		   //TNode t = tree.search(tree.root, 4);
		  // if(t != null)
		    // System.out.println("Found node:" + t.value);
		  
		   	
		   //int niza[]={15,6,18,3,2,4,7,13,9,17,20}; 
		    //TNode t = tree.kreiraj(niza,11);
		    //tree.inorder(t);
		    
		    
		  
		   // t = tree.delete(tree.root, 9);
		   

	}

}
