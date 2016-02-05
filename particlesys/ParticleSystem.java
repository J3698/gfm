package gfm.particlesys;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import gfm.util.Vec2;

// TODO: Auto-generated Javadoc
/**
 * The Class ParticleSystem.
 */
public class ParticleSystem {

   /** The my particles. */
   private ArrayList<Particle> myParticles;

   /** The my source position. */
   private Vec2 mySourcePosition;

   /** The my max source offset. */
   private Vec2 myMaxSourceOffset;

   /** The my initial velocity. */
   private Vec2 myInitialVelocity = new Vec2(0, 0);

   /** The my particle type. */
   private Particle myParticleType;

   /** The my emission rate. */
   private double myEmissionRate = 1;

   /** The my lower angle limit. */
   private double myLowerAngleLimit = -Math.PI;

   /** The my upper angle limit. */
   private double myUpperAngleLimit = Math.PI;

   /** The my fertility. */
   private int myFertility;

   /**
    * Instantiates a new particle system.
    *
    * @param particleType the particle type
    * @param position the position
    * @param velocity the velocity
    * @param fertility the fertility
    * @param lowerAngleLimit the lower angle limit
    * @param upperAngleLimit the upper angle limit
    */
   public ParticleSystem(Particle particleType, Vec2 position, Vec2 velocity, int fertility,
         double lowerAngleLimit, double upperAngleLimit) {
      myParticleType = particleType;
      mySourcePosition = position;
      myInitialVelocity = velocity;
      myFertility = fertility;
      myLowerAngleLimit = lowerAngleLimit;
      myUpperAngleLimit = upperAngleLimit;
      myParticles = new ArrayList<Particle>();
   }

   /**
    * Update.
    */
   public void update() {
      Particle temp;
      for ( int i = 0; i < myParticles.size(); i++ ) {
         temp = myParticles.get(i);
         if ( temp.isDead() ) {
            myParticles.remove(temp);
         } else {
            temp.update();
         }
      }

      if ( myFertility != 0 ) {
         for ( int i = 0; i < myEmissionRate; i++ ) {
            createParticles();
         }

         double chance = myEmissionRate - Math.floor(myEmissionRate);
         if ( new Random().nextDouble() < chance ) {
            createParticles();
         }
      }

      if ( myFertility > 0 ) { myFertility--; }
   }

   /**
    * Draw.
    *
    * @param pen the pen
    */
   public void draw(Graphics pen) {
      for ( int i = 0; i < myParticles.size(); i++ ) {
         myParticles.get(i).draw(pen);
      }
   }

   /**
    * Creates the particles.
    */
   private void createParticles() {
      Vec2 position = mySourcePosition.copy();
      if ( myMaxSourceOffset != null ) {
         double xLowerLim = -(myMaxSourceOffset.getX() / 2);
         double yLowerLim = -(myMaxSourceOffset.getY() / 2);
         double xUpperLim = myMaxSourceOffset.getX() / 2;
         double yUpperLim = myMaxSourceOffset.getY() / 2;
         position.addVector(Vec2.randSquareVector(xLowerLim, yLowerLim, xUpperLim, yUpperLim));
      }

      Vec2 velocity = myInitialVelocity.copy();

      double angle = new Random().nextDouble() * (myUpperAngleLimit - myLowerAngleLimit);
      angle += myLowerAngleLimit;

      velocity.rotateRadians(angle);

      Particle newParticle = myParticleType.newParticle();
      newParticle.setPosition(position);
      newParticle.setVelocity(velocity);

      myParticles.add(newParticle);
   }

   /**
    * Gets the fertility.
    *
    * @return the fertility
    */
   public int getFertility() { return myFertility; }

   /**
    * Sets the fertility.
    *
    * @param fertility the new fertility
    */
   public void setFertility(int fertility) { myFertility = fertility; }

   /**
    * Gets the source position.
    *
    * @return the source position
    */
   public Vec2 getSourcePosition() { return mySourcePosition; }

   /**
    * Sets the source position.
    *
    * @param position the new source position
    */
   public void setSourcePosition(Vec2 position) { mySourcePosition = position; }

   /**
    * Sets the source offset.
    *
    * @param offset the new source offset
    */
   public void setSourceOffset(Vec2 offset) { myMaxSourceOffset = offset; }

   /**
    * Gets the source offset.
    *
    * @return the source offset
    */
   @SuppressWarnings("unused")
   private Vec2 getSourceOffset() { return myMaxSourceOffset; }

   /**
    * Sets the emission rate.
    *
    * @param emissionRate the new emission rate
    */
   public void setEmissionRate(double emissionRate) { myEmissionRate = emissionRate; }

   /**
    * Gets the emission rate.
    *
    * @return the emission rate
    */
   public double getEmissionRate() { return myEmissionRate; }

   /**
    * Sets the emission angles.
    *
    * @param lowerLimit the lower limit
    * @param upperLimit the upper limit
    */
   public void setEmissionAngles(double lowerLimit, double upperLimit) {
      myLowerAngleLimit = lowerLimit;
      myUpperAngleLimit = upperLimit;
   }

   /**
    * Sets the emission angles.
    *
    * @param angle the new emission angles
    */
   public void setEmissionAngles(double angle) { setEmissionAngles(angle, angle); }

   /**
    * Gets the emission angles.
    *
    * @return the emission angles
    */
   public double[] getEmissionAngles() { return new double[]{ myLowerAngleLimit, myUpperAngleLimit }; }

   /**
    * Sets the initial velocity.
    *
    * @param velocity the new initial velocity
    */
   public void setInitialVelocity(Vec2 velocity) { myInitialVelocity = velocity; }

   /**
    * Gets the initial velocity.
    *
    * @return the initial velocity
    */
   public Vec2 getInitialVelocity() { return myInitialVelocity; }
}