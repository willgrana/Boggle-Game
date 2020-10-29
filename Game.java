/*
   Will Grana
   CS110
   Game Class
*/

import java.util.ArrayList;

import java.lang.StringBuilder;

public class Game
{
   private ArrayList<Tile> selectedtiles;
   private Dictionary dict;
   private int totalpoints;
   public ArrayList<String> correctwords = new ArrayList<String>();
   
   /**
   Game Constructor
   Creates the board, creates an array to store selected tiles, and initializes the dictionary.
   */
   public Game()   
   {
      Board b = new Board();
      selectedtiles = new ArrayList<Tile>();
      dict= new Dictionary("dictionary.txt");  
   }
   
   /**
   toString method for the Game class.
   Prints the board, selected tiles, correct words, and your score.
   @return arraylist of tiles, arraylist of selected tiles, arraylist of correct words, and integer score.
   */
   public String toString()
   {
      return Board.tiles.get(0) + "\n" + Board.tiles.get(1) + "\n" + Board.tiles.get(2) + "\n" + Board.tiles.get(3) + "\nSelected: " + getSelectedTiles()+ "\nWords: " + getCorrectWords() + "\nScore: " +totalpoints;
   }
   
   /**
   isValidSelection method for Game class.
   Only allows for adjacent tiles to be selected after the first tile has been selected.
   @param integer row and integer column of tile
   @return boolean for if selection is allowed or not.
   */
   public boolean isValidSelection(int row, int column)
   {
      
      if (selectedtiles.size()>0)
      {
         int lasttilerow1 = selectedtiles.get(selectedtiles.size()-1).getRow();
         int tilerow = row;
         int lasttilerow2 = selectedtiles.get(selectedtiles.size()-1).getRow()-1;
         int lasttilerow3 = selectedtiles.get(selectedtiles.size()-1).getRow()+1;
         int tilecolumn = column;
         int lasttilecolumn1 = selectedtiles.get(selectedtiles.size()-1).getColumn();
         int lasttilecolumn2 = selectedtiles.get(selectedtiles.size()-1).getColumn()-1;
         int lasttilecolumn3 = selectedtiles.get(selectedtiles.size()-1).getColumn()+1;
         

          if ((lasttilerow1==tilerow|lasttilerow2==tilerow|lasttilerow3==tilerow) && (lasttilecolumn1==tilecolumn|lasttilecolumn2==tilecolumn|lasttilecolumn3==tilecolumn))
          {
            return true;
          }
          return false;
      }
      else
      {
         return true;
      }
      
   }
   
   /**
   addToSelected method for the Game class.
   Adds a tile to the list of selected tiles given the row and column by the user.
   @param integer row and integer column.
   */
   public void addToSelected(int row, int column)
   {
      selectedtiles.add(Board.tiles.get(row).get(column));
   }
   
   /**
   removeFromSelected method for the Game class.
   Allows the user to deselect a selected tile based on its row and column.
   @param integer row and integer column.
   */
   public void removeFromSelected(int row, int column)
   {
      for (int i = 0;i<selectedtiles.size();i++)
      {
         if (selectedtiles.get(i).getRow()==row && selectedtiles.get(i).getColumn()==column)
         {
            selectedtiles.remove(i);
         }
      }
   }  
   
   /**
   getSelectedTiles method for Game class.
   Gives an arraylist of selected tiles.
   @return ArrayList of selected tiles.
   */   
   public ArrayList<Tile> getSelectedTiles()
   {
      return selectedtiles;
   }
   
   /**
   clearSelected method for the Game class.
   Allows the user to clear the list of selected tiles.
   */
   public void clearSelected()
   {
      selectedtiles.clear();
   }
   
   /**
   testSelected method for the Game class.
   Tests selected tiles for a correct word.
   If the word is acceptable, it is added to the list of correct words points are awarded.
   */
   public void testSelected()
   {
      Word w = new Word(selectedtiles);
      String selectedword = w.toString();
      if (!correctwords.contains(selectedword))
      {
      if (dict.isValidWord(selectedtiles))
      {
         correctwords.add(selectedword);
         totalpoints = w.getPoints()+totalpoints;
      }
      }
      
      selectedtiles.clear();
   }
   
   /**
   getCorrectWords method for the Game class.
   Gives an arraylist of correct words.
   @return correct words in an ArrayList.
   */
   public String getCorrectWords()
   {
      String words = "";
      for (int a = 0;a<correctwords.size();a++)
      {
         words +="\n";
         words +=correctwords.get(a);
      }
      return words;
   }
   
   /**
   getPoints method for the Game class returns the
   total points earned by the user as an int.
   @return integer totalpoints.
   */
   public int getPoints()
   {
      return totalpoints;
   }
   
   /**
   getDict method for the Game class returns the dictionary.
   @return Dictionary object.
   */
   public Dictionary getDict()
   {
      return dict;
   }
   
      
      
            
}