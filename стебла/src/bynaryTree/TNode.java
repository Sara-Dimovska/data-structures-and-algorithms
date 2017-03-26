package bynaryTree;

public class TNode 
{
	public int value;
	public TNode left; 
    public TNode right;
    
	public TNode(){}
	public TNode( int value)
	{
		this.value = value;
		left = null;
		right = null;
	}
	}