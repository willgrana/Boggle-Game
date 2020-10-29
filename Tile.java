/*
   Will Grana
   CS110
   Tile Class
*/

public class Tile
{
   private char letter;
   
   private int row;
   private int column;
   
   /**
   Constructor for Tile Class.
   Assigns a letter, a row, and a column.
   @param letter as a string, row as an integer, column as an integer.
   */
   public Tile(char letter, int row, int column)
   {
      this.letter = letter;
      this.row = row;
      this.column = column;
   }
   
   /**
   Alternate constructor fot Tile Class.
   Accepts a string instead of a char for the letter to handle 'Qu' scenarios.
   @param letter as a string, row as an int, column as an int.
   */
   public Tile(String letter, int row, int column)
   {
      this.letter = 'q';
      this.row = row;
      this.column = column;
   }

   
  
   
   /**
   Method to get letter assigned to tile.
   @return letter as a string.
   */
   public String getLetter()
   {
    return Character.toString(letter);
   }
   
   
   /**
   Method to getter row assigned to tile.
   @return row as an int.
   */
   public int getRow()
   {
      return row;
   }
   
   /**
   Method to get cloumn assigned to tile.
   @return column as an int.
   */
   public int getColumn()
   {
      return column;
   }
   
   /**
   Method to return tile's assigned letter as string.
   @return letter as a string.
   */
   public String toString()
   {
      return getLetter();
   }
   
   /**
   equals method for comparing tile objects.
   @param Tile object
   @return boolean if the tiles are equal or not.
   */
   public boolean equals(Tile other)
   {
      if (this==null)
         return false;
      if (this==other)
         return true;
      if (this.getClass()!=other.getClass())
         return false;
      if (this.getRow()==other.getRow() && this.getColumn()==other.getColumn())
         return true;
      else
         return false;
   }
}