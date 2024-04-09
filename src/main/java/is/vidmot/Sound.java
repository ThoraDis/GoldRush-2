package is.vidmot;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;


public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("sound/coin.wav");
        soundURL[1] = getClass().getResource("sound/hitmonster.wav");
        soundURL[2] = getClass().getResource("sound/titlesong.wav");
        soundURL[3] = getClass().getResource("sound/coin2.wav");
        soundURL[4] = getClass().getResource("sound/goofymusic.wav");
        soundURL[5] = getClass().getResource("sound/startup.wav");
        soundURL[6] = getClass().getResource("sound/gameover.wav");
        soundURL[7] = getClass().getResource("sound/tiktok.wav");
        soundURL[8] = getClass().getResource("sound/countdown.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            System.out.println("Finn ekki skrá");
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
