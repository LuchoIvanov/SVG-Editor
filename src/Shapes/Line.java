package Shapes;

public class Line implements Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String stroke;

    public Line(int x1, int y1, int x2, int y2, String stroke) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.stroke = stroke;
    }

    @Override
    public void translate(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }
    @Override
    public String toString() {
        return String.format("line %d %d %d %d %s", x1, y1, x2, y2, stroke);
    }

    @Override
    public boolean isWithinRectangle(int x, int y, int w, int h) {
        return x1 >= x && y1 >= y && x1 <= x + w && y1 <= y + h && x2 >= x && y2 >= y && x2 <= x + w && y2 <= y + h;
    }

    @Override
    public boolean isWithinCircle(int cx, int cy, int r) {
        double d1 = Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2);
        double d2 = Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2);
        return d1 <= r*r && d2 <= r*r;
    }

    @Override
    public String toSvg() {
        return String.format("<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"%s\"/>",
                x1, y1, x2, y2, stroke);
    }
}
