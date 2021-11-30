import java.util.*;
public class ConnectFour
{
    public static void main(String args[])
    {
        GameBoard yessir = new GameBoard();
        yessir.play();
        
    }
}

class GameBoard
{
    private int input = 0;
    private boolean win = false;
    public int[][] board = new int[6][7];
    public Scanner sc = new Scanner(System.in);
    private int player = 0; //use mod to of 2 to indicate which player is currently playing (odd turns are 1 and even turns are 2)
    

    public GameBoard()
    {
    }
    
    public void printBoard()
    {
        for(int i=0; i<board.length; i++){
            for(int o=0; o<board[i].length; o++){
                System.out.print(board[i][o]+"\t ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void play()
    {
        while (win == false) 
        {
            printBoard();
            System.out.println("Player- "+((player%2)+1)+" make a move.");
            input = sc.nextInt()-1;// Input a number between 1-7
            board[getAvailableRow(input)][input] = (player%2)+1;//Puts the players move onto the board
            win = gameOver();
            if(win)//Stops the game if the player won with the last move
                break;
            player++;
        }
        printBoard();
        System.out.println("Good job player- "+((player%2)+1)+" on winning");
    }
    
    //determines which row gets the chip (must drop to lowest available row for specified column)
    public int getAvailableRow(int c)
    {
        for(int i=board.length-1; i>=0; i--){
             if(board[i][c]==0)
                return i;
        }
        return -1;
    }

    //Returns True if someone won otherwise it keeps boolean win as false
    public boolean gameOver()
    {
        int p = (player%2)+1;
        //check rows (24 Combinations)
        for(int i=0; i<board.length; i++){
            for(int o=0; o<4; o++){
                for(int k=o; k<o+4; k++){//Checks the 4 to the right
                if(board[i][k]!=p)
                    break;//Stops the check for the combinations if conditions isnt met
                if(k==o+3)
                    return true;//If all points are equal the player, they win and the game ends
                }
            }
        }
        
        //check cols (21 Combinations)
        for(int o=0; o<board[0].length; o++){
            for(int i=0; i<3; i++){
                for(int k=i; k<i+3; k++){//Checks the 4 below the spot
                if(board[k][o]!=p)
                    break;
                if(k==i+2)
                    return true;
                }
            }
        }
        
        //check down and right diagonals (12 Combinations)
        for(int i=0; i<3; i++){
            for(int o=0; o<4; o++){
                for(int k=0; k<4;k++){//Checks the 4 down and right
                    if(board[i+k][o+k]!=p)
                        break;
                    if(k==3)
                        return true;
                }
            }
        }
        
        //check down and left diagonals (12 Combinations)
        for(int i=0; i<3; i++){
            for(int o=3; o<7; o++){
                for(int k=0; k<4;k++){//Checks the 4 down and left
                    if(board[i+k][o-k]!=p)
                        break;
                    if(k==3)
                        return true;
                }
            }
        }
        
        return false;
    }
}
