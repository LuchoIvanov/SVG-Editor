public class Line implements Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String fill;

    public Line(int x1, int y1, int x2, int y2, String fill) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.fill = fill;
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
        return String.format("line %d %d %d %d %s", x1, y1, x2, y2, fill);
    }
}
