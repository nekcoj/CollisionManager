package com.company;

import java.util.List;

public class Shape implements Position {
    float x, y, radius;
    static int sizeX = 100, sizeY = 100;

    public Shape()  {
        this.x = (float)Math.floor(Math.random() * (sizeX + 1));
        this.y = (float)Math.floor(Math.random() * (sizeY + 1));
        this.radius = (float)Math.floor(Math.random() * 10) + 1;
    }

    public int getSizeX(){
        return sizeX;
    }

    public static void setSizeX(int sizeX){
        Shape.sizeX = sizeX;
    }

    public int getSizeY(){
        return sizeY;
    }
    public static void setSizeY(int sizeY){
        Shape.sizeY = sizeY;
    }

    static void setBoardSize(int boardSize){
        setSizeX(boardSize);
        setSizeY(boardSize);
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

    public static void checkCollisions(List<Shape> shapes) {
        if (shapes.getClass() == Circle.class){

        }
    }

    @Override
    public void setPosition() {
        setY((float)Math.floor(Math.random() * (sizeY + 1)));
        setX((float)Math.floor(Math.random() * (sizeX + 1)));
    }


    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
