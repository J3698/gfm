package gfm.particlesys;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import gfm.particlesys.Particle;
import gfm.util.Vector2;

public class ParticleSystem {
   private ArrayList<Particle> myParticles;

   private Vector2 mySourcePosition;
   private Vector2 myMaxSourceOffset;;
   private Vector2 myInitialVelocity = new Vector2(0, 0);
   private Particle myParticleType;
   private double myEmissionRate = 1;
   private double myLowerAngleLimit = -Math.PI;
   private double myUpperAngleLimit = Math.PI;

   public ParticleSystem(Particle particleType, Vector2 position, Vector2 velocity,
         double lowerAngleLimit, double upperAngleLimit) {
      myParticleType = particleType;
      mySourcePosition = position;
      myInitialVelocity = velocity;
      myLowerAngleLimit = lowerAngleLimit;
      myUpperAngleLimit = upperAngleLimit;
      myParticles = new ArrayList<Particle>();
   }

   public void update() {
      Particle temp;
      for (int i = 0; i < myParticles.size(); i++) {
         temp = myParticles.get(i);
         if (temp.isDead()) {
            myParticles.remove(temp);
         } else {
            temp.update();
         }
      }
      for (int i = 0; i < myEmissionRate; i++) {
         createParticles();
      }
      double chance = myEmissionRate - Math.floor(myEmissionRate);
      if (new Random().nextDouble() < chance) {
         createParticles();
      }
   }

   public void draw(Graphics pen) {
      for (int i = 0; i < myParticles.size(); i++) {
         myParticles.get(i).draw(pen);
      }
   }

   private void createParticles() {
      Vector2 position = mySourcePosition.copy();
      if (myMaxSourceOffset != null) {
         double xLowerLim = -(myMaxSourceOffset.getX() / 2);
         double yLowerLim = -(myMaxSourceOffset.getY() / 2);
         double xUpperLim = myMaxSourceOffset.getX() / 2;
         double yUpperLim = myMaxSourceOffset.getY() / 2;
         position.addVector(Vector2.randSquareVector(xLowerLim, yLowerLim, xUpperLim, yUpperLim));
      }

      Vector2 velocity = myInitialVelocity.copy();

      double angle = myLowerAngleLimit + new Random().nextDouble()
            * (myUpperAngleLimit - myLowerAngleLimit);
      velocity.rotateRadians(angle);

      myParticles.add(myParticleType.newParticle());
   }

   public Vector2 getSourcePosition() { return mySourcePosition; }
   public void setSourcePosition(Vector2 position) { mySourcePosition = position; }
   public void setSourceOffset(Vector2 offset) { myMaxSourceOffset = offset; }
   @SuppressWarnings("unused")
   private Vector2 getSourceOffset() { return myMaxSourceOffset; }

   public void setEmissionRate(double emissionRate) { myEmissionRate = emissionRate; }
   public double getEmissionRate() { return myEmissionRate; }
   public void setEmissionAngles(double lowerLimit, double upperLimit) {
      myLowerAngleLimit = lowerLimit;
      myUpperAngleLimit = upperLimit;
   }
   public void setEmissionAngles(double angle) { setEmissionAngles(angle, angle); }
   public double[] getEmissionAngles() { return new double[]{ myLowerAngleLimit, myUpperAngleLimit }; }
   public void setInitialVelocity(Vector2 velocity) { myInitialVelocity = velocity; }
   public Vector2 getInitialVelocity() { return myInitialVelocity; }
}