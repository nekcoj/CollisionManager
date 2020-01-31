package com.company;

public class Square extends Shape {
    float x, y, radius;

    public Square() {
        super();
        this.x = super.x;
        this.y = super.y;
        this.radius = super.radius;
        System.out.println(toString());

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public void setPosition() {
        super.setPosition();
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                ", y=" + y +
                ", side=" + radius * 2 +
                '}';
    }
}