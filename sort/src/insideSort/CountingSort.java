package insideSort;
import java.util.*;
public class CountingSort {
	//--------------COUNTING-------------------------
	public static int[] sort(int[] array) 
	{
		     
	    int[] aux = new int[array.length];	     
	    int[] counts = new int[99];
	 
	   //kolku pati se povtoruva istata cifra
	    for (int i = 0;  i < array.length; i++)
	    {
	      counts[array[i]] +=  1;    
	    }
	 
	    //sobiraj prethodnik + current	   
	    for (int i = 1; i < counts.length; i++)
	    {
	      counts[i] = counts[i] + counts[i-1];
	    }
	 	 
	    /*
	     gleda se prvo a[i] clen, pa -1,indeks vo counts[3-1]
	     na indeks 2 vo counts se naogja clen 1
	     pa toj clen kako indeks vo aux
	     i na toa mesto smeste a[i]
	      */
	    for (int i = array.length - 1; i >= 0; i--) 
	    {
	        aux[counts[array[i] - 1]] = array[i];
	        counts[array[i]] --;
	    }
	 
	    return aux;
	  }
	 
	  public static void main(String[] args) {
	 
	    int [] unsorted = {3,5,1,7,4}; 
	    System.out.println("Before: " + Arrays.toString(unsorted));
	 
	    int [] sorted = sort(unsorted);
	    System.out.println("After:  " + Arrays.toString(sorted));
	 
	  }
	}