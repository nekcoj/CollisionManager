package com.company;

public class Dot extends Shape{

    float x, y, radius = 0;

    public Dot(){
        super();
        this.x = super.x;
        this.y = super.y;
        System.out.println(toString());
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setPosition() {
        super.setPosition();
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
