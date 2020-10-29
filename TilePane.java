/*
   Will Grana
   CS110
   TilePane Class
*/


import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.text.Text;


public class TilePane extends HBox
{
   private boolean selected;
   
   /**
   TilePane constructor. Takes a Tile and gets its letter.
   @param Tile object.
   */
   public TilePane(Tile t)
   {
      this.getChildren().add(new Text(0,0, t.getLetter()));
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(100,100);
      this.setStyle("-fx-border-width: 3;" + "-fx-border-color : black;" + "-fx-background-color : lightgray");
      selected = false;
   }
   
   /**
   setSelected method for TilePane class sets selected variable to true and makes the
   TilePane color blue to show it is selected.
   */
   public void setSelected()
   {
      this.setStyle("-fx-border-width: 3;" + "-fx-border-color : black;" + "-fx-background-color : aqua");
      selected = true;
   }
   
   /**
   setUnselected method for TilePane class sets the selected variable to false and
   changes the color of the TilePane back to grey to show it is unselected.
   */
   public void setUnselected()
   {
      this.setStyle("-fx-border-width: 3;" + "-fx-border-color : black;" + "-fx-background-color : lightgray");
      selected = false;
   }
   
   /**
   getSelectedStatus method for TilePane class returns a boolean value for
   whether the TilePane is selected or not.
   @return boolean selected.
   */
   public boolean getSelectStatus()
   {
      return selected;
   }
   
      
}