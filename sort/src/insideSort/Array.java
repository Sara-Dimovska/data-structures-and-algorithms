package insideSort;

public class Array {
	
	private int[] a; 		
    private int nElems; 		

public Array(int max) 	// constructor
   {
    a = new int[max]; 		
    nElems = 0; 
    }

public void insert(int value) 	
   {
    a[nElems] = value; 		
    nElems++; 			
    }

public void display() 
    {
    for(int j=0; j<nElems; j++) 		// for each element,
         System.out.print(a[j] +  " "); 	// display it
    System.out.println("");
}

private void swap(int one, int two)
{
 int temp = a[one];
 a[one] = a[two];
 a[two] = temp;
 }
//------------BUBBLE--------------------------
public void bubbleSort()
{
 int i, j;
 for(i = 0; i <nElems; i++) 	
       for(j=i; j<nElems; j++) 		
             if( a[j] > a[j+1] ) 		
                  swap(j, j+1); 		
 } 
//----------SELECTION-------------------------------
public void selectionSort()   
{
    int i, j, min;
    for(i=0; i<nElems-1; i++) 		
  {
    	
          min = i; 		
          
          System.out.println(i+1 + " iteration " + a[min] );
          
          for(j=i+1; j<nElems; j++) 	
                 if(a[j] < a[min] ) 			
                   min = j; 	
          
          System.out.println(i+1 + " iteration " + a[min] );
     swap(i, min); 			
     } 

} 
//-----------INSERTION-------------------------------------
public void insertionSort()
{
int i, j;
for(i=1; i<nElems; i++) 		
    {
    int temp = a[i]; 		
    j = i - 1; 				
    while(j>=0 && a[j] > temp) 	
          {
          a[j+1] = a[j]; 			
          j--; 				
          }
    a[j+1] = temp; 				
} 
} 
//-------------MERGE------------------------
void Mergesort()
{
	int [] temp = new int[nElems];
	recMergeSort(temp,0,nElems - 1);
}
void recMergeSort(int [] temp,int left, int right)
{
    int mid;
    if (right>left) 
    {
        mid = (right + left)/2;
        recMergeSort( temp, left, mid);
        recMergeSort( temp, mid+1, right);
        merge(temp, left, mid+1, right);
    }
}
void merge(int temp[], int left, int mid, int right) 
{
   int i = left, j = mid, k = left;
   
   while (i < mid && j <= right)
   {
        if (a[i] <= a[j])
             temp[k++] = a[i++];
        else
             temp[k++] = a[j++];
   }
   
  while (i < mid)//prepise
        temp[k++] = a[i++];
  
  while (j <= right)//prepise	  
        temp[k++] = a[j++];
  
  for(i = left; i <=right; ++i)//kopira
        a[i] = temp[i];
}



public static void main(String[] args)
{
 int maxSize = 100; 		
 Array arr; 			
 arr = new Array(maxSize); 	

 arr.insert(10); 			
 arr.insert(5);
 arr.insert(2);
 arr.insert(3);


 arr.display(); 			

 //arr.selectionSort();; 	
  arr.Mergesort();

 arr.display(); 			
} 



}
