package gfm.gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;

import gfm.util.Vec2;

public class MenuButton extends BasicButton {
   public MenuButton(ActionListener listener, String text, Vec2 position, Vec2 size) {
      super(listener, text, Color.black, Color.black, null, position, size);
      setRandomBodyColor();
      setTextColor(new Color(100, 100, 100));
   }

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