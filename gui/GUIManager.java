package gfm.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Collection;

import gfm.Game;
import gfm.Macro;

// Note, not everything is treated fairly,
// can only disable buttons, only they make
// sound, etc.

public class GUIManager implements Macro {
   private Game myGame;

   private ArrayList<Button> myButtons;
   private ArrayList<GUIComponent> myGUIComponents;
   private boolean myDisabled;

   public GUIManager(Game game) {
      myGame = game;
      myButtons = new ArrayList<Button>();
      myGUIComponents = new ArrayList<GUIComponent>();
      myDisabled = false;
   }

   @Override
   public void draw(Graphics pen) {
      for ( int i = 0; i < myButtons.size(); i++ ) {
         Button button = myButtons.get(i);
         if (button.getMouseHovering()) {
            button.drawHovered(pen);
         } else {
            button.draw(pen);
         }
      }

      for ( GUIComponent comp : myGUIComponents ) {
         comp.draw(pen);
      }
   }

   @Override
   public void update() {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.update();
      }
   }

   @Override
   public void mousePressed(MouseEvent event) {
      if ( myDisabled || event.getButton() != MouseEvent.BUTTON1 ) {
         return;
      }

      for ( int i = 0; i < myButtons.size(); i++ ) {
         Button button = myButtons.get(i);
         if ( button.collidesPoint(event.getX(), event.getY()) ) {
            String clickSound = button.getClickSound();
            if ( clickSound != null) {
               myGame.getSoundManager().play(clickSound);
            }
            button.doAction();
         }
      }

      for ( GUIComponent comp : myGUIComponents ) {
         comp.mousePressed(event);
      }
   }

   @Override
   public void mouseMoved(MouseEvent event) {
      if ( myDisabled ) {
         return;
      }

      for ( int i = 0; i < myButtons.size(); i++ ) {
         Button button = myButtons.get(i);
         if ( button.collidesPoint(event.getX(), event.getY())) {
            if ( button.getMouseHovering() == false ) {
               String hoverSound = button.getHoverSound();
               if ( hoverSound != null) {
                  myGame.getSoundManager().play(hoverSound);
               }
               button.setMouseHovering(true);
            }
         } else {
            button.setMouseHovering(false);
         }
      }

      for ( GUIComponent comp : myGUIComponents ) {
         comp.mouseMoved(event);
      }
   }

   @Override
   public void keyPressed(KeyEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.keyPressed(event);
      }
   }

   @Override
   public void keyReleased(KeyEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.keyReleased(event);
      }
   }

   @Override
   public void keyTyped(KeyEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.keyTyped(event);
      }
   }

   @Override
   public void mouseClicked(MouseEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.mouseClicked(event);
      }
   }

   @Override
   public void mouseDragged(MouseEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.mouseDragged(event);
      }
   }

   @Override
   public void mouseEntered(MouseEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.mouseEntered(event);
      }
   }

   @Override
   public void mouseExited(MouseEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.mouseExited(event);
      }
   }

   @Override
   public void mouseReleased(MouseEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.mouseReleased(event);
      }
   }

   @Override
   public void mouseWheelMoved(MouseWheelEvent event) {
      for ( GUIComponent comp : myGUIComponents ) {
         comp.mouseWheelMoved(event);
      }
   }

   public void resetInputs() {
      for (Button button: myButtons) {
         button.setMouseHovering(false);
      }
   }

   public void disable() {
      myDisabled = true;
      for ( int i = 0; i < myButtons.size(); i++ ) {
         myButtons.get(i).setMouseHovering(false);
      }
   }

   public void enable() {
      myDisabled = false;
   }

   public void deleteAllButtons() {
      myButtons = new ArrayList<Button>();
   }

   public void addButton(Button button) {
      button.setGUIManager(this);
      myButtons.add(button);
   }

   public void removeButton(Button button) {
      myButtons.remove(button);
   }

   public void addGUIComponent(GUIComponent toAdd) {
      myGUIComponents.add(toAdd);
   }

   public void removeGUIComponent(GUIComponent toRemove) {
      myGUIComponents.remove(toRemove);
   }

   public void deleteAllComponents() {
      myGUIComponents = new ArrayList<GUIComponent>();
   }

   public Game getGame() { return myGame; }
   public ArrayList<Button> getButtons() { return myButtons; }
   public Collection<GUIComponent> getGUIComponents() { return myGUIComponents; }
}
