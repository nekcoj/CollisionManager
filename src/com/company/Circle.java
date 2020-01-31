package com.company;

public class Circle extends Shape {
    float x, y, radius;

    public Circle() {
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
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
