package gfm.gui;

import java.awt.Graphics;

import gfm.util.Vec2;

public interface Button {
   void draw(Graphics pen);
   void drawHovered(Graphics pen);

   void doAction();
   boolean collidesPoint(double x, double y);

   Vec2 getPosition();
   void setPosition(Vec2 position);
   Vec2 getSize();
   void setSize(Vec2 size);

   GUIManager getGUIManager();
   void setGUIManager(GUIManager guianager);

   boolean getMouseHovering();
   void setMouseHovering(boolean isHovering);

   String getHoverSound();
   void setHoverSound(String sound);

   String getClickSound();
   void setClickSound(String sound);
}