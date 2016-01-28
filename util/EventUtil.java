package gfm.util;

import java.awt.event.MouseEvent;

import gfm.GamePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class EventUtil.
 */
public class EventUtil {
   
   /**
    * Scale event.
    *
    * @param event the event
    */
   public static void scaleEvent(MouseEvent event) {
      GamePanel gamePanel = (GamePanel) event.getComponent();
      double scaleFactorX = gamePanel.getGameWidth() / (double) gamePanel.getWidth();
      double scaleFactorY = gamePanel.getGameHeight() / (double) gamePanel.getHeight();
      int x = (int) (event.getX() * scaleFactorX);
      int y = (int) (event.getY() * scaleFactorY);
      event.translatePoint(-event.getX(), -event.getY());
      event.translatePoint(x, y);
   }
}