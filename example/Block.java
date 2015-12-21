package gfm.example;

import gfm.util.Vector2;

import java.awt.Graphics;
import java.awt.Color;

public class Block implements Rect {
   private Vector2 myPos;
   private Vector2 mySize;

   private int myLives;

   public Block(Vector2 pos, Vector2 size, int lives) {
      myPos = pos;
      mySize = size;
      myLives = lives;
   }

   public void draw(Graphics pen) {
      pen.setColor(Color.red);
      int x = (int) (myPos.getX() - mySize.getX() / 2);
      int y = (int) (myPos.getY() - mySize.getY() / 2);
      pen.fillRect(x, y, (int) mySize.getX(), (int) mySize.getY());
   }

   public void draw(Graphics pen, Color toFill) {
      pen.setColor(toFill);
      int x = (int) (myPos.getX() - mySize.getX() / 2);
      int y = (int) (myPos.getY() - mySize.getY() / 2);
      pen.fillRect(x, y, (int) mySize.getX(), (int) mySize.getY());
   }

   public void loseLife(int toLose) {
      if ( toLose < 0 ) {
         throw new IllegalArgumentException("Negative Life Loss");
      }
      myLives -= toLose;
   }
   public void setLives(int lives) { myLives = lives; }
   public boolean isDead() { return (myLives <= 0); }
   public int getLives() { return myLives; }
   public void setPos(Vector2 pos) { myPos = pos; }
   public Vector2 getPos() { return myPos; }
   public void setSize(Vector2 size) { mySize = size; }
   public Vector2 getSize() { return mySize; }
}