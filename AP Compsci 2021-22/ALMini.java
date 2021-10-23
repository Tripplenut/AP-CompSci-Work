import java.util.*;
public class ALMini
{
    public static void main(String args[])
    {
        AL yessir = new AL();
        
        /*The Array list for the problems
        * Just change the values within list.add depending on the method being used
        * If the method uses an Integer or String change as needed
        * The methods should have the type they take next to them
        */
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        
        //Methods
        //yessir.minToFront(list); //Integer Array List
        //yessir.removeEvenLength(list); //String Array List
        //yessir.doubleString(list); //String Array List
        //yessir.stretch(list); //Integer Array List
        //yessir.switchPairs(list); //String Array List
        //System.out.println(yessir.multiply(list)); //Integer Array List
        //System.out.println(yessir.hasNegativeSum(list)); //Integer Array List
        //yessir.sendBackHalf(list); //Integer or String Array List
        
        //Prints
        //yessir.original(list); //Prints the Inputed ArrayList
        yessir.print(); //Prints the Final ArrayList
    }
}

class AL
{
    private ArrayList temp = new ArrayList();
    public AL(){}
    
    public void minToFront(ArrayList<Integer> list)
    {
        int set = 0; //Remembers the place of the lowest value
        int value = list.get(0);//Remembers the lowest value (Starts as the index)
        
        for(int i = 0; i<list.size()-1; i++)
        {
            if (value>list.get(i+1))//Checks if the lowest value is lower than the 
                set = i+1; value = list.get(set);
        }
        
        list.remove(set);//Takes the number out of the arraylist
        list.add(0,value);//Puts the number back into the list but at the start
        temp = list;
    }
    
    public void removeEvenLength(ArrayList<String> list)
    {
        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i).length()%2 == 0)//Checks if the string in the list is even
            {
                list.remove(i); 
                i--;//goes bac
            }
        }
        temp = list;
    }
    
    public void doubleString(ArrayList<String> list)
    {
        for(int i=0; i<list.size() ;i++)
        {
            list.add(i+1,list.get(i));//Adds a copy of the string at the index
            i++;//Skips the newly added string
        }
        temp = list;
    }
    
    public void stretch(ArrayList<Integer> list)
    {
        for(int i=0; i<list.size(); i++)
        {
            if (list.get(i)%2==1)//checks if the int is odd
            {
                list.add(i+1,list.get(i)/2);//puts half of the int in the next index
                list.set(i,(list.get(i)/2)+1);//makes the current index half of the number(adds 1 since odd)
                i++;//skips the new index
            }
            else
            {
                list.add(i+1,list.get(i)/2);
                list.set(i,list.get(i)/2);
                i++;
            }
        }
        
        temp = list;
    }
    
    public void switchPairs(ArrayList<String> list)
    {
        String value;
        
        if (list.size()%2==1)//checks if the array list is odd
        {
            for(int i=0; i<list.size()-1; i++)
            {
                value = list.get(i);
                list.set(i,list.get(i+1));
                list.set(i+1,value);
                i++;
            }
        }
        else
        {
            for(int i=0; i<list.size(); i++)
            {
                value = list.get(i);//Remembers the string being removed
                list.set(i,list.get(i+1));//Sets the current index to the next index
                list.set(i+1,value);//Sets the next string to the one before it
                i++;//skips the pair switched
            }
        }
        temp = list;
    }
    
    public int multiply(ArrayList<Integer> list)
    {
        int total = 1;
        for(int i=0; i<list.size();i++)
        {
            total *= list.get(i);
        }
        
        return total;
    }
    
    public boolean hasNegativeSum(ArrayList<Integer> list)
    {
        boolean neg = false; //Boolean that indicates when total is negative
        int total = 0;
        for(int i=0; i<list.size() ;i++)
        {
            total += list.get(i);//Adds the next index to total
            if (total<0)//When Total is less than 0 (or negative) it returns false
            {
                neg = true;
                return neg;
            }
        }
        return neg;
    }
    
    public void sendBackHalf(ArrayList list)
    {
        //For this one I just did all 3. Just take the comments out for which ever one you want to do.
        
        //First Half
        /*
        for(int i=0; i<list.size()/2;i++)
            temp.add(list.get(i)); //makes temp the first half
        */
        
        //Last Half
        /*
        for(int i=list.size(); i>list.size()/2;i--)
            temp.add(list.get(i-1)); //makes temp the last half
        */
        
        //Every Other
        /*
        for(int i=0; i<list.size();i++)
        {
            if(i%2==0)//change the 0 to 1 if you want to get all the even indexs
                temp.add(list.get(i));
        }
        */
    }
    
    public void original(ArrayList list)
    {
        for(int i=0; i<list.size();i++)
            System.out.println(list.get(i));
    }
    
    public void print()
    {
        for(int i=0; i<temp.size();i++)
            System.out.println(temp.get(i));
    }
}