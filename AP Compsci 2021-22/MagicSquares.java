import java.util.*;
public class MagicSquares
{
    public static void main(String args[])
    {
        System.out.println("Please input the size of Magic Square");
        System.out.println("Only odd numbers are accepted, no negatives either");
        int userNumber = 3; //Starts at 3 just incase the while loop decides to break
        Scanner input = new Scanner(System.in);
        boolean param = false;
        while (param == false)//Makes sure the number being inputed is odd and positive
        {
            
            userNumber = input.nextInt();
            if((userNumber > 0)&&(userNumber%2 == 1)){
                param = true;
            }
            else{
                System.out.println("Please input a positive odd number");
            }
        }
        Square yessir = new Square(userNumber);
        System.out.println("Magic Square");
        yessir.print();
    }
}

class Square
{
    private int[][] magic;
    public Square(){
        magic = new int [3][3];
    }
    
    public Square(int number){
        magic = new int [number][number];
        create();
        //print();
    }
    
    public void create()
    {
        int i = 0;//row
        int o = magic.length/2;//column
        int len = magic.length; //shortend
        int k = 1; //Number being put into index
        for(int n=0; n < (len*len); n++){
            if(k==1){//Puts the first number in the top middle to start the algorithm
                magic[i][o]=k;
            }
            else if(i==0&&o==len-1)//Checks if number is at top right corner(bug fix)
            {
                i=1;
                o=len-1;
                magic[i][o]=k;
            }
            else if(i == 0){//Checks if in top row
                i = len-1;
                if(o == len-1){//Checks if in last column
                    o = 0;
                    magic[i][o]=k;
                }
                else{ //shifts number to the right if not in last column
                    o++;
                    magic[i][o]=k;
                }
            }
            else if(o == len-1){ //Checks if in last column
                i--;
                o = 0;
                magic[i][o] = k;
            }
            else{ //Runs if no condition is met
                i--;
                o++;
                if(magic[i][o] != 0)//Checks if the spot is taken
                {
                    i++;
                    i++;
                    o--;
                }
                magic[i][o] = k;
            }
            k++;
            //print();
            //System.out.println("");
        }
    }
    
    public void print()
    {
        for(int i=0; i < magic.length; i++){
            for(int o=0; o < magic[i].length; o++){
                System.out.print(magic[i][o]+"\t");
            }
            System.out.println("");
        }
    }
}