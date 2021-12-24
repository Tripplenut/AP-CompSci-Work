public class MazeRecursion{
	public static void main(String[] args){
		Maze m = new Maze();
		m.solve(5,5);			// Starting position is [5][5]
	}
}

class Maze{
    private static int solutionNumber = 0;
    private final int MAXROW = 12;
    private final int MAXCOL = 12;
    private char[][] grid =
                  { {'*','*','*',' ','*','*','*','*','*','*','*','*'},
  					{'*','*','*',' ',' ',' ',' ','*','*','*','*','*'},
                    {'*','*','*',' ','*','*',' ',' ','*','*','*','*'},
                    {'*','*','*',' ',' ',' ','*',' ',' ','*','*','*'},
                    {'*','*','*','*','*',' ','*','*',' ','*','*','*'},
                    {'*','*','*','*','*',' ','*','*',' ','*','*','*'},
                    {'*','*','*','*','*',' ','*','*','*','*','*','*'},
                    {'*','*','*','*','*',' ',' ',' ','*','*','*','*'},
                    {'*','*','*','*',' ',' ','*',' ','*','*','*','*'},
                    {'*',' ',' ',' ','*','*',' ',' ','*','*','*','*'},
                    {'*',' ','*',' ',' ',' ',' ','*','*','*','*','*'},
                    {'*',' ','*','*','*','*','*','*','*','*','*','*'}
				  };
	
	public void solve(int posRow, int posCol){
	    if(grid[posRow][posCol]=='*'||grid[posRow][posCol]=='!'){//Lets you know if you hit a wall or a point you already reached
	        //This kinda just stops the recursion calls but there's no return so yeah, hi :)
	    }
	    else if(atEnd(posRow,posCol)){//Checks if your at the end of the matrix
	        grid[posRow][posCol]='!';
	        printGrid();
	    }
	    else{
	        grid[posRow][posCol]='!';
	        solve(posRow-1,posCol);//Checks up
	        solve(posRow+1,posCol);//Checks down
	        solve(posRow,posCol-1);//Checks left
	        solve(posRow,posCol+1);//Checks right
	        grid[posRow][posCol]=' ';
	    }
	}
	
	public boolean atEnd(int r, int c){
	    if(r==0 || r == grid.length-1 || c == 0|| c == grid.length-1)
	        return true;
	    return false;
	}
	
	public void printGrid(){
		solutionNumber++;
		System.out.println("Solution #" + solutionNumber);
		for(int i=0; i<MAXROW; i++){//Prints path
		    for(int k=0; k<MAXCOL; k++){
		        System.out.print(grid[i][k]);
		    }
		    System.out.println("");
		}
		System.out.println("");
	}
}
