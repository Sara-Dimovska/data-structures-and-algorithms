package polimon;

public class SoberiPolinom {
 public static int[] soberi(int polinom1[],int polinom2[])
	{
		int n1,n2;
		n1=polinom1[0];
		n2=polinom2[0];
		
		int rezultatLenght = Math.max(n1, n2);
		
		int rezultat[]=new int[ 2 *rezultatLenght + 1];
		
		int i=1,j=1,k=1;//brojaci za 3polinomi
		
		 while ((i <= 2*n1 ) && (j <= 2*n2 )) 
         { 
            if (polinom1[i] == polinom2[j]) // isti eksponenti 
            { 
                 rezultat[k+1] = polinom1[i+1] + polinom2[j+1]; 
                 rezultat[k] = polinom1[i]; 
                  k+=2; 
                  i+=2;
                  j+=2;
            }
            
            else  if (polinom1[i] < polinom2[j]) 
               { 
                  rezultat[k+1] = polinom2[j+1]; 
                  rezultat[k] = polinom2[j]; 
                  k+=2; j+=2; 
               }
            else if (polinom1[i] > polinom2[j]) 
                   { 
                      rezultat[k+1] = polinom1[i+1]; 
                      rezultat[k] = polinom1[i]; 
                      k+=2; i+=2; 
                   } 
              
          } 
		 rezultat[0] = k/2; 
          return rezultat;
       } 

	public static void main(String[] args) 
	{
		int a[]={3,2,3,1,2,0,5};
		int b[]={4,3,4,2,3,1,4,0,4};
	
		int []rezultat=soberi(a, b);
		
		for(int i=0;i<rezultat.length;i++)
          System.out.print(rezultat[i] + " ");

	}

}