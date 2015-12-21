package gfm.example;

import java.awt.Graphics;
import java.awt.Color;

import gfm.util.ControllableAdapter;
import gfm.util.Controls;
import gfm.util.Vector2;

public class Paddle extends ControllableAdapter implements Rect {
   private Vector2 myPos;
   private Vector2 mySize;

   private int myLeftBound;
   private int myRightBound;

   private double myVelocity;
   private double myFriction;
   private double myAcceleration;
   private double myMaxVelocity;

   private String myButtonPressed;
   private Controls myControls;

   public Paddle(Vector2 pos, Vector2 size, int leftBound, int rightBound) {
      myPos = pos;
      mySize = size;

      myLeftBound = leftBound;
      myRightBound = rightBound;

      myVelocity = 0;
      myFriction = 0.9;
      myAcceleration = 1.5;
      myMaxVelocity = 12;

      myControls = new Controls(this);
      myButtonPressed = "";
   }

   public void draw(Graphics pen) {
      pen.setColor(Color.red);
      int x = (int) (myPos.getX() - mySize.getX() / 2);
      int y = (int) (myPos.getY() - mySize.getY() / 2);
      pen.fillRect(x, y, (int) mySize.getX(), (int) mySize.getY());
   }

   public void update() {
      updateVelocityAndSpeed();
   }

   public void updateVelocityAndSpeed() {
      // accelerate
      if ( myButtonPressed.equals("left") ) {
         myVelocity -= myAcceleration;
      } else if ( myButtonPressed.equals("right") ) {
         myVelocity += myAcceleration;
      }
      // enforce max velocity
      if ( Math.abs(myVelocity) > myMaxVelocity ) {
         if ( myVelocity > 0 ) {
            myVelocity = myMaxVelocity;
         } else {
            myVelocity = -myMaxVelocity;
         }
      }
      // enforce boundaries
      int width = myRightBound;
      if ( myPos.getX() + mySize.getX() / 2  > width) {
         myVelocity = 0;
         myPos.setX(width - mySize.getX() / 2);
      } else if ( mySize.getX() / 2 > myPos.getX() ) {
         myVelocity = 0;
         myPos.setX(mySize.getX() / 2);
      }

      myVelocity *= myFriction;
      myPos.addX(myVelocity);
   }

   public void left() {
      myButtonPressed = "left";
   }
   public void right() {
      myButtonPressed = "right";
   }

   public void releaseLeft() {
      if ( myButtonPressed.equals("left") ) {
         myButtonPressed = "";
      }
   }
   public void releaseRight() {
      if ( myButtonPressed.equals("right") ) {
         myButtonPressed = "";
      }
   }

   public Controls getControls() { return myControls; }
   public void setButtonPressed(String buttonPressed) { myButtonPressed = buttonPressed; }
   public String getButtonPressed() { return  myButtonPressed; }
   public void setPos(Vector2 pos) { myPos = pos; }
   public Vector2 getPos() { return myPos; }
   public void setSize(Vector2 size) { mySize = size; }
   public Vector2 getSize() { return mySize; }
}