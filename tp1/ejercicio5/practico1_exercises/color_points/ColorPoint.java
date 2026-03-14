package practico1_exercises.color_points;

import java.awt.Color;
import java.util.Objects;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        ColorPoint cp = (ColorPoint) o;
        return super.equals(o) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), color);
    }
}
