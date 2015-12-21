package gfm.util;

import java.awt.Color;

public class ColorCross {
   Color myStartColor;
   Color myEndColor;
   Color myCurrentColor;
   int mySteps;
   int myCurrentStep = 0;
   double myRedNow;
   double myGreenNow;
   double myBlueNow;
   double myRedIncrement;
   double myGreenIncrement;
   double myBlueIncrement;

   public ColorCross(Color start, Color end, int steps) {
      myStartColor = start;
      myEndColor = end;
      myCurrentColor = start;
      mySteps = steps;
      myRedNow = start.getRed();
      myGreenNow = start.getGreen();
      myBlueNow = start.getBlue();
      myRedIncrement = (end.getRed() - start.getRed()) / (double) steps;
      myGreenIncrement = (end.getGreen() - start.getGreen()) / (double) steps;
      myBlueIncrement = (end.getBlue() - start.getBlue()) / (double) steps;
   }

   public void next() {
      if (myCurrentStep == mySteps)
         return;
      myRedNow += myRedIncrement;
      myGreenNow += myGreenIncrement;
      myBlueNow += myBlueIncrement;
      myCurrentColor = new Color(limit(myRedNow), limit(myGreenNow), limit(myBlueNow));
      myCurrentStep++;
   }
   public Color getCurrentColor() {
      return myCurrentColor;
   }

   public Color getPercent(double percent) {
      double r, g, b, r2, g2, b2;
      r = myStartColor.getRed() * (1 - percent);
      g = myStartColor.getGreen() * (1 - percent);
      b = myStartColor.getBlue() * (1 - percent);
      r2 = myEndColor.getRed() * percent;
      g2 = myEndColor.getGreen() * percent;
      b2 = myEndColor.getBlue() * percent;
      return new Color((int)(r + r2), (int)(g + g2), (int)(b + b2));
   }

   public int limit(double color) {
      if (color > 255)
         color = 255;
      else if (color < 0)
         color = 0;
      return (int) color;
   }

   public static Color alpha(Color color, int alpha) {
	   int red = color.getRed();
	   int green = color.getGreen();
	   int blue = color.getBlue();
	   return new Color(red, green, blue, alpha);
   }
}
