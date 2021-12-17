public class TowerOfHanoi{
    static int moves = 0; 
    public static void main(String args[]) {
        System.out.println("The Tower Of Hanoi");
        TowerOfHanoi(3,1,2,3);
        System.out.println("# of moves- "+moves);
    }
    public static int TowerOfHanoi(int disc, int start, int help, int end){
        if(disc==1){
            moves++;
            System.out.println("Move disc at "+start+" to "+ end);
            return 0;
        }
        else{
            moves++;
            TowerOfHanoi(disc-1,start,end,help);
            System.out.println("Move disc at "+start+" to "+ end);
            return TowerOfHanoi(disc-1,help,start,end);
        }
    }
}