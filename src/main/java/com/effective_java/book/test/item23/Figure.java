package com.effective_java.book.test.item23;

// 태그 달린 클래스 - 절대 이렇게 만들지 말자 !!
public class Figure {

    // 태그 필드 - 현재 표현하는 모양을 나타낸다.
    final Shape shape;

    // 사각형 일때만 쓰이는 필드
    double length;
    double width;

    // 원 일때만 쓰이는 필드
    double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }

enum Shape {RECTANGLE, CIRCLE}

}
