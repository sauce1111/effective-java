package com.effective_java.book.test.item23;

abstract class ImproveFigure {

    abstract double area();

}

class Circle extends ImproveFigure {

    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }

}

class Rectangle extends ImproveFigure {

    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

}