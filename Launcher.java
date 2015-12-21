package gfm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class Launcher {
   private static final String digits = "0123456789";

   private static String currentVersion = "1.4.3";

   private static String downloadURL =
         "https://github.com/J3698/TwoP/blob/master/release/TwoP.jar?raw=true";

   private GamePanel myGamePanel;

   public Launcher(GamePanel gamePanel) {
      myGamePanel = gamePanel;
   }

   public void checkAndInstallUpdates() {
      UIManager.put("OptionPane.background", new ColorUIResource(0, 0, 0));
      UIManager.put("Panel.background", new ColorUIResource(0, 0, 0));
      UIManager.put("OptionPane.messageForeground", new ColorUIResource(250, 250, 250));

      if (!isLatestVersion()) {
         if (JOptionPane.showConfirmDialog(myGamePanel, "Download new TwoP version?") == 0) {
            JOptionPane.showMessageDialog(myGamePanel, "Download will temporarily freeze TwoP.",
                  "", JOptionPane.WARNING_MESSAGE);
            downloadLatestVersion();
         }
      }
   }

   public boolean isLatestVersion() {
      // get arrays of decimal places for versions
      String rawCurrentVers = getCurrentVersion();
      String rawLatestVers = getLatestVersion();

      // quit if latest version returns non digits
      for (int index = 0; index < rawLatestVers.length(); index++) {
         boolean containsNonDigit = digits.indexOf(rawLatestVers.charAt(index)) == -1;
         if (containsNonDigit && rawLatestVers.charAt(index) != '.') {
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
      while (index != currentVers.length && index != latestVers.length) {
         // inform of formatting errors
         boolean latestNumFailed = latestVers[index].equals("");
         boolean currentNumFailed = currentVers[index].equals("");
         if (latestNumFailed && currentNumFailed) {
            message("Version numbers failed to be read");
            break;
         } else if (latestNumFailed) {
            message("Latest version number failed to be read:" + rawLatestVers);
            break;
         } else if (currentNumFailed) {
            message("Current version number failed to be read:" + rawCurrentVers);
            break;
         }

         // get next nubmers to compare
         currentVersInt = Integer.parseInt(currentVers[index]);
         latestVersInt = Integer.parseInt(latestVers[index]);
         // compare numbers
         if (currentVersInt > latestVersInt) {
            message("No new updates.");
            return true;
         } else if (currentVersInt < latestVersInt) {
            return false;
         }
         // move to next index
         index++;
      }
      // handle if indices have been exhausted
      if (index == currentVers.length && index == latestVers.length) {
         message("No new updates.");
         return true;
      } else if (index == currentVers.length) {
         return false;
      } else if (index == latestVers.length) {
         message("No new updates.");
         return true;
      }
      // because we need a return statement
      return true;
   }

   public void message(String message) {
      JOptionPane.showMessageDialog(myGamePanel, message);
   }

   public String getLatestVersion() {
      // declare URL, reader and version number
      URL latestVersionURL;
      BufferedReader fromWeb = null;
      String latestVersion = "";

      try {
         // get latest version
         latestVersionURL = new URL("https://raw.githubusercontent.com/J3698/TwoP/master/current.version");
         fromWeb = new BufferedReader(
               new InputStreamReader(latestVersionURL.openStream()));
         latestVersion = fromWeb.readLine();
      } catch(UnknownHostException e) {
         return "Couldn't connect to server.";
      } catch (Exception e) {
         // print errors
         e.printStackTrace();
         return "Error.";
      } finally {
         try {
            // close reader
            if (fromWeb != null) { fromWeb.close(); }
         } catch (Exception e) {
            // print errors
            e.printStackTrace();
         }
      }
      // return latest version number
      return latestVersion;
   }

   public static String getCurrentVersion() {
      return currentVersion.toString();
   }

   public boolean downloadLatestVersion() {
      // set variables for creating file name
      String fileName = "TwoP" + ("" + getLatestVersion()).replace(".", "_") + ".jar";
      File file = new File(fileName);
      int number = 0;
      // get available file name
      while (file.exists() && !file.isDirectory()) {
         number++;
         fileName = "TwoP" + ("" + getLatestVersion()).replace(".", "_") + "(" + number + ")" + ".jar";
         file = new File(fileName);
      }

      // declare variables for downloading file
      URL downloadSite;
      InputStream in = null;
      ByteArrayOutputStream out = null;
      FileOutputStream fileWriter = null;
      byte[] buffer = new byte[1024 * 16];
      int n = 0;

      // download file
      try {
         downloadSite = new URL(downloadURL);
         // establish input and ouput streams
         in = new BufferedInputStream(downloadSite.openStream());
         out = new ByteArrayOutputStream();
         // read downlaoad
         while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
         }
         // move downlaod to new file
         byte[] response = out.toByteArray();
         fileWriter = new FileOutputStream(fileName);
         fileWriter.write(response);
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         // close input and output
         try {
            if (out != null) {
               out.close();
            }
            if (in != null) {
               in.close();
            }
            if (fileWriter != null) {
               fileWriter.close();
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      message("Check the folder containing this jar for "
            + "the latest version of TwoP!");

      return true;
   }
}
