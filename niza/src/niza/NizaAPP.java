package niza;

public class NizaAPP
{
	public static void main(String[] args)
	{
		Niza a = new Niza(100);
	    int	nElem=5;
	    int j;
	    a.setNiza(0,77);
	    a.setNiza(1,99);
	    a.setNiza(2,44);
	    a.setNiza(3,55);
	    a.setNiza(4,22);
	   
	    for(j=0;j<nElem;j++)
	    {
	    	System.out.print(a.getNiza(j) + " ");
	    }
	    System.out.println(" ");
	    int kluc=22;
	    for(j=0;j<nElem;j++)
	    {
	    	if(a.getNiza(j)== kluc)
	    	break;
	    }
	    if(j==nElem)
	    	System.out.println("Ne e pronajden");
	    else 
	    	System.out.println("Pronajden " + kluc);
	    for(j=0;j<nElem;j++)
	    {
	    	if(a.getNiza(j)==55)
	    		break;
	    }
	    for(int k=j;j<nElem;j++)
	    	a.setNiza(k,a.getNiza(k+1));
	    nElem--;
	    for(j=0;j<nElem;j++)
	    {
	    	System.out.print(a.getNiza(j) + " ");
	    }
	   
	    
	}

}
