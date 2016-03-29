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

   public boolean add(String path) {
      return add(path, path);
   }

   public boolean add(String path, String name) {
      ImageIcon icon = new ImageIcon(path);
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

   public Image getImageLazy(String name) {
      Image img = getImage(name);
      if ( img != null ) {
         return img;
      } else {
         add(name);
         return getImage(name);
      }
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
