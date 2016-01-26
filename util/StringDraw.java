package gfm.util;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;

public class StringDraw {
   private static HashMap<String, Font> myFonts = new HashMap<String, Font>();

   public static void addFont(String name, Font toAdd) {
      myFonts.put(name, toAdd);
   }

   public static Font getFont(String name) {
      return myFonts.get(name);
   }

   public static Rectangle2D stringBounds(Graphics pen, String string) {
      Graphics2D pen2D = (Graphics2D) pen;
      FontMetrics fontMetrics = pen2D.getFontMetrics();
      Rectangle2D stringRect = fontMetrics.getStringBounds(string, pen2D);
      return stringRect;
   }

   public static Rectangle2D drawStringCenter(Graphics pen, String string, int x, int y) {
      Rectangle2D stringRect = stringBounds(pen, string);
      FontMetrics fontMetrics = ((Graphics2D)pen).getFontMetrics();
      x = (int) (x - stringRect.getWidth() / 2);
      y = (int) (y + stringRect.getHeight() / 2 - fontMetrics.getAscent() / 5);
      pen.drawString(string, x, y);
      return stringRect;
   }

   public static String[] availableSystemFonts() {
      GraphicsEnvironment local = GraphicsEnvironment.getLocalGraphicsEnvironment();
      return local.getAvailableFontFamilyNames();
   }
}