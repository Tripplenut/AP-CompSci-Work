import java.util.*;
public class LifeDriver
{
	public static void main(String[] args)
	{
		Life organism = new Life();

		Scanner in = new Scanner(System.in);
		System.out.print("How many generations...");
		int numGenerations = in.nextInt();

		System.out.println("Original Positions...");
		System.out.println(organism);
		System.out.println();
		
		for(int i = 1; i <= numGenerations; i++)
		{
			organism.mutate();
  			System.out.println("Generation " + i);
			System.out.println(organism);
			System.out.println();
		}
		
	}
}

class Life
{
	private final int MAXSIZE = 13;

	private int[][] temp;	// used to store copy of matrix mat at the beginning
							// of each generation since changing the cells of mat
							// during each generation would alter the desire outcome.

	private int[][] mat = {
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,1,0,1,0,1,0,0,0,0},
					{0,0,0,0,1,0,0,0,1,0,0,0,0},
					{0,0,0,0,1,0,0,0,1,0,0,0,0},
					{0,0,0,0,1,0,0,0,1,0,0,0,0},
					{0,0,0,0,1,0,1,0,1,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
												 };
	public Life()
	{
		temp = new int[MAXSIZE][MAXSIZE];
	}

   /**
    *  This  methods returns a copy of the matrix passed in
    */
	private int[][] copyMatrix(int[][] orig)
	{
	    for (int i = 0; i < MAXSIZE; i++){
	        for (int o = 0; o < MAXSIZE; o++){
	            mat[i][o] = orig[i][o];
	        }
	    }
	    return mat;
	}


   /**
    *  This methods passes in a matrix and a cell position and
    *  returns the number of neighbors that cell has.
    */
	private int numNeighbors(int[][] m, int r, int c)
	{
	    int total = 0;
	    if(m[r-1][c-1] == 1)//top left
	        total++;
	    if(m[r-1][c] == 1)//above
	        total++;
	    if(m[r-1][c+1] == 1)//top right
	        total++;
	    if(m[r][c-1] == 1)//left
	        total++;
	    if(m[r][c+1] == 1)//right
	        total++;
	    if(m[r+1][c-1] == 1)//bottom left
	        total++;
	    if(m[r+1][c] == 1)//below
	        total++;
	    if(m[r+1][c+1] == 1)//bottom right
	        total++;
	   return total;
	}

   /**
    *  This methods passes in a matrix and a cell position and
    *  calculates if there is birth, survival or death of that cell
    *  by placing a 1 for birth or survival and 0 for death..
    */
	private int lifeOrDeath( int[][] m, int r, int c)
	{
	    int n = numNeighbors(m,r,c);//Total number of neighbors
	    
	    if(m[r][c] == 0 && n == 3){//Births a new cell
	        return 1;
	    }
	    else if(m[r][c] == 1 &&(n == 2 || n == 3)){//Keeps cell alive
	        return 1;
	    }
	    return 0;//kills cell
	}


   /**
    *  This methods simulates 1 generation of Life
    *  Each cell is visited and birth, survival or death is determined
    */
	public void mutate()
	{
	    //Sets the Lifes and Deaths
	    for(int i=1; i<MAXSIZE-1;i++){
	        for(int o=1; o<MAXSIZE-1;o++){
	           temp[i][o] = lifeOrDeath(mat,i,o);
	        }
	    }
	    copyMatrix(temp);
	}

   /**
    *  This methods a String of 0 and 1's representing  the contents of the matrix mat
    */
	public String toString()
	{
	    for(int i=0; i<mat.length; i++){
	        for(int o=0; o<mat[i].length; o++){
	            System.out.print(mat[i][o] + " ");
	        }
	        System.out.println("");
	    }
	    return "";
	}
}

	/* Small Exploder
	private int[][] mat = {
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,1,0,0,0,0,0,0},
					{0,0,0,0,0,1,1,1,0,0,0,0,0},
					{0,0,0,0,0,1,0,1,0,0,0,0,0},
					{0,0,0,0,0,0,1,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
												 }
	*/

	/* 9 Cell Row
	private int[][] mat = {
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,1,1,1,1,1,1,1,1,1,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
												 };
	*/

	/* Tumbler  Do 14 generations (to get back to beginning
	private int[][] mat = {
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,1,1,0,1,1,0,0,0,0},
					{0,0,0,0,1,1,0,1,1,0,0,0,0},
					{0,0,0,0,0,1,0,1,0,0,0,0,0},
					{0,0,0,1,0,1,0,1,0,1,0,0,0},
					{0,0,0,1,0,1,0,1,0,1,0,0,0},
					{0,0,0,1,1,0,0,0,1,1,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0},
												 };
    */
    