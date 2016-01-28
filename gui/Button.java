package gfm.gui;

import java.awt.Graphics;

import gfm.util.Vec2;

// TODO: Auto-generated Javadoc
/**
 * The Interface Button.
 */
public interface Button {
   
   /**
    * Draw.
    *
    * @param pen the pen
    */
   void draw(Graphics pen);
   
   /**
    * Draw hovered.
    *
    * @param pen the pen
    */
   void drawHovered(Graphics pen);

   /**
    * Do action.
    */
   void doAction();
   
   /**
    * Collides point.
    *
    * @param x the x
    * @param y the y
    * @return true, if successful
    */
   boolean collidesPoint(double x, double y);

   /**
    * Gets the position.
    *
    * @return the position
    */
   Vec2 getPosition();
   
   /**
    * Sets the position.
    *
    * @param position the new position
    */
   void setPosition(Vec2 position);
   
   /**
    * Gets the size.
    *
    * @return the size
    */
   Vec2 getSize();
   
   /**
    * Sets the size.
    *
    * @param size the new size
    */
   void setSize(Vec2 size);

   /**
    * Gets the GUI manager.
    *
    * @return the GUI manager
    */
   GUIManager getGUIManager();
   
   /**
    * Sets the GUI manager.
    *
    * @param guianager the new GUI manager
    */
   void setGUIManager(GUIManager guianager);

   /**
    * Gets the mouse hovering.
    *
    * @return the mouse hovering
    */
   boolean getMouseHovering();
   
   /**
    * Sets the mouse hovering.
    *
    * @param isHovering the new mouse hovering
    */
   void setMouseHovering(boolean isHovering);

   /**
    * Gets the hover sound.
    *
    * @return the hover sound
    */
   String getHoverSound();
   
   /**
    * Sets the hover sound.
    *
    * @param sound the new hover sound
    */
   void setHoverSound(String sound);

   /**
    * Gets the click sound.
    *
    * @return the click sound
    */
   String getClickSound();
   
   /**
    * Sets the click sound.
    *
    * @param sound the new click sound
    */
   void setClickSound(String sound);
}