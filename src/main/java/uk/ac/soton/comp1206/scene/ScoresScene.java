package uk.ac.soton.comp1206.scene;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleListProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Pair;
import uk.ac.soton.comp1206.ui.GamePane;
import uk.ac.soton.comp1206.ui.GameWindow;

/**
 * Scene responsible for scores
 */
public class ScoresScene extends BaseScene{
    /**
     * SimpleArrayList to hold the Scores
     */
    protected SimpleListProperty localScores;

    /**
     * ArrayList to hold the pair of Names and Scores
     */
    protected ArrayList<Pair<String,Integer>> scoresArrayList;

    /**
     * This scene will display the scores
     * @param gameWindow gameWindow
     */
    public ScoresScene(GameWindow gameWindow) {
        super(gameWindow);
//        localScores = new SimpleListProperty(FXCollections.observableArrayList(localScores));

    }

    @Override
    public void initialise() {
      
//        localScores.addListener(new ListChangeListener() {
//            @Override
//            public void onChanged(Change c) {
//
//            }
//        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                KeyCode key = t.getCode();
                if (key == KeyCode.ESCAPE){
                    gameWindow.startMenu();
                }
            }
        });

    }

    @Override
    public void build() {

        root = new GamePane(gameWindow.getWidth(), gameWindow.getHeight());
        Label gameOver = new Label("Game Over!!");
        gameOver.getStyleClass().add("bigtitle");
        gameOver.setAlignment(Pos.CENTER);

        root.setAlignment(Pos.CENTER);
        root.getChildren().add(gameOver);

    }

    /**
     * not complete
     * @return not complete
     */
    public ArrayList<Pair<String,Integer>> getScoresArrayList(){
        return scoresArrayList;
    }

    /**
     * Not Complete
     * @return Not Complete
     */
    public ObservableList<Pair<String,Integer>> createScores() {
        ObservableList<Pair<String,Integer>> observableList = FXCollections
                .synchronizedObservableList(FXCollections.observableArrayList());
        observableList.addAll(getScoresArrayList());
        return observableList;
    }
    

    
}
