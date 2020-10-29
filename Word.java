/*
   Will Grana
   CS110
   Word Class
*/

import java.util.ArrayList;
import java.lang.StringBuilder;
public class Word
{
   private String word;
   private static int points;
   
   /**
   Constructor for the Word class.
   Takes an ArrayList of selected tiles and constructs the word.
   @param ArrayList of Tile objects.
   */
   public Word(ArrayList<Tile> tiles)
   {
      StringBuilder w = new StringBuilder();
      
      for (int i = 0; i<tiles.size(); i++)
      {
         
         if (tiles.get(i).getLetter().equals("q"))
         {
            w.append("qu");
         }
         else
         {
            w.append(tiles.get(i).getLetter());
         } 
           
         
         
      }
      word = w.toString();
      if (word.length()<5)
      {
         points = 1;
      }
      if (word.length()==5)
      {
         points = 2;
      }
      if (word.length()==6)
      {
         points = 3;
      }
      if (word.length()==7)
      {
         points = 5;
      }
      if (word.length()>7)
      {
         points = 11;
      }
      


      
            
   }
   
   /**
   Method to show how many points the word is worth.
   @return points as an int.
   */
   public static int getPoints()
   {

      return points;
   }
   
   /**
   Method to return the user selected word as a string.
   @return word as a string.
   */
   public String toString()
   {
      return word;
   }
   
   /**
   equals method for Word objects.
   Takes a word and compares it.
   @param Word object
   @return boolean for if the words are equal or not
   */
   public boolean equals(Word w)
   {
      if (this.toString()==w.toString())
         return true;
      else
         return false;
   }
}
      