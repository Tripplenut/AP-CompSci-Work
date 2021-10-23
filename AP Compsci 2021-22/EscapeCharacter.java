public class EscapeCharacter {
    public static void main(String args[]) {
        //vars
        String fSlash = "///////////////////"; //forward slash
        String bSlash = "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"; //backslash
        char q = '"';//quotations marks
        int aL = (int)(Math.random()*(50-10+1)+10),aB = (int)(Math.random()*(10-0+1)+0); // The next 5 lines creates random lab and bonus points for each student
        int lL = (int)(Math.random()*(50-10+1)+10),lB = (int)(Math.random()*(10-0+1)+0);
        int eL = (int)(Math.random()*(50-10+1)+10),eB = (int)(Math.random()*(10-0+1)+0);
        int nL = (int)(Math.random()*(50-10+1)+10),nB = (int)(Math.random()*(10-0+1)+0);
        int jL = (int)(Math.random()*(50-10+1)+10),jB = (int)(Math.random()*(10-0+1)+0);
        
        //prints
        System.out.println(fSlash+bSlash);//Top slashes
        System.out.println("==\t\t\t"+q+"Student Points"+q+"\t\t==");//Student Point
        System.out.println(bSlash+fSlash);//Bottom slashes
        System.out.println();//Enter
        System.out.println("Name\t\t"+"Lab\t\t"+"Bonus\t\t"+"Total");//Labels
        System.out.println("----\t\t"+"---\t\t"+"-----\t\t"+"-----");//Dashes
        System.out.println("Ava\t\t\t"+aL+"\t\t"+aB+"\t\t\t"+(aL+aB));//Ava Row
        System.out.println("Lexus\t\t"+lL+"\t\t"+lB+"\t\t\t"+(lL+lB));//Lexus Row
        System.out.println("Everett\t\t"+eL+"\t\t"+eB+"\t\t\t"+(eL+eB));//Everett Row
        System.out.println("Nathan\t\t"+nL+"\t\t"+nB+"\t\t\t"+(nL+nB));//Nathan Row
        System.out.println("Jeremus\t\t"+jL+"\t\t"+jB+"\t\t\t"+(jL+jB));//Jeremus Row
    }
}