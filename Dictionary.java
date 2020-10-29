/*
   Will Grana
   CS110
   Dictionary Class
*/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class Dictionary
{
   private static ArrayList<String> dict= new ArrayList<String>();
   
   /**
   Constructor for the Dictionary class.
   Takes a file name with accepted words and makes an ArrayList.
   @param file name as a string.
   */
   public Dictionary(String filename)
   {
      try
      {
         File file = new File("dictionary.txt");
         Scanner filesearch = new Scanner(file);
         while (filesearch.hasNext())
         {
            dict.add(filesearch.nextLine());
         }
         filesearch.close(); 
      }
      catch (IOException e)
      {
         System.out.print("Dictionary file not found");
      }
        
   }
   
   /**
   Method to compare the user entered word with the list of acceptable words.
   @param ArrayList of selected tiles.
   @return true or false depending on whether the word is valid or not.
   */
   public boolean isValidWord(ArrayList<Tile> tiles)
   {
      StringBuilder userword = new StringBuilder();   
      for (int i = 0; i<tiles.size(); i++)
      {
         String userletter = tiles.get(i).getLetter();
         userword.append(userletter);
         if (userletter.equals("q"))
         {
            userword.append("u");
         }
      }
      String wordasstring = userword.toString().toLowerCase();
      if (dict.contains(wordasstring))
      {
         return true;
      }
      else
      {
         return false;
      }
      
   }
   
  
         
   
}      