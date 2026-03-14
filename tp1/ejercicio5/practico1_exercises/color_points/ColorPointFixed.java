package practico1_exercises.color_points;

import java.awt.Color;
import java.util.Objects;

// Version corregida: usa composicion para agregar color sin romper equals
public class ColorPointFixed {
    private final Point point;
    private final Color color;

    public ColorPointFixed(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {
        return point;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointFixed)) {
            return false;
        }
        ColorPointFixed cp = (ColorPointFixed) o;
        return point.equals(cp.point) && color.equals(cp.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }
}
