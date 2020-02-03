package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    Scanner scan = new Scanner(System.in);
    List<Shape> shapes = new ArrayList<>();
    int rounds = 2;

    public void run() {
        show();
    }

    private void show() {
        boolean exit = false;
        do {
            System.out.println("1. Create Dots\n" +
                    "2. Create Circles\n" +
                    "3. Create Squares\n" +
                    "4. Restart\n" +
                    "5. Play\n" +
                    "6. Set board size\n" +
                    "7. Clear shape list\n" +
                    "9. Show shape list\n" +
                    "0. Exit");
            System.out.print("Enter choice> ");
            int menuChoice = scan.nextInt();
            switch (menuChoice) {
                case 1:
                    System.out.print("How many dots would you like to create?> ");
                    createDot();
                    break;
                case 2:
                    System.out.print("How many circles would you like to create?> ");
                    createCircle();
                    break;
                case 3:
                    System.out.print("How many squares would you like to create?> ");
                    createSquare();
                    break;
                case 4:
                    repositionShapes();
                    break;
                case 5:
                    play();
                    break;
                case 6:
                    changeBoardSize();
                    break;
                case 7:
                    shapes.clear();
                    break;
                case 9:
                    printShapeList();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + menuChoice);
            }
        } while (!exit);
    }

    private void changeBoardSize() {
        System.out.printf("Default board size is 100x100.\nCurrent board size: %sx%s.\nEnter new board size or 0 to return to main menu> "
                , Shape.sizeX, Shape.sizeY);
        int boardSize = scan.nextInt();
        if (!(boardSize == 0))
            Shape.setBoardSize(boardSize);
    }
    private void printShapeList() {
        for (Shape shape : shapes) {
            System.out.print(shape.toString());
        }
    }

    private void play() {
        if (!shapes.isEmpty()) {
            for (int round = 1; round <= rounds; round++) {
                for (int i = 0; i < shapes.size(); i++) {
                    for (int j = i + 1; j < shapes.size(); j++) {
                        collisionCheck(shapes.get(i), shapes.get(j));
                    }
                }
                System.out.println("-------\nEnd of round: " + round + "\n-------\n");
                repositionShapes();
            }
        }
    }

    private void repositionShapes() {
        for (Shape shape : shapes) {
            shape.setPosition();
        }
    }

    private void createDot() {
        int numberOfDots = scan.nextInt();
        for (int i = 0; i < numberOfDots; i++) {
            shapes.add(new Dot());
        }
    }

    private void createCircle() {
        int numberOfCircles = scan.nextInt();
        for (int i = 0; i < numberOfCircles; i++) {
            shapes.add(new Circle());
        }
    }

    private void createSquare() {
        int numberOfSquares = scan.nextInt();
        for (int i = 0; i < numberOfSquares; i++) {
            shapes.add(new Square());
        }
    }

    private void collisionCheck(Shape s1, Shape s2) {
        var collision = false;

        if (s1 instanceof Circle) {
            if (Circle.checkCollisions((Circle) s1, s2)) collision = true;
        }
        if (s1 instanceof Square) {
            if (Square.checkCollisions((Square) s1, s2)) collision = true;
        }
        if (s1 instanceof Dot) {
            if (Dot.checkCollisions((Dot) s1, s2)) collision = true;
        }

        if (collision) {
            System.out.printf("Collision detected! %s on %s!\n" + s1.toString() + s2.toString(),
                    s1.getClass().getSimpleName(), s2.getClass().getSimpleName());
        }
    }
}
