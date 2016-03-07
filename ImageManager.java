package gfm;

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
      myImages = new HashMap<String, Image>(capacity);
   }
   public ImageManager() {
      myImages = new HashMap<String, Image>();
   }

   public boolean addImage(String path) {
      
   }

   public boolean addImage(String path, String name) {
      
   }

   public Image getImage(String name) {
   }

   public void clear() {
      myImages.clear();
   }
   public int size() {
      return myImages.size();
   }
   public Collection<V> getImages() {
      return myImages.values();
   }
}
