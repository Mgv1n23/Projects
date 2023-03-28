package uk.ac.soton.comp1206.component;

import javafx.application.Platform;
import uk.ac.soton.comp1206.game.GamePiece;

/**
 * This class is responsible for creating the 3x3 grid to display the GamePiece
 */
public class PieceBoard extends GameBoard {

    /**
     * Piece board responsible for displaying the 3x3 grid
     * @param width width
     * @param height height
     */
    public PieceBoard(double width, double height) {
        super( 3, 3, width, height);
    }     

    /**
     * It is responsible for the small grid which show the next incoming piece
     * @param smallGridPiece Used to add the gameBlock on to the grid
     */
    public void addToSmallGrid(GamePiece smallGridPiece) {
        
        for(int x = 0; x < smallGridPiece.getBlocks().length; x++){
            for(int y = 0;y < smallGridPiece.getBlocks()[x].length; y++){
                grid.set(x, y, 0);

                // //Find the blocks of the 3x3 grid of a piece that holds value
                if(smallGridPiece.getBlocks()[x][y] != 0){
                    grid.set(x, y, smallGridPiece.getValue());
                }
            }
        }
        setcircle();

    }

    /**
     * This method is adding a circle in the middle Square
     */
    public void setcircle(){

        Platform.runLater(() -> {
            blocks[1][1].makeCircle();
            add(blocks[1][1].getCircle(),1,1);
        });



    }
  
}    
