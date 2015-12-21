package gfm.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import gfm.GamePanel;

public class GUIManager {
   private GamePanel myGamePanel;
   private ArrayList<Button> myButtons;
   private boolean myDisabled;

   public GUIManager(GamePanel gamePanel) {
      myGamePanel = gamePanel;
      myButtons = new ArrayList<Button>();
      myDisabled = false;
   }

   public void draw(Graphics pen) {
      for (Button button: myButtons) {
         if (button.getMouseHovering()) {
            button.drawHovered(pen);
         } else {
            button.draw(pen);
         }
      }
   }

   public void mousePressed(MouseEvent event) {
      if (!myDisabled) {
         if (event.getButton() == MouseEvent.BUTTON1) {
            for (Button button: myButtons) {
               if (button.collidesPoint(event.getX(), event.getY())) {
                  button.doAction();
               }
            }
         }
      }
   }

   public void mouseMoved(MouseEvent event) {
      for (Button button: myButtons) {
         if (button.collidesPoint(event.getX(), event.getY())) {
            if (button.getMouseHovering() == false) {
               button.setMouseHovering(true);
            }
         } else {
            button.setMouseHovering(false);
         }
      }
   }

   public void resetInputs() {
      for (Button button: myButtons) {
         button.setMouseHovering(false);
      }
   }

   public void disable() {
      myDisabled = true;
   }

   public void enable() {
      myDisabled = false;
   }

   public void addButton(Button button) {
      myButtons.add(button);
   }
}
