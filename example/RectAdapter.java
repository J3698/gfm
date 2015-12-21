package gfm.example;

import gfm.util.Vector2;

import java.awt.event.MouseEvent;

public class RectAdapter implements Rect {
   private Vector2 myPos;
   private Vector2 mySize;

   public RectAdapter(MouseEvent toConvert) {
      this(new Vector2(toConvert.getX(), toConvert.getY()));
   }
   public RectAdapter(Vector2 pos) {
      this(pos, new Vector2(0, 0));
   }
   public RectAdapter(Vector2 pos, Vector2 size) {
      myPos = pos;
      mySize = size;
   }

   public Vector2 getPos() {
      return myPos;
   }
   public Vector2 getSize() {
      return mySize;
   }
}