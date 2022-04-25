package wit.comp1050.mastermind;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class Audio {
    public static void main(String[] args){
        //System.out.println(Audio.class.getClassLoader().getResourceAsStream("README.md"));
        //playSound("sounds/pegPlace.wav");
        Audio audio = new Audio();
        audio.playMusic("checkSound.wav");
    }

    void playMusic(String musicLocation){
        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()){
                AudioInputStream ais = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.start();
            } else {
                System.out.println("Cant find file.");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}