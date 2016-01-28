package gfm.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import gfm.Game;
import gfm.util.ColorCross;

// TODO: Auto-generated Javadoc
/**
 * The Class FadeTransition.
 */
public class FadeTransition extends Transition {
   
   /** The my color. */
   private Color myColor;
   
   /** The my steps. */
   private int mySteps;
   
   /** The my curr step. */
   private int myCurrStep;

   /**
    * Instantiates a new fade transition.
    *
    * @param game the game
    * @param first the first
    * @param second the second
    */
   public FadeTransition(Game game, String first, String second) {
      this(game, first, second, 100, Color.black);
   }
   
   /**
    * Instantiates a new fade transition.
    *
    * @param game the game
    * @param first the first
    * @param second the second
    * @param steps the steps
    * @param color the color
    */
   public FadeTransition(Game game, String first, String second, int steps, Color color) {
      super(game, first, second);
      myColor = color;
      mySteps = steps;
   }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#init()
    */
   @Override
   public void init() {
      myCurrStep = 0;
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#initGUI()
    */
   @Override
   public void initGUI() {}

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#draw(java.awt.Graphics)
    */
   @Override
   public void draw(Graphics pen) { }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#drawOverMacro(java.awt.Graphics)
    */
   @Override
   public void drawOverMacro(Graphics pen) {
      int width = getWidth();
      int height = getHeight();
      int alpha;

      if ( myCurrStep <= mySteps / 2 ) {
         getFirstGameState().draw(pen);
         getFirstGameState().drawOverMacro(pen);
         alpha = (255 * myCurrStep * 2) / mySteps;
      } else {
         getSecondGameState().draw(pen);
         getSecondGameState().drawOverMacro(pen);
         alpha = 255 - (255 * (myCurrStep - mySteps / 2) / (mySteps / 2));
      }

      pen.setColor(ColorCross.alpha(myColor, alpha));
      pen.fillRect(0, 0, width, height);
   }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#update()
    */
   @Override
   public void update() {
      if ( myCurrStep >= mySteps ) { finish(); }
      myCurrStep++;
   }

   /**
    * Sets the steps.
    *
    * @param steps the new steps
    */
   public void setSteps(int steps) { mySteps = steps; }
   
   /**
    * Gets the steps.
    *
    * @return the steps
    */
   public int getSteps() { return mySteps; }
   
   /**
    * Sets the color.
    *
    * @param color the new color
    */
   public void setColor(Color color) { myColor = color; }
   
   /**
    * Gets the color.
    *
    * @return the color
    */
   public Color getColor() { return myColor; }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#keyPressed(java.awt.event.KeyEvent)
    */
   @Override
   public void keyPressed(KeyEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#keyReleased(java.awt.event.KeyEvent)
    */
   @Override
   public void keyReleased(KeyEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#keyTyped(java.awt.event.KeyEvent)
    */
   @Override
   public void keyTyped(KeyEvent event) {
   }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseClicked(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseClicked(MouseEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseDragged(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseDragged(MouseEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseEntered(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseEntered(MouseEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseExited(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseExited(MouseEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseMoved(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseMoved(MouseEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mousePressed(java.awt.event.MouseEvent)
    */
   @Override
   public void mousePressed(MouseEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseReleased(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseReleased(MouseEvent event) {
   }
   
   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#mouseWheelMoved(java.awt.event.MouseWheelEvent)
    */
   @Override
   public void mouseWheelMoved(MouseWheelEvent event) {
   }
}