package uk.ac.soton.comp1206.ui;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Objects;

public class Multimedia {

    private static final Logger logger = LogManager.getLogger(Multimedia.class);
    public static MediaPlayer musicPlayer;

    private static final BooleanProperty PlayAudio = new SimpleBooleanProperty(true);
    public static BooleanProperty PlayAudio(){
        return PlayAudio;
    }
    public static void setPlayAudio(boolean enable){
        PlayAudio().set(enable);
    }
    public static boolean getPlayAudio(){
        return PlayAudio().get();
    }
    public static MediaPlayer bgmplayer;
    public static void BGM(String music) {
        if (!getPlayAudio()){
            return;
        }
        String Play = Objects.requireNonNull(Multimedia.class.getResource("/music/" + music)).toExternalForm();

        try{
            Media playbgm = new Media(Play);
            bgmplayer = new MediaPlayer(playbgm);
            bgmplayer.setAutoPlay(true);
            bgmplayer.setCycleCount(MediaPlayer.INDEFINITE);
            bgmplayer.play();

        }
        catch(Exception e){
            setPlayAudio(false);
            e.printStackTrace();
        }
    }
    public static void MusicPlayer(String sound){
        if (!getPlayAudio()){
            return;
        }
        String Play = Objects.requireNonNull(Multimedia.class.getResource("sound"+sound)).toExternalForm();

        logger.info(Play);

        try{
            Media playmp = new Media(Play);
            musicPlayer = new MediaPlayer(playmp);
            musicPlayer.play();
        }
        catch (Exception e){
            setPlayAudio(false);
            e.printStackTrace();
        }
    }
}
