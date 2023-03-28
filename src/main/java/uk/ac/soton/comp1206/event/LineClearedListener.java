package uk.ac.soton.comp1206.event;

import java.util.ArrayList;

import uk.ac.soton.comp1206.component.GameBlockCoordinate;

/**
 * The LineClearedListener is responsible for gettting a Set of Gameblocks which are been cleared  
 * Then pass it to the GameBlockCoordinates to trigger the method on all of them at once 
 */
public interface LineClearedListener {
    /**
     * Takes in a ArrayList of GameBlocks which are supposed to be fadedOut
     * @param coordinates The Arraylist of GameBlock Coordinates
     */
    public void lineClearedCoordinates(ArrayList <GameBlockCoordinate> coordinates);
}
