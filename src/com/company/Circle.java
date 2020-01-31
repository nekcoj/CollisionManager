package com.company;

public class Circle extends Shape {
    float x, y, radius;

    public Circle() {
        super();
        this.x = super.x;
        this.y = super.y;
        this.radius = super.radius;
        System.out.print(toString());

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public static boolean checkCollisions(Circle c1, Shape s1){
        if(s1 instanceof Dot){ Dot d1 = (Dot) s1; return checkCollisions(c1, d1);}
        else if(s1 instanceof Circle){ Circle c2 = (Circle) s1;  return checkCollisions(c1, c2);}
        else {Square sq1 = (Square) s1; return checkCollisions(c1, sq1); }
    }

    public static boolean checkCollisions(Circle c1, Dot d1){
        var diffX = c1.getX() - d1.getX();
        var diffY = c1.getY() - d1.getY();
        var distance = Math.sqrt(diffX * diffX + diffY * diffY);

        return distance < c1.getRadius();
    }

    public static boolean checkCollisions(Circle c1, Circle c2) {
        var diffX = c1.getX() - c2.getX();
        var diffY = c1.getY() - c2.getY();
        var distance = Math.sqrt(diffX * diffX + diffY * diffY);

        return distance < c1.getRadius() + c2.getRadius();
    }

    public static boolean checkCollisions(Circle c1, Square sq1) {
        float closestX = clamp(c1.getX(), sq1.x, sq1.x + sq1.radius);
        float closestY = clamp(c1.getY(), sq1.y - sq1.radius, sq1.y);

        float distanceX = c1.getX() - closestX;
        float distanceY = c1.getY() - closestY;

        return Math.pow(distanceX, 2) + Math.pow(distanceY, 2) < Math.pow(c1.getRadius(), 2);
    }

    private static float clamp(float value, float min, float max) {
        float x = value;
        if (x < min) {
            x = min;
        } else if (x > max) {
            x = max;
        }
        return x;
    }

    @Override
    public void setPosition() {
        super.setPosition();
        this.x = super.x;
        this.y = super.y;
    }

    @Override
    public String toString() {
        return "Circle (x" + x + ", y" + y + "), r:" + radius + "\n";
    }
}
