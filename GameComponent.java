package gfm;

import java.util.Collection;

public interface GameComponent<T> extends DrawUpdatable {
   void addComponent(T toAdd);
   void removeComponent(T toRemove);
   Collection<T> getComponents();
}
