package gfm;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
   private static final long serialVersionUID = 1488512595217358382L;

   private GamePanel myGamePanel;
   private String myName;

   private int myDrawWidth;
   private int myDrawHeight;

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

   public GamePanel getGamePanel() {
      return myGamePanel;
   }

   @Override
   public String getName() {
      return myName;
   }
}
