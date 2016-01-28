package gfm.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import gfm.Game;
import gfm.util.StringDraw;

// TODO: Auto-generated Javadoc
/**
 * The Class UnchartedTerritory.
 */
public class UnchartedTerritory extends GameState {

   /**
    * Instantiates a new uncharted territory.
    *
    * @param game the game
    */
   public UnchartedTerritory(Game game) {
      super(game);
   }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#draw(java.awt.Graphics)
    */
   @Override
   public void draw(Graphics pen) {
      pen.setFont(new Font("Ariel", 1, 30));
      pen.setColor(Color.green);
      int x = getWidth() / 2;
      int y = getHeight() / 2;
      StringDraw.drawStringCenter(pen, "Seems The Dev Sent You To Nowhere...", x, y);
   }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#update()
    */
   @Override
   public void update() {
   }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#initGUI()
    */
   @Override
   public void initGUI() {
   }

   /* (non-Javadoc)
    * @see gfm.gamestate.GameState#init()
    */
   @Override
   public void init() {
   }

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
