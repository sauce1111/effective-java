package com.effective_java.book.test.item10;

import java.awt.Color;

public class TestItem10 {

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));
    }

}
