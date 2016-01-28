package gfm.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import gfm.util.ColorCross;

// TODO: Auto-generated Javadoc
/**
 * The Class GUIBox.
 */
public class GUIBox extends GUIComponentAdapter {
   
   /** The my box. */
   private Rectangle myBox;
   
   /** The my color. */
   private Color myColor;
   
   /** The my max opacity. */
   private int myMaxOpacity;
   
   /** The my min opacity. */
   private int myMinOpacity;
   
   /** The my current opacity. */
   private int myCurrentOpacity;
   
   /** The my opacity speed. */
   private int myOpacitySpeed;
   
   /** The my opacity direction. */
   private int myOpacityDirection;
   
   /** The my is activated. */
   private boolean myIsActivated;

   /**
    * Instantiates a new GUI box.
    *
    * @param box the box
    * @param color the color
    * @param minOpacity the min opacity
    * @param maxOpacity the max opacity
    * @param opacitySpeed the opacity speed
    */
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

   /* (non-Javadoc)
    * @see gfm.gui.GUIComponentAdapter#draw(java.awt.Graphics)
    */
   @Override
   public void draw(Graphics pen) {
      Color fill = ColorCross.alpha(myColor, myCurrentOpacity);
      pen.setColor(fill);
      pen.fillRect(myBox.x, myBox.y, myBox.width, myBox.height);
   }

   /* (non-Javadoc)
    * @see gfm.gui.GUIComponentAdapter#update()
    */
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


   /**
    * Contains.
    *
    * @param event the event
    * @return true, if successful
    */
   public boolean contains(MouseEvent event) {
      if ( myBox.contains(event.getPoint()) ) {
         return true;
      }
      return false;
   }

   /**
    * Activate.
    */
   public void activate() { myIsActivated = true; }
   
   /**
    * Deactivate.
    */
   public void deactivate() { myIsActivated = false; }
   
   /**
    * Sets the activated.
    *
    * @param activated the new activated
    */
   public void setActivated(boolean activated) { myIsActivated = activated; }
   
   /**
    * Checks if is activated.
    *
    * @return true, if is activated
    */
   public boolean isActivated() { return myIsActivated; }

   /**
    * Gets the box.
    *
    * @return the box
    */
   public Rectangle getBox() { return myBox; }
}