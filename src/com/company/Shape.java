package com.company;

public abstract class Shape implements Position {
    float x, y, radius;
    static int sizeX = 100, sizeY = 100;

    public Shape()  {
        this.radius = (float)Math.floor(Math.random() * 10) + 1;
        setPosition();
    }

    public static void setSizeX(int sizeX){
        Shape.sizeX = sizeX;
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

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public void setPosition() {
        do{
            this.x = ((float)Math.floor(Math.random() * (sizeX + 1)));
        } while(this.x - this.radius < 0 || this.x + this.radius > sizeX);
        do{
            this.y = ((float)Math.floor(Math.random() * (sizeY + 1)));
        } while(this.y - this.radius < 0 || this.y + this.radius > sizeY);
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
