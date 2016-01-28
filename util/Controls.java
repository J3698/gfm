package gfm.util;

import java.awt.event.KeyEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class Controls.
 */
public class Controls {
   
   /** The my to control. */
   private Controllable myToControl;

   /** The my is disabled. */
   private boolean myIsDisabled;

   /** The my up key. */
   private int myUpKey = KeyEvent.VK_E;
   
   /** The my down key. */
   private int myDownKey = KeyEvent.VK_D;
   
   /** The my left key. */
   private int myLeftKey = KeyEvent.VK_S;
   
   /** The my right key. */
   private int myRightKey = KeyEvent.VK_F;
   
   /** The my first action key. */
   private int myFirstActionKey = KeyEvent.VK_1;
   
   /** The my second action key. */
   private int mySecondActionKey = KeyEvent.VK_2;
   
   /** The my third action key. */
   private int myThirdActionKey = KeyEvent.VK_3;

   /**
    * Instantiates a new controls.
    *
    * @param toControl the to control
    */
   public Controls(Controllable toControl) {
      myToControl = toControl;
      myIsDisabled = false;
   }

   /**
    * Key pressed.
    *
    * @param event the event
    */
   public void keyPressed(KeyEvent event) {
      if ( myIsDisabled ) { return; }

      if (event.getKeyCode() == myUpKey)
    	  myToControl.up();
      else if (event.getKeyCode() == myDownKey)
    	  myToControl.down();
      else if (event.getKeyCode() == myLeftKey)
    	  myToControl.left();
      else if (event.getKeyCode() == myRightKey)
    	  myToControl.right();
      else if (event.getKeyCode() == myFirstActionKey)
    	  myToControl.firstAction();
      else if (event.getKeyCode() == mySecondActionKey)
    	  myToControl.secondAction();
      else if (event.getKeyCode() == myThirdActionKey)
    	  myToControl.thirdAction();
   }

   /**
    * Key released.
    *
    * @param event the event
    */
   public void keyReleased(KeyEvent event) {
      if ( myIsDisabled ) { return; }

      if (event.getKeyCode() == myUpKey)
    	  myToControl.releaseUp();
      else if (event.getKeyCode() == myDownKey)
    	  myToControl.releaseDown();
      else if (event.getKeyCode() == myLeftKey)
    	  myToControl.releaseLeft();
      else if (event.getKeyCode() == myRightKey)
    	  myToControl.releaseRight();
      else if (event.getKeyCode() == myFirstActionKey)
    	  myToControl.releaseFirstAction();
      else if (event.getKeyCode() == mySecondActionKey)
    	  myToControl.releaseSecondAction();
      else if (event.getKeyCode() == myThirdActionKey)
    	  myToControl.releaseThirdAction();
   }

   /**
    * Sets the first controls.
    */
   public void setFirstControls() {
      setUpKey(KeyEvent.VK_W);
      setDownKey(KeyEvent.VK_S);
      setLeftKey(KeyEvent.VK_A);
      setRightKey(KeyEvent.VK_D);
      setFirstActionKey(KeyEvent.VK_1);
      setSecondActionKey(KeyEvent.VK_2);
      setThirdActionKey(KeyEvent.VK_3);
   }

   /**
    * Sets the second controls.
    */
   public void setSecondControls() {
      setUpKey(KeyEvent.VK_UP);
      setDownKey(KeyEvent.VK_DOWN);
      setLeftKey(KeyEvent.VK_LEFT);
      setRightKey(KeyEvent.VK_RIGHT);
      setFirstActionKey(KeyEvent.VK_COMMA);
      setSecondActionKey(KeyEvent.VK_PERIOD);
      setThirdActionKey(KeyEvent.VK_M);
   }

   /**
    * Sets the disabled.
    *
    * @param isDisabled the new disabled
    */
   public void setDisabled(boolean isDisabled) {
      myIsDisabled = isDisabled;
   }

   /**
    * Sets the up key.
    *
    * @param upKey the new up key
    */
   public void setUpKey(int upKey) { myUpKey = upKey; }
   
   /**
    * Sets the down key.
    *
    * @param downKey the new down key
    */
   public void setDownKey(int downKey) { myDownKey = downKey; }
   
   /**
    * Sets the left key.
    *
    * @param leftKey the new left key
    */
   public void setLeftKey(int leftKey) { myLeftKey = leftKey; }
   
   /**
    * Sets the right key.
    *
    * @param rightKey the new right key
    */
   public void setRightKey(int rightKey) { myRightKey = rightKey; }
   
   /**
    * Sets the first action key.
    *
    * @param firstActionKey the new first action key
    */
   public void setFirstActionKey(int firstActionKey) { myFirstActionKey = firstActionKey; }
   
   /**
    * Sets the second action key.
    *
    * @param secondActionKey the new second action key
    */
   public void setSecondActionKey(int secondActionKey) { mySecondActionKey = secondActionKey; }
   
   /**
    * Sets the third action key.
    *
    * @param thirdActionKey the new third action key
    */
   public void setThirdActionKey(int thirdActionKey) { myThirdActionKey = thirdActionKey; }

   /**
    * Gets the up key.
    *
    * @return the up key
    */
   public int getUpKey() { return myUpKey; }
   
   /**
    * Gets the down key.
    *
    * @return the down key
    */
   public int getDownKey() { return myDownKey; }
   
   /**
    * Gets the left key.
    *
    * @return the left key
    */
   public int getLeftKey() { return myLeftKey; }
   
   /**
    * Gets the right key.
    *
    * @return the right key
    */
   public int getRightKey() { return myRightKey; }
   
   /**
    * Gets the first action key.
    *
    * @return the first action key
    */
   public int getFirstActionKey() { return myFirstActionKey; }
   
   /**
    * Gets the second action key.
    *
    * @return the second action key
    */
   public int getSecondActionKey() { return mySecondActionKey; }
   
   /**
    * Gets the third action key.
    *
    * @return the third action key
    */
   public int getThirdActionKey() { return myThirdActionKey; }
}
