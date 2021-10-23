import java.util.*;
public class CardGame
{
    public static void main(String args[])
    {
        Deck yessir = new Deck();
        yessir.shuffle();
        yessir.printDeck();
    }
}

class Card
{
    //Variables
    int card; //Just a 
    String suit;//Suit of the card
    int nValue; //Number of the card
    String value; //String version of nValue
    
    
    //Constructors
    public Card() //Creates an Ace of Spades
    {
        card = 0;
        getSuit();
        getValue();
    }
    public Card(int i)
    {
        if (-1 < i && i < 52)
            card = i;
        else 
            card = 0;//Creates an Ace of spades if a number out of the range is inputed
        getSuit();
        getValue();
    }
    
    //Methods
    public void setCard(int i)// Allows you to change the given card
    {
        card = i;
        getSuit();
        getValue();
    }
    
    public void getSuit()//Assigns a suit to the card
    {
        if (card/13 == 0)
            suit = "Spades";
        if (card/13 == 1)
            suit = "Hearts";
        if (card/13 == 2)
            suit = "Clubs";
        if (card/13 == 3)
            suit = "Diamonds";
    }
    
    public void getValue()//Assigns a value to the card
    {
        if(card%13 == 0)
            value = "Ace"; nValue = 1;
        if(card%13 == 1)
            value = "2"; nValue = 2;
        if(card%13 == 2)
            value = "3"; nValue = 3;
        if(card%13 == 3)
            value = "4"; nValue = 4;
        if(card%13 == 4)
            value = "5"; nValue = 5;
        if(card%13 == 5)
            value = "6"; nValue = 6;
        if(card%13 == 6)
            value = "7"; nValue = 7;
        if(card%13 == 7)
            value = "8"; nValue = 8;
        if(card%13 == 8)
            value = "9"; nValue = 9;
        if(card%13 == 9)
            value = "10"; nValue = 10;
        if(card%13 == 10)
            value = "Jack"; nValue = 11;
        if(card%13 == 11)
            value = "Queen"; nValue = 12;
        if(card%13 == 12)
            value = "King"; nValue = 13;
    }
    
    public String toString()//Returns the cards value and suit
    {
        return value+" of "+suit;
    }
}

class Deck
{
    //Variables
    private ArrayList<Card> DOC = new ArrayList<Card>();//Deck of cards array list
    
    //Constructor
    public Deck()
    {
        deck();//Creates a fresh deck of cards
    }
    
    //Methods
    public void deck()//Creates a deck of cards in order
    {
        for(int i=0; i<52 ;i++)
        {
            DOC.add(new Card(i));
        }
    }
    
    public void printDeck()//Prints the deck of cards
    {
        for(int i=0; i<DOC.size(); i++)
        {
            System.out.println(DOC.get(i));
        }
    }
    
    public void shuffle()//Shuffles the deck of cards
    {
        ArrayList<Card> temp = new ArrayList<Card>();
        for(int i=0; i<DOC.size(); i++)
        {
            int x = (int)(Math.random()*DOC.size());//random card inside of DOC
            temp.add(DOC.get(x));//Take the random card and puts it into temp
            DOC.remove(x); //Removes the card put into temp
            i--;
        }
        DOC = temp;//Makes the shuffled deck the private variable
    }
    
}
