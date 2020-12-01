package com.effective_java.book.test.item10;

import java.awt.Color;
import java.util.Objects;

public class ColorPointComposition {

    private final Point point;

    private final Color color;

    public ColorPointComposition(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointComposition)) {
            return false;
        }

        ColorPointComposition cpComposition = (ColorPointComposition) o;
        return cpComposition.point.equals(point) && cpComposition.color.equals(color);
    }

}
