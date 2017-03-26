
package niza;

public class Niza 
{
	private int[] pole;
	
	public Niza(int size){ pole=new int[size];}
	public void setNiza(int index,int value)
	{
		pole[index]=value;
	}
	public int getNiza(int index)
	{
		return pole[index];
	}

}
