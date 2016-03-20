import java.util.HashMap;
import java.util.Collection;
import java.net.URL;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;

class ImageManager {
   private static ImageManager mySingleton;

   private HashMap<String, Image> myImages;

   public ImageManager(int initCapacity) {
      myImages = new HashMap<String, Image>(initCapacity);
   }
   public ImageManager() {
      myImages = new HashMap<String, Image>();
   }

   public boolean addImage(String path) {
      return addImage(path, path);
   }

   public boolean addImage(String path, String name) {
      // load image
      URL url = getClass().getResource(path);
      if ( url == null ) {
         return false;
      }
      ImageIcon icon = new ImageIcon(url);
      // get load status
      int status = 0;
      do {
         status = icon.getImageLoadStatus();
      } while ( status == MediaTracker.LOADING );
      // add if loaded correctly
      if ( status == MediaTracker.COMPLETE ) {
         myImages.put(name, icon.getImage());
         return true;
      }
      return false;
   }

   public Image getImage(String name) {
      return myImages.get(name);
   }

   public void clear() {
      myImages.clear();
   }
   public int size() {
      return myImages.size();
   }
   public Collection<Image> getImages() {
      return myImages.values();
   }

   public static ImageManager getSingleton() {
      if ( mySingleton == null ) {
         mySingleton = new ImageManager();
      }
      return mySingleton;
   }
}
