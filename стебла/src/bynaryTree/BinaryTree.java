package bynaryTree;

public class BinaryTree 
{
	
	public TNode root;
	public BinaryTree(){}
	
	public void addNode(int value)
	{
		TNode newNode = new TNode(value);
		if(root == null)
		{
			root = newNode;
			return;
		}
		TNode node = root;
		TNode parent;
		while(true)
		{
			parent = node;
			
			if(value < node.value)
			{
				node = node.left;
				if(node.left == null)
				{ 
				  parent.left = newNode;
				  return;
				}			
			}
			else
			{
				node = node.right;
				if(node.right == null)
				{
					parent.right = newNode;
					return;
				}				
			}
		}
		
	}
	
public void inorder(TNode curr)
{
	if (curr!=null)
   {
   	inorder(curr.left);
   	System.out.print(curr.value + " ");
   	inorder(curr.right);
   }
}
   public static void main(String [] a)
   {
	   BinaryTree tree = new BinaryTree();
	   tree.addNode(15);
	   tree.addNode(6);
	   tree.addNode(18);
	   tree.addNode(3);
	   
	   tree.inorder(tree.root);
   }

}

