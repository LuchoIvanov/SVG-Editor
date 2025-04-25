public class Circle implements Shape {
    private int x;
    private int y;
    private int r;
    private String fill;

    public Circle(int x, int y, int r, String fill) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.fill = fill;
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return String.format("circle %d %d %d %s", x, y, r, fill);
    }
}
