package gfm.particlesys;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import gfm.util.Vec2;

// TODO: Auto-generated Javadoc
/**
 * The Class Particle.
 */
public abstract class Particle {
   
   /** The my particle position. */
   private Vec2 myParticlePosition;
   
   /** The my particle velocity. */
   private Vec2 myParticleVelocity;
   
   /** The my life. */
   private int myLife = 255;
   
   /** The my color. */
   private Color myColor;

   /**
    * Instantiates a new particle.
    *
    * @param position the position
    * @param velocity the velocity
    */
   public Particle(Vec2 position, Vec2 velocity) {
      myParticlePosition = position;
      myParticleVelocity = velocity;
   }

   /**
    * Run.
    *
    * @param pen the pen
    */
   public void run(Graphics pen) {
      update();
      draw(pen);
   }

   /**
    * Update.
    */
   public abstract void update();
   
   /**
    * Draw.
    *
    * @param pen the pen
    */
   public abstract void draw(Graphics pen);
   
   /**
    * New particle.
    *
    * @return the particle
    */
   public abstract Particle newParticle();

   
   /**
    * Checks if is dead.
    *
    * @return true, if is dead
    */
   public boolean isDead() {
      if (myLife > 0) {
         return false;
      }
      return true;
   }

   /**
    * Gets the random color.
    *
    * @return the random color
    */
   public Color getRandomColor() {
      Random random = new Random();
      int red = random.nextInt(256);
      int green = random.nextInt(256);
      int blue = random.nextInt(256);
      return new Color(red, green, blue);
   }
   
   /**
    * Gets the random color.
    *
    * @param minRed the min red
    * @param maxRed the max red
    * @param minGreen the min green
    * @param maxGreen the max green
    * @param minBlue the min blue
    * @param maxBlue the max blue
    * @return the random color
    */
   public Color getRandomColor(int minRed, int maxRed, int minGreen, int maxGreen,
         int minBlue, int maxBlue) {
      Random random = new Random();
      int red = minRed + random.nextInt(maxRed - minRed);
      int green = minGreen + random.nextInt(maxGreen - minGreen);
      int blue = minBlue + random.nextInt(maxBlue - minBlue);
      return new Color(red, green, blue);
   }

   /**
    * Lose life.
    *
    * @param damage the damage
    */
   public void loseLife(int damage) { myLife -= damage; }
   
   /**
    * Gets the life.
    *
    * @return the life
    */
   public int getLife(){ return myLife; }
   
   /**
    * Sets the life.
    *
    * @param life the new life
    */
   public void setLife(int life){ myLife = life; }
   
   /**
    * Gets the position.
    *
    * @return the position
    */
   public Vec2 getPosition() { return myParticlePosition; }
   
   /**
    * Sets the position.
    *
    * @param position the new position
    */
   public void setPosition(Vec2 position) {myParticlePosition = position; }
   
   /**
    * Gets the velocity.
    *
    * @return the velocity
    */
   public Vec2 getVelocity() { return myParticleVelocity; }
   
   /**
    * Sets the velocity.
    *
    * @param velocity the new velocity
    */
   public void setVelocity(Vec2 velocity) { myParticleVelocity = velocity; }
   
   /**
    * Sets the color.
    *
    * @param color the new color
    */
   public void setColor(Color color) { myColor = color; }
   
   /**
    * Gets the color.
    *
    * @return the color
    */
   public Color getColor() { return myColor; }
}