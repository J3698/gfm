package gfm.example;

import java.awt.Color;
import java.awt.Graphics;

import gfm.util.Vector2;

public class Ball implements Rect {
   private Vector2 myPos;
   private Vector2 mySize;
   private Vector2 myVelocity;

   public Ball(Vector2 pos) {
      myPos = pos;
      mySize = new Vector2(15, 15);
      myVelocity = new Vector2(1.1, -0.3);
      myVelocity.setMagnitude(3);
   }

   public void update() {
      myPos.addVector(myVelocity);
   }

   public void draw(Graphics pen) {
      pen.setColor(Color.green);
      int x = (int) (myPos.getX() - mySize.getX() / 2);
      int y = (int) (myPos.getY() - mySize.getY() / 2);
      int width = (int) mySize.getX();
      int height = (int) mySize.getY();
      pen.fillRect(x, y, width, height);
   }

   public void setPos(Vector2 pos) { myPos = pos; }
   public Vector2 getPos() { return myPos; }
   public void setSize(Vector2 size) { mySize = size; }
   public Vector2 getSize() { return mySize; }

   public Vector2 getVelocity() { return myVelocity; }
   public void setVelocity(Vector2 velocity) { myVelocity = velocity; }
}