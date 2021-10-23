public class Text
{
    public static void main(String args[])
    {
       TextFormatter T = new TextFormatter("_this_ is _a_ sentence");
       System.out.println("Find String- "+T.findString("t",5));
       System.out.println("Count Strings- "+T.countStrings("en"));
       System.out.println("Convert to Italics- "+T.convertItalics());
       
    }
}

class TextFormatter
{
    
    private String line; //The line to format
    
    public TextFormatter (String lineToFormat)
    {
        line = lineToFormat;
    }
    
    /**
     * Finds the first single instance of str in line,starting at the position start 
     * @param str the string of length 1 to find, guaranteed to be length 1. 
     * @param start the position to start searching, guaranteed to be in the string line. 
     * @return the index of the first single instance of str if the string is found 
     * or -1 if it is not found
     */
    public int findString (String str, int start)
    {
        if(line.length()>1)// Checks if the string is long enough
        {
            String text = line.substring(start)+" "; //Takes the string that needs to be check and turns it into a var
            //I added a space to the text so that the loop doesn't go out of the strings range
            char c = str.charAt(0); //turns the "string" into a char
            int x = text.length(); //makes the text length a var
            for(int i = 0; i<x; i++) //A loop to check for each char in the string
            {
                //System.out.println(text.charAt(i)); //This can be deleted it's literally here to make sure the loop works 
                if (i == 0)
                {
                    if ((text.charAt(i) == c) && (text.charAt(i+1) != c))//Checks if the first char in the string
                        return i+start;//Adds the characters removed
                }
                if ((i != 0) && (i != x)) //Same thing as above but for every other character
                {
                    if ((text.charAt(i-1) != c) && (text.charAt(i) == c) && (text.charAt(i+1) != c))
                        return i+start;
                }
            }
            return -1;//If all the conditions fail to be met
        }
        else //Result if the string isn't long enough
            return -1;
    }
    
    /**
     *Count the number of times single instances of str appear in the line.
     *@param str the string to find.
     *Guaranteed to be length 1. 
     *@return the number of times the string appears in the line
     */
    public int countStrings (String str)
    {
       String text = line + " ";//Added a space so the loop doesnt go out of the strings index
       int count = 0;//Used to count the return
       for (int i = 0; i < (text.length()-1); i++)//A loop
       {
           if (str.charAt(0) == text.charAt(i) && str.charAt(1) == text.charAt(i+1)) //Checks each char of the line to check for str
               count++;
       }
       return count;
    }
     
     /**
     * Replace all single instances of underscores in the line given by
     * line with italics tags. There must be an even number of underscores
     * in the line, and they will be replaced by <I>, </I>, alternating.
     * @param original a string of length 1 to replace
     * @param replacement the string (of any length) use as a replacement
     * @return the line with single instances of underscores replaced with
     * <I> tags or the original line if there are not an even number of underscores.
     */ 
     
    public String convertItalics()
    {
        String newline = line;//The line that will return for the modified string
        int count = 0;
        for(int i = 0; i < line.length() ;i++) //Counts the amount of underscores in the string
        {
            if(line.charAt(i) == '_')
                count++;
        }
        
        if (count % 2 == 0)//Only converts underscores to <I> if there are an even amount
        {
            newline = newline.replace("_","<I>"); //Converts all the underscores into <I>
            int check = 0;
            for(int i=0; i < newline.length(); i++)
            {
                if (newline.charAt(i) == '<')// Checks for '<'
                {
                    check++;
                    if (check%2 == 0)//Checks for the 2nd instance of "<""
                    {
                        newline = newline.substring(0,i)+"</"+newline.substring(i+1);// Every other "<" adds a "/"
                    }
                }
            }
            return newline;
        }
        else //If the underscore count is not 2 it returns the original line
            return line;
    }
}