package uk.ac.soton.comp1206.scene;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import uk.ac.soton.comp1206.component.PieceBoard;
import uk.ac.soton.comp1206.game.GamePiece;
import uk.ac.soton.comp1206.ui.GamePane;
import uk.ac.soton.comp1206.ui.GameWindow;

import java.util.Objects;

/**
 * The Instruction scene is responsible for displaying the instructions to play the game
 */
public class InstructionsScene extends BaseScene {

    //Making the instance of the Logger (Helps in debugging)
    private static final Logger logger = LogManager.getLogger(MenuScene.class);


    /**
     * super Constructor from the base scene
     * @param gameWindow the gameWindow
     */
    public InstructionsScene(GameWindow gameWindow) {
        super(gameWindow);
        logger.info("Creating Instructions Scene");
        //TODO Auto-generated constructor stub
    }

    @Override
    public void initialise() {
        getScene().setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ESCAPE) {
                moveOut();
            }});
        }


    /**
     * Taking back to the Menu Scene and cancelling the timer
     */
    public void moveOut(){
        gameWindow.startMenu();
    }
    @Override
    public void build() {
        
        logger.info("Building " + this.getClass().getName());
        root = new GamePane(gameWindow.getWidth(),gameWindow.getHeight());
        
        //This the main Stack Pane
        var InstructionsPane = new VBox();
        InstructionsPane.setMaxWidth(gameWindow.getWidth());
        InstructionsPane.setMaxHeight(gameWindow.getHeight());
        InstructionsPane.getStyleClass().add("menu-background");
        
        //Adding the Text
        var instructionText = new Text("Instructions");
        instructionText.getStyleClass().add("title");
        
        InstructionsPane.getChildren().add(instructionText);

        //Adding the Image
        var imgInstructions = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Instructions.png")));
        var ivInstructions = new ImageView(imgInstructions);
        ivInstructions.setFitWidth(gameWindow.getWidth()*3/4);
        ivInstructions.setFitHeight(gameWindow.getHeight()/2 );
        InstructionsPane.getChildren().add(ivInstructions);

        root.getChildren().add(InstructionsPane);
        

        //Making the instances for the small Grids
        //These Grids show all the existing pieces in the game

        //Making the instance of all the pieces
        PieceBoard piece1 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece1.addToSmallGrid(GamePiece.createPiece(1));

        PieceBoard piece2 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece2.addToSmallGrid(GamePiece.createPiece(2));

        PieceBoard piece3 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece3.addToSmallGrid(GamePiece.createPiece(3));

        PieceBoard piece4 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece4.addToSmallGrid(GamePiece.createPiece(4));

        PieceBoard piece5 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece5.addToSmallGrid(GamePiece.createPiece(5));

        PieceBoard piece6 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece6.addToSmallGrid(GamePiece.createPiece(6));

        PieceBoard piece7 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece7.addToSmallGrid(GamePiece.createPiece(7));

        PieceBoard piece8 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece8.addToSmallGrid(GamePiece.createPiece(8));

        PieceBoard piece9 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece9.addToSmallGrid(GamePiece.createPiece(9));

        PieceBoard piece10 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece10.addToSmallGrid(GamePiece.createPiece(10));

        PieceBoard piece11 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece11.addToSmallGrid(GamePiece.createPiece(11));

        PieceBoard piece12 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece12.addToSmallGrid(GamePiece.createPiece(12));

        PieceBoard piece13 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece13.addToSmallGrid(GamePiece.createPiece(13));

        PieceBoard piece14 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece14.addToSmallGrid(GamePiece.createPiece(14));

        PieceBoard piece15 = new PieceBoard(gameWindow.getWidth() / 10, gameWindow.getWidth() / 10);
        piece15.addToSmallGrid(GamePiece.createPiece(0));
        piece15.setMaxHeight(gameWindow.getHeight()/100);

        //Initialising the Grid Pane
        GridPane gridPane = new GridPane();

        //Putting all the pieces in place
        gridPane.add(piece1,0,0);
        gridPane.add(piece2,1,0);
        gridPane.add(piece3,2,0);
        gridPane.add(piece4,3,0);
        gridPane.add(piece5,4,0);
        gridPane.add(piece6,0,1);
        gridPane.add(piece7,1,1);
        gridPane.add(piece8,2,1);
        gridPane.add(piece9,3,1);
        gridPane.add(piece10,4,1);
        gridPane.add(piece11,0,2);
        gridPane.add(piece12,1,2);
        gridPane.add(piece13,2,2);
        gridPane.add(piece14,3,2);
        gridPane.add(piece15,4,2);
        
        //Adding some more customizations to the GridPane
        gridPane.setHgap(10); //horizontal gap in pixels 
        gridPane.setVgap(15); //vertical gap in pixels
        gridPane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
        gridPane.setMaxWidth(gameWindow.getWidth()/100);
        gridPane.setMaxHeight(gameWindow.getHeight()/100);
        
        //Adding the GridPane to the stack Pane
        InstructionsPane.getChildren().add(gridPane);
        StackPane.setAlignment(InstructionsPane,Pos.CENTER);

        //Some more Alignments
        InstructionsPane.setAlignment(Pos.CENTER);


    }
    
    
}
