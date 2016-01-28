package gfm;

import java.awt.Graphics;
import java.util.Collection;

public abstract class GameComponentAdapter<T> implements GameComponent<T> {
   @Override
   public void draw(Graphics pen) { }
   @Override
   public void update() { }
   @Override
   public void addComponent(T toAdd) { }
   @Override
   public void removeComponent(T toRemove) { }
   @Override
   public Collection<T> getComponents() { return null; }
}
