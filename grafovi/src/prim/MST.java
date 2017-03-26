package prim;

public class MST 
{

	
 
    int mindistance (int distance[], boolean visited[],int n)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int i = 0; i < n; i++)
            if (visited[i] == false && distance[i] <= min)
            {
                min = distance[i];
                min_index = i;
            }
 
        return min_index;
    }
 
    
    void print(int parent[], int n,int graph[][])
    {
    	System.out.println("Edge   Weight");
        for (int i = 1; i < n; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
    }
 
    
    void primMST(int graph[][],int n)
    {
       
        int parent[] = new int[n]; 
        int distance[] = new int [n];       
        boolean visited[] = new boolean[n];
       
        for (int i = 0; i < n; i++)//init
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
 
        
        distance[0] = 0;     
         parent[0] = -1; // First node is always root of MST
 
       
        for (int i = 0; i < n; i++)
        {
            
            int next = mindistance(distance, visited ,n);          
            visited[next] = true;
           
            for (int j = 0; j < n; j++)                      	
               if (graph[next][j]!=0 && visited[j] == false &&
                    graph[next][j] <  distance[j])
                {
                    parent[j]  = next;
                    
                    distance[j] = graph[next][j];
                }
        }
 
        
        print(parent, n, graph);
    }
 
    public static void main (String[] args)
    {
    	
        MST t = new MST();
        int graph[][] = new int[][]
        	{{0,0,13,0,16,8},
            {0,0,0, 6, 0, 10},
            {13,0,0,14,0,11},
           {0,6,0,0,5,17},
           {16,0,0,5,0,7},
           {8,10,11,17,7,0},          
          };
 
        // Print the solution
        t.primMST(graph,6);
    }
}