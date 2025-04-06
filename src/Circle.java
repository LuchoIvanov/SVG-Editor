public class Circle implements Shapes{
    private int x;
    private int y;
    private int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
