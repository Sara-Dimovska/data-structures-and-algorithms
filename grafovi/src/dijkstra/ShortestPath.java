package dijkstra;

public class ShortestPath 
{

	
   // static final int V=9;
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
 
    void printSolution(int distance[], int n)
    {
        System.out.println("Vertex   distance from Source");
        for (int i = 0; i < n; i++)
            System.out.println(i+" \t\t "+distance[i]);
    }
 
    
    void dijkstra(int graph[][], int src ,int n)//matrica,od koj jazel,dolzina
    {
        int distance[] = new int[n];                               
        boolean visited[] = new boolean[n];
 
        
        for (int i = 0; i < n; i++)//init
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
       
        distance[src] = 0;
 
        // Find shortest path for all vertices
        for (int i = 0; i < n; i++)
        {          
            int next = mindistance(distance, visited, n);
           
            visited[next] = true;
 
           
            for (int j = 0; j < n; j++)
               
                if (!visited[j] && graph[next][j]!=0 &&                     
                      distance[next]+graph[next][j] < distance[j])
                	
                    distance[j] = distance[next] + graph[next][j];
        }
 
       
        printSolution(distance, n);
        
       

    }
 
    // Driver method
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
       int graph[][] = new int[][]{{0,9,0,0,5},
                                   {9,0,0,6,7},
                                   {0,0,0,14,8},
                                  {0,6,14,0,0},
                                  {5,7,8,0,0}
                                  
                                  
                                 };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0,5);
    }
}