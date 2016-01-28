package gfm;

import java.awt.Graphics;
import java.util.Collection;

// TODO: Auto-generated Javadoc
/**
 * The Class GameComponentAdapter.
 *
 * @param <T> the generic type
 */
public abstract class GameComponentAdapter<T> implements GameComponent<T> {
   
   /* (non-Javadoc)
    * @see gfm.DrawUpdatable#draw(java.awt.Graphics)
    */
   @Override
   public void draw(Graphics pen) { }
   
   /* (non-Javadoc)
    * @see gfm.DrawUpdatable#update()
    */
   @Override
   public void update() { }
   
   /* (non-Javadoc)
    * @see gfm.GameComponent#addComponent(java.lang.Object)
    */
   @Override
   public void addComponent(T toAdd) { }
   
   /* (non-Javadoc)
    * @see gfm.GameComponent#removeComponent(java.lang.Object)
    */
   @Override
   public void removeComponent(T toRemove) { }
   
   /* (non-Javadoc)
    * @see gfm.GameComponent#getComponents()
    */
   @Override
   public Collection<T> getComponents() { return null; }
}
