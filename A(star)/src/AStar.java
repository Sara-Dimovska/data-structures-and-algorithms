import java.util.*;

public class AStar 
{
    
    static class Cell
    {  
        int H = 0; //rastojanie do destinacijata 
        int F = 0; //G+H,finalno rastojanie 
        int i, j;
        Cell parent; //za da ostavame traga
        
        Cell(int i, int j)//koordinati na kelija
        {
            this.i = i;
            this.j = j; 
        }
        
        @Override
        public String toString()
        {
            return "["+this.i+", "+this.j+"]";
        }
    }
    
    //G
    public static final int DIAGONAL_COST = 14;
    public static final int V_H_COST = 10;
    
    
    static Cell [][] grid = new Cell[5][5];
    
    //razgleduvanje na sosedi,otvaranje na patot
    static PriorityQueue<Cell> open;
     
    static boolean closed[][];//izbrani kjelii 
    static int startI, startJ;
    static int endI, endJ;
            
    public static void set_Blocked(int i, int j)
    {
        grid[i][j] = null;
    }
    
    public static void Source(int i, int j)
    {
        startI = i;
        startJ = j;
    }
    
    public static void Destination(int i, int j)
    {
        endI = i;
        endJ = j; 
    }
    
    //razgleduvanje i izmena na finalnata tezina 
    static void checkAndUpdateCost(Cell current, Cell t, int cost)
    {
    	//ako e blok ili e vekje izbrana kjelija
        if(t == null || closed[t.i][t.j])
        	return;
        
        
        //new cost = cost to destination + dosegashnata od pominat pat
        
        int t_final_cost = t.H+cost;//ako go odbere
        
        boolean inOpen = open.contains(t);
        
        
        //ako ne e na otvoren pat ili novata tezina e pomala od tekovnata
        
        if(!inOpen || t_final_cost < t.F)
        {
        	//System.out.println("t.f = " +t.F);
        	//System.out.println("t_final_cost="+t_final_cost);
        	
            t.F = t_final_cost;
            t.parent = current;
            
            if(!inOpen)//vo sortiran red
            	open.add(t);
        }
    }
    
    public static void Astar()
    { 
        
        //source dodavame vo red
        open.add(grid[startI][startJ]);
        
        
        Cell current;
        
        while(true)
        { 
            current = open.poll();//vademe
            
            if(current==null) break;//ako e blok
            closed[current.i][current.j]=true;//oznacuvanje na vekje poseten

            if(current.equals(grid[endI][endJ]))//ako e destination
                return; 
            
            
           //------------ sosedi na izvorot ----------------------------------------------
            Cell t; 
            
            //nad 
            if(current.i-1 >= 0)
            {
                t = grid[current.i-1][current.j];
                checkAndUpdateCost(current, t, current.F+V_H_COST);//G vtor param
               
                //nad ,diagonalno-levo
                if(current.j-1 >= 0)
                {                      
                    t = grid[current.i-1][current.j-1];
                    checkAndUpdateCost(current, t, current.F+DIAGONAL_COST); 
                }

                //nad ,diagonalno-desno < dolzina na redici,
                if(current.j+1 < grid[0].length)
                {
                    t = grid[current.i-1][current.j+1];
                    checkAndUpdateCost(current, t, current.F+DIAGONAL_COST); 
                }
            } 

            //levo 
            if(current.j-1 >= 0)
            {
                t = grid[current.i][current.j-1];
                checkAndUpdateCost(current, t, current.F+V_H_COST); 
            }

            //desno 
            if(current.j+1<grid[0].length)
            {
                t = grid[current.i][current.j+1];
                checkAndUpdateCost(current, t, current.F+V_H_COST); 
            }

            //pod
            if(current.i+1<grid.length)
            {
                t = grid[current.i+1][current.j];
                checkAndUpdateCost(current, t, current.F+V_H_COST); 

                //pod,diagonalno levo
                if(current.j-1>=0)
                {
                    t = grid[current.i+1][current.j-1];
                    
                    checkAndUpdateCost(current, t, current.F+DIAGONAL_COST); 
                    
                }
                
                //pod,diagonalno desno
                if(current.j+1<grid[0].length)
                {
                   t = grid[current.i+1][current.j+1];
                    checkAndUpdateCost(current, t, current.F+DIAGONAL_COST); 
                }  
            }
        } 
    }
    
    public static void test(int nCase, int maxi, int maxj, int si, int sj, int ei, int ej, int[][] blocked)
    {
           System.out.println("\n\nSlucaj broj #"+nCase);
           
           grid = new Cell[maxj][maxj];//mapa
           closed = new boolean[maxi][maxj];//izbran pat
           
           //sortiranje spored najmalata tezina
           
           open = new PriorityQueue<>((Object o1, Object o2) -> 
           {
                Cell c1 = (Cell)o1;
                Cell c2 = (Cell)o2;

                return c1.F < c2.F? -1:
                        c1.F>c2.F? 1:0;
            });
           
           Source(si, sj);  
           
           
           Destination(ei, ej); 
           
           for(int i=0;i< maxi;i++)//init.1
           {
              for(int j=0;j<maxj;j++)
              {
                  grid[i][j] = new Cell(i, j);
                  grid[i][j].H = Math.abs(i-endI)+Math.abs(j-endJ);

              }

           }
           grid[si][sj].F = 0;
           
           
           for(int i=0;i<blocked.length;i++)//init.2
           {
               set_Blocked(blocked[i][0], blocked[i][1]);
           }
           
           //print initial map
           System.out.println("Prostor: ");
            for(int i=0;i<maxi;i++)
            {
                for(int j=0;j<maxj;j++)
                {
                   if(i==si&&j==sj)System.out.print("SO  "); //Source
                   else if(i==ei && j==ej)System.out.print("DE  ");  //Destination
                   else if(grid[i][j]!=null)System.out.printf("%-3d ", 0);
                   else System.out.print("||  "); 
                }
                System.out.println();
            } 
            System.out.println();
           
           Astar(); 
           
           //print tezini
           System.out.println("\nTezini na kjelii: ");
           for(int i=0;i<maxi;i++)
           {
               for(int j=0;j<maxj;j++)
               {
                   if(grid[i][j]!=null)System.out.printf("%-3d ", grid[i][j].F);
                   else System.out.print("||  ");
               }
               System.out.println();
           }
           System.out.println();
            
           //---------------BACKTRACKING-------------------------------------
           if(closed[endI][endJ])//ako e posetena destinacijata
           {
               
                System.out.println("Pat: ");
                Cell current = grid[endI][endJ];
                System.out.print(current);
                
                while(current.parent!=null)
                {
                    System.out.print(" -> "+current.parent);
                    current = current.parent;
                } 
                System.out.println();
           }else System.out.println("Ne postoi pat");
    }
    public static void main(String[] args) throws Exception
    {   
        test(1, 5, 5, 2, 1, 2, 4, new int[][]{{1,3},{2,3},{3,3}}); 
    
    }
}
