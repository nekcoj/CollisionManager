package com.company;

public class Dot extends Shape {

    float x, y, radius = 0;

    public Dot(){
        super();
        this.x = super.x;
        this.y = super.y;
        System.out.print(toString());
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static boolean checkCollisions(Dot d1, Shape s1){
        if(s1 instanceof Dot){ Dot d2 = (Dot) s1; return checkCollisions(d1, d2);}
        else if(s1 instanceof Circle){ Circle c1 = (Circle) s1;  return checkCollisions(d1, c1);}
        else {Square sq1 = (Square) s1; return checkCollisions(d1, sq1); }
    }

    public static boolean checkCollisions(Dot d1, Circle c1){
        return Circle.checkCollisions(c1, d1);
    }

    public static boolean checkCollisions(Dot d1, Dot d2) {
        return d1.getX() == d2.getX() && d1.getY() == d2.getY();
    }

    public static boolean checkCollisions(Dot d1, Square sq1) {
        float minX, maxX, minY, maxY;
        minX = sq1.getX() - sq1.getRadius();
        maxX = sq1.getX() + sq1.getRadius();
        minY = sq1.getY() - sq1.getRadius();
        maxY = sq1.getY() + sq1.getRadius();
        return minX <= d1.getX() && d1.getX() <= maxX && minY <= d1.getY() && d1.getY() <= maxY;
    }

    @Override
    public float getRadius() {
        return radius;
    }

    @Override
    public void setPosition() {
        super.setPosition();
        this.x = super.x;
        this.y = super.y;
    }

    @Override
    public String toString() {
        return "Dot (x" + x + ", y" + y + ")\n";
    }

}
