package Shapes;

public interface Shape {
    void translate(int dx, int dy);
    String toString();
    boolean isWithinRectangle(int x, int y, int width, int height);
    boolean isWithinCircle(int cx, int cy, int r);
}
