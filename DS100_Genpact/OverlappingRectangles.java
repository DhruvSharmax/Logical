package DS100_Genpact;

public class OverlappingRectangles {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point l1 = new Point(0, 10);
        Point r1 = new Point(10, 0);
        Point l2 = new Point(5, 5);
        Point r2 = new Point(15, 0);

        if (doOverlap(l1, r1, l2, r2))
            System.out.println("Rectangles Overlap");
        else
            System.out.println("Rectangles Don't Overlap");
    }

    static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        return (l1.x<r2.x || l2.x<r1.x) || (r1.y<l2.y || r2.y<l1.y) ? false:true;
    }
}
