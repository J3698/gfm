package gfm.gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;

import gfm.util.Vec2;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuButton.
 */
public class MenuButton extends BasicButton {
   
   /**
    * Instantiates a new menu button.
    *
    * @param listener the listener
    * @param text the text
    * @param position the position
    * @param size the size
    */
   public MenuButton(ActionListener listener, String text, Vec2 position, Vec2 size) {
      super(listener, text, Color.black, Color.black, null, position, size);
      setRandomBodyColor();
      setTextColor(new Color(100, 100, 100));
   }

   /**
    * Sets the random body color.
    */
   public void setRandomBodyColor() {
      Random rand = new Random();
      int base = 100;
      int range = 255 - base;
      int red = base + rand.nextInt(range + 1);
      int green = base + rand.nextInt(range + 1);
      int blue = base + rand.nextInt(range + 1);
      setBodyColor(new Color(red, green, blue));
   }
}