package insideSort;

class ArrayIns
{
     private long[] theArray; 			
     private int nElems; 				

 public ArrayIns(int max) // constructor
{
   theArray = new long[max]; 		
   nElems = 0; 				
}
//--------------------------------------------------------------
 public void insert(long value) 		
{
   theArray[nElems] = value; 		
   nElems++; 				
}
//--------------------------------------------------------------
public void display() 			
{
   System.out.print("A=");

    for(int j=0; j<nElems; j++) 		// for each element,
     System.out.print(theArray[j] + " "); // display it
   System.out.println("");
}
//--------------------------------------------------------------
public void quickSort()
{
   recQuickSort(0, nElems-1);
}
//--------------------------------------------------------------
public void recQuickSort(int left, int right)
{
     if(right-left <= 0) // ako e eden element
         return; 
     
     else 					
    	 {
              long pivot = theArray[right];//najdesnio
     
              //partition range
              int partition = partitionIt(left, right, pivot);
              recQuickSort(left, partition-1); 	// sort left side
              recQuickSort(partition+1, right); // sort right side
    	 }
} 
//--------------------------------------------------------------
 public int partitionIt(int left, int right, long pivot)
{
   int leftPtr = left-1; 			// left (after ++)
   int rightPtr = right; 			// right-1 (after --)

   while(true)
   { 	
	   // naogja pogolem od pivot
        while( theArray[++leftPtr] < pivot ); 
       
       //pomal od pivot
        while(rightPtr > 0 && theArray[--rightPtr] > pivot); 


         if (leftPtr >= rightPtr)// if pointers cross,
             break; 				//partition done
         
         else 	// not crossed, so
             swap(leftPtr, rightPtr); 		
   } 
   
      swap(leftPtr, right);	// levio  se zamenuva so pivot ako se razminati
      return leftPtr;		 // nov pivot
 } 
//--------------------------------------------------------------
public void swap(int dex1, int dex2) 		
     {
      long temp = theArray[dex1]; 		
      theArray[dex1] = theArray[dex2];	 
      theArray[dex2] = temp; 			
      } 
//--------------------------------------------------------------


  public static void main(String[] args)
       {
           int maxSize = 7; 			// array size
           ArrayIns arr;
           arr = new ArrayIns(maxSize);		 // create array

           
              arr.insert(1);
              arr.insert(5);
              arr.insert(3);
              arr.insert(8);
              arr.insert(2);
              arr.insert(9);
              arr.insert(4);
           
           arr.display(); 				// display items
           arr.quickSort(); 				// quicksort them
           arr.display(); 				// display them again
        } 
} 
