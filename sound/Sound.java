package gfm.sound;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// TODO: Auto-generated Javadoc
/**
 * The Class Sound.
 */
public class Sound {
   
   /** The my enabled. */
   private static boolean myEnabled = true;

   /** The my audio in. */
   private AudioInputStream myAudioIn;
   
   /** The my clip. */
   private Clip myClip;
   
   /** The my gain control. */
   private FloatControl myGainControl;

   /**
    * Instantiates a new sound.
    *
    * @param filename the filename
    * @param autoClose the auto close
    */
   public Sound(String filename, boolean autoClose) {
      if (! filename.contains(".wav")) {
         filename += ".wav";
      }

      loadSound(filename);

      if (autoClose) {
         myClip.addLineListener(new LineListener() {
            @Override
            public void update(LineEvent myLineEvent) {
               if (myLineEvent.getType() == LineEvent.Type.STOP) {
                  myClip.close();
               }
            }
         });
      }
   }

   /**
    * Load sound.
    *
    * @param filename the filename
    */
   private void loadSound(String filename) {
      try {
         //URL url = new URL("./" + fileName);//this.getClass().getResource(fileName);
         URL url = getClass().getResource(filename);
         myAudioIn = AudioSystem.getAudioInputStream(url);
         AudioFormat format = myAudioIn.getFormat();
         DataLine.Info info = new DataLine.Info(Clip.class, format);
         myClip = (Clip) AudioSystem.getLine(info);
         myClip.open(myAudioIn);
         myGainControl = (FloatControl) myClip.getControl(FloatControl.Type.MASTER_GAIN);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }

   /**
    * Play.
    */
   public void play() {
      if (myEnabled) {
         myClip.start();
      }
   }

   /**
    * Loop.
    *
    * @param repetitions the repetitions
    */
   public void loop(int repetitions) {
      myClip.loop(repetitions - 1);
   }

   /**
    * Loop.
    */
   public void loop() {
      myClip.loop(Clip.LOOP_CONTINUOUSLY);
   }

   /**
    * Stop.
    */
   public void stop() {
      if (myClip.isRunning()) {
         myClip.stop();
         myClip.flush();
      }
   }

   /**
    * Checks if is running.
    *
    * @return true, if is running
    */
   public boolean isRunning() {
      return myClip.isRunning();
   }

   /**
    * Reset.
    */
   public void reset() {
      myClip.setFramePosition(0);
   }

   /**
    * Change volume.
    *
    * @param decibels the decibels
    */
   public void changeVolume(float decibels) {
      myGainControl.setValue(decibels);
   }

   /**
    * Close.
    */
   public void close() {
      myClip.close();
   }

   /**
    * Close if finished.
    */
   public void closeIfFinished() {
      if ( !isRunning() ) {
         close();
      }
   }

   /**
    * Enable.
    */
   public static void enable() {
      myEnabled = true;
   }

   /**
    * Disable.
    */
   public static void disable() {
      myEnabled = false;
   }
}