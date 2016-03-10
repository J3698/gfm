package gfm;

import java.util.HashMap;
import java.util.Collection;
import java.net.URL;
import java.awt.Image;

import javax.swing.ImageIcon;

class ImageManager {
   private static ImageManager mySingleton;
   public static ImageManager getSingleton() {
      if ( mySingleton == null ) {
         mySingleton = new ImageManager();
      }
      return mySingleton;
   }

   private HashMap<String, Image> myImages;

   public ImageManager(int initCapacity) {
      myImages = new HashMap<String, Image>(initCapacity);
   }
   public ImageManager() {
      myImages = new HashMap<String, Image>();
   }

   public boolean addImage(String path) {
      URL url = getClass().getResource(path);
      if ( url == null ) {
         return false;
      }


      ImageIcon icon = new ImageIcon(url);
      // fix errors if URL is wrong - up to
      // here, we know that URL is not null, thus it exists
   }

   public boolean addImage(String path, String name) {
      
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
}
