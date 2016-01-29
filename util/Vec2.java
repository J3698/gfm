package gfm.util;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Vec2.
 */
public class Vec2 {
   /** The x component of the vector. */
   private double x;

   /** The y component of the vector. */
   private double y;



   /**
    * Instantiates a new vec2 zero vector.
    */
   public Vec2() {                                //Constructor
      this(0, 0);
   }

   /**
    * Instantiates a new vec2 from a point.
    *
    * @param point the point to use
    */
   public Vec2(Point point) {
      this(point.getX(), point.getY());
   }


   /**
    * Instantiates a new vec2.
    *
    * @param _x the x value
    * @param _y the y value
    */
   public Vec2(double _x, double _y) {
      x = _x;
      y = _y;
   }

   /**
    * Sets the x.
    *
    * @param _x the new x value
    */
   public void setX(double _x) { x = _x; }           //Setters and getters

   /**
    * Gets the x value.
    *
    * @return the x value
    */
   public double getX() { return x; }

   /**
    * Sets the y value.
    *
    * @param _y the new y
    */
   public void setY(double _y) { y = _y; }

   /**
    * Gets the y value.
    *
    * @return the y
    */
   public double getY(){ return y; }

   /**
    * Adds the x value.
    *
    * @param scalar the scalar
    */
   public void addX(double scalar){
      x += scalar;
   }

   /**
    * Adds the y value.
    *
    * @param scalar the scalar
    */
   public void addY(double scalar){
      y += scalar;
   }

   /**
    * Subtracts a scalar from the x value.
    *
    * @param scalar the scalar
    */
   public void subX(double scalar){
      x -= scalar;
   }

   /**
    * Subtracts a scalar from the y value.
    *
    * @param scalar the scalar
    */
   public void subY(double scalar){
      y -= scalar;
   }

   /**
    * Multiplies the x value by a scalar.
    *
    * @param scalar the scalar
    */
   public void multiplyX(double scalar){
      x *= scalar;
   }

   /**
    * Multiplies the y value by a scalar.
    *
    * @param scalar the scalar
    */
   public void multiplyY(double scalar){
      y *= scalar;
   }

   /**
    * Divides the x value by a scalar.
    *
    * @param scalar the scalar
    */
   public void divideX(double scalar){
      x /= scalar;
   }

   /**
    * Divides the y value by a scalar.
    *
    * @param scalar the scalar
    */
   public void divideY(double scalar){
      y /= scalar;
   }

   /**
    * Adds the vector.
    *
    * @param v the v
    */
   public void addVector(Vec2 v){                 //Basic vector arithmetic
      x += v.getX();
      y += v.getY();
   }

   /**
    * Sub vector.
    *
    * @param v the v
    */
   public void subVector(Vec2 v){
      x -= v.getX();
      y -= v.getY();
   }

   /**
    * Multiply.
    *
    * @param scalar the scalar
    */
   public void multiply(double scalar){
      x = x * scalar;
      y = y * scalar;
   }

   /**
    * Divide.
    *
    * @param scalar the scalar
    */
   public void divide(double scalar){
      if (scalar == 0){
         throw new IllegalArgumentException("Vector divided by zero");
      }
      x /= scalar;
      y /= scalar;
   }

   /**
    * Gets the magnitude.
    *
    * @return the magnitude
    */
   public double getMagnitude(){                     //Return the magnitude
      return Math.pow(x*x + y*y, 0.5);
   }

   /**
    * Normalize magnitude.
    */
   public void normalizeMagnitude(){                 //Manipulate the magnitude
      double mag = getMagnitude();
      if (mag != 0){
         x /= mag;
         y /= mag;
      }
   }

   /**
    * Sets the magnitude.
    *
    * @param scalar the new magnitude
    */
   public void setMagnitude(double scalar){
      normalizeMagnitude();
      multiply(scalar);
   }

   /**
    * Limit magnitude.
    *
    * @param scalar the scalar to limit the magnitude to.
    */
   public void limitMagnitude(double scalar){
      if(getMagnitude() > scalar) {
         setMagnitude(scalar);
      }
   }

   /**
    * Return vector heading in radians.
    *
    * @return the double
    */
   public double asRadians(){
      if(x == 0) {
         return Math.PI / 2;
      }
      return Math.atan2(y, x);
   }

   /**
    * Return vector heading in degrees.
    *
    * @return the double
    */
   public double asDegrees(){
      return Math.toDegrees(asRadians());
   }

   /**
    * Rotate the vector about a point in radians.
    *
    * @param center the center
    * @param angle the angle
    */
   public void rotateAboutRadians(Vec2 center, double angle) {
      subVector(center);
      rotateRadians(angle);
      addVector(center);
   }

   /**
    * Rotate about degrees.
    *
    * @param center the center
    * @param angle the angle
    */
   public void rotateAboutDegrees(Vec2 center, double angle) {
      double radAngle = Math.toRadians(angle % 360);
      rotateAboutRadians(center, radAngle);
   }

   /**
    * Rotate radians.
    *
    * @param angle the angle
    */
   public void rotateRadians(double angle){          //Rotate the vector
      while(Math.abs(angle) > 2 * Math.PI){
         angle -= Math.abs(angle) / angle * 2 * Math.PI;
      }
      double tempX = x;
      x = x * Math.cos(angle) - y * Math.sin(angle);
      y = y * Math.cos(angle) + tempX * Math.sin(angle);
   }

   /**
    * Rotate degrees.
    *
    * @param angle the angle
    */
   public void rotateDegrees(double angle){
      rotateRadians(Math.toRadians(angle % 360));
   }

   /**
    * Distance.
    *
    * @param other the other
    * @return the double
    */
   public double distance(Vec2 other) {
      Vec2 copy = copy();
      copy.subVector(other);
      return copy.getMagnitude();
   }

   /**
    * Return a deep copy of this vector
    *
    * @return the vec2
    */
   public Vec2 copy() {
      return new Vec2(x, y);
   }

   /**
    * Return a copy of the vector as an array{@code {x, y}}.
    *
    * @return A double array
    */
   public double[] toArray() {
      return new double[] {x, y};
   }

   /**
    * Return a copy of the vector as a point.
    *
    * @return A double array
    */

   public Point toPoint() {
      return new Point((int) x, (int) y);
   }

   /**
    * Get a Srting representation of the vector of the form (x, y)
    *
    * @return a string representation of the vector
    *
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString(){
      return "(" + x + ", " + y + ")";
   }

   /**
    * Equals.
    *
    * @param other the other vector to compare against
    * @return true, if both vectors are equal
    */
   public boolean equals(Vec2 other) {
      return x == other.getX() && y == other.getY();
   }

   /**
    * Rand vector.
    *
    * @param minRotate the min rotate
    * @param maxRotate the max rotate
    * @return the vec2
    */
   public static Vec2 randVector(double minRotate, double maxRotate) {
      Vec2 toReturn = new Vec2(1, 0);
      toReturn.rotateRadians(new Random().nextDouble() * (maxRotate - minRotate) + minRotate);
      return toReturn;
   }

   /**
    * Rand square vector.
    *
    * @param xLowerLim the x lower lim
    * @param yLowerLim the y lower lim
    * @param xUpperLim the x upper lim
    * @param yUpperLim the y upper lim
    * @return the vec2
    */
   public static Vec2 randSquareVector(double xLowerLim, double yLowerLim,
         double xUpperLim, double yUpperLim) {
      Random rand = new Random();
      double x = rand.nextDouble() * (xUpperLim - xLowerLim) + xLowerLim;
      double y = rand.nextDouble() * (yUpperLim - yLowerLim) + yLowerLim;
      return new Vec2(x, y);
   }
}





class Vector2List {
   private ArrayList<Vec2> myVectors;

   public Vector2List() {
      myVectors = new ArrayList<Vec2>();
   }

   public void add(double x, double y) {
      add(new Vec2(x, y));
   }

   public void add(Vec2 _vector2) {
      myVectors.add(_vector2);
   }

   public void transform(TMatrix tMatrix) {
      for (Vec2 vector2 : myVectors) {
         double tempX = vector2.getX();
         double tempY = vector2.getY();
         vector2.setX(tempX * tMatrix.get(1, 1) + tempY * tMatrix.get(1, 2));
         vector2.setY(tempX * tMatrix.get(2, 1) + tempY * tMatrix.get(2, 2));
      }
   }

   public void addPos(double x, double y) {
      for (Vec2 vector2 : myVectors) {
         vector2.setX(vector2.getX() + x);
         vector2.setY(vector2.getY() + y);
      }
   }

   @Override
   public Vector2List clone() {
      Vector2List copy = new Vector2List();
      for (Vec2 vector2: myVectors) {
         copy.add(vector2.copy());
      }

      return copy;
   }

   public void draw(Graphics pen) {
      int numPoints = myVectors.size();
      int[] xPoints = new int[numPoints];
      int[] yPoints = new int[numPoints];

      int index = 0;
      for (Vec2 vector2 : myVectors) {
         xPoints[index] = (int) vector2.getX();
         yPoints[index] = (int) vector2.getY();
         index++;
      }

      pen.drawPolygon(xPoints, yPoints, numPoints);
   }
}

class TMatrix {
   private double a;
   private double b;
   private double c;
   private double d;

   public TMatrix(double _a, double _b,
         double _c, double _d) {
      a = _a;
      b = _b;
      c = _c;
      d = _d;
   }

   public double get(int row, int col) {
      if (row == 1 && col == 1) {
         return a;
      } else if (row == 2 && col == 1) {
         return c;
      } else if (row == 1 && col == 2) {
         return b;
      } else if (row == 2 && col == 2) {
         return d;
      }

      throw new IllegalArgumentException("OUT OF BOUNDS!!");
   }
}