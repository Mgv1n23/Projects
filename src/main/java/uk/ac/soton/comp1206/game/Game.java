package uk.ac.soton.comp1206.game;

import javafx.beans.property.SimpleIntegerProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ac.soton.comp1206.component.GameBlock;
import uk.ac.soton.comp1206.event.LineClearedListener;
import uk.ac.soton.comp1206.ui.Multimedia;
import uk.ac.soton.comp1206.ui.NextPieceListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The Game class handles the main logic, state and properties of the TetrECS game. Methods to manipulate the game state
 * and to handle actions made by the player should take place inside this class.
 */
public class Game {

    private static final Logger logger = LogManager.getLogger(Game.class);

    /**
     * Property for scores
     */
    public static SimpleIntegerProperty score = new SimpleIntegerProperty(0);
    /**
     * property for level
     */
    public static SimpleIntegerProperty level = new SimpleIntegerProperty(0);
    /**
     * Property for Multiplier
     */
    public static SimpleIntegerProperty multiplier = new SimpleIntegerProperty(1);
    /**
     * Property for lives
     */
    public static SimpleIntegerProperty lives = new SimpleIntegerProperty(3);

    //Dummy Score to keep track of the level
    int dummyScore = 0;

    /**
     * Keeping track of the current piece
     */
    protected GamePiece currentPiece = spawnPiece();

    /**
     * Keeping track of the following piece
     */
    protected GamePiece nextpiece = GamePiece.createPiece(((int) (Math.random() * (14))));


    /**
     * The LineCleared Listener sends out the coordinates to apply the effect t
     */
    protected LineClearedListener lineClearedListener;
    /**
     * Initializing the timer
     */
    public Timer timer;




    /**
     * Number of rows
     */
    protected final int rows;

    /**
     * Number of columns
     */
    protected final int cols;

    /**
     * The grid model linked to the game
     */
    protected final Grid grid;




    /**
     * Create a new game with the specified rows and columns. Creates a corresponding grid model.
     * @param cols number of columns
     * @param rows number of rows
     */
    public Game(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;

        //Create a new grid model to represent the game state
        this.grid = new Grid(cols,rows);
    }

    /**
     * Start the game
     */
    public void start() {
        logger.info("Starting game");
        initialiseGame();
    }

    /**
     * Assigning the Task to the timer
     */
    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            gameLoop();

        }
    };

    /**
     * Initialise a new game and set up anything that needs to be done at the start
     */
    public void initialiseGame() {
        logger.info("Initialising game");
    }

    /**
     * Handle what should happen when a particular block is clicked
     * @param gameBlock the block that was clicked
     */
    public void blockClicked(GameBlock gameBlock) {
        //Get the position of this block
        int x = gameBlock.getX();
        int y = gameBlock.getY();

        //Get the new value for this block
        int previousValue = grid.get(x,y);
        int newValue = previousValue + 1;
        if (newValue  > GamePiece.PIECES) {
            newValue = 0;
        }

        //Update the grid with the new value
        grid.set(x,y,newValue);
    }
    public void logGameLoopEntry(){
        logger.info("Now entering the game loop");
    }
    protected void gameLoop() {
        // Check if there are remaining lives
        if (lives.get() > 0) {
            // Log entering the game loop
            logGameLoopEntry();

            // Decrement the remaining lives
            int nextLive = lives.get()-1;
            lives.set(nextLive);

            // Discard the current piece and prepare the next piece
            NextPiece();

            // Reset the multiplier
            multiplier.set(1);

            // Restart the game timer
            restartTimer();
            System.out.println("time up");

            // Log the time delay for the next iteration
           logNextIterationDelay();

            // Schedule the next game loop iteration
            scheduleNextIteration();
        } else {
            // If no lives left, end the game
            endGame();
        }
    }

    public void NextPiece(){
        currentPiece = nextpiece;
        nextpiece = spawnPiece();
        Multimedia.MusicPlayer("place.wav");

        NextPieceListener.nextmove(currentPiece, nextpiece);
    }


    public GamePiece spawnPiece(){
        //Generating new gamePiece by calling createPiece function

        int randomNumber = ((int) (Math.random() * (14)));
        GamePiece piece = GamePiece.createPiece(randomNumber);
        return piece;
    }

    protected void restartTimer(){
        timer = new Timer();
        timer.purge();
        timer.schedule(new TimerTask()  {
            @Override
            public void run(){
                gameLoop();
            }
        },getTimeDelay());
    }

    public static long getTimeDelay(){
        return Math.max(2500, 12000-500*level.get());
    }

    /**
     * Get the grid model inside this game representing the game state of the board
     * @return game grid model
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Get the number of columns in this game
     * @return number of columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * Get the number of rows in this game
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }


}
