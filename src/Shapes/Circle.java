package Shapes;

public class Circle implements Shape {
    private int cx;
    private int cy;
    private int r;
    private String fill;

    public Circle(int cx, int cy, int r, String fill) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
        this.fill = fill;
    }

    @Override
    public void translate(int dx, int dy) {
        cx += dx;
        cy += dy;
    }

    @Override
    public String toString() {
        return String.format("circle %d %d %d %s", cx, cy, r, fill);
    }

    @Override
    public boolean isWithinRectangle(int x, int y, int w, int h) {
        return (cx - r >= x) && (cy - r >= y) && (cx + r <= x + w) && (cy + r <= y + h);
    }

    @Override
    public boolean isWithinCircle(int cx, int cy, int r) {
        return false;
    }
    @Override
    public String toSvg() {
        return String.format("<circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\"/>",
                cx, cy, r, fill);
    }
}
