package Avl;

public class Node 
{

   public	int info;
   public Node left;
   public Node right;
   public int visina;
   
   

   public Node(){}
   
   public Node(int i)  
   {   info=i;  }
 

   public void pecatiJazel()    
   {
      System.out.print(info);
   }

   
}
