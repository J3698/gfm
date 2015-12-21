package gfm.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import gfm.util.Vector2;

public class UpdateButton implements Button {
   private ActionListener myListener;

   private Vector2 myPosition;
   private Vector2 mySize;

   private boolean myMouseHovering;

   public UpdateButton(ActionListener listener, Vector2 position, Vector2 size) {
      myListener = listener;
      myPosition = position;
      mySize = size;
   }

   @Override
   public void draw(Graphics pen) {
      int x = (int) myPosition.getX();
      int y = (int) myPosition.getY();
      int width = (int) mySize.getX();
      int height = (int) mySize.getY();
      pen.setColor(new Color(200, 50, 50));
      pen.drawRect(x, y, width, height);
      pen.fillPolygon(new int[] {x + width / 4, x + width / 2, x + width * 3 / 4},
            new int[] {y + height * 2 / 5, y + height * 1 / 6, y + height * 2 / 5}, 3);
   }

   @Override
   public void drawHovered(Graphics pen) {
      draw(pen);
   }

   @Override
   public void doAction() {
      myListener.actionPerformed(null);
   }

   @Override
   public boolean collidesPoint(double x, double y) {
      boolean inXBounds = (x >= myPosition.getX() && x <= myPosition.getX() + mySize.getX());
      boolean inYBounds = (y >= myPosition.getY() && y <= myPosition.getY() + mySize.getY());
      return (inXBounds && inYBounds);
   }

   @Override
   public Vector2 getPosition() {
      return myPosition;
   }

   @Override
   public Vector2 getSize() {
      return mySize;
   }

   @Override
   public boolean getMouseHovering() {
      return myMouseHovering;
   }

   @Override
   public void setMouseHovering(boolean isHovering) {
      myMouseHovering = isHovering;
   }
}
