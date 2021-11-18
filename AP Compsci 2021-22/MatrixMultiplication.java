public class MatrixMultiplication {
    public static void main(String args[]) {
        
        int[][] temp1 = {{1,3,0},{2,12,-4}};
        int[][] temp2 = {{9,1},{4,-3},{-2,4}};
        
        multiplier yessir = new multiplier(temp1, temp2);
        System.out.println(yessir);
    }
}

class multiplier{
    int[][] f1;
    int[][] f2;
    int[][] result;
    
    public multiplier(int[][]x, int[][]y){
        
        if(wontWork(x,y) == true){
            f1 = new int[2][2];
            f2 = new int [2][2];
            result = new int[f1.length][f2[0].length];
        }
        else{
            f1 = x;
            f2 = y;
            result = new int[f1.length][f2[0].length];
        }
    }
    
    public boolean wontWork(int[][]x, int[][]y){
        if(x[0].length!=y.length)
            return true;
        return false;
    }
    
    public int[] getRow(int[][] x, int row){//Puts the row of a matrix into an array
        int[] temp = new int[x[row].length];
        for(int i=0; i<x[row].length; i++){
            temp[i] = x[row][i];
        }
        return temp;
    }
    
    public int[] getCol(int[][] x, int col){//Puts the column of a matrix into an array
        int[] temp = new int[x.length];
        for(int i=0; i<x.length; i++){
            for(int o=0; o<x[i].length; o++){
                if(o==col)
                    temp[i] = x[i][o];
            }
        }
        return temp;
    }
    
    public int multiplyArr(int[] x, int[]y){//Multiplies and Adds the values of an array
        int temp = 0;
        for(int i=0; i<x.length; i++){
            temp += (x[i]*y[i]);
        }
        return temp;
    }
    
    public void result(int[][] x, int[][] y){//Puts the final product into a result matrix
        for(int i=0; i<result.length; i++){
            for(int o=0; o<result[i].length; o++){
                result[i][o]=multiplyArr(getRow(f1,i), getCol(f2,o));
            }
        }
    }
    
    public String toString(){//Prints the Result Matrix
        result(f1,f2);
        for(int i=0; i < result.length; i++){
            for(int o=0; o < result[i].length; o++){
                System.out.print(result[i][o]+"\t");
            }
            System.out.println("");
        }
        return "";
    }
}