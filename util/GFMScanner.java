package gfm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// TODO: Auto-generated Javadoc
/**
 * The Class GFMScanner.
 */
public class GFMScanner {
   
   /** The my path. */
   private String myPath;
   
   /** The my in. */
   private InputStream myIn;
   
   /** The my in reader. */
   private InputStreamReader myInReader;
   
   /** The my reader. */
   private BufferedReader myReader;
   
   /** The my next. */
   private String myNext;

   /**
    * Instantiates a new GFM scanner.
    *
    * @param path the path
    */
   public GFMScanner(String path) {
      myPath = path;
      myIn = getClass().getResourceAsStream(myPath);
      myInReader = new InputStreamReader(myIn);
      myReader = new BufferedReader(myInReader);
      myNext = null;
   }

   /**
    * Next line.
    *
    * @return the string
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public String nextLine() throws IOException {
      if ( myNext != null ) {
         String temp = myNext;
         myNext = null;
         return temp;
      }
      return myReader.readLine();
   }

   /**
    * Checks for next line.
    *
    * @return true, if successful
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public boolean hasNextLine() throws IOException {
      if ( myNext != null) {
         return true;
      }
      myNext = myReader.readLine();
      return !(myNext == null);
   }

   /**
    * Close.
    *
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public void close() throws IOException {
      myIn.close();
      myInReader.close();
      myReader.close();
   }

   /**
    * Gets the path.
    *
    * @return the path
    */
   public String getPath() { return myPath; }
}
