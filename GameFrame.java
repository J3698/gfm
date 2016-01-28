package gfm;

import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class GameFrame.
 */
public class GameFrame extends JFrame {
   
   /** The Constant serialVersionUID. */
   private static final long serialVersionUID = 1488512595217358382L;

   /** The my game panel. */
   private GamePanel myGamePanel;
   
   /** The my name. */
   private String myName;

   /** The my draw width. */
   private int myDrawWidth;
   
   /** The my draw height. */
   private int myDrawHeight;

   /**
    * Instantiates a new game frame.
    *
    * @param name the name
    * @param gamePanel the game panel
    * @param drawWidth the draw width
    * @param drawHeight the draw height
    */
   public GameFrame(String name, GamePanel gamePanel, int drawWidth, int drawHeight) {
      super(name);
      myName = name;
      myGamePanel = gamePanel;
      myDrawWidth = drawWidth;
      myDrawHeight = drawHeight;
      setSize(myDrawWidth, myDrawHeight);
      getContentPane().add(myGamePanel);
      setLocationRelativeTo(null);
      setResizable(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   /**
    * Gets the game panel.
    *
    * @return the game panel
    */
   public GamePanel getGamePanel() {
      return myGamePanel;
   }

   /* (non-Javadoc)
    * @see java.awt.Component#getName()
    */
   @Override
   public String getName() {
      return myName;
   }
}
