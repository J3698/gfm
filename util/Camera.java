package gfm.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import gfm.GamePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class Camera.
 */
public class Camera {
   
   /** The my game panel. */
   private GamePanel myGamePanel;

   /** The my image. */
   private BufferedImage myImage;
   
   /** The my pen. */
   private Graphics myPen;

   /** The my default pos1. */
   private Vec2 myDefaultPos1;
   
   /** The my default pos2. */
   private Vec2 myDefaultPos2;
   
   /** The my pos1. */
   private Vec2 myPos1;
   
   /** The my pos2. */
   private Vec2 myPos2;

   /**
    * Instantiates a new camera.
    *
    * @param gamePanel the game panel
    */
   public Camera(GamePanel gamePanel) {
      myGamePanel = gamePanel;
      setImageSize(myGamePanel.getGameWidth(), myGamePanel.getGameHeight());
      myDefaultPos1 = new Vec2(0, 0);
      myDefaultPos2 = new Vec2(myGamePanel.getGameWidth(), myGamePanel.getGameHeight());
      myPos1 = myDefaultPos1.copy();
      myPos2 = myDefaultPos2.copy();
   }

   /**
    * Update.
    */
   public void update() {
   }

   /**
    * Reset.
    */
   // put image size and perspective to default
   public void reset() {
      myPos1 = myDefaultPos1.copy();
      myPos2 = myDefaultPos2.copy();
      setImageSize(myGamePanel.getGameWidth(), myGamePanel.getGameHeight());
   }

   /**
    * Clear image.
    */
   // erase image
   public void clearImage() {
      myPen.clearRect(0, 0, myImage.getWidth(), myImage.getHeight());
   }

   /**
    * Gets the scaled pos1.
    *
    * @return the scaled pos1
    */
   public Vec2 getScaledPos1() {
      Vec2 pos1 = myPos1.copy();
      pos1.divideX(myGamePanel.getGameWidth() / (double) myGamePanel.getWidth());
      pos1.divideY(myGamePanel.getGameHeight() / (double) myGamePanel.getHeight());
      return pos1;
   }
   
   /**
    * Gets the scaled pos2.
    *
    * @return the scaled pos2
    */
   public Vec2 getScaledPos2() {
      Vec2 pos2 = myPos2.copy();
      pos2.subVector(myPos1);
      pos2.divideX(myGamePanel.getGameWidth() / (double) myGamePanel.getWidth());
      pos2.divideY(myGamePanel.getGameHeight() / (double) myGamePanel.getHeight());
      return pos2;
   }

   /**
    * Gets the pos1.
    *
    * @return the pos1
    */
   public Vec2 getPos1() { return myPos1; }
   
   /**
    * Gets the pos2.
    *
    * @return the pos2
    */
   public Vec2 getPos2() { return myPos2; }

   /**
    * Sets the pos1.
    *
    * @param pos1 the new pos1
    */
   public void setPos1(Vec2 pos1) { myPos1 = pos1; }
   
   /**
    * Sets the pos2.
    *
    * @param pos2 the new pos2
    */
   public void setPos2(Vec2 pos2) { myPos2 = pos2; }

   /**
    * Gets the pen.
    *
    * @return the pen
    */
   public Graphics getPen() { return myPen; }
   
   /**
    * Sets the pen.
    *
    * @param pen the new pen
    */
   public void setPen(Graphics pen) { myPen = pen; }

   /**
    * Gets the image.
    *
    * @return the image
    */
   public BufferedImage getImage() { return myImage; }

   /**
    * Sets the image size.
    *
    * @param x the x
    * @param y the y
    */
   public void setImageSize(int x, int y) {
      myImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
      myPen = myImage.getGraphics();
      Graphics2D pen2D = (Graphics2D) myPen;
      pen2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      pen2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
      pen2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
      pen2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      pen2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
   }
   
   /**
    * Sets the perspective.
    *
    * @param startPos the start pos
    * @param endPos the end pos
    */
   public void setPerspective(Vec2 startPos, Vec2 endPos) {
      Vec2 diff = endPos.copy();
      diff.subVector(startPos);
      double xRatio = myGamePanel.getGameWidth() / diff.getX();
      double yRatio = myGamePanel.getGameHeight() / diff.getY();

      myPos1 = startPos.copy();
      myPos1.multiplyX(-xRatio);
      myPos1.multiplyY(-yRatio);

      myPos2 = new Vec2(myImage.getWidth(), myImage.getHeight());
      myPos2.multiplyX(xRatio);
      myPos2.multiplyY(yRatio);
      myPos2.addVector(myPos1);
   }
}