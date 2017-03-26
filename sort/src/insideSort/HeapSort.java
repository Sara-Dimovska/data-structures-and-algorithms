package insideSort;

public class HeapSort {

	 private static int[] a;
	 private static int n;
	 private static int left;
	 private static int right;
	 private static int largest;
	 
	 
	 // funkcija za gradenje na heap steblo
	 
	 public static void buildheap(int []a)
	 {
	 n=a.length-1;
 
	 for(int i=n/2;i>=0;i--)//tolku treba za da postave roditeli
	 {
	 System.out.println("i="+ i);
	 maxheap(a,i);
	 }
	 }

	 // Max-Heap Funkcija
	 public static void maxheap(int[] a, int i)
	 {
	 left=2*i;
	 right=2*i+1;
	 System.out.println("i = " +i  + " levo=" + left + " desno=" + right);
	 
	 if(left <= n && a[left] > a[i])//ako e vo granicite i e pogolemo od i
	 {
	 largest=left;   //najgolemo e levoto dete
	 }
	 else
	 {
	 largest=i; //vo sprotivno si ostanuva i kako najgolemo
	 }

	 if(right <= n && a[right] > a[largest])//ako desnoto e vo granici 
	 { 
	 largest=right; //toa e pogolemo i od levoto
	 }
	 
	 
	 if(largest!=i) //ako e najdeno pogolem od i
	 {
	 exchange(i,largest); //zameni
	 maxheap(a, largest);
	 }
	 }

	 // Exchange Function
	 public static void exchange(int i, int j){
	 int t=a[i];
	 a[i]=a[j];
	 a[j]=t;
	 }

	 // funkcija za podreduvanje
	 public static void sort(int []a0)
	 {
	 a=a0;
	 buildheap(a);

	 for(int i=n;i>0;i--){
	 exchange(0, i);
	 n=n-1;
	 maxheap(a, 0);
	 }
	 }

	 public static void main(String[] args)
	 {
	int []a1={3,5,1,2,4};
	 sort(a1);
	 for(int i=0;i<a1.length;i++){
	 System.out.print(a1[i] + " ");
	 }
	}
	}
