package gfm.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import gfm.util.ColorCross;

public class GUIBox extends GUIComponentAdapter {
   private Rectangle myBox;
   private Color myColor;
   private int myMaxOpacity;
   private int myMinOpacity;
   private int myCurrentOpacity;
   private int myOpacitySpeed;
   private int myOpacityDirection;
   private boolean myIsActivated;

   public GUIBox(Rectangle box, Color color,
         int minOpacity, int maxOpacity, int opacitySpeed) {
      myBox = box;
      myColor = color;
      myMaxOpacity = maxOpacity;
      myMinOpacity = minOpacity; //  "/ 6 * 4"
      myCurrentOpacity = myMinOpacity;
      myOpacitySpeed = opacitySpeed;
      myOpacityDirection = -opacitySpeed;
      myIsActivated = false;
   }

   @Override
   public void draw(Graphics pen) {
      Color fill = ColorCross.alpha(myColor, myCurrentOpacity);
      pen.setColor(fill);
      pen.fillRect(myBox.x, myBox.y, myBox.width, myBox.height);
   }

   @Override
   public void update() {
      if ( myOpacityDirection == -myOpacitySpeed ) {
         if ( myCurrentOpacity > myMinOpacity ) {
            myCurrentOpacity -= myOpacitySpeed;
         } else if ( myIsActivated ) {
            myOpacityDirection = myOpacitySpeed;
         }
      } else if ( myOpacityDirection == myOpacitySpeed ) {
         if ( myCurrentOpacity < myMaxOpacity ) {
            myCurrentOpacity += myOpacitySpeed;
         } else if ( !myIsActivated ) {
            myOpacityDirection = -myOpacitySpeed;
         }
      }

      if ( myCurrentOpacity > myMaxOpacity ) {
         myCurrentOpacity = myMaxOpacity;
      } else if ( myCurrentOpacity < myMinOpacity ) {
         myCurrentOpacity = myMinOpacity;
      }
   }


   public boolean contains(MouseEvent event) {
      if ( myBox.contains(event.getPoint()) ) {
         return true;
      }
      return false;
   }

   public void activate() { myIsActivated = true; }
   public void deactivate() { myIsActivated = false; }
   public void setActivated(boolean activated) { myIsActivated = activated; }
   public boolean isActivated() { return myIsActivated; }

   public Rectangle getBox() { return myBox; }
}