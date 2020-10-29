/*
   Will Grana
   CS110
   BoggleGUI
*/


import javafx.application.Application; 
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;



public class BoggleJavaFX extends Application
{
   
   private GridPane grid;
   private Game g;
   private ArrayList<TilePane> tilepanes;
   private Text incorrect;
   private BorderPane pane;
   private VBox titlepane;
   private Text title;
   private VBox leftpane;
   private Text correctword;
   private Text score;
   private VBox bottompane;
   private VBox rightpane;
   private Button endgame;
   private Button testword;
   private Scene scene;
   
   
   
   public void start(Stage primaryStage)
   {
      g = new Game();//Initialize game and main panes
      tilepanes = new ArrayList<TilePane>();
      primaryStage.setTitle("Boggle");
      pane = new BorderPane();
      grid = new GridPane();
      pane.setCenter(grid);
      for (int i = 0; i<4;i++)//for loops to set grid of tiles
      {
         for (int j = 0; j<4;j++)
         {
            TilePane tp = new TilePane(Board.tiles.get(i).get(j));
            tp.setOnMouseClicked(this::handleClick);
            grid.add(tp,i,j);
            tilepanes.add(tp);
            
         }
      }
      titlepane = new VBox();//Set up top pane for title
      title = new Text ("Boggle");
      title.setFont(Font.font("Arial",24));
      titlepane.setAlignment(Pos.CENTER);
      titlepane.getChildren().add(title);
      leftpane = new VBox();//Set up right pane to show correct words and score
      correctword = new Text ("Words :" + g.getCorrectWords());
      score = new Text ("Score :" + g.getPoints());
      score.setFont(Font.font("Arial",16));
      correctword.setFont(Font.font("Arial",16));
      leftpane.setAlignment(Pos.CENTER);
      leftpane.getChildren().add(correctword);
      leftpane.getChildren().add(score);
      bottompane = new VBox();//Set up bottom pane to display messages to user i.e. invalid tile or invalid word
      incorrect = new Text ("");
      bottompane.getChildren().add(incorrect);
      rightpane = new VBox();      
      endgame = new Button("End Game");//End game button ends the game and issues a closing message
      endgame.setOnAction(new EventHandler<ActionEvent>() 
      {
         @Override
         public void handle(ActionEvent e) 
         {
            pane.getChildren().clear();
            VBox endmessage = new VBox();
            pane.getChildren().add(endmessage);
            Text ending = new Text("Thanks for playing! Your final score is: " + g.getPoints());
            endmessage.getChildren().add(ending);
            
               
         }
      });
      testword = new Button("Test Word");//Test word button tests the selected tiles for a corret word in the dictionary.
      testword.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle(ActionEvent e)
         {
            if (g.getDict().isValidWord(g.getSelectedTiles()))
            {
               incorrect.setText("");
            }
            else
            {
               incorrect.setText("Invalid Word");
            }

            g.testSelected();
            score.setText("Score :" + g.getPoints());
            correctword.setText("Words :" + g.getCorrectWords());
            
            for (int k = 0;k<tilepanes.size();k++)
            {
               tilepanes.get(k).setUnselected();
            }
            
               

            
         }
      });
      
     
      
      
     
            
      
      rightpane.getChildren().add(endgame);
      rightpane.getChildren().add(testword);
      pane.setRight(rightpane);//Set panes to each location of borderpane
      pane.setTop(titlepane);
      pane.setLeft(leftpane);
      pane.setBottom(bottompane);
      scene = new Scene(pane);//Initialize scene and set scene in stage
      primaryStage.setScene(scene);
      primaryStage.show();
      
      
            
      
   }
   
     
  
   
   
   
      
      public void handleClick(MouseEvent e)//Handles clicks by user in the gridpane of tiles. This method deals with selecting and unselecting.
      {
         TilePane source = (TilePane)(e.getSource());
         int row = grid.getRowIndex(source);
         int col = grid.getColumnIndex(source);
         if (!source.getSelectStatus())
         {
            
            if (g.isValidSelection(col,row))
            {
               source.setSelected();
               g.addToSelected(col,row);
               incorrect.setText("");
            }
            else
            {
               incorrect.setText("Invalid Tile");
            }
         }
         else
         {
            
            incorrect.setText("");
            int lasttile = g.getSelectedTiles().size()-1;
            if (g.getSelectedTiles().size()>0)
            {
            
            if (g.getSelectedTiles().get(lasttile).getRow()==col && g.getSelectedTiles().get(lasttile).getColumn()==row)
            {
               source.setUnselected();
               g.removeFromSelected(col,row);
            }
            }
         }
                
         
         
   }
    
       
       
 
   
   public static void main(String []args)//Main method
   {
      launch(args);
       
   }
}
         