package gfm.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import gfm.util.StringDraw;
import gfm.util.Vec2;

// TODO: Auto-generated Javadoc
/**
 * The Class BasicButton.
 */
public class BasicButton implements Button {
   
   /** The my gui manager. */
   private GUIManager myGUIManager;
   
   /** The my listener. */
   private ActionListener myListener;
   
   /** The my text. */
   private String myText;
   
   /** The my body color. */
   private Color myBodyColor;
   
   /** The my text color. */
   private Color myTextColor;
   
   /** The my font. */
   private Font myFont;
   
   /** The my position. */
   private Vec2 myPosition;
   
   /** The my size. */
   private Vec2 mySize;
   
   /** The my hover sound. */
   private String myHoverSound;
   
   /** The my click sound. */
   private String myClickSound;
   
   /** The my mouse hovering. */
   private boolean myMouseHovering;

   /**
    * Instantiates a new basic button.
    *
    * @param listener the listener
    * @param text the text
    * @param bodyColor the body color
    * @param textColor the text color
    * @param font the font
    * @param position the position
    * @param size the size
    */
   public BasicButton(ActionListener listener, String text, Color bodyColor, Color textColor, Font font,
         Vec2 position, Vec2 size) {
      myListener = listener;
      myText = text;
      myFont = font;
      myBodyColor = bodyColor;
      myTextColor = textColor;
      myPosition = position;
      mySize = size;
      myMouseHovering = false;
   }

   /* (non-Javadoc)
    * @see gfm.gui.Button#draw(java.awt.Graphics)
    */
   @Override
   public void draw(Graphics pen) {
      pen.setColor(myBodyColor);
      int x = (int) myPosition.getX();
      int y = (int) myPosition.getY();
      int width = (int) mySize.getX();
      int height = (int) mySize.getY();
      pen.fillRect(x, y, width, height);
      pen.setColor(myTextColor);
      pen.setFont(myFont);
      StringDraw.drawStringCenter(pen, myText, x + width / 2, y + height / 2);
   }

   /* (non-Javadoc)
    * @see gfm.gui.Button#drawHovered(java.awt.Graphics)
    */
   @Override
   public void drawHovered(Graphics pen) {
      //shrink
      myPosition.addVector(new Vec2(1, 1));
      mySize.subVector(new Vec2(2, 2));
      //draw normal
      draw(pen);
      //draw veil
      pen.setColor(new Color(0, 0, 0, 100));
      int x = (int) myPosition.getX();
      int y = (int) myPosition.getY();
      int width = (int) mySize.getX();
      int height = (int) mySize.getY();
      pen.fillRect(x, y, width, height);
      //undo shrink
      myPosition.subVector(new Vec2(1, 1));
      mySize.addVector(new Vec2(2, 2));
   }

   /* (non-Javadoc)
    * @see gfm.gui.Button#doAction()
    */
   @Override
   public void doAction() {
      myListener.actionPerformed(null);
   }

   /* (non-Javadoc)
    * @see gfm.gui.Button#collidesPoint(double, double)
    */
   @Override
   public boolean collidesPoint(double x, double y) {
      boolean inXBounds = (x >= myPosition.getX() && x <= myPosition.getX() + mySize.getX());
      boolean inYBounds = (y >= myPosition.getY() && y <= myPosition.getY() + mySize.getY());
      return (inXBounds && inYBounds);
   }

   /**
    * Gets the action.
    *
    * @return the action
    */
   public ActionListener getAction() { return myListener; }
   
   /**
    * Sets the action.
    *
    * @param listener the new action
    */
   public void setAction(ActionListener listener) { myListener = listener; }

   /* (non-Javadoc)
    * @see gfm.gui.Button#getPosition()
    */
   @Override
   public Vec2 getPos() { return myPosition; }
   
   /* (non-Javadoc)
    * @see gfm.gui.Button#setPosition(gfm.util.Vec2)
    */
   @Override
   public void setPos(Vec2 position) { myPosition = position; }

   /* (non-Javadoc)
    * @see gfm.gui.Button#getSize()
    */
   @Override
   public Vec2 getSize() { return mySize; }
   
   /* (non-Javadoc)
    * @see gfm.gui.Button#setSize(gfm.util.Vec2)
    */
   @Override
   public void setSize(Vec2 size) { mySize = size; }

   /**
    * Gets the text.
    *
    * @return the text
    */
   public String getText() { return myText; }
   
   /**
    * Sets the text.
    *
    * @param text the new text
    */
   public void setText(String text) { myText = text; }

   /**
    * Gets the body color.
    *
    * @return the body color
    */
   public Color getBodyColor() { return myBodyColor; }
   
   /**
    * Sets the body color.
    *
    * @param bodyColor the new body color
    */
   public void setBodyColor(Color bodyColor) { myBodyColor = bodyColor; }

   /**
    * Gets the text color.
    *
    * @return the text color
    */
   public Color getTextColor() { return myTextColor; }
   
   /**
    * Sets the text color.
    *
    * @param textColor the new text color
    */
   public void setTextColor(Color textColor) { myTextColor = textColor; }

   /* (non-Javadoc)
    * @see gfm.gui.Button#getMouseHovering()
    */
   @Override
   public boolean getMouseHovering() { return myMouseHovering; }
   
   /* (non-Javadoc)
    * @see gfm.gui.Button#setMouseHovering(boolean)
    */
   @Override
   public void setMouseHovering(boolean isHovering) { myMouseHovering = isHovering; }

   /**
    * Gets the font.
    *
    * @return the font
    */
   public Font getFont() { return myFont; }
   
   /**
    * Sets the font.
    *
    * @param font the new font
    */
   public void setFont(Font font) { myFont = font; }


   /* (non-Javadoc)
    * @see gfm.gui.Button#getGUIManager()
    */
   @Override
   public GUIManager getGUIManager() { return myGUIManager; }
   
   /* (non-Javadoc)
    * @see gfm.gui.Button#setGUIManager(gfm.gui.GUIManager)
    */
   @Override
   public void setGUIManager(GUIManager guiManager) { myGUIManager = guiManager; }

   /* (non-Javadoc)
    * @see gfm.gui.Button#getHoverSound()
    */
   @Override
   public String getHoverSound() { return myHoverSound; }
   
   /* (non-Javadoc)
    * @see gfm.gui.Button#setHoverSound(java.lang.String)
    */
   @Override
   public void setHoverSound(String sound) { myHoverSound = sound; }

   /* (non-Javadoc)
    * @see gfm.gui.Button#getClickSound()
    */
   @Override
   public String getClickSound() { return myClickSound; }

   /* (non-Javadoc)
    * @see gfm.gui.Button#setClickSound(java.lang.String)
    */
   @Override
   public void setClickSound(String sound) { myClickSound = sound; }
}