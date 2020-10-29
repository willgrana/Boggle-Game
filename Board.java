/*
   Will Grana
   CS110
   Board Class
*/

import java.util.ArrayList;
import java.util.Random;

public class Board
{
   private String Die0[] = {"R","I","F","O","B","X"};
   private String Die1[] = {"I","F","E","H","E","Y"};
   private String Die2[] = {"D","E","N","O","W","S"};
   private String Die3[] = {"U","T","O","K","N","D"};
   private String Die4[] = {"H","M","S","R","A","O"};
   private String Die5[] = {"L","U","P","E","T","S"};
   private String Die6[] = {"A","C","I","T","O","A"};
   private String Die7[] = {"Y","L","G","K","U","I"};
   private String Die8[] = {"Qu","B","M","J","O","A"};
   private String Die9[] = {"E","H","I","S","P","N"};
   private String Die10[] = {"V","E","T","I","G","N"};
   private String Die11[] = {"B","A","L","I","Y","T"};
   private String Die12[] = {"E","Z","A","V","N","D"};
   private String Die13[] = {"R","A","L","E","S","C"};
   private String Die14[] = {"U","W","I","L","R","G"};
   private String Die15[] = {"P","A","C","E","M","D"};
   private ArrayList<Tile> row0=new ArrayList<Tile>(4);
   private ArrayList<Tile> row1=new ArrayList<Tile>(4);
   private ArrayList<Tile> row2=new ArrayList<Tile>(4);
   private ArrayList<Tile> row3=new ArrayList<Tile>(4);
   private int numrows;
   private int numcolumns;
   public static ArrayList<ArrayList<Tile>> tiles = new ArrayList<>(4);
   
   /**
   Board Constructor.
   Creates a random board.
   */
   public Board()
   {
      ArrayList<String[]> dies = new ArrayList<String[]>();
      dies.add(Die0);
      dies.add(Die1);
      dies.add(Die2);
      dies.add(Die3);
      dies.add(Die4);
      dies.add(Die5);
      dies.add(Die6);
      dies.add(Die7);
      dies.add(Die8);
      dies.add(Die9);
      dies.add(Die10);
      dies.add(Die11);
      dies.add(Die12);
      dies.add(Die13);
      dies.add(Die14);
      dies.add(Die15);
      
      
      
      Random rand = new Random();
      int a = rand.nextInt(16);
      int b = rand.nextInt(15);
      int c = rand.nextInt(14);
      int d = rand.nextInt(13);
      int e = rand.nextInt(12);
      int f = rand.nextInt(11);
      int g = rand.nextInt(10);
      int h = rand.nextInt(9);
      int i = rand.nextInt(8);
      int j = rand.nextInt(7);
      int k = rand.nextInt(6);
      int l = rand.nextInt(5);
      int m = rand.nextInt(4);
      int n = rand.nextInt(3);
      int o = rand.nextInt(2);
      int p = rand.nextInt(1);
      row0.add(new Tile(dies.get(a)[rand.nextInt(6)].charAt(0),0,0));
      dies.remove(a);
      row0.add(new Tile(dies.get(b)[rand.nextInt(6)].charAt(0),0,1));
      dies.remove(b);
      row0.add(new Tile(dies.get(c)[rand.nextInt(6)].charAt(0),0,2));
      dies.remove(c);
      row0.add(new Tile(dies.get(d)[rand.nextInt(6)].charAt(0),0,3));
      dies.remove(d);
      row1.add(new Tile(dies.get(e)[rand.nextInt(6)].charAt(0),1,0));
      dies.remove(e);
      row1.add(new Tile(dies.get(f)[rand.nextInt(6)].charAt(0),1,1));
      dies.remove(f);
      row1.add(new Tile(dies.get(g)[rand.nextInt(6)].charAt(0),1,2));
      dies.remove(g);
      row1.add(new Tile(dies.get(h)[rand.nextInt(6)].charAt(0),1,3));
      dies.remove(h);
      row2.add(new Tile(dies.get(i)[rand.nextInt(6)].charAt(0),2,0));
      dies.remove(i);
      row2.add(new Tile(dies.get(j)[rand.nextInt(6)].charAt(0),2,1));
      dies.remove(j);
      row2.add(new Tile(dies.get(k)[rand.nextInt(6)].charAt(0),2,2));
      dies.remove(k);
      row2.add(new Tile(dies.get(l)[rand.nextInt(6)].charAt(0),2,3));
      dies.remove(l);
      row3.add(new Tile(dies.get(m)[rand.nextInt(6)].charAt(0),3,0));
      dies.remove(m);
      row3.add(new Tile(dies.get(n)[rand.nextInt(6)].charAt(0),3,1));
      dies.remove(n);
      row3.add(new Tile(dies.get(o)[rand.nextInt(6)].charAt(0),3,2));
      dies.remove(o);
      row3.add(new Tile(dies.get(p)[rand.nextInt(6)].charAt(0),3,3));
      dies.remove(p);
      tiles.add(row0);
      tiles.add(row1);
      tiles.add(row2);
      tiles.add(row3);
      
   }
   
   /**
   Method to return the board as a string.
   @return board as a string.
   */
   public String toString()
   {
      return row0 + "\n" + row1 + "\n" + row2 + "\n" + row3;
   }
   
   /**
   Method to return the letter of a tile, given row and column.
   @param integer row and integer column
   @return tile letter as string.
   */
   public String getTile(int row, int column)
   {
      return tiles.get(row).get(column).getLetter();   
   }
      
   
}