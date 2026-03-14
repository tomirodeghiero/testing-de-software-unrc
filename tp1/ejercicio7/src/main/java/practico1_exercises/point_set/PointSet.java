package practico1_exercises.point_set;

import java.util.HashSet;
import java.util.Set;

public class PointSet {
    private final Set<Point> points = new HashSet<>();

    public boolean add(Point point) {
        return points.add(point);
    }

    public boolean remove(Point point) {
        return points.remove(point);
    }

    public boolean contains(Point point) {
        return points.contains(point);
    }

    public int size() {
        return points.size();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }
}
