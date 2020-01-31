package com.company;

public class Square extends Shape {
    float x, y, radius;

    public Square() {
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

    public static boolean checkCollisions(Square sq1, Shape s1){
        if(s1 instanceof Dot){ Dot d1 = (Dot) s1; return Dot.checkCollisions(d1, sq1);}
        else if(s1 instanceof Circle){ Circle c2 = (Circle) s1;  return checkCollisions(sq1, c2);}
        else {Square sq2 = (Square) s1; return checkCollisions(sq1, sq2); }
    }

    public static boolean checkCollisions(Square sq1, Square sq2) {
        return sq1.x < sq2.x + sq2.radius &&
                sq1.x + sq1.radius > sq2.x &&
                sq1.y < sq2.y + sq2.radius &&
                sq1.y + sq1.radius > sq2.y;
    }

    public static boolean checkCollisions(Square sq1, Circle c1) {
        return Circle.checkCollisions(c1, sq1);
    }

    @Override
    public void setPosition() {
        super.setPosition();
        this.x = super.x;
        this.y = super.y;
    }

    @Override
    public String toString() {
        return "Square (x" + x + ", y" + y + "), side:" + radius*2 + "\n";
    }
}