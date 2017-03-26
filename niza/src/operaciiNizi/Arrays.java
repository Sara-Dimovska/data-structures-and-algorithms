package operaciiNizi;

public class Arrays 
{
	
	public int[] vnesiElement(int pole[],int index,int novElement)
	{
		int pole1[] = new int[pole.length + 1];
		int i;
		if(index > pole.length)
			System.out.println("Izberi nov index");
		else 
		{
			for(i=0;i<=index;i++)
				{
				 pole1[i]=pole[i];
			     pole1[index]=novElement;
				}
			
			for(i=index;i<pole.length;i++)
			{
				pole1[i+1]=pole[i];
			}
			System.out.println("Elementot e vnesen");
				
		}
		return pole1;
	}
	public void najdiElement(int [] pole,int element1)
	{
		int i,count=0;
		for(i=0;i<pole.length;i++)
		{
			if(pole[i] == element1)
				System.out.println("Elementot e pronajden na pozicija:" +i );
			else
				count++;
		}
		if(count == pole.length)
				System.out.println("Ne e pronajden element");
	}
public int[] brisiElement(int pole[],int element)	
{
	int pole1[]=new int[pole.length-1];
	int i,j;
	for (i=0;i<pole.length;i++)
	{
		if(pole[i] == element)
		{
			for(j=0;j<i;j++)
				pole1[j]=pole[j];
			for(j=i;j<pole.length-1;j++)
				pole1[j]=pole[j+1];
		}
		
	}
	return pole1;
}
	

	public static void main(String[] args) {
		Arrays arr = new Arrays();
		int [] niza={1,2,3,4,5};
		
		arr.najdiElement(niza, 8);
		
		int []niza1=arr.vnesiElement(niza, 2, 6);
		for(int i=0;i<niza1.length;i++)
            System.out.print(niza1[i]+ " ");
		
		System.out.println("");
		
		int []niza2=arr.brisiElement(niza1, 6);
		for(int i=0;i<niza2.length;i++)
            System.out.print(niza2[i]+ " ");

	}

}
