package gfm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class Launcher.
 */
public class Launcher {
   
   /** The Constant digits. */
   private static final String digits = "0123456789";

   /** The is inited. */
   private boolean isInited = false;
   
   /** The my available version url. */
   private String myAvailableVersionURL = null;
   
   /** The my current version url. */
   private String myCurrentVersionURL = null;
   
   /** The my current version. */
   private String myCurrentVersion = null;
   
   /** The my latest version. */
   private String myLatestVersion = null;
   
   /** The my download url. */
   private String myDownloadURL = null;
   
   /** The my upgrade size. */
   private int myUpgradeSize  = -1;
   
   /** The my bytes downloaded. */
   private volatile Integer myBytesDownloaded = null;

   /** The my game. */
   private Game myGame;

   /**
    * Instantiates a new launcher.
    *
    * @param game the game
    */
   public Launcher(Game game) {
      myGame = game;
   }

   /**
    * Inits the versioning.
    *
    * @param versioningFile the versioning file
    * @throws UnknownHostException the unknown host exception
    */
   public void initVersioning(String versioningFile) throws UnknownHostException {
      InputStream in = null;
      BufferedReader reader = null;
      InputStreamReader inputReader = null;
      isInited = true;

      try {
         in = getClass().getResourceAsStream(versioningFile);
         inputReader = new InputStreamReader(in);
         reader = new BufferedReader(inputReader);

         String next;
         String last = "";
         while ( (next = reader.readLine()) != null) {
            if ( last.equals("currentVersionURL") ) {
               myCurrentVersionURL = next;
            } else if ( last.equals("availableVersionURL") ) {
               myAvailableVersionURL = next;
            } else if ( last.equals("downloadURL") ) {
               myDownloadURL = next;
            }

            last = next;
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            if ( in != null ) {
               in.close();
            }
            if ( reader != null ) {
               reader.close();
            }
            if ( inputReader != null) {
               inputReader.close();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      getLatestVersion();
      getCurrentVersion();
   }

   /**
    * Checks if is latest version.
    *
    * @return true, if is latest version
    */
   public boolean isLatestVersion() {
      if ( !isInited ) {
         return true;
      }

      // get arrays of decimal places for versions
      if ( myLatestVersion == null || myCurrentVersion == null ) {
         return true;
      }

      String rawLatestVers = myLatestVersion;
      String rawCurrentVers = myCurrentVersion;

      // quit if latest version returns non digits
      for ( int index = 0; index < rawLatestVers.length(); index++ ) {
         boolean containsNonDigit = digits.indexOf(rawLatestVers.charAt(index)) == -1;
         if ( containsNonDigit && rawLatestVers.charAt(index) != '.' ) {
            message("Latest version number failed to be read:" + rawLatestVers);
            return true;
         }
      }

      // prep version numbers
      String[] currentVers = rawCurrentVers.split("\\.");
      String[] latestVers = rawLatestVers.split("\\.");

      // keep track of current decimal place
      int index = 0;
      int currentVersInt;
      int latestVersInt;

      // compare until we run out of decimal places
      while ( index != currentVers.length && index != latestVers.length ) {

         // inform of formatting errors
         boolean latestNumFailed = latestVers[index].equals("");
         boolean currentNumFailed = currentVers[index].equals("");
         if ( latestNumFailed && currentNumFailed ) {
            message("Version numbers failed to be read");
            break;
         } else if ( latestNumFailed ) {
            message("Latest version number failed to be read: " + rawLatestVers);
            break;
         } else if ( currentNumFailed ) {
            message("Current version number failed to be read: " + rawCurrentVers);
            break;
         }
         // get next nubmers to compare
         currentVersInt = Integer.parseInt(currentVers[index]);
         latestVersInt = Integer.parseInt(latestVers[index]);
         // compare numbers
         if ( currentVersInt > latestVersInt ) {
            message("No new updates.");
            return true;
         } else if ( currentVersInt < latestVersInt ) {
            return false;
         }
         // move to next index
         index++;
      }

      // handle if indices have been exhausted
      if ( index == currentVers.length && index == latestVers.length ) {
         message("No new updates.");
         return true;
      } else if ( index == currentVers.length ) {
         return false;
      } else if ( index == latestVers.length ) {
         message("No new updates.");
         return true;
      }

      // because we need a return statement
      return true;
   }

   /**
    * Message.
    *
    * @param message the message
    */
   public void message(String message) {
      JOptionPane.showMessageDialog(myGame.getGamePanel(), message);
   }

   /**
    * Gets the upgrade size.
    *
    * @return the upgrade size
    */
   public int getUpgradeSize() {
      if ( !isInited ) {
         return -1;
      }

      if ( myUpgradeSize == -1 ) {
         try {
            getLatestVersion();
         } catch (UnknownHostException e) {
            e.printStackTrace();
         }
      }
      return myUpgradeSize;
   }

   /**
    * Gets the bytes downloaded.
    *
    * @return the bytes downloaded
    */
   public Integer getBytesDownloaded() {
      return myBytesDownloaded;
   }

   /**
    * Gets the latest version.
    *
    * @return the latest version
    * @throws UnknownHostException the unknown host exception
    */
   public String getLatestVersion() throws UnknownHostException {
      if ( !isInited ) {
         return null;
      }

      if ( myAvailableVersionURL == null ) {
         throw new NullPointerException("URL to get next version number from is null.");
      }

      // declare URL, reader and version number
      URL latestVersionURL;
      BufferedReader fromWeb = null;
      String latestVersion = "";

      try {
         // get latest version
         latestVersionURL = new URL(myAvailableVersionURL);
         fromWeb = new BufferedReader(
               new InputStreamReader(latestVersionURL.openStream()));
         latestVersion = fromWeb.readLine();
      } catch (MalformedURLException e) {
         e.printStackTrace();
         return null;
      } catch (IOException e) {
         e.printStackTrace();
         return null;
      } finally {
         try {
            // close reader
            if ( fromWeb != null ) { fromWeb.close(); }
         } catch (Exception e) {
            // print errors
            e.printStackTrace();
         }
      }
      // return latest version number
      myLatestVersion = latestVersion;
      return myLatestVersion;
   }

   /**
    * Gets the current version.
    *
    * @return the current version
    */
   public String getCurrentVersion() {
      if ( !isInited ) {
         return null;
      }

      if ( myCurrentVersion != null ) {
         return myCurrentVersion;
      } else {
         InputStream in = getClass().getResourceAsStream(myCurrentVersionURL);
         InputStreamReader stream  = new InputStreamReader(in);
         BufferedReader reader = new BufferedReader(stream);

         try {
            myCurrentVersion = reader.readLine();
            myUpgradeSize = Integer.parseInt(reader.readLine());
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            try {
               if ( in != null) {
                  in.close();
               }
               if ( stream != null) {
                  stream.close();
               }
               if ( reader != null) {
                  reader.close();
               }
            } catch (IOException e) {
               e.printStackTrace();
            }
         }

         return myCurrentVersion;
      }
   }

   /**
    * Download latest version.
    *
    * @return true, if successful
    */
   public boolean downloadLatestVersion() {
      if ( !isInited ) {
         return true;
      }

      // set variables for creating file name
      String fileName = "Quiztter" + ("" + myLatestVersion).replace(".", "_") + ".jar";
      File file = new File(fileName);
      int number = 0;
      // get available file name
      while ( file.exists() && !file.isDirectory() ) {
         number++;
         fileName = "TwoP" + ("" + myLatestVersion).replace(".", "_") + "(" + number + ")" + ".jar";
         file = new File(fileName);
      }

      // declare variables for downloading file
      URL downloadSite;
      InputStream in = null;
      ByteArrayOutputStream out = null;
      FileOutputStream fileWriter = null;
      byte[] buffer = new byte[1024 * 16];
      int n = 0;
      myBytesDownloaded = 0;

      // download file
      try {
         downloadSite = new URL(myDownloadURL);
         // establish input and ouput streams
         in = new BufferedInputStream(downloadSite.openStream());
         out = new ByteArrayOutputStream();
         // read downlaoad
         while ( (n = in.read(buffer)) != -1 ) {
            out.write(buffer, 0, n);
            myBytesDownloaded += n;
         }
         // move downlaod to new file
         byte[] response = out.toByteArray();
         fileWriter = new FileOutputStream(fileName);
         fileWriter.write(response);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         myBytesDownloaded = null;
         // close input and output
         try {
            if ( out != null ) {
               out.close();
            }
            if ( in != null ) {
               in.close();
            }
            if ( fileWriter != null ) {
               fileWriter.close();
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      return true;
   }

   /**
    * Gets the download url.
    *
    * @return the download url
    */
   public String getDownloadURL() {
      if ( !isInited ) {
         return null;
      }

      return myDownloadURL;
   }
}